package com.example.elibrary.service;

import com.example.elibrary.entity.*;
import com.example.elibrary.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AdminService {

    @Autowired
    private LtMonographTypeRepository ltMonographTypeRepository;

    @Autowired
    private LtMonographSubjectRepository ltMonographSubjectRepository;

    @Autowired
    private LtMonographLanguageRepository ltMonographLanguageRepository;

    @Autowired
    private LtMonographStsRepository ltMonographStsRepository;

    @Autowired
    private LtMonographBorrowStsRepository ltMonographBorrowStsRepository;

    @Autowired
    private LtMonographBookingStsRepository ltMonographBookingStsRepository;

    @Autowired
    private LtMonographLocRepository ltMonographLocRepository;

    @Autowired
    private LtMonographCatalogingRepository ltMonographCatalogingRepository;

    @Autowired
    private LtUserRolesRepository ltUserRolesRepository;

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public List<LtMonographType> getMonographTypeList(){
        return ltMonographTypeRepository.findAll();
    }

    public LtMonographType getMonographTypeById(int type_id){
        return ltMonographTypeRepository.findByTypeId(type_id);
    }

    public void deleteMonographTypeById(int type_id){
        ltMonographTypeRepository.deleteById(type_id);
    }

    public LtMonographSubject getMonographSubjectById(int subject_id){
        return ltMonographSubjectRepository.findBySubjectId(subject_id);
    }

    public List<LtMonographSubject> getMonographSubjectList(){
        return ltMonographSubjectRepository.findAll();
    }

    public void deleteMonographSubjectById(int subject_id){
        ltMonographSubjectRepository.deleteById(subject_id);
    }

    public LtMonographType saveMonographType(String type_name,String type_desc, int type_active){
        LtMonographType ltMonographType = new LtMonographType();
        ltMonographType.setType_type(type_name);
        ltMonographType.setType_description(type_desc);
        ltMonographType.setType_active(type_active);
        ltMonographType.setType_created_at(new Date());
        ltMonographType.setType_created_by("admin");

        return ltMonographTypeRepository.save(ltMonographType);
    }

    public LtMonographType updateMonographType(int type_id, String type_name,String type_desc, int type_active){
        LtMonographType ltMonographType = ltMonographTypeRepository.findByTypeId(type_id);
        ltMonographType.setType_type(type_name);
        ltMonographType.setType_description(type_desc);
        ltMonographType.setType_active(type_active);

        return ltMonographTypeRepository.save(ltMonographType);
    }

    public LtMonographSubject saveMonographSubject(String subject_name,String subject_desc, int subject_active){

        LtMonographSubject ltMonographSubject = new LtMonographSubject();
        ltMonographSubject.setSubject_subject(subject_name);
        ltMonographSubject.setSubject_description(subject_desc);
        ltMonographSubject.setSubject_active(subject_active);
        ltMonographSubject.setSubject_created_at(new Date());
        ltMonographSubject.setSubject_created_by("admin");

        return ltMonographSubjectRepository.save(ltMonographSubject);
    }

    public LtMonographSubject updateMonographSubject(int subject_id, String subject_name,String subject_desc, int subject_active){

        LtMonographSubject ltMonographSubject = ltMonographSubjectRepository.findBySubjectId(subject_id);
        ltMonographSubject.setSubject_subject(subject_name);
        ltMonographSubject.setSubject_description(subject_desc);
        ltMonographSubject.setSubject_active(subject_active);

        return ltMonographSubjectRepository.save(ltMonographSubject);
    }

    public List<LtMonographLanguage> getMonographLanguageList(){
        return ltMonographLanguageRepository.findAll();
    }

    public void deleteMonographLanguageById(int lang_id){
        ltMonographLanguageRepository.deleteById(lang_id);
    }

    public LtMonographLanguage saveMonographLanguage(String lang_name,String lang_desc, int lang_active){

        LtMonographLanguage ltMonographLanguage = new LtMonographLanguage();
        ltMonographLanguage.setLang_type(lang_name);
        ltMonographLanguage.setLang_description(lang_desc);
        ltMonographLanguage.setLang_active(lang_active);
        ltMonographLanguage.setLang_created_at(new Date());
        ltMonographLanguage.setLang_created_by("admin");

        return ltMonographLanguageRepository.save(ltMonographLanguage);
    }

    public LtMonographLanguage updateMonographLanguage(int lang_id, String lang_name,String lang_desc, int lang_active){

        LtMonographLanguage ltMonographLanguage = ltMonographLanguageRepository.findByLangId(lang_id);
        ltMonographLanguage.setLang_type(lang_name);
        ltMonographLanguage.setLang_description(lang_desc);
        ltMonographLanguage.setLang_active(lang_active);

        return ltMonographLanguageRepository.save(ltMonographLanguage);
    }

    public LtMonographLanguage getMonographLanguageById(int lang_id){
        return ltMonographLanguageRepository.findByLangId(lang_id);
    }

    public List<LtMonographSts> getMonographStsList(){
        return ltMonographStsRepository.findAll();
    }

    public void deleteMonographStatusById(int sts_id){
        ltMonographStsRepository.deleteById(sts_id);
    }

    public LtMonographSts saveMonographStatus(String sts_status,String sts_description){

        LtMonographSts ltMonographSts = new LtMonographSts();
        ltMonographSts.setSts_status(sts_status);
        ltMonographSts.setSts_description(sts_description);

        return ltMonographStsRepository.save(ltMonographSts);
    }

    public LtMonographSts getMonographStatusById(int sts_id){
        return ltMonographStsRepository.findByStsId(sts_id);
    }

    public LtMonographSts updateMonographStatus(int sts_id, String sts_status,String sts_desc){


        LtMonographSts ltMonographSts = ltMonographStsRepository.findByStsId(sts_id);
        ltMonographSts.setSts_status(sts_status);
        ltMonographSts.setSts_description(sts_desc);

        return ltMonographStsRepository.save(ltMonographSts);
    }

    public List<LtMonographBorrowSts> getMonographBorrowStsList(){
        return ltMonographBorrowStsRepository.findAll();
    }

    public void deleteMonographBorrowStatusById(int sts_id){
        ltMonographBorrowStsRepository.deleteById(sts_id);
    }

    public LtMonographBorrowSts saveMonographBorrowStatus(String borrow_sts_status,String borrow_sts_description){

        LtMonographBorrowSts ltMonographBorrowSts = new LtMonographBorrowSts();
        ltMonographBorrowSts.setBorrow_sts_status(borrow_sts_status);
        ltMonographBorrowSts.setBorrow_sts_description(borrow_sts_description);

        return ltMonographBorrowStsRepository.save(ltMonographBorrowSts);
    }

    public LtMonographBorrowSts getMonographBorrowStatusById(int borrow_sts_id){
        return ltMonographBorrowStsRepository.findByStatusId(borrow_sts_id);
    }

    public LtMonographBorrowSts updateMonographBorrowStatus(int borrow_sts_id, String borrow_sts_status,String borrow_sts_desc){

        LtMonographBorrowSts ltMonographBorrowSts = ltMonographBorrowStsRepository.findByStatusId(borrow_sts_id);
        ltMonographBorrowSts.setBorrow_sts_status(borrow_sts_status);
        ltMonographBorrowSts.setBorrow_sts_description(borrow_sts_desc);

        return ltMonographBorrowStsRepository.save(ltMonographBorrowSts);
    }

    public List<LtMonographBookingSts> getMonographBookStsList(){
        return ltMonographBookingStsRepository.findAll();
    }

    public void deleteMonographBookStatusById(int sts_id){
        ltMonographBookingStsRepository.deleteById(sts_id);
    }

    public LtMonographBookingSts saveMonographBookStatus(String book_sts_status,String book_sts_description){

        LtMonographBookingSts ltMonographBookingSts = new LtMonographBookingSts();
        ltMonographBookingSts.setBooking_sts_status(book_sts_status);
        ltMonographBookingSts.setBooking_sts_description(book_sts_description);

        return ltMonographBookingStsRepository.save(ltMonographBookingSts);
    }

    public LtMonographBookingSts getMonographBookStatusById(int book_sts_id){
        return ltMonographBookingStsRepository.findByStatusId(book_sts_id);
    }

    public LtMonographBookingSts updateMonographBookStatus(int book_sts_id, String book_sts_status,String book_sts_desc){

        LtMonographBookingSts ltMonographBookingSts = ltMonographBookingStsRepository.findByStatusId(book_sts_id);
        ltMonographBookingSts.setBooking_sts_status(book_sts_status);
        ltMonographBookingSts.setBooking_sts_description(book_sts_desc);

        return ltMonographBookingStsRepository.save(ltMonographBookingSts);
    }

    public List<LtMonographLoc> getMonographLocation(){
        return ltMonographLocRepository.findAll();
    }

    public void deleteMonographLocationById(int loc_id){
        ltMonographLocRepository.deleteById(loc_id);
    }

    public LtMonographLoc saveMonographLocation(String loc_location,String loc_wilayah, String loc_location_code,
                                                String loc_telephone, String loc_address){

        LtMonographLoc ltMonographLoc = new LtMonographLoc();
        ltMonographLoc.setLoc_location(loc_location);
        ltMonographLoc.setLoc_wilayah(loc_wilayah);
        ltMonographLoc.setLoc_location_code(loc_location_code);
        ltMonographLoc.setLoc_telephone(loc_telephone);
        ltMonographLoc.setLoc_address(loc_address);
        ltMonographLoc.setLoc_created_at(new Date());
        ltMonographLoc.setLoc_created_by("admin");

        return ltMonographLocRepository.save(ltMonographLoc);
    }

    public LtMonographLoc getMonographLocationById(int loc_id){
        return ltMonographLocRepository.findByLocId(loc_id);
    }

    public LtMonographLoc updateMonographLocation(int loc_id, String loc_location, String loc_wilayah, String loc_location_code, String loc_telephone, String loc_address){

        LtMonographLoc ltMonographLoc = ltMonographLocRepository.findByLocId(loc_id);
        ltMonographLoc.setLoc_location(loc_location);
        ltMonographLoc.setLoc_wilayah(loc_wilayah);
        ltMonographLoc.setLoc_location_code(loc_location_code);
        ltMonographLoc.setLoc_telephone(loc_telephone);
        ltMonographLoc.setLoc_address(loc_address);

        return ltMonographLocRepository.save(ltMonographLoc);
    }

    public List<LtMonographCataloging> getMonographCataloging(){
        return ltMonographCatalogingRepository.findAll();
    }

    public void deleteMonographCatalogingById(int cat_id){
        ltMonographCatalogingRepository.deleteById(cat_id);
    }

    public LtMonographCataloging saveMonographCataloging(int cataloging_tag,String cataloging_Ind1, String cataloging_Ind2,
                                                String cataloging_data){

        LtMonographCataloging ltMonographCataloging = new LtMonographCataloging();
        ltMonographCataloging.setCataloging_tag(cataloging_tag);
        ltMonographCataloging.setCataloging_Ind1(cataloging_Ind1);
        ltMonographCataloging.setCataloging_Ind2(cataloging_Ind2);
        ltMonographCataloging.setCataloging_data(cataloging_data);
        ltMonographCataloging.setCataloging_created_at(new Date());
        ltMonographCataloging.setCataloging_created_by("admin");

        return ltMonographCatalogingRepository.save(ltMonographCataloging);
    }

    public LtMonographCataloging getMonographCatalogingById(int cataloging_id){
        return ltMonographCatalogingRepository.findByCatalogingId(cataloging_id);
    }

    public LtMonographCataloging updateMonographCataloging(int cataloging_id, int cataloging_tag, String cataloging_Ind1,
                                                           String cataloging_Ind2, String cataloging_data){

        LtMonographCataloging ltMonographCataloging = ltMonographCatalogingRepository.findByCatalogingId(cataloging_id);
        ltMonographCataloging.setCataloging_tag(cataloging_tag);
        ltMonographCataloging.setCataloging_Ind1(cataloging_Ind1);
        ltMonographCataloging.setCataloging_Ind2(cataloging_Ind2);
        ltMonographCataloging.setCataloging_data(cataloging_data);

        return ltMonographCatalogingRepository.save(ltMonographCataloging);
    }

    public List<LtUserRoles> getUserRole(){
        return ltUserRolesRepository.findAll();
    }

    public void deleteRoleById(int role_id){
        ltUserRolesRepository.deleteById(role_id);
    }

    public LtUserRoles saveUserRole(String roles_type,String roles_description, int roles_active){

        LtUserRoles ltUserRoles = new LtUserRoles();
        ltUserRoles.setRoles_type(roles_type);
        ltUserRoles.setRoles_description(roles_description);
        ltUserRoles.setRoles_active(roles_active);
        ltUserRoles.setRoles_created_at(new Date());
        ltUserRoles.setRoles_created_by("admin");


        return ltUserRolesRepository.save(ltUserRoles);
    }

    public LtUserRoles getRoleById(int roles_id){
        return ltUserRolesRepository.findByRoleId(roles_id);
    }

    public LtUserRoles updateUserRole(int roles_id, String roles_type, String roles_description, int roles_active){

        LtUserRoles ltUserRoles = ltUserRolesRepository.findByRoleId(roles_id);
        ltUserRoles.setRoles_type(roles_type);
        ltUserRoles.setRoles_description(roles_description);
        ltUserRoles.setRoles_active(roles_active);

        return ltUserRolesRepository.save(ltUserRoles);
    }

    public List<User> getApprovedUser(){
        return userRepository.findByApproved();
    }

    public List<User> getNotApprovedUser(){
        return userRepository.findByNotApproved();
    }

    public void deleteUserById(int user_id){
        userRepository.deleteById(user_id);
    }

    public User getUserByIC(String ic){
        return userRepository.findByUserIc(ic);
    }

    public User getUserById(int user_id){
        return userRepository.findByUserId(user_id);
    }

    public void updateApprovedUser(int user_id, User request){

        User user = userRepository.findByUserId(user_id);
        user.setUsername(request.getUsername());
        user.setFullName(request.getFullName());
        user.setRole_id(request.getRole_id());
        user.setAddress1(request.getAddress1());
        user.setAddress2(request.getAddress2());
        user.setEmail(request.getEmail());
        user.setPhoneNo(request.getPhoneNo());
        user.setState(request.getState());
        user.setRole(request.getRole());

        userRepository.save(user);
    }

    public void updateNotApproveUser(int user_id, User request){
        User user = userRepository.findByUserId(user_id);
        user.setUsername(request.getUsername());
        user.setFullName(request.getFullName());
        user.setRole_id(request.getRole_id());
        user.setAddress1(request.getAddress1());
        user.setAddress2(request.getAddress2());
        user.setEmail(request.getEmail());
        user.setPhoneNo(request.getPhoneNo());
        user.setState(request.getState());
        user.setRole(request.getRole());

        if(Objects.equals(request.getApproved(), "yes")){
            user.setApproved(request.getApproved());
            user.setApprovedBy(request.getApprovedBy());
            user.setApprovedDate(new Date());
        }


        userRepository.save(user);
    }

}
