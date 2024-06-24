package com.example.elibrary.controller;

import com.example.elibrary.dto.*;
import com.example.elibrary.entity.DtMonographBooking;
import com.example.elibrary.entity.DtMonographCatalogRegistration;
import com.example.elibrary.entity.DtMonographHistoryStatus;
import com.example.elibrary.entity.DtMonographRegistration;
import com.example.elibrary.service.PatronService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:80", "https://mmdis.marine.gov.my"})
public class PatronController {
    private PatronService patronService;

    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/reservation-list/{user_id}")
    public List<ReservedBook> getReservationList(@PathVariable int user_id){
        return patronService.getReservationList(user_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/borrowed-list/{user_id}")
    public List<BorrowedBook> getBorrowedList(@PathVariable int user_id){
        return patronService.getBorrowedList(user_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/history-list/{user_id}")
    public List<BorrowedBook> getHistoryListWithCompletedStatus(@PathVariable int user_id){
        return patronService.getHistoryListByUserIdAndCompletedStatus(user_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/book-list")
    public List<DtMonographRegistration> getAllBooks(){
        return patronService.getAllBooks();
    }

    @GetMapping("/patron/book-list-details")
    public List<MonographDetails> getAllBooksDetails(){
        List<DtMonographRegistration> book_list = patronService.getAllBooks();
        List<MonographDetails> book_list_details = new ArrayList<>();
        for(int i = 0; i<book_list.size(); i++){
            DtMonographRegistration book = book_list.get(i);
            MonographDetails book_details = patronService.getMonographDetails(book.getReg_id());
            book_list_details.add(book_details);
        }
        return book_list_details;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/patron/book-list/search-books")
    public List<MonographDetails> getSearchBookResult(@RequestParam("search_by") String search_by, @RequestParam("title") String title,
                                                              @RequestParam("monograph_type") String monograph_type){

        List<DtMonographRegistration> book_list = patronService.getSearchBookResult(search_by, title, monograph_type);
        List<MonographDetails> book_list_details = new ArrayList<>();
        for(int i = 0; i<book_list.size(); i++){
            DtMonographRegistration book = book_list.get(i);
            MonographDetails book_details = patronService.getMonographDetails(book.getReg_id());
            book_list_details.add(book_details);
        }
        return book_list_details;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/book-list/{reg_id}")
    public AboutMonograph getMonographAbout(@PathVariable int reg_id){
        return patronService.getMonographAbout(reg_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/status-book/{reg_id}")
    public List<ReservedBook> getStatusBook(@PathVariable int reg_id){
        return patronService.getReservationListActive(reg_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/status-borrow/{reg_id}")
    public List<BorrowedBook> getStatusBorrow(@PathVariable int reg_id){
        return patronService.getHistoryListByWithUserStatus(reg_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/book/check-reserve/{book_id}")
    public boolean checkIfReserved(@PathVariable int book_id){
        return patronService.checkIfReserved(book_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/patron/book/reserve")
    public DtMonographBooking setReservedBook(@RequestParam("book_id") int book_id, @RequestParam("user_id") int user_id,
                                              @RequestParam("booking_date") Date booking_date){

        DtMonographBooking dtMonographBooking = new DtMonographBooking();
        dtMonographBooking.setBookingDate(booking_date);
        dtMonographBooking.setBookingMonoId(book_id);
        dtMonographBooking.setBookingUserId(user_id);
        dtMonographBooking.setBookingLibrarianId(user_id);
        dtMonographBooking.setBookingStatus(1);
        dtMonographBooking.setBookingCreatedDate(new Date());

        return patronService.saveReservation(dtMonographBooking);


    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/borrowed-list/book/{history_id}")
    public BorrowedBook getBorrowedBook(@PathVariable int history_id){
        return patronService.getBorrowedBookById(history_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/patron/book/reserve/update/{history_id}")
    public DtMonographHistoryStatus updateBorrowedBook(@PathVariable int history_id,
                                                       @RequestParam("extend_date") Date extend_date){

        return patronService.updateBorrowedBook(history_id, extend_date);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/monograph-list/details/{reg_id}")
    public MonographDetails getMonographDetails(@PathVariable int reg_id){
        return patronService.getMonographDetails(reg_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/monograph-list/marctag/{mono_id}")
    public List<DtMonographCatalogRegistration> getMonographMarcTag(@PathVariable int mono_id){
        return patronService.getMarcTag(mono_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/featured")
    public List<DtMonographRegistration> getRegFeatured(){
        return patronService.getRegFeatured();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/image/{mono_id}")
    public String getMonoImage(@PathVariable int mono_id){
        return patronService.getMonoImage(mono_id);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/min-reserved-date/{book_id}")
    public List<DateExclude> getMinReserveDate(@PathVariable int book_id){
        return patronService.getExcludeDetails(book_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/patron/min-extend-date/{reserve_id}")
    public DateExclude getMinExtendDate(@PathVariable int reserve_id){
        return patronService.getAvailableExtendDate(reserve_id);
    }
}
