package com.example.elibrary.controller;

import com.example.elibrary.entity.*;
import com.example.elibrary.model.AuthenticationResponse;
import com.example.elibrary.service.AdminService;
import com.example.elibrary.service.AuthService;
import com.example.elibrary.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:80", "https://mmdis.marine.gov.my"})
public class AdminController {

    private AdminService adminService;
    private AuthService authService;

    private EmailService emailService;

    public AdminController(AdminService adminService, AuthService authService, EmailService emailService) {
        this.adminService = adminService;
        this.authService = authService;
        this.emailService = emailService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-type")
    public List<LtMonographType> getMonographTypeList(){
        return adminService.getMonographTypeList();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-type/{type_id}")
    public LtMonographType getTypeById(@PathVariable int type_id){
        return adminService.getMonographTypeById(type_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/admin/monograph-type/{type_id}")
    public void deleteTypeById(@PathVariable int type_id){
         adminService.deleteMonographTypeById(type_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-subject/{subject_id}")
    public LtMonographSubject getSubjectById(@PathVariable int subject_id){
        return adminService.getMonographSubjectById(subject_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/admin/monograph-subject/{subject_id}")
    public void deleteSubjectById(@PathVariable int subject_id){
        adminService.deleteMonographSubjectById(subject_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/admin/monograph-type")
    public LtMonographType saveMonographType(@RequestParam("type_name") String type_name,
                                             @RequestParam("type_desc") String type_desc,
                                             @RequestParam("type_active") int type_active){
        return adminService.saveMonographType(type_name, type_desc, type_active);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/admin/monograph-type/{type_id}")
    public LtMonographType updateMonographType(@PathVariable int type_id,
                                               @RequestParam("type_name") String type_name,
                                             @RequestParam("type_desc") String type_desc,
                                             @RequestParam("type_active") int type_active){
        return adminService.updateMonographType(type_id, type_name, type_desc, type_active);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-subject")
    public List<LtMonographSubject> getMonographSubject(){
        return adminService.getMonographSubjectList();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/admin/monograph-subject")
    public LtMonographSubject saveMonographSubject(@RequestParam("subject_name") String subject_name,
                                             @RequestParam("subject_desc") String subject_desc,
                                             @RequestParam("subject_active") int subject_active){
        return adminService.saveMonographSubject(subject_name, subject_desc, subject_active);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/admin/monograph-subject/{subject_id}")
    public LtMonographSubject updateMonographSubject(@PathVariable int subject_id,
                                               @RequestParam("subject_name") String subject_name,
                                               @RequestParam("subject_desc") String subject_desc,
                                               @RequestParam("subject_active") int subject_active){
        return adminService.updateMonographSubject(subject_id, subject_name, subject_desc, subject_active);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-language")
    public List<LtMonographLanguage> getMonographLanguage(){
        return adminService.getMonographLanguageList();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/admin/monograph-language/{lang_id}")
    public void deleteLanguageById(@PathVariable int lang_id){
        adminService.deleteMonographLanguageById(lang_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/admin/monograph-language")
    public LtMonographLanguage saveMonographLanguage(@RequestParam("lang_name") String lang_name,
                                                   @RequestParam("lang_desc") String lang_desc,
                                                   @RequestParam("lang_active") int lang_active){
        return adminService.saveMonographLanguage(lang_name, lang_desc, lang_active);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/admin/monograph-language/{lang_id}")
    public LtMonographLanguage updateMonographLanguage(@PathVariable int lang_id,
                                                     @RequestParam("lang_name") String lang_name,
                                                     @RequestParam("lang_desc") String lang_desc,
                                                     @RequestParam("lang_active") int lang_active){
        return adminService.updateMonographLanguage(lang_id, lang_name, lang_desc, lang_active);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-language/{lang_id}")
    public LtMonographLanguage getLanguageById(@PathVariable int lang_id){
        return adminService.getMonographLanguageById(lang_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-status")
    public List<LtMonographSts> getMonographStatus(){
        return adminService.getMonographStsList();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/admin/monograph-status/{status_id}")
    public void deleteStatusById(@PathVariable int status_id){
        adminService.deleteMonographStatusById(status_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/admin/monograph-status")
    public LtMonographSts saveMonographStatus(@RequestParam("sts_status") String sts_status,
                                                     @RequestParam("sts_desc") String sts_desc){
        return adminService.saveMonographStatus(sts_status, sts_desc);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-status/{sts_id}")
    public LtMonographSts getStatusById(@PathVariable int sts_id){
        return adminService.getMonographStatusById(sts_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/admin/monograph-status/{sts_id}")
    public LtMonographSts updateMonographStatus(@PathVariable int sts_id,
                                                       @RequestParam("sts_status") String sts_status,
                                                       @RequestParam("sts_desc") String sts_desc){
        return adminService.updateMonographStatus(sts_id, sts_status, sts_desc);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-borrow-status")
    public List<LtMonographBorrowSts> getMonographBorrowStatus(){
        return adminService.getMonographBorrowStsList();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/admin/monograph-borrow-status/{status_id}")
    public void deleteBorrowStatusById(@PathVariable int status_id){
        adminService.deleteMonographBorrowStatusById(status_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/admin/monograph-borrow-status")
    public LtMonographBorrowSts saveMonographBorrowStatus(@RequestParam("borrow_sts_status") String borrow_sts_status,
                                              @RequestParam("borrow_sts_desc") String borrow_sts_desc){
        return adminService.saveMonographBorrowStatus(borrow_sts_status, borrow_sts_desc);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-borrow-status/{borrow_sts_id}")
    public LtMonographBorrowSts getBorrowStatusById(@PathVariable int borrow_sts_id){
        return adminService.getMonographBorrowStatusById(borrow_sts_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/admin/monograph-borrow-status/{borrow_sts_id}")
    public LtMonographBorrowSts updateMonographBorrowStatus(@PathVariable int borrow_sts_id,
                                                @RequestParam("borrow_sts_status") String borrow_sts_status,
                                                @RequestParam("borrow_sts_desc") String borrow_sts_desc){
        return adminService.updateMonographBorrowStatus(borrow_sts_id, borrow_sts_status, borrow_sts_desc);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-book-status")
    public List<LtMonographBookingSts> getMonographBookStatus(){
        return adminService.getMonographBookStsList();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/admin/monograph-book-status/{status_id}")
    public void deleteBookStatusById(@PathVariable int status_id){
        adminService.deleteMonographBookStatusById(status_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/admin/monograph-book-status")
    public LtMonographBookingSts saveMonographBookStatus(@RequestParam("book_sts_status") String book_sts_status,
                                                          @RequestParam("book_sts_desc") String book_sts_desc){
        return adminService.saveMonographBookStatus(book_sts_status, book_sts_desc);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-book-status/{book_sts_id}")
    public LtMonographBookingSts getBookStatusById(@PathVariable int book_sts_id){
        return adminService.getMonographBookStatusById(book_sts_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/admin/monograph-book-status/{book_sts_id}")
    public LtMonographBookingSts updateMonographBookStatus(@PathVariable int book_sts_id,
                                                            @RequestParam("book_sts_status") String book_sts_status,
                                                            @RequestParam("book_sts_desc") String book_sts_desc){
        return adminService.updateMonographBookStatus(book_sts_id, book_sts_status, book_sts_desc);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-location")
    public List<LtMonographLoc> getMonographLocation(){
        return adminService.getMonographLocation();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/admin/monograph-location/{loc_id}")
    public void deleteLocationById(@PathVariable int loc_id){
        adminService.deleteMonographLocationById(loc_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/admin/monograph-location")
    public LtMonographLoc saveMonographLocation(@RequestParam("loc_location") String loc_location,
                                                         @RequestParam("loc_wilayah") String loc_wilayah,
                                                @RequestParam("loc_location_code") String loc_location_code,
                                                @RequestParam("loc_telephone") String loc_telephone,
                                                @RequestParam("loc_address") String loc_address){
        return adminService.saveMonographLocation(loc_location, loc_wilayah, loc_location_code, loc_telephone, loc_address);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-location/{loc_id}")
    public LtMonographLoc getLocationById(@PathVariable int loc_id){
        return adminService.getMonographLocationById(loc_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/admin/monograph-location/{loc_id}")
    public LtMonographLoc updateMonographLocation(@PathVariable int loc_id,
                                                  @RequestParam("loc_location") String loc_location,
                                                  @RequestParam("loc_wilayah") String loc_wilayah,
                                                  @RequestParam("loc_location_code") String loc_location_code,
                                                  @RequestParam("loc_telephone") String loc_telephone,
                                                  @RequestParam("loc_address") String loc_address){
        return adminService.updateMonographLocation(loc_id, loc_location, loc_wilayah, loc_location_code, loc_telephone, loc_address);
    }



    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-cataloging")
    public List<LtMonographCataloging> getMonographCataloging(){
        return adminService.getMonographCataloging();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/admin/monograph-cataloging/{cat_id}")
    public void deleteCatalogingById(@PathVariable int cat_id){
        adminService.deleteMonographCatalogingById(cat_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/admin/monograph-cataloging")
    public LtMonographCataloging saveMonographCataloging(@RequestParam("cataloging_tag") int cataloging_tag,
                                                @RequestParam("cataloging_Ind1") String cataloging_Ind1,
                                                @RequestParam("cataloging_Ind2") String cataloging_Ind2,
                                                @RequestParam("cataloging_data") String cataloging_data){
        return adminService.saveMonographCataloging(cataloging_tag, cataloging_Ind1, cataloging_Ind2, cataloging_data);
    }



    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/monograph-cataloging/{cataloging_id}")
    public LtMonographCataloging getCatalogingById(@PathVariable int cataloging_id){
        return adminService.getMonographCatalogingById(cataloging_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/admin/monograph-cataloging/{cataloging_id}")
    public LtMonographCataloging updateMonographCataloging(@PathVariable int cataloging_id,
                                                    @RequestParam("cataloging_tag") int cataloging_tag,
                                                    @RequestParam("cataloging_Ind1") String cataloging_Ind1,
                                                    @RequestParam("cataloging_Ind2") String cataloging_Ind2,
                                                    @RequestParam("cataloging_data") String cataloging_data){
        return adminService.updateMonographCataloging(cataloging_id, cataloging_tag, cataloging_Ind1, cataloging_Ind2, cataloging_data);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/user-role")
    public List<LtUserRoles> getUserRole(){
        return adminService.getUserRole();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/admin/user-role/{role_id}")
    public void deleteRoleById(@PathVariable int role_id){
        adminService.deleteRoleById(role_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/admin/user-role")
    public LtUserRoles saveUserRole(@RequestParam("roles_type") String roles_type,
                                                         @RequestParam("roles_description") String roles_description,
                                                         @RequestParam("roles_active") int roles_active){
        return adminService.saveUserRole(roles_type, roles_description, roles_active);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/user-role/{roles_id}")
    public LtUserRoles getRoleById(@PathVariable int roles_id){
        return adminService.getRoleById(roles_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/admin/user-role/{roles_id}")
    public LtUserRoles updateUserRole(@PathVariable int roles_id,
                                      @RequestParam("roles_type") String roles_type,
                                      @RequestParam("roles_description") String roles_description,
                                      @RequestParam("roles_active") int roles_active){
        return adminService.updateUserRole(roles_id, roles_type, roles_description, roles_active);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/approved-user")
    public List<User> getApprovedUser(){
        return adminService.getApprovedUser();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/not-approved-user")
    public List<User> getNotApprovedUser(){
        return adminService.getNotApprovedUser();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/admin/user/{user_id}")
    public void deleteUserById(@PathVariable int user_id){
        adminService.deleteUserById(user_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/admin/user")
    public void saveUser(@RequestBody User request){
        authService.adminRegister(request);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/admin/user/{userId}")
    public User getUserById(@PathVariable int userId){
        return adminService.getUserById(userId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/admin/user/{user_id}")
    public void updateApprovedUser(@PathVariable int user_id, @RequestBody User request){
        adminService.updateApprovedUser(user_id, request);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/admin/not-approved-user/{user_id}")
    public void updateNotApprovedUser(@PathVariable int user_id, @RequestBody User request){
        adminService.updateNotApproveUser(user_id, request);
    }
}
