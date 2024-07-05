package com.example.elibrary.controller;

import com.example.elibrary.entity.*;
import com.example.elibrary.model.AuthenticationResponse;
import com.example.elibrary.repository.StUserDetailRepository;
import com.example.elibrary.repository.StUserRepository;
import com.example.elibrary.repository.StUserRoleRepository;
import com.example.elibrary.repository.UserRepository;
import com.example.elibrary.security.Encryption;
import com.example.elibrary.service.JwtService;
import com.example.elibrary.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

import static com.example.elibrary.entity.Role.*;

@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:80", "https://mmdis.marine.gov.my"})
public class RecController {
    @Autowired
    private StUserRepository stUserRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StUserDetailRepository stUserDetailRepository;

    @Autowired
    private StUserRoleRepository stUserRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PdfService pdfService;

    @GetMapping("/public/barcode/{barcode}")
    public ResponseEntity<?> downloadPdf(@PathVariable String barcode) {
        try {
            ByteArrayInputStream bis = pdfService.generatePdfWithImage("https://barcode.tec-it.com/barcode.ashx?data="+barcode+"&code=ISBN13&translate-esc=on");

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=download.pdf");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(bis));
        } catch (Exception e) {
            // Log the exception if needed
            e.printStackTrace();

            // Return an error response
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while generating the PDF: " + e.getMessage());
        }
    }

    @PostMapping("/public/test")
    public String token(@RequestParam("mmdis_token") String mmdis_token){
        return mmdis_token;
    }

    @PostMapping("/public/decrypt")
    public String decryptToken(@RequestParam("mmdis_token") String mmdis_token){
        try{
            return Encryption.Decrypt(mmdis_token);
        }catch (Exception e){
            return e.toString();
        }
    }

    @PostMapping("/public/check")
    public ResponseEntity<AuthenticationResponse> checkAuth(@RequestParam("mmdis_token") String mmdis_token){
        try{
            StUser mmdis_user = stUserRepository.getUserByGuid(Encryption.Decrypt(mmdis_token));
            User lib_user = userRepository.findByUserIc(mmdis_user.getUsername());

            if(lib_user == null){
                StUserDetail mmdis_user_detail = stUserDetailRepository.getUserDetailByGuid(mmdis_user.getGuid());
                StUserRole mmdis_user_role = stUserRoleRepository.getUserRoleByGuidAndModuleId(mmdis_user.getGuid(), 66);

                User user = new User();
                user.setUsername(mmdis_user.getUsername());
                user.setFullName(mmdis_user_detail.getFull_name());
                user.setPassword(passwordEncoder.encode("dummy"));
                if(mmdis_user_role.getRole_id() == 45){
                    user.setRole_id(1);
                    user.setRole(ADMIN);
                }else if(mmdis_user_role.getRole_id() == 38){
                    user.setRole_id(2);
                    user.setRole(LIBRARIAN);
                }else{
                    user.setRole_id(3);
                    user.setRole(PATRON);
                }
//                user.setRole_id(1);
                user.setApproved("yes");
                user.setAddress1(mmdis_user_detail.getAddress1());
                user.setAddress2(mmdis_user_detail.getAddress2());
                user.setApprovedBy("mmdis");
                user.setEmail(mmdis_user.getEmail());
                user.setPhoneNo(mmdis_user_detail.getMobile_phone_number());
                user.setRegDate(mmdis_user.getCreated_date());
                user.setState(mmdis_user_detail.getState_code());

//                user.setRole(LIBRARIAN);
                user = userRepository.save(user);

                String token = jwtService.generateToken(user);
                return ResponseEntity.ok(new AuthenticationResponse(token, user.getAuthorities(), user.getUsername(), user.getId(), user.getFullName()));

            }else{
                String token = jwtService.generateToken(lib_user);
                return ResponseEntity.ok(new AuthenticationResponse(token, lib_user.getAuthorities(), lib_user.getUsername(), lib_user.getId(), lib_user.getFullName()));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping("/public/check/test")
    public String checkAuthTest(@RequestParam("mmdis_token") String mmdis_token){
        try{
            StUser mmdis_user = stUserRepository.getUserByGuid(Encryption.Decrypt(mmdis_token));
            User lib_user = userRepository.findByUserIc(mmdis_user.getUsername());

            if(lib_user == null){
                StUserDetail mmdis_user_detail = stUserDetailRepository.getUserDetailByGuid(mmdis_user.getGuid());
                StUserRole mmdis_user_role = stUserRoleRepository.getUserRoleByGuidAndModuleId(mmdis_user.getGuid(), 66);

                User user = new User();
                user.setUsername(mmdis_user.getUsername());
                user.setFullName(mmdis_user_detail.getFull_name());
                user.setPassword(passwordEncoder.encode("dummy"));
                if(mmdis_user_role.getRole_id() == 45){
                    user.setRole_id(1);
                    user.setRole(ADMIN);
                }else if(mmdis_user_role.getRole_id() == 38){
                    user.setRole_id(2);
                    user.setRole(LIBRARIAN);
                }else if(mmdis_user_role.getRole_id() == 39){
                    user.setRole_id(3);
                    user.setRole(PATRON);
                }
//                user.setRole_id(1);
                user.setApproved("yes");
                user.setAddress1(mmdis_user_detail.getAddress1());
                user.setAddress2(mmdis_user_detail.getAddress2());
                user.setApprovedBy("mmdis");
                user.setEmail(mmdis_user.getEmail());
                user.setPhoneNo(mmdis_user_detail.getMobile_phone_number());
                user.setRegDate(mmdis_user.getCreated_date());
                user.setState(mmdis_user_detail.getState_code());

//                user.setRole(LIBRARIAN);
                user = userRepository.save(user);

                String token = jwtService.generateToken(user);
                return ResponseEntity.ok(new AuthenticationResponse(token, user.getAuthorities(), user.getUsername(), user.getId(), user.getFullName())).toString();

            }else{
                String token = jwtService.generateToken(lib_user);
                return ResponseEntity.ok(new AuthenticationResponse(token, lib_user.getAuthorities(), lib_user.getUsername(), lib_user.getId(), lib_user.getFullName())).toString();

            }
        } catch (Exception e) {
            return e.toString();
        }

    }

}
