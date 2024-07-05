package com.example.elibrary.service;

import com.example.elibrary.Utils.DateUtil;
import com.example.elibrary.dto.*;
import com.example.elibrary.entity.*;
import com.example.elibrary.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LibrarianService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DtMonographBookingRepository dtMonographBookingRepository;

    @Autowired
    private DtMonographRegistrationRepository dtMonographRegistrationRepository;

    @Autowired
    private LtMonographBookingStsRepository ltMonographBookingStsRepository;

    @Autowired
    private DtMonographHistoryStatusRepository dtMonographHistoryStatusRepository;

    @Autowired
    private LtMonographBorrowStsRepository ltMonographBorrowStsRepository;

    @Autowired
    private DtAuthorRepository dtAuthorRepository;

    @Autowired
    private DtPublisherRepository dtPublisherRepository;

    @Autowired
    private LtMonographStsRepository ltMonographStsRepository;

    @Autowired
    private DtMonographDamagedRepository dtMonographDamagedRepository;

    @Autowired
    private LtMonographTypeRepository ltMonographTypeRepository;

    @Autowired
    private LtMonographLanguageRepository ltMonographLanguageRepository;

    @Autowired
    private  LtMonographLocRepository ltMonographLocRepository;

    @Autowired
    private LtMonographSubjectRepository ltMonographSubjectRepository;

    @Autowired
    private LtMonographCatalogingRepository ltMonographCatalogingRepository;

    @Autowired
    private DtMonographCatalogRegistrationRepository dtMonographCatalogRegistrationRepository;


    public List<DtMonographRegistration> getAllBooks(){
        return dtMonographRegistrationRepository.findAll();
    }

