package com.example.elibrary.controller;

import com.example.elibrary.entity.User;
import com.example.elibrary.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:80", "https://mmdis.marine.gov.my"})
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/reservation/confirm/send/{reserve_id}")
    public void sendConfirmReserveEmail(@PathVariable int reserve_id) throws MessagingException {
        emailService.sendConfirmReserveEmail(reserve_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/reservation/status/send/{reserve_id}")
    public void sendStatusReserveEmail(@PathVariable int reserve_id) throws MessagingException {
        emailService.sendStatusReserveEmail(reserve_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/reservation/confirm/extend/send/{borrow_id}")
    public void sendConfirmExtendBorrowEmail(@PathVariable int borrow_id) throws MessagingException {
        emailService.sendConfirmExtendBorrowEmail(borrow_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/reservation/status/extend/send/{borrow_id}")
    public void sendStatusExtendBorrowEmail(@PathVariable int borrow_id) throws MessagingException {
        emailService.sendStatusExtendBorrowEmail(borrow_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user/status/send/{user_id}")
    public void sendStatusUserApprovedEmail(@PathVariable int user_id) throws MessagingException {
        emailService.sendStatusUserApprovedEmail(user_id);
    }
}
