package com.example.elibrary.service;

import com.example.elibrary.entity.*;
import com.example.elibrary.repository.*;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DtMonographBookingRepository dtMonographBookingRepository;

    @Autowired
    private DtMonographRegistrationRepository dtMonographRegistrationRepository;

    @Autowired
    LtMonographBookingStsRepository ltMonographBookingStsRepository;

    @Autowired
    DtMonographHistoryStatusRepository dtMonographHistoryStatusRepository;

    @Autowired
    LtMonographBorrowStsRepository ltMonographBorrowStsRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void sendConfirmReserveEmail(int book_id) throws MessagingException {

        DtMonographBooking dtMonographBooking = dtMonographBookingRepository.findByReserveId(book_id);
        LtMonographBookingSts ltMonographBookingSts = ltMonographBookingStsRepository.findByStatusId(dtMonographBooking.getBookingStatus());
        User user = userRepository.findByUserId(dtMonographBooking.getBookingUserId());
        DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(dtMonographBooking.getBookingMonoId());

        String html = "<h1>Reservation Confirmation</h1>"+
                "<p><strong>Your reservation application has been submitted</strong></p>"+
                "<p>Name: "+user.getFullName()+"</p>"+
                "<p>Book ID: "+dtMonographRegistration.getReg_id()+"</p>"+
                "<p>Book Title: "+dtMonographRegistration.getReg_title()+"</p>"+
                "<p>Date Reserved: "+dtMonographBooking.getBookingDate()+"</p>"+
                "<p>Status: "+ltMonographBookingSts.getBooking_sts_status()+"</p>";


        MimeMessage message = mailSender.createMimeMessage();
        message.setFrom("ELibrary");
        message.setRecipients(MimeMessage.RecipientType.TO, user.getEmail());
        message.setSubject("Reservation confirmation");
        message.setContent(html,"text/html; charset=utf-8");

        mailSender.send(message);
    }

    public void sendConfirmExtendBorrowEmail(int borrow_id) throws MessagingException {

        DtMonographHistoryStatus dtMonographHistoryStatus = dtMonographHistoryStatusRepository.findById(borrow_id);
        User user = userRepository.findByUserId(dtMonographHistoryStatus.getHistory_user_id());
        DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(dtMonographHistoryStatus.getHistory_mono_id());


        String html = "<h1>Extend Confirmation</h1>"+
                "<p><strong>Your reservation application has been submitted</strong></p>"+
                "<p>Name: "+user.getFullName()+"</p>"+
                "<p>Book ID: "+dtMonographRegistration.getReg_id()+"</p>"+
                "<p>Book Title: "+dtMonographRegistration.getReg_title()+"</p>"+
                "<p>Extend Date: "+dtMonographHistoryStatus.getExtend_date()+"</p>"+
                "<p>Status: "+dtMonographHistoryStatus.getExtend_status()+"</p>";


        MimeMessage message = mailSender.createMimeMessage();
        message.setFrom("ELibrary");
        message.setRecipients(MimeMessage.RecipientType.TO, user.getEmail());
        message.setSubject("Application confirmation");
        message.setContent(html,"text/html; charset=utf-8");

        mailSender.send(message);
    }

    public void sendStatusReserveEmail(int book_id) throws MessagingException {

        DtMonographBooking dtMonographBooking = dtMonographBookingRepository.findByReserveId(book_id);
        LtMonographBookingSts ltMonographBookingSts = ltMonographBookingStsRepository.findByStatusId(dtMonographBooking.getBookingStatus());
        User user = userRepository.findByUserId(dtMonographBooking.getBookingUserId());
        DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(dtMonographBooking.getBookingMonoId());

        String html = "<h1>Reservation Status</h1>"+
                "<p><strong>Your reservation status</strong></p>"+
                "<p>Name: "+user.getFullName()+"</p>"+
                "<p>Book ID: "+dtMonographRegistration.getReg_id()+"</p>"+
                "<p>Book Title: "+dtMonographRegistration.getReg_title()+"</p>"+
                "<p>Date Reserve: "+dtMonographBooking.getBookingDate()+"</p>"+
                "<p>Status: "+ltMonographBookingSts.getBooking_sts_status()+"</p>";



        MimeMessage message = mailSender.createMimeMessage();
        message.setFrom("ELibrary");
        message.setRecipients(MimeMessage.RecipientType.TO, user.getEmail());
        message.setSubject("Application status");
        message.setContent(html,"text/html; charset=utf-8");

        mailSender.send(message);
    }

    public void sendStatusExtendBorrowEmail(int borrow_id) throws MessagingException {

        DtMonographHistoryStatus dtMonographHistoryStatus = dtMonographHistoryStatusRepository.findById(borrow_id);
        User user = userRepository.findByUserId(dtMonographHistoryStatus.getHistory_user_id());
        DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(dtMonographHistoryStatus.getHistory_mono_id());


        String html = "<h1>Application Status</h1>"+
                "<p><strong>Your extend application status</strong></p>"+
                "<p>Name: "+user.getFullName()+"</p>"+
                "<p>Book ID: "+dtMonographRegistration.getReg_id()+"</p>"+
                "<p>Book Title: "+dtMonographRegistration.getReg_title()+"</p>"+
                "<p>Extend Date: "+dtMonographHistoryStatus.getExtend_date()+"</p>"+
                "<p>Status: "+dtMonographHistoryStatus.getExtend_status()+"</p>";

        MimeMessage message = mailSender.createMimeMessage();
        message.setFrom("ELibrary");
        message.setRecipients(MimeMessage.RecipientType.TO, user.getEmail());
        message.setSubject("Application Status");
        message.setContent(html,"text/html; charset=utf-8");

        mailSender.send(message);
    }

    public void sendStatusUserApprovedEmail(int user_id) throws MessagingException {

        User user = userRepository.findByUserId(user_id);

        String html = "<h1>User registration status</h1>"+
                "<p><strong>Your user registration status</strong></p>"+
                "<p>Name: "+user.getFullName()+"</p>"+
                "<p>User ID: "+user.getId()+"</p>"+
                "<p>Role: "+user.getRole()+"</p>"+
                "<p>Email: "+user.getEmail()+"</p>"+
                "<p>Approved: "+user.getApproved()+"</p>";

        MimeMessage message = mailSender.createMimeMessage();
        message.setFrom("ELibrary");
        message.setRecipients(MimeMessage.RecipientType.TO, user.getEmail());
        message.setSubject("User registration status");
        message.setContent(html,"text/html; charset=utf-8");

        mailSender.send(message);
    }
}