//    public List<DtMonographCatalogRegistration> getAllBooks(){
//        return dtMonographRegistrationRepository.findAll();
//    }

    public List<DtMonographRegistration> getSearchBookResult(String search_by, String title, String monograph_type){

//        if(search_by.equals("title")){
//
//            return dtMonographRegistrationRepository.searchBookByTitle(title);
//
//        }else if (search_by.equals("book_id")){
//
//            return dtMonographRegistrationRepository.searchBookByBookId(Integer.parseInt(title));
//
//        }else if (search_by.equals("author")){
//
//            return dtMonographRegistrationRepository.searchBookByAuthorId(Integer.parseInt(title));
//
//        }else{
//            return dtMonographRegistrationRepository.searchBookByPublisherId(Integer.parseInt(title));
//        }

        if(search_by.equals("title")){
            List<DtMonographCatalogRegistration> first = dtMonographCatalogRegistrationRepository.findByTagAndData(13, title);
            List<DtMonographCatalogRegistration> second = dtMonographCatalogRegistrationRepository.findByTagAndData(21, monograph_type);

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i< first.size(); i++){
                DtMonographCatalogRegistration aFirst = first.get(i);

                for(int j = 0; j<second.size(); j++){
                    DtMonographCatalogRegistration aSecond = second.get(j);

                    if(aFirst.getCatreg_mono_reg_id() == aSecond.getCatreg_mono_reg_id()){
                        list.add(aSecond.getCatreg_mono_reg_id());
                    }
                }
            }

            Integer[] array = list.toArray(new Integer[0]);
            HashSet<Integer> set = new HashSet<>(Arrays.asList(array));
            Integer[] result = set.toArray(new Integer[set.size()]);
            ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(array));
            List<DtMonographRegistration> dtMonographRegistrations = new ArrayList<>();

            for(int k = 0; k< newList.size(); k++){
                int aList = newList.get(k);
                dtMonographRegistrations.add(dtMonographRegistrationRepository.findByBookId(aList));
            }

            return dtMonographRegistrations;
        }else if (search_by.equals("book_id")){
            return dtMonographRegistrationRepository.searchBookByBookId(Integer.parseInt(title));
        }else if (search_by.equals("author")){
            List<DtMonographCatalogRegistration> first = dtMonographCatalogRegistrationRepository.findByTagAndData(11, title);
            List<DtMonographCatalogRegistration> second = dtMonographCatalogRegistrationRepository.findByTagAndData(21, monograph_type);

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i< first.size(); i++){
                DtMonographCatalogRegistration aFirst = first.get(i);

                for(int j = 0; j<second.size(); j++){
                    DtMonographCatalogRegistration aSecond = second.get(j);

                    if(aFirst.getCatreg_mono_reg_id() == aSecond.getCatreg_mono_reg_id()){
                        list.add(aSecond.getCatreg_mono_reg_id());
                    }
                }
            }

            Integer[] array = list.toArray(new Integer[0]);
            HashSet<Integer> set = new HashSet<>(Arrays.asList(array));
            Integer[] result = set.toArray(new Integer[set.size()]);
            ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(array));
            List<DtMonographRegistration> dtMonographRegistrations = new ArrayList<>();

            for(int k = 0; k< newList.size(); k++){
                int aList = newList.get(k);
                dtMonographRegistrations.add(dtMonographRegistrationRepository.findByBookId(aList));
            }

            return dtMonographRegistrations;
        }else{
            List<DtMonographCatalogRegistration> first = dtMonographCatalogRegistrationRepository.findByTagAndData(14, title);
            List<DtMonographCatalogRegistration> second = dtMonographCatalogRegistrationRepository.findByTagAndData(21, monograph_type);

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i< first.size(); i++){
                DtMonographCatalogRegistration aFirst = first.get(i);

                for(int j = 0; j<second.size(); j++){
                    DtMonographCatalogRegistration aSecond = second.get(j);

                    if(aFirst.getCatreg_mono_reg_id() == aSecond.getCatreg_mono_reg_id()){
                        list.add(aSecond.getCatreg_mono_reg_id());
                    }
                }
            }

            Integer[] array = list.toArray(new Integer[0]);
            HashSet<Integer> set = new HashSet<>(Arrays.asList(array));
            Integer[] result = set.toArray(new Integer[set.size()]);
            ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(array));
            List<DtMonographRegistration> dtMonographRegistrations = new ArrayList<>();

            for(int k = 0; k< newList.size(); k++){
                int aList = newList.get(k);
                dtMonographRegistrations.add(dtMonographRegistrationRepository.findByBookId(aList));
            }

            return dtMonographRegistrations;
        }
    }

    public AboutMonograph getMonographAbout(int reg_id){
        DtMonographRegistration book_details = dtMonographRegistrationRepository.findByBookId(reg_id);

        LtMonographSts book_status = ltMonographStsRepository.findByStsId(book_details.getReg_status());
        List<DtMonographCatalogRegistration> dtMonographCatalogRegistrations = dtMonographCatalogRegistrationRepository.findByMonoId(reg_id);

        AboutMonograph dto = new AboutMonograph();
        dto.setBook_id(reg_id);
        dto.setImage_name(book_details.getReg_image_link());

        for(int i = 0; i<dtMonographCatalogRegistrations.size(); i++){
            if(dtMonographCatalogRegistrations.get(i).getCatreg_tag() == 7){
                dto.setCall_no(dtMonographCatalogRegistrations.get(i).getCatreg_data());
            }else if(Objects.equals(dtMonographCatalogRegistrations.get(i).getCatreg_tag(), 11)){
                dto.setAuthor(dtMonographCatalogRegistrations.get(i).getCatreg_data());
            }else if(Objects.equals(dtMonographCatalogRegistrations.get(i).getCatreg_tag(), 26)){
                dto.setItem_number(dtMonographCatalogRegistrations.get(i).getCatreg_data());
            }else if(Objects.equals(dtMonographCatalogRegistrations.get(i).getCatreg_tag(), 12)) {
                dto.setCopy(Integer.valueOf(dtMonographCatalogRegistrations.get(i).getCatreg_data()));
            }else if(Objects.equals(dtMonographCatalogRegistrations.get(i).getCatreg_tag(), 13)){
                dto.setTitle(dtMonographCatalogRegistrations.get(i).getCatreg_data());
            }else if(Objects.equals(dtMonographCatalogRegistrations.get(i).getCatreg_tag(), 14)){
                dto.setPublisher(dtMonographCatalogRegistrations.get(i).getCatreg_data());
            }else if(Objects.equals(dtMonographCatalogRegistrations.get(i).getCatreg_tag(), 21)){
                dto.setBook_type(dtMonographCatalogRegistrations.get(i).getCatreg_data());
            }
        }
        dto.setBook_description(book_details.getReg_description());
        dto.setStatus(book_status.getSts_status());

        return dto;
    }

    public List<ReservedBook> getReservationListActive(int reg_id) {
        List<DtMonographBooking> aDtMonographBookings = dtMonographBookingRepository.findPendingOrCompletedBookingStatusByBookId(reg_id);
        List<ReservedBook> newReservationList = new ArrayList<>();

        for (int i = 0; i < aDtMonographBookings.size(); i++) {
            DtMonographBooking aList = aDtMonographBookings.get(i);

            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getBookingMonoId());
            User aUser = userRepository.findByUserId(aList.getBookingUserId());
            LtMonographBookingSts aLtMonographBookingSts = ltMonographBookingStsRepository.findByStatusId(aList.getBookingStatus());

            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String reserved_date = formatter.format(aList.getBookingDate());

            ReservedBook dto = new ReservedBook();
            dto.setBook_id(aList.getBookingMonoId());
            dto.setBook_title(dtMonographRegistration.getReg_title());
            dto.setUser_id(aList.getBookingUserId());
            dto.setUser_name(aUser.getFullName());
            dto.setLibrary_id(aList.getBookingLibrarianId());
            dto.setDate_reserved(reserved_date);
            dto.setStatus(aLtMonographBookingSts.getBooking_sts_status());

            newReservationList.add(dto);
        }

        return newReservationList;
    }

    public List<BorrowedBook> getHistoryListByWithUserStatus(int reg_id){
        List<DtMonographHistoryStatus> aDtMonographHistoryStatuses = dtMonographHistoryStatusRepository.findByWithUserHistoryStatus(reg_id);
        List<BorrowedBook> newBorrowedList = new ArrayList<>();

        for(int i=0; i<aDtMonographHistoryStatuses.size();i++){
            DtMonographHistoryStatus aList = aDtMonographHistoryStatuses.get(i);

            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getHistory_mono_id());
            LtMonographBorrowSts ltMonographBorrowSts = ltMonographBorrowStsRepository.findByStatusId(aList.getHistory_status());
            User user = userRepository.findByUserId(aList.getHistory_user_id());


            BorrowedBook dto = new BorrowedBook();
            dto.setBook_id(aList.getHistory_mono_id());
            dto.setBook_title(dtMonographRegistration.getReg_title());
            dto.setBorrower(user.getFullName());
            dto.setDate_borrowed(aList.getHistory_date_borrow());
            dto.setEst_date_to_return(aList.getHistory_date_return());
            dto.setAct_date_return(aList.getHistory_actual_rtn_date());
            dto.setStatus_extend(ltMonographBorrowSts.getBorrow_sts_status());

            newBorrowedList.add(dto);
        }

        return newBorrowedList;
    }

    public User getUserByUserId(String user_id){
       return userRepository.findByUserIc(user_id);
    }

    public DtMonographBooking saveReservation(DtMonographBooking dtMonographBooking){
        return dtMonographBookingRepository.save(dtMonographBooking);
    }

    public List<ReservedBook> getReservationList() {
        List<DtMonographBooking> aDtMonographBookings = dtMonographBookingRepository.findAll();
        List<ReservedBook> newReservationList = new ArrayList<>();

        for (int i = 0; i < aDtMonographBookings.size(); i++) {
            DtMonographBooking aList = aDtMonographBookings.get(i);

            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getBookingMonoId());
            User aUser = userRepository.findByUserId(aList.getBookingUserId());
            LtMonographBookingSts aLtMonographBookingSts = ltMonographBookingStsRepository.findByStatusId(aList.getBookingStatus());

            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String reserved_date = formatter.format(aList.getBookingDate());

            ReservedBook dto = new ReservedBook();
            dto.setReserve_id(aList.getBookingId());
            dto.setBook_id(aList.getBookingMonoId());
            dto.setBook_title(dtMonographRegistration.getReg_title());
            dto.setUser_id(aList.getBookingUserId());
            dto.setUser_name(aUser.getFullName());
            dto.setLibrary_id(aList.getBookingLibrarianId());
            dto.setDate_reserved(reserved_date);
            dto.setStatus(aLtMonographBookingSts.getBooking_sts_status());

            newReservationList.add(dto);
        }

        return newReservationList;
    }

    public ReservedBook getReservedBook(int reserve_id){
        DtMonographBooking dtMonographBooking = dtMonographBookingRepository.findByReserveId(reserve_id);

        DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(dtMonographBooking.getBookingMonoId());
        User aUser = userRepository.findByUserId(dtMonographBooking.getBookingUserId());
        LtMonographBookingSts aLtMonographBookingSts = ltMonographBookingStsRepository.findByStatusId(dtMonographBooking.getBookingStatus());


        ReservedBook dto = new ReservedBook();
        dto.setReserve_id(dtMonographBooking.getBookingId());
        dto.setBook_id(dtMonographBooking.getBookingMonoId());
        dto.setBook_title(dtMonographRegistration.getReg_title());
        dto.setCopy(dtMonographRegistration.getCopy());
        dto.setUser_id(dtMonographBooking.getBookingUserId());
        dto.setUser_name(aUser.getFullName());
        dto.setLibrary_id(dtMonographBooking.getBookingLibrarianId());
        dto.setDate_reserved(dtMonographBooking.getBookingDate().toString());
        dto.setStatus(aLtMonographBookingSts.getBooking_sts_status());

        return dto;
    }

    public DtMonographBooking updateReservedBookStatus(int reserve_id, Date reserved_date, int status){
        DtMonographBooking dtMonographBooking = dtMonographBookingRepository.findByReserveId(reserve_id);
        dtMonographBooking.setBookingStatus(status);
        dtMonographBooking.setBookingDate(reserved_date);
        return dtMonographBookingRepository.save(dtMonographBooking);

    }

    public DtMonographBooking updateReservedBookStatusClosed(int reserve_id, int status){
        DtMonographBooking dtMonographBooking = dtMonographBookingRepository.findByReserveId(reserve_id);
        dtMonographBooking.setBookingStatus(status);
        return dtMonographBookingRepository.save(dtMonographBooking);

    }

    public DtMonographHistoryStatus setBorrowedBook(int reserve_id, int librarian_id, Date return_date){

        DtMonographBooking dtMonographBooking = dtMonographBookingRepository.findByReserveId(reserve_id);


        DtMonographHistoryStatus dtMonographHistoryStatus = new DtMonographHistoryStatus();
        dtMonographHistoryStatus.setHistory_mono_id(dtMonographBooking.getBookingMonoId());
        dtMonographHistoryStatus.setHistory_user_id(dtMonographBooking.getBookingUserId());
        dtMonographHistoryStatus.setHistory_librarian_id(librarian_id);
        dtMonographHistoryStatus.setHistory_date_borrow(new Date());
        dtMonographHistoryStatus.setHistory_date_return(return_date);
        dtMonographHistoryStatus.setHistory_status(1);
        dtMonographHistoryStatus.setHistory_late("no");
        dtMonographHistoryStatus.setHistory_created_date(new Date());

        return dtMonographHistoryStatusRepository.save(dtMonographHistoryStatus);
    }

    public List<BorrowedBook> getHistoryListByTrueExtend(){
        List<DtMonographHistoryStatus> aDtMonographHistoryStatuses = dtMonographHistoryStatusRepository.findByTrueExtend();
        List<BorrowedBook> newBorrowedList = new ArrayList<>();

        for(int i=0; i<aDtMonographHistoryStatuses.size();i++){
            DtMonographHistoryStatus aList = aDtMonographHistoryStatuses.get(i);

            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getHistory_mono_id());
            LtMonographBorrowSts ltMonographBorrowSts = ltMonographBorrowStsRepository.findByStatusId(aList.getHistory_status());
            User user = userRepository.findByUserId(aList.getHistory_user_id());


            BorrowedBook dto = new BorrowedBook();
            dto.setHistory_id(aList.getHistory_id());
            dto.setBook_id(aList.getHistory_mono_id());
            dto.setBook_title(dtMonographRegistration.getReg_title());
            dto.setCopy(dtMonographRegistration.getCopy());
            dto.setBorrower(user.getFullName());
            dto.setDate_borrowed(aList.getHistory_date_borrow());
            dto.setExtend_date(aList.getExtend_date());
            dto.setEst_date_to_return(aList.getHistory_date_return());
            dto.setAct_date_return(aList.getHistory_actual_rtn_date());
            dto.setStatus_book(ltMonographBorrowSts.getBorrow_sts_status());
            dto.setStatus_extend(aList.getExtend_status());

            newBorrowedList.add(dto);
        }

        return newBorrowedList;
    }

    public BorrowedBook getHistoryById(int history_id){
        DtMonographHistoryStatus dtMonographHistoryStatus = dtMonographHistoryStatusRepository.findById(history_id);

        DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(dtMonographHistoryStatus.getHistory_mono_id());
        LtMonographBorrowSts ltMonographBorrowSts = ltMonographBorrowStsRepository.findByStatusId(dtMonographHistoryStatus.getHistory_status());
        User user = userRepository.findByUserId(dtMonographHistoryStatus.getHistory_user_id());

        BorrowedBook dto = new BorrowedBook();
        dto.setHistory_id(dtMonographHistoryStatus.getHistory_id());
        dto.setBook_id(dtMonographHistoryStatus.getHistory_mono_id());
        dto.setBook_title(dtMonographRegistration.getReg_title());
        dto.setCopy(dtMonographRegistration.getCopy());
        dto.setBorrower_id(user.getId());
        dto.setBorrower(user.getFullName());
        dto.setDate_borrowed(dtMonographHistoryStatus.getHistory_date_borrow());
        dto.setExtend_date(dtMonographHistoryStatus.getExtend_date());
        dto.setEst_date_to_return(dtMonographHistoryStatus.getHistory_date_return());
        dto.setAct_date_return(dtMonographHistoryStatus.getHistory_actual_rtn_date());
        dto.setStatus_book(ltMonographBorrowSts.getBorrow_sts_status());
        dto.setStatus_extend(dtMonographHistoryStatus.getExtend_status());

        return  dto;
    }

    public DtMonographHistoryStatus updateExtendApplicationStatus(int history_id, Date extend_date, String status){
        DtMonographHistoryStatus dtMonographHistoryStatus = dtMonographHistoryStatusRepository.findById(history_id);
        dtMonographHistoryStatus.setExtend_status(status);
        dtMonographHistoryStatus.setExtend_date(extend_date);
        return dtMonographHistoryStatusRepository.save(dtMonographHistoryStatus);

    }

    public List<BorrowedBook> getHistoryListByWithUserOrCompletedStatus() {
        List<DtMonographHistoryStatus> aDtMonographHistoryStatuses = dtMonographHistoryStatusRepository.findByWithUserOrCompletedHistoryStatus();
        List<BorrowedBook> newBorrowedList = new ArrayList<>();

        for (int i = 0; i < aDtMonographHistoryStatuses.size(); i++) {
            DtMonographHistoryStatus aList = aDtMonographHistoryStatuses.get(i);

            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getHistory_mono_id());
            LtMonographBorrowSts ltMonographBorrowSts = ltMonographBorrowStsRepository.findByStatusId(aList.getHistory_status());
            User user = userRepository.findByUserId(aList.getHistory_user_id());


            BorrowedBook dto = new BorrowedBook();
            dto.setHistory_id(aList.getHistory_id());
            dto.setBook_id(aList.getHistory_mono_id());
            dto.setBook_title(dtMonographRegistration.getReg_title());
            dto.setCopy(dtMonographRegistration.getCopy());
            dto.setBorrower(user.getFullName());
            dto.setDate_borrowed(aList.getHistory_date_borrow());
            dto.setExtend_date(aList.getExtend_date());
            dto.setEst_date_to_return(aList.getHistory_date_return());
            dto.setAct_date_return(aList.getHistory_actual_rtn_date());
            dto.setStatus_book(ltMonographBorrowSts.getBorrow_sts_status());
            dto.setStatus_extend(aList.getExtend_status());

            newBorrowedList.add(dto);
        }

        return newBorrowedList;
    }

    public DtMonographHistoryStatus updateReturnBorrowedBook(int history_id, String late){
        DtMonographHistoryStatus dtMonographHistoryStatus = dtMonographHistoryStatusRepository.findById(history_id);
        dtMonographHistoryStatus.setHistory_status(2);
        dtMonographHistoryStatus.setHistory_late(late);
        dtMonographHistoryStatus.setHistory_actual_rtn_date(new Date());

        return dtMonographHistoryStatusRepository.save(dtMonographHistoryStatus);
    }

    public DtMonographDamaged setDamagedBook(int mono_id, String damaged_description, int last_person, int librarian_id){
        DtMonographDamaged dtMonographDamaged = new DtMonographDamaged();
        dtMonographDamaged.setDamaged_mono_id(mono_id);
        dtMonographDamaged.setDamaged_description(damaged_description);
        dtMonographDamaged.setLast_person(last_person);
        dtMonographDamaged.setDamaged_reported_by(librarian_id);
        dtMonographDamaged.setDamaged_date(new Date());
        dtMonographDamaged.setDamaged_created_at(new Date());

        return dtMonographDamagedRepository.save(dtMonographDamaged);
    }

    public List<DamagedBook> getDamagedBookList() {
        List<DtMonographDamaged> dtMonographDamaged = dtMonographDamagedRepository.findAll();
       List<DamagedBook> newDamagedList = new ArrayList<>();

        for (int i = 0; i < dtMonographDamaged.size(); i++) {
            DtMonographDamaged aList = dtMonographDamaged.get(i);

            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getDamaged_mono_id());
            User user = userRepository.findByUserId(aList.getLast_person());


            DamagedBook dto = new DamagedBook();
            dto.setBook_id(aList.getDamaged_mono_id());
            dto.setDamaged_id(aList.getDamaged_id());
            dto.setDamaged_description(aList.getDamaged_description());
            dto.setBook_title(dtMonographRegistration.getReg_title());
            dto.setDate_return(aList.getDamaged_date());
            dto.setLast_person_id(aList.getLast_person());
            dto.setLast_person_name(user.getFullName());

            newDamagedList.add(dto);
        }

        return newDamagedList;
    }

    public DamagedBook getDamagedBookDetails(int damaged_id){

        DtMonographDamaged dtMonographDamaged = dtMonographDamagedRepository.findByDamagedId(damaged_id);

        DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(dtMonographDamaged.getDamaged_mono_id());
        User user = userRepository.findByUserId(dtMonographDamaged.getLast_person());

        DamagedBook dto = new DamagedBook();
        dto.setBook_id(dtMonographDamaged.getDamaged_mono_id());
        dto.setDamaged_id(dtMonographDamaged.getDamaged_id());
        dto.setDamaged_description(dtMonographDamaged.getDamaged_description());
        dto.setBook_title(dtMonographRegistration.getReg_title());
        dto.setDate_return(dtMonographDamaged.getDamaged_date());
        dto.setLast_person_id(dtMonographDamaged.getLast_person());
        dto.setLast_person_name(user.getFullName());

        return dto;
    }

    public DtMonographDamaged updateDamagedBookDetails(int damaged_id, String damaged_details){
        DtMonographDamaged dtMonographDamaged = dtMonographDamagedRepository.findByDamagedId(damaged_id);
        dtMonographDamaged.setDamaged_description(damaged_details);

        return dtMonographDamagedRepository.save(dtMonographDamaged);
    }

    public void deleteDamagedBook(int damaged_id){
        dtMonographDamagedRepository.deleteById(damaged_id);
    }

    public MonographDetails getMonographDetails(int monograph_id){

        DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(monograph_id);
        DtAuthor dtAuthor = dtAuthorRepository.findByAuthorId(dtMonographRegistration.getReg_author_id());
        DtPublisher dtPublisher = dtPublisherRepository.findByPublisherId(dtMonographRegistration.getReg_publisher_id());
        LtMonographLanguage ltMonographLanguage = ltMonographLanguageRepository.findByLangId(dtMonographRegistration.getReg_mono_lang());
        LtMonographSts ltMonographSts = ltMonographStsRepository.findByStsId(dtMonographRegistration.getReg_status());
        LtMonographType ltMonographType = ltMonographTypeRepository.findByTypeId(dtMonographRegistration.getReg_type());
        LtMonographLoc ltMonographLoc = ltMonographLocRepository.findByLocId(dtMonographRegistration.getReg_location_id());
        LtMonographSubject ltMonographSubject = ltMonographSubjectRepository.findBySubjectId(dtMonographRegistration.getReg_mono_subject());
        List<DtMonographCatalogRegistration> dtMonographCatalogRegistration = dtMonographCatalogRegistrationRepository.findByMonoId(dtMonographRegistration.getReg_id());
        List<LtMonographCataloging> ltMonographCataloging = ltMonographCatalogingRepository.findAll();

        List<LtMonographCataloging> aLtMonographCataloging = new ArrayList<>();

        for (int i = 0;i<dtMonographCatalogRegistration.size(); i++){
            DtMonographCatalogRegistration dtCat = dtMonographCatalogRegistration.get(i);
            for(int j = 0; j<ltMonographCataloging.size(); j++){
                LtMonographCataloging ltCat = ltMonographCataloging.get(j);

                if(dtCat.getCatreg_tag() == ltCat.getCataloging_tag()){
                    aLtMonographCataloging.add(ltCat);
                }
            }
        }

        MonographDetails monographDetails = new MonographDetails();
        monographDetails.setMonograph(dtMonographRegistration);
        monographDetails.setAuthor(dtAuthor);
        monographDetails.setPublisher(dtPublisher);
        monographDetails.setLanguage(ltMonographLanguage);
        monographDetails.setStatus(ltMonographSts);
        monographDetails.setType(ltMonographType);
        monographDetails.setLocation(ltMonographLoc);
        monographDetails.setSubject(ltMonographSubject);
        monographDetails.setCataloging(aLtMonographCataloging);
        monographDetails.setCatalog(dtMonographCatalogRegistration);

        return monographDetails;
    }

    public DtMonographRegistration setMonographRegistration(MultipartFile file, String title, String description, String reg_featured, String reg_publish, String reg_ebook, String reg_by, String status){

        try {
            byte[] bytes = file.getBytes();

            // Creating the directory to store file
            String rootPath = System.getProperty("catalina.home");
            File dir = new File(rootPath + File.separator + "elibrary"+ File.separator +"book cover page");
            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            File serverFile = new File(dir.getAbsolutePath()
                    + File.separator + file.getOriginalFilename());
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();

            DtMonographRegistration dtMonographRegistration = new DtMonographRegistration();
            dtMonographRegistration.setReg_featured(reg_featured);
            dtMonographRegistration.setReg_title(title);
            dtMonographRegistration.setReg_description(description);
            dtMonographRegistration.setReg_registered_by(reg_by);
            dtMonographRegistration.setReg_publish(reg_publish);
            dtMonographRegistration.setReg_ebook(reg_ebook);
            dtMonographRegistration.setReg_status(Integer.parseInt(status));
            dtMonographRegistration.setReg_image_link(file.getOriginalFilename());
            dtMonographRegistration.setReg_created_date(new Date());

            return dtMonographRegistrationRepository.save(dtMonographRegistration);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    public DtMonographRegistration setMonographRegistrationWithOutImage(String title, String description, String reg_featured, String reg_publish, String reg_ebook, String reg_by, String status){

        DtMonographRegistration dtMonographRegistration = new DtMonographRegistration();
        dtMonographRegistration.setReg_featured(reg_featured);
        dtMonographRegistration.setReg_title(title);
        dtMonographRegistration.setReg_description(description);
        dtMonographRegistration.setReg_registered_by(reg_by);
        dtMonographRegistration.setReg_publish(reg_publish);
        dtMonographRegistration.setReg_ebook(reg_ebook);
        dtMonographRegistration.setReg_status(Integer.parseInt(status));
        dtMonographRegistration.setReg_image_link("No_Image_Available.jpg");
        dtMonographRegistration.setReg_created_date(new Date());

        return dtMonographRegistrationRepository.save(dtMonographRegistration);


    }

    public DtMonographRegistration updateMonographRegistration(int reg_id, MultipartFile file, String title, String description, String reg_featured, String reg_publish, String reg_ebook, String status) throws IOException {

        byte[] bytes = file.getBytes();

        // Creating the directory to store file
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "elibrary"+ File.separator +"book cover page");
        if (!dir.exists())
            dir.mkdirs();

        // Create the file on server
        File serverFile = new File(dir.getAbsolutePath()
                + File.separator + file.getOriginalFilename());
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();

        DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(reg_id);
        dtMonographRegistration.setReg_featured(reg_featured);
        dtMonographRegistration.setReg_title(title);
        dtMonographRegistration.setReg_description(description);
        dtMonographRegistration.setReg_publish(reg_publish);
        dtMonographRegistration.setReg_ebook(reg_ebook);
        dtMonographRegistration.setReg_status(Integer.parseInt(status));
        dtMonographRegistration.setReg_image_link(file.getOriginalFilename());

        return dtMonographRegistrationRepository.save(dtMonographRegistration);
    }

    public DtMonographRegistration updateMonographRegistrationWithoutImage(int reg_id, String title, String description, String reg_featured, String reg_publish, String reg_ebook, String status) throws IOException {


        DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(reg_id);
        dtMonographRegistration.setReg_featured(reg_featured);
        dtMonographRegistration.setReg_title(title);
        dtMonographRegistration.setReg_description(description);
        dtMonographRegistration.setReg_publish(reg_publish);
        dtMonographRegistration.setReg_ebook(reg_ebook);
        dtMonographRegistration.setReg_status(Integer.parseInt(status));

        return dtMonographRegistrationRepository.save(dtMonographRegistration);
    }

    public List<LtMonographCataloging> getLtCataloging(){
        return ltMonographCatalogingRepository.findAll();
    }

    public DtMonographCatalogRegistration setNewCatalog(int tag, int mono_id, String ind1, String ind2, String data){

        DtMonographCatalogRegistration dtMonographCatalogRegistration = new DtMonographCatalogRegistration();
        dtMonographCatalogRegistration.setCatreg_tag(tag);
        dtMonographCatalogRegistration.setCatreg_mono_reg_id(mono_id);
        dtMonographCatalogRegistration.setCatreg_ind1(ind1);
        dtMonographCatalogRegistration.setCatreg_ind2(ind2);
        dtMonographCatalogRegistration.setCatreg_data(data);
        dtMonographCatalogRegistration.setCatreg_created_date(new Date());

        return dtMonographCatalogRegistrationRepository.save(dtMonographCatalogRegistration);

    }

    public DtMonographCatalogRegistration updateNewCatalog(int mono_id, int tag, String ind1, String ind2, String data){

        DtMonographCatalogRegistration dtMonographCatalogRegistration = dtMonographCatalogRegistrationRepository.findByMonoIdAndTag(mono_id, tag);
        dtMonographCatalogRegistration.setCatreg_ind1(ind1);
        dtMonographCatalogRegistration.setCatreg_ind2(ind2);
        dtMonographCatalogRegistration.setCatreg_data(data);

        return dtMonographCatalogRegistrationRepository.save(dtMonographCatalogRegistration);

    }

    public CatalogOptionsForm  getCatalogOptions(){

        CatalogOptionsForm catalogOptionsForm = new CatalogOptionsForm();
        catalogOptionsForm.setLanguage(ltMonographLanguageRepository.findAll());
        catalogOptionsForm.setLocation(ltMonographLocRepository.findAll());
        catalogOptionsForm.setSubject(ltMonographSubjectRepository.findAll());
        catalogOptionsForm.setType(ltMonographTypeRepository.findAll());
        catalogOptionsForm.setAuthor(dtAuthorRepository.findAll());
        catalogOptionsForm.setPublisher(dtPublisherRepository.findAll());

        return catalogOptionsForm;
    }

    public List<LtMonographLanguage>  getLanguage(){
        return ltMonographLanguageRepository.findAll();
    }

    public List<LtMonographSubject>  getSubject(){
        return ltMonographSubjectRepository.findAll();
    }

    public List<LtMonographType>  getType(){
        return ltMonographTypeRepository.findAll();
    }

    public List<DtMonographCatalogRegistration> getMarcTag(int mono_id){
        return dtMonographCatalogRegistrationRepository.findByMonoId(mono_id);
    }

    public List<Object[]> pivotDataByCatRegTag(int regId){
        return dtMonographCatalogRegistrationRepository.getAllBooksCat(regId);
    }

    public List<DtAuthor> getAuthor(){
        return dtAuthorRepository.findAll();
    }

    public List<DtPublisher> getPublisherList(){
        return dtPublisherRepository.findAll();
    }

    public DtAuthor saveAuthor(String name, String email, String telephone, int publisher_id){
        DtAuthor author = new DtAuthor();
        author.setAuthor_name(name);
        author.setAuthor_email(email);
        author.setAuthor_telephone(telephone);
        author.setPublisher_id(publisher_id);

        return dtAuthorRepository.save(author);
    }

    public DtPublisher savePublisher(String publisher_name, String publisher_address1, String publisher_address2, String publisher_address3, String publisher_telephone, String publisher_email){
        DtPublisher publisher = new DtPublisher();
        publisher.setPublisher_name(publisher_name);
        publisher.setPublisher_address1(publisher_address1);
        publisher.setPublisher_address2(publisher_address2);
        publisher.setPublisher_address3(publisher_address3);
        publisher.setPublisher_telephone(publisher_telephone);
        publisher.setPublisher_email(publisher_email);

        return dtPublisherRepository.save(publisher);
    }

    public ResponseEntity<Resource> getMonoImage(int mono_id){
        String image_name =  dtMonographRegistrationRepository.findImageById(mono_id);
        String rootPath = System.getProperty("catalina.home");
        rootPath = rootPath + "/elibrary/book cover page";
        // Resolve file path within Tomcat's file system
        Path filePath = Paths.get(rootPath).resolve(image_name);
        Resource resource;
        try {
            resource = new UrlResource(filePath.toUri());
        } catch (IOException e) {
            throw new RuntimeException("File not found: " + image_name);
        }

        // Determine the file's MIME type
        String contentType;
        try {
            contentType = Files.probeContentType(filePath);
        } catch (IOException e) {
            contentType = "application/octet-stream";
        }

        // Set content disposition
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .headers(headers)
                .body(resource);
    }

    public Date getMinReserveDate(int book_id){
        List<DtMonographBooking> dtMonographBookings = dtMonographBookingRepository.findPendingOrCompletedBookingStatusByBookId(book_id);
        List<DtMonographHistoryStatus> dtMonographHistoryStatuses = dtMonographHistoryStatusRepository.findByWithUserHistoryStatus(book_id);

        Date today = new Date();

        if(dtMonographHistoryStatuses.size()>0){
            for(int i = 0; i<dtMonographHistoryStatuses.size(); i++){
                DtMonographHistoryStatus dtMonographHistoryStatus = dtMonographHistoryStatuses.get(i);
                if (dtMonographHistoryStatus.getExtend_date() != null){
                    if(dtMonographHistoryStatus.getExtend_date().after(today)){
                        today = dtMonographHistoryStatus.getExtend_date();
                    }
                }else{
                    if(dtMonographHistoryStatus.getHistory_date_return().after(today)){
                        today = dtMonographHistoryStatus.getHistory_date_return();
                    }
                }
            }
        }

        if(dtMonographBookings.size()>0){
            for(int i = 0; i<dtMonographBookings.size(); i++){
                DtMonographBooking dtMonographBooking = dtMonographBookings.get(i);
                Date reserved_date = dtMonographBooking.getBookingDate();
                reserved_date = DateUtil.addDays(reserved_date, 8);
                if (reserved_date.after(today)){
                    today = reserved_date;
                }
            }
        }

        return today;

    }

    public DateExclude getAvailableReturnDate(int reserve_id){
        DtMonographBooking dtMonographBooking = dtMonographBookingRepository.findByReserveId(reserve_id);
        List<DtMonographBooking> dtMonographBookings = dtMonographBookingRepository.findPendingOrCompletedBookingStatusByBookId(dtMonographBooking.getBookingMonoId());

        Date tempDate = new Date(2999,12,30);
        DateExclude dateExclude = new DateExclude();


        if(dtMonographBookings.size()>0){
            for(int i = 0; i<dtMonographBookings.size(); i++){
                DtMonographBooking aDtMonographBooking = dtMonographBookings.get(i);

                if(aDtMonographBooking.getBookingDate().before(tempDate) && aDtMonographBooking.getBookingDate().after(dtMonographBooking.getBookingDate())) {
                    tempDate = aDtMonographBooking.getBookingDate();
                    dateExclude.setStartDate(new Date());
                    dateExclude.setEndDate(aDtMonographBooking.getBookingDate());
                }
            }
        }

        return dateExclude;
    }

    public List<DateExclude> getExcludeDetails(int book_id){
        List<DtMonographBooking> dtMonographBookings = dtMonographBookingRepository.findPendingOrCompletedBookingStatusByBookId(book_id);
        List<DtMonographHistoryStatus> dtMonographHistoryStatuses = dtMonographHistoryStatusRepository.findByWithUserHistoryStatus(book_id);
        List<DateExclude> dateExcludesList = new ArrayList<>();


        if(dtMonographHistoryStatuses.size()>0){
            for(int i = 0; i<dtMonographHistoryStatuses.size(); i++){
                DtMonographHistoryStatus dtMonographHistoryStatus = dtMonographHistoryStatuses.get(i);
                DateExclude dateExclude = new DateExclude();

                if(dtMonographHistoryStatus.getExtend_date() != null){
                    dateExclude.setStartDate(dtMonographHistoryStatus.getHistory_date_borrow());
                    dateExclude.setEndDate(dtMonographHistoryStatus.getExtend_date());
                }else {
                    dateExclude.setStartDate(dtMonographHistoryStatus.getHistory_date_borrow());
                    dateExclude.setEndDate(dtMonographHistoryStatus.getHistory_date_return());
                }

                dateExcludesList.add(dateExclude);
            }
        }

        if(dtMonographBookings.size()>0){
            for(int i = 0; i<dtMonographBookings.size(); i++){
                DtMonographBooking dtMonographBooking = dtMonographBookings.get(i);
                DateExclude dateExclude = new DateExclude();

                dateExclude.setStartDate(DateUtil.addDays(dtMonographBooking.getBookingDate(),1) );
                dateExclude.setEndDate(DateUtil.addDays(dtMonographBooking.getBookingDate(),8));

                dateExcludesList.add(dateExclude);
            }
        }

        return dateExcludesList;
    }

    public DateExclude getAvailableExtendDate(int borrow_id){
        DtMonographHistoryStatus dtMonographHistoryStatus = dtMonographHistoryStatusRepository.findById(borrow_id);
        List<DtMonographBooking> dtMonographBookings = dtMonographBookingRepository.findPendingOrCompletedBookingStatusByBookId(dtMonographHistoryStatus.getHistory_mono_id());

        Date tempDate = new Date(2999,12,30);
        DateExclude dateExclude = new DateExclude();


        if(dtMonographBookings.size()>0){
            for(int i = 0; i<dtMonographBookings.size(); i++){
                DtMonographBooking aDtMonographBooking = dtMonographBookings.get(i);

                if(aDtMonographBooking.getBookingDate().before(tempDate) && aDtMonographBooking.getBookingDate().after(dtMonographHistoryStatus.getHistory_date_return())) {
                    tempDate = aDtMonographBooking.getBookingDate();
                    dateExclude.setStartDate(dtMonographHistoryStatus.getHistory_date_return());
                    dateExclude.setEndDate(aDtMonographBooking.getBookingDate());
                }
            }
        }

        return dateExclude;
    }

    public List<LtMonographSts> getAllMonoStatus(){
        return ltMonographStsRepository.findAll();
    }

}
