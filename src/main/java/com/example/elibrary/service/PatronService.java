package com.example.elibrary.service;

import com.example.elibrary.Utils.DateUtil;
import com.example.elibrary.dto.*;
import com.example.elibrary.entity.*;
import com.example.elibrary.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PatronService {

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
    private DtMonographCatalogRegistrationRepository dtMonographCatalogRegistrationRepository;

    @Autowired
    private LtMonographLanguageRepository ltMonographLanguageRepository;

    @Autowired
    private LtMonographTypeRepository ltMonographTypeRepository;

    @Autowired
    private LtMonographLocRepository ltMonographLocRepository;

    @Autowired
    private LtMonographSubjectRepository ltMonographSubjectRepository;

    @Autowired
    private LtMonographCatalogingRepository ltMonographCatalogingRepository;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<ReservedBook> getReservationList(int user_id) {
        List<DtMonographBooking> aDtMonographBookings = dtMonographBookingRepository.findByUserId(user_id);
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

    public List<BorrowedBook> getBorrowedList(int user_id) {
        List<DtMonographHistoryStatus> aDtMonographHistoryStatuses = dtMonographHistoryStatusRepository.findByUserId(user_id);
        List<BorrowedBook> newBorrowedList = new ArrayList<>();

        for (int i = 0; i < aDtMonographHistoryStatuses.size(); i++) {
            DtMonographHistoryStatus aList = aDtMonographHistoryStatuses.get(i);

            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getHistory_mono_id());


            BorrowedBook dto = new BorrowedBook();
            dto.setHistory_id(aList.getHistory_id());
            dto.setBook_id(aList.getHistory_mono_id());
            dto.setBook_title(dtMonographRegistration.getReg_title());
            dto.setDate_borrowed(aList.getHistory_date_borrow());
            dto.setEst_date_to_return(aList.getHistory_date_return());
            dto.setAct_date_return(aList.getHistory_actual_rtn_date());
            dto.setExtend_date(aList.getExtend_date());
            dto.setStatus_extend(aList.getExtend_status());

            newBorrowedList.add(dto);
        }

        return newBorrowedList;
    }

    public List<BorrowedBook> getHistoryListByUserIdAndCompletedStatus(int user_id) {
        List<DtMonographHistoryStatus> aDtMonographHistoryStatuses = dtMonographHistoryStatusRepository.findByUserIdAndCompletedHistoryStatus(user_id);
        List<BorrowedBook> newBorrowedList = new ArrayList<>();

        for (int i = 0; i < aDtMonographHistoryStatuses.size(); i++) {
            DtMonographHistoryStatus aList = aDtMonographHistoryStatuses.get(i);

            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getHistory_mono_id());
            LtMonographBorrowSts ltMonographBorrowSts = ltMonographBorrowStsRepository.findByStatusId(aList.getHistory_status());


            BorrowedBook dto = new BorrowedBook();
            dto.setBook_id(aList.getHistory_mono_id());
            dto.setBook_title(dtMonographRegistration.getReg_title());
            dto.setDate_borrowed(aList.getHistory_date_borrow());
            dto.setEst_date_to_return(aList.getHistory_date_return());
            dto.setAct_date_return(aList.getHistory_actual_rtn_date());
            dto.setExtend_date(aList.getExtend_date());
            dto.setStatus_extend(ltMonographBorrowSts.getBorrow_sts_status());

            newBorrowedList.add(dto);
        }

        return newBorrowedList;
    }

    public List<DtMonographRegistration> getAllBooks(){
        return dtMonographRegistrationRepository.findAll();
    }

    public List<DtMonographRegistration> getSearchBookResult(String search_by, String title, String monograph_type){

        if(search_by.equals("title")){
            List<DtMonographCatalogRegistration> first = dtMonographCatalogRegistrationRepository.findByTagAndData(13, title);
            List<DtMonographCatalogRegistration> second = dtMonographCatalogRegistrationRepository.findByTagAndData(21, monograph_type);
//            List<DtMonographCatalogRegistration> result = new ArrayList<>();

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i< first.size(); i++){
                DtMonographCatalogRegistration aFirst = first.get(i);

                for(int j = 0; j<second.size(); j++){
                    DtMonographCatalogRegistration aSecond = second.get(j);

                    if(aFirst.getCatreg_mono_reg_id() == aSecond.getCatreg_mono_reg_id()){
                        list.add(aFirst.getCatreg_mono_reg_id());
                    }
                }
            }

//            Integer[] array = list.toArray(new Integer[0]);
//            HashSet<Integer> set = new HashSet<>(Arrays.asList(array));
//            Integer[] result = set.toArray(new Integer[set.size()]);
//            ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(array));
            List<DtMonographRegistration> dtMonographRegistrations = new ArrayList<>();

            for(int k = 0; k< list.size(); k++){
                int aList = list.get(k);
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
                        list.add(aFirst.getCatreg_mono_reg_id());
                    }
                }
            }

