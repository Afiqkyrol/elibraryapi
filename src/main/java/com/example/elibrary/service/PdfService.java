package com.example.elibrary.service;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;

@Service
public class PdfService {
    public ByteArrayInputStream generatePdfWithImage(String imageUrl) {
        try (PDDocument document = new PDDocument(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            // Download the image to a byte array
            ByteArrayOutputStream imageOut = new ByteArrayOutputStream();
            try (InputStream in = new URL(imageUrl).openStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    imageOut.write(buffer, 0, bytesRead);
                }
            }

            // Create a PDImageXObject from the byte array
            PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, imageOut.toByteArray(), "downloadedImage");

            // Create a new page and add the image to it
            PDPage page = new PDPage(new PDRectangle(pdImage.getWidth(), pdImage.getHeight()));
            document.addPage(page);
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.drawImage(pdImage, 0, 0);
            }

            // Save the document to the ByteArrayOutputStream
            document.save(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
