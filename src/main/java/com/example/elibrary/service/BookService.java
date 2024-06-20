//package com.example.elibrary.service;
//
//import com.example.elibrary.dto.AboutMonograph;
//import com.example.elibrary.entity.*;
//import com.example.elibrary.dto.BorrowedList;
//import com.example.elibrary.dto.ReservationList;
//import com.example.elibrary.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class BookService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private DtMonographBookingRepository dtMonographBookingRepository;
//
//    @Autowired
//    private DtMonographRegistrationRepository dtMonographRegistrationRepository;
//
//    @Autowired
//    private LtMonographBookingStsRepository ltMonographBookingStsRepository;
//
//    @Autowired
//    private DtMonographHistoryStatusRepository dtMonographHistoryStatusRepository;
//
//    @Autowired
//    private LtMonographBorrowStsRepository ltMonographBorrowStsRepository;
//
//    @Autowired
//    private DtAuthorRepository dtAuthorRepository;
//
//    @Autowired
//    private DtPublisherRepository dtPublisherRepository;
//
//    @Autowired
//    private LtMonographStsRepository ltMonographStsRepository;
//
//
//    public List<ReservationList> getReservationListActive(int reg_id) {
//        List<DtMonographBooking> aDtMonographBookings = dtMonographBookingRepository.findByBookingStatus(reg_id);
//        List<ReservationList> newReservationList = new ArrayList<>();
//
//        for (int i = 0; i < aDtMonographBookings.size(); i++) {
//            DtMonographBooking aList = aDtMonographBookings.get(i);
//
//            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getBookingMonoId());
//            User aUser = userRepository.findByUserId(aList.getBookingUserId());
//            LtMonographBookingSts aLtMonographBookingSts = ltMonographBookingStsRepository.findByStatusId(aList.getBookingStatus());
//
//            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//            String reserved_date = formatter.format(aList.getBookingDate());
//
//            ReservationList dto = new ReservationList();
//            dto.setBook_id(aList.getBookingId());
//            dto.setBook_title(dtMonographRegistration.getReg_title());
//            dto.setUser_id(aList.getBookingUserId());
//            dto.setUser_name(aUser.getFullName());
//            dto.setLibrary_id(aList.getBookingLibrarianId());
//            dto.setDate_reserved(reserved_date);
//            dto.setStatus(aLtMonographBookingSts.getBooking_sts_status());
//
//            newReservationList.add(dto);
//        }
//
//        return newReservationList;
//    }
//
//    public List<ReservationList> getReservationList() {
//        List<DtMonographBooking> aDtMonographBookings = dtMonographBookingRepository.findAll();
//        List<ReservationList> newReservationList = new ArrayList<>();
//
//        for (int i = 0; i < aDtMonographBookings.size(); i++) {
//            DtMonographBooking aList = aDtMonographBookings.get(i);
//
//            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getBookingMonoId());
//            User aUser = userRepository.findByUserId(aList.getBookingUserId());
//            LtMonographBookingSts aLtMonographBookingSts = ltMonographBookingStsRepository.findByStatusId(aList.getBookingStatus());
//
//            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//            String reserved_date = formatter.format(aList.getBookingDate());
//
//            ReservationList dto = new ReservationList();
//            dto.setBook_id(aList.getBookingId());
//            dto.setBook_title(dtMonographRegistration.getReg_title());
//            dto.setUser_id(aList.getBookingUserId());
//            dto.setUser_name(aUser.getFullName());
//            dto.setLibrary_id(aList.getBookingLibrarianId());
//            dto.setDate_reserved(reserved_date);
//            dto.setStatus(aLtMonographBookingSts.getBooking_sts_status());
//
//            newReservationList.add(dto);
//        }
//
//        return newReservationList;
//    }
//
//    public DtMonographHistoryStatus getBorrowedBookById(int history_id){
//        return dtMonographHistoryStatusRepository.findById(history_id);
//    }
//
//    public List<BorrowedList> getBorrowedList(int user_id) {
//        List<DtMonographHistoryStatus> aDtMonographHistoryStatuses = dtMonographHistoryStatusRepository.findByUserIdAndWithUserStatus(user_id);
//        List<BorrowedList> newBorrowedList = new ArrayList<>();
//
//        for (int i = 0; i < aDtMonographHistoryStatuses.size(); i++) {
//            DtMonographHistoryStatus aList = aDtMonographHistoryStatuses.get(i);
//
//            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getHistory_mono_id());
//
//
//            BorrowedList dto = new BorrowedList();
//            dto.setHistory_id(aList.getHistory_id());
//            dto.setBook_id(aList.getHistory_mono_id());
//            dto.setBook_title(dtMonographRegistration.getReg_title());
//            dto.setDate_borrowed(aList.getHistory_date_borrow());
//            dto.setEst_date_to_return(aList.getHistory_date_return());
//            dto.setAct_date_return(aList.getHistory_actual_rtn_date());
//            dto.setExtend_date(aList.getExtend_date());
//            dto.setStatus_extend(aList.getExtend_status());
//
//            newBorrowedList.add(dto);
//        }
//
//        return newBorrowedList;
//    }
//
//    public List<BorrowedList> getHistoryListByCompletedStatus() {
//        List<DtMonographHistoryStatus> aDtMonographHistoryStatuses = dtMonographHistoryStatusRepository.findByCompletedHistoryStatus();
//        List<BorrowedList> newBorrowedList = new ArrayList<>();
//
//        for (int i = 0; i < aDtMonographHistoryStatuses.size(); i++) {
//            DtMonographHistoryStatus aList = aDtMonographHistoryStatuses.get(i);
//
//            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getHistory_mono_id());
//            LtMonographBorrowSts ltMonographBorrowSts = ltMonographBorrowStsRepository.findByStatusId(aList.getHistory_status());
//
//
//            BorrowedList dto = new BorrowedList();
//            dto.setBook_id(aList.getHistory_mono_id());
//            dto.setBook_title(dtMonographRegistration.getReg_title());
//            dto.setDate_borrowed(aList.getHistory_date_borrow());
//            dto.setEst_date_to_return(aList.getHistory_date_return());
//            dto.setAct_date_return(aList.getHistory_actual_rtn_date());
//            dto.setStatus_extend(ltMonographBorrowSts.getBorrow_sts_status());
//
//            newBorrowedList.add(dto);
//        }
//
//        return newBorrowedList;
//    }
//
//    public List<BorrowedList> getHistoryListByWithUserStatus(int reg_id){
//        List<DtMonographHistoryStatus> aDtMonographHistoryStatuses = dtMonographHistoryStatusRepository.findByWithUserHistoryStatus(reg_id);
//        List<BorrowedList> newBorrowedList = new ArrayList<>();
//
//        for(int i=0; i<aDtMonographHistoryStatuses.size();i++){
//            DtMonographHistoryStatus aList = aDtMonographHistoryStatuses.get(i);
//
//            DtMonographRegistration dtMonographRegistration = dtMonographRegistrationRepository.findByBookId(aList.getHistory_mono_id());
//            LtMonographBorrowSts ltMonographBorrowSts = ltMonographBorrowStsRepository.findByStatusId(aList.getHistory_status());
//            User user = userRepository.findByUserId(aList.getHistory_user_id());
//
//
//            BorrowedList dto = new BorrowedList();
//            dto.setBook_id(aList.getHistory_mono_id());
//            dto.setBook_title(dtMonographRegistration.getReg_title());
//            dto.setBorrower(user.getFullName());
//            dto.setDate_borrowed(aList.getHistory_date_borrow());
//            dto.setEst_date_to_return(aList.getHistory_date_return());
//            dto.setAct_date_return(aList.getHistory_actual_rtn_date());
//            dto.setStatus_extend(ltMonographBorrowSts.getBorrow_sts_status());
//
//            newBorrowedList.add(dto);
//        }
//
//        return newBorrowedList;
//    }
//
//    public List<DtMonographRegistration> getAllBooks(){
//        return dtMonographRegistrationRepository.findAll();
//    }
//
//    public List<DtMonographRegistration> searchBooks(String search_by, String title, String monograph_type){
//
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
//    }
//
//    public AboutMonograph getMonographAbout(int reg_id){
//        DtMonographRegistration book_details = dtMonographRegistrationRepository.findByBookId(reg_id);
//
//        DtAuthor author = dtAuthorRepository.findByAuthorId(book_details.getReg_author_id());
//        DtPublisher publisher = dtPublisherRepository.findByPublisherId(book_details.getReg_publisher_id());
//        LtMonographSts book_status = ltMonographStsRepository.findByStsId(book_details.getReg_status());
//
//        AboutMonograph dto = new AboutMonograph();
//        dto.setBook_id(reg_id);
//        dto.setCall_no(book_details.getReg_ddc_call_no());
//        dto.setAuthor(author.getAuthor_name());
//        dto.setTitle(book_details.getReg_title());
//        dto.setPublisher(publisher.getPublisher_name());
//        dto.setStatus(book_status.getSts_status());
//
//        return dto;
//    }
//
//    public DtMonographBooking saveReservation(DtMonographBooking dtMonographBooking){
//        return dtMonographBookingRepository.save(dtMonographBooking);
//    }
//
//    public DtMonographHistoryStatus updateBorrowedBook(int history_id, Date extend_date){
//        DtMonographHistoryStatus dtMonographHistoryStatus = dtMonographHistoryStatusRepository.findById(history_id);
//        dtMonographHistoryStatus.setExtend_status("pending");
//        dtMonographHistoryStatus.setExtend_date(extend_date);
//        return dtMonographHistoryStatusRepository.save(dtMonographHistoryStatus);
//
//    }
//
//    public boolean checkIfReserved(int book_id){
//        List<DtMonographBooking> dtMonographBooking = dtMonographBookingRepository.findByBookingStatus(book_id);
//        if(dtMonographBooking.isEmpty()){
//            return false;
//        }else{
//            return true;
//        }
//    }
//}