//            Integer[] array = list.toArray(new Integer[0]);
//            HashSet<Integer> set = new HashSet<>(Arrays.asList(array));
//            Integer[] result = set.toArray(new Integer[set.size()]);
//            ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(array));
            List<DtMonographRegistration> dtMonographRegistrations = new ArrayList<>();

            for(int k = 0; k< list.size(); k++){
                int aList = list.get(k);
                dtMonographRegistrations.add(dtMonographRegistrationRepository.findByBookId(aList));
            }

            return dtMonographRegistrations;
        }else{
            List<DtMonographCatalogRegistration> first = dtMonographCatalogRegistrationRepository.findByTagAndData(14, title);
            List<DtMonographCatalogRegistration> second = dtMonographCatalogRegistrationRepository.findByTagAndData(21, monograph_type);

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i< first.size(); i++){
//                DtMonographCatalogRegistration aFirst = first.get(i);

                for(int j = 0; j<second.size(); j++){
//                    DtMonographCatalogRegistration aSecond = second.get(j);

                    if(first.get(i).getCatreg_mono_reg_id() == second.get(j).getCatreg_mono_reg_id()){
                        list.add(first.get(i).getCatreg_mono_reg_id());
                    }
                }
            }

//            Integer[] array = list.toArray(new Integer[0]);
//            HashSet<Integer> set = new HashSet<>(Arrays.asList(array));
//            Integer[] result = set.toArray(new Integer[set.size()]);
//            ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(array));
            List<DtMonographRegistration> dtMonographRegistrations = new ArrayList<>();

            for(int k = 0; k< list.size(); k++){
                int aList = list.get(k);
                dtMonographRegistrations.add(dtMonographRegistrationRepository.findByBookId(aList));
            }

            return dtMonographRegistrations;
        }

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
    }

    public String getSearchBookResulttest(String search_by, String title, String monograph_type){
        try {


            if (search_by.equals("title")) {
                List<DtMonographCatalogRegistration> first = dtMonographCatalogRegistrationRepository.findByTagAndData(13, title);
                List<DtMonographCatalogRegistration> second = dtMonographCatalogRegistrationRepository.findByTagAndData(21, monograph_type);
//            List<DtMonographCatalogRegistration> result = new ArrayList<>();

                List<Integer> list = new ArrayList<>();

                for (int i = 0; i < first.size(); i++) {
                    DtMonographCatalogRegistration aFirst = first.get(i);

                    for (int j = 0; j < second.size(); j++) {
                        DtMonographCatalogRegistration aSecond = second.get(j);

                        if (aFirst.getCatreg_mono_reg_id() == aSecond.getCatreg_mono_reg_id()) {
                            list.add(aFirst.getCatreg_mono_reg_id());
                        }
                    }
                }

//            Integer[] array = list.toArray(new Integer[0]);
//            HashSet<Integer> set = new HashSet<>(Arrays.asList(array));
//            Integer[] result = set.toArray(new Integer[set.size()]);
//            ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(array));
                List<DtMonographRegistration> dtMonographRegistrations = new ArrayList<>();

                for (int k = 0; k < list.size(); k++) {
                    int aList = list.get(k);
                    dtMonographRegistrations.add(dtMonographRegistrationRepository.findByBookId(aList));
                }

                return dtMonographRegistrations.toString();
            } else if (search_by.equals("book_id")) {
                return dtMonographRegistrationRepository.searchBookByBookId(Integer.parseInt(title)).toString();
            } else if (search_by.equals("author")) {
                List<DtMonographCatalogRegistration> first = dtMonographCatalogRegistrationRepository.findByTagAndData(11, title);
                List<DtMonographCatalogRegistration> second = dtMonographCatalogRegistrationRepository.findByTagAndData(21, monograph_type);

                List<Integer> list = new ArrayList<>();

                for (int i = 0; i < first.size(); i++) {
                    DtMonographCatalogRegistration aFirst = first.get(i);

                    for (int j = 0; j < second.size(); j++) {
                        DtMonographCatalogRegistration aSecond = second.get(j);

                        if (aFirst.getCatreg_mono_reg_id() == aSecond.getCatreg_mono_reg_id()) {
                            list.add(aFirst.getCatreg_mono_reg_id());
                        }
                    }
                }

//            Integer[] array = list.toArray(new Integer[0]);
//            HashSet<Integer> set = new HashSet<>(Arrays.asList(array));
//            Integer[] result = set.toArray(new Integer[set.size()]);
//            ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(array));
                List<DtMonographRegistration> dtMonographRegistrations = new ArrayList<>();

                for (int k = 0; k < list.size(); k++) {
                    int aList = list.get(k);
                    dtMonographRegistrations.add(dtMonographRegistrationRepository.findByBookId(aList));
                }

                return dtMonographRegistrations.toString();
            } else {
                List<DtMonographCatalogRegistration> first = dtMonographCatalogRegistrationRepository.findByTagAndData(14, title);
                List<DtMonographCatalogRegistration> second = dtMonographCatalogRegistrationRepository.findByTagAndData(21, monograph_type);

                List<Integer> list = new ArrayList<>();

                for (int i = 0; i < first.size(); i++) {
//                DtMonographCatalogRegistration aFirst = first.get(i);

                    for (int j = 0; j < second.size(); j++) {
//                    DtMonographCatalogRegistration aSecond = second.get(j);

                        if (first.get(i).getCatreg_mono_reg_id() == second.get(j).getCatreg_mono_reg_id()) {
                            list.add(first.get(i).getCatreg_mono_reg_id());
                        }
                    }
                }

//            Integer[] array = list.toArray(new Integer[0]);
//            HashSet<Integer> set = new HashSet<>(Arrays.asList(array));
//            Integer[] result = set.toArray(new Integer[set.size()]);
//            ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(array));
                List<DtMonographRegistration> dtMonographRegistrations = new ArrayList<>();

                for (int k = 0; k < list.size(); k++) {
                    int aList = list.get(k);
                    dtMonographRegistrations.add(dtMonographRegistrationRepository.findByBookId(aList));
                }

                return list.toString();
            }
        }catch (Exception e){
            return e.toString();
        }
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
            }else if(Objects.equals(dtMonographCatalogRegistrations.get(i).getCatreg_tag(), 12)){
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

    public DtMonographBooking saveReservation(DtMonographBooking dtMonographBooking){
        return dtMonographBookingRepository.save(dtMonographBooking);
    }

    public BorrowedBook getBorrowedBookById(int history_id){
        DtMonographHistoryStatus dtMonographHistoryStatus = dtMonographHistoryStatusRepository.findById(history_id);
        DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(dtMonographHistoryStatus.getHistory_mono_id());
        LtMonographBorrowSts ltMonographBorrowSts = ltMonographBorrowStsRepository.findByStatusId(dtMonographHistoryStatus.getHistory_status());

        BorrowedBook dto = new BorrowedBook();
        dto.setHistory_id(dtMonographHistoryStatus.getHistory_id());
        dto.setBook_id(dtMonographHistoryStatus.getHistory_mono_id());
        dto.setBook_title(dtMonographRegistration.getReg_title());
        dto.setDate_borrowed(dtMonographHistoryStatus.getHistory_date_borrow());
        dto.setEst_date_to_return(dtMonographHistoryStatus.getHistory_date_return());
        dto.setAct_date_return(dtMonographHistoryStatus.getHistory_actual_rtn_date());
        dto.setExtend_date(dtMonographHistoryStatus.getExtend_date());
        dto.setStatus_extend(dtMonographHistoryStatus.getExtend_status());

        return dto;
    }

    public DtMonographHistoryStatus updateBorrowedBook(int history_id, Date extend_date){
        DtMonographHistoryStatus dtMonographHistoryStatus = dtMonographHistoryStatusRepository.findById(history_id);
        dtMonographHistoryStatus.setExtend_status("pending");
        dtMonographHistoryStatus.setExtend(true);
        dtMonographHistoryStatus.setExtend_date(extend_date);
        return dtMonographHistoryStatusRepository.save(dtMonographHistoryStatus);

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

    public boolean checkIfReserved(int book_id){
        List<DtMonographBooking> dtMonographBooking = dtMonographBookingRepository.findPendingOrCompletedBookingStatusByBookId(book_id);
        if(!dtMonographBooking.isEmpty()){
            return true;
        }else{
            return false;
        }
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

    public List<DtMonographCatalogRegistration> getMarcTag(int mono_id){
        return dtMonographCatalogRegistrationRepository.findByMonoId(mono_id);
    }

    public List<DtMonographRegistration> getRegFeatured(){
        return dtMonographRegistrationRepository.findRegFeatured();
    }

    public String getMonoImage(int mono_id){
        return dtMonographRegistrationRepository.findImageById(mono_id);
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
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public DateExclude getAvailableExtendDate(int history_id){
        DtMonographHistoryStatus dtMonographHistoryStatus = dtMonographHistoryStatusRepository.findById(history_id);
        List<DtMonographBooking> dtMonographBookings = dtMonographBookingRepository.findPendingOrCompletedBookingStatusByBookId(dtMonographHistoryStatus.getHistory_mono_id());

        Date tempDate = new Date(2999,12,30);
        DateExclude dateExclude = new DateExclude();


        if(dtMonographBookings.size()>0){
            for(int i = 0; i<dtMonographBookings.size(); i++){
                DtMonographBooking aDtMonographBooking = dtMonographBookings.get(i);

                if(aDtMonographBooking.getBookingDate().before(tempDate) && aDtMonographBooking.getBookingDate().after(dtMonographHistoryStatus.getExtend_date())) {
                    tempDate = aDtMonographBooking.getBookingDate();
                    dateExclude.setStartDate(dtMonographHistoryStatus.getExtend_date());
                    dateExclude.setEndDate(aDtMonographBooking.getBookingDate());
                }
            }
        }

        return dateExclude;
    }
}
