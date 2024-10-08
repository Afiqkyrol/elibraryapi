package com.example.elibrary.controller;

import com.example.elibrary.dto.*;
import com.example.elibrary.entity.*;
import com.example.elibrary.service.LibrarianService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:80", "https://mmdis.marine.gov.my"})
public class LibrarianController {

    private LibrarianService librarianService;

    public LibrarianController (LibrarianService librarianService){
        this.librarianService = librarianService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/book-list")
    public List<DtMonographRegistration> getAllBooks(){
        return librarianService.getAllBooks();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/book-list-details")
    public List<MonographDetails> getAllBooksDetails(){
        List<DtMonographRegistration> book_list = librarianService.getAllBooks();
        List<MonographDetails> book_list_details = new ArrayList<>();
        for(int i = 0; i<book_list.size(); i++){
            DtMonographRegistration book = book_list.get(i);
            MonographDetails book_details = librarianService.getMonographDetails(book.getReg_id());
            book_list_details.add(book_details);
        }
        return book_list_details;
    }

    @GetMapping("/librarian/book-list-details/test")
    public List<MonographDetails> getAllBooksDetailsTest(){
        try {
            List<DtMonographRegistration> book_list = librarianService.getAllBooks();
            List<MonographDetails> book_list_details = new ArrayList<>();
            for (int i = 0; i < book_list.size(); i++) {
                DtMonographRegistration book = book_list.get(i);
                MonographDetails book_details = librarianService.getMonographDetails(book.getReg_id());
                book_list_details.add(book_details);
            }
            return book_list_details;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/book-list-details-v2")
    public List<MonographDetailsV2> getAllBooksDetailsV2(){
        try {
            return librarianService.getAllbooksV2();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/book-list-details-v2/{isbn_no}")
    public List<CopyBookDetails> getAllBooksDetailsCopyV2(@PathVariable("isbn_no") String isbn_no){
        try {
            return librarianService.getAllCopyBookDetails(isbn_no);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }



    @GetMapping("/librarian/ebook-list-details")
    public List<MonographDetails> getAllEBooksDetails(){
        List<DtMonographRegistration> book_list = librarianService.getAllEBooks();
        List<MonographDetails> book_list_details = new ArrayList<>();
        for(int i = 0; i<book_list.size(); i++){
            DtMonographRegistration book = book_list.get(i);
            MonographDetails book_details = librarianService.getMonographDetails(book.getReg_id());
            book_list_details.add(book_details);
        }
        return book_list_details;
    }

    @PostMapping("/librarian/ebook-list-details/search-ebook")
    public List<MonographDetails> getAllEBooksDetails(@RequestParam("category") String category, @RequestParam("title") String title){
        List<DtMonographRegistration> book_list = librarianService.getAllEBooksSearchResult(category, title);
        List<MonographDetails> book_list_details = new ArrayList<>();
        for(int i = 0; i<book_list.size(); i++){
            DtMonographRegistration book = book_list.get(i);
            MonographDetails book_details = librarianService.getMonographDetails(book.getReg_id());
            book_list_details.add(book_details);
        }
        return book_list_details;
    }

    @GetMapping("/librarian/ebook-list-details/search-ebook/test")
    public String getAllEBooksDetailsTest(@RequestParam("search_by") String search_by, @RequestParam("title") String title,
                                                      @RequestParam("monograph_type") String monograph_type){
        try {
            List<DtMonographRegistration> book_list = librarianService.getAllEBooksSearchResult(search_by, title);
            List<MonographDetails> book_list_details = new ArrayList<>();
            for (int i = 0; i < book_list.size(); i++) {
                DtMonographRegistration book = book_list.get(i);
                MonographDetails book_details = librarianService.getMonographDetails(book.getReg_id());
                book_list_details.add(book_details);
            }
            return book_list_details.toString();
        }catch(Exception e){
            return e.toString();
        }
    }

    @GetMapping("/librarian/ebook-list-details/test")
    public String getAllEBooksDetailsTest(){
        try {
            List<DtMonographRegistration> book_list = librarianService.getAllEBooks();
            List<MonographDetails> book_list_details = new ArrayList<>();
            for (int i = 0; i < book_list.size(); i++) {
                DtMonographRegistration book = book_list.get(i);
                MonographDetails book_details = librarianService.getMonographDetails(book.getReg_id());
                book_list_details.add(book_details);
            }
            return book_list_details.toString();
        }catch (Exception e){
            return e.toString();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/book-list/search-books")
    public List<DtMonographRegistration> getSearchBookResult(@RequestParam("search_by") String search_by, @RequestParam("title") String title,
                                                             @RequestParam("monograph_type") String monograph_type){

        return librarianService.getSearchBookResult(search_by, title, monograph_type);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/book-list/search-books-v2")
    public List<MonographDetailsV2> getSearchBookResultV2(@RequestParam("category") String category, @RequestParam("title") String title){

        return librarianService.getSearchBookResultV2(category, title);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/book-list/search-ebooks-v2")
    public List<MonographDetailsV2> getSearchEbookResultV2(@RequestParam("category") String category, @RequestParam("title") String title){

        return librarianService.getSearchEbookResultV2(category, title);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/book-list/{reg_id}")
    public AboutMonograph getMonographAbout(@PathVariable int reg_id){
        return librarianService.getMonographAbout(reg_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/status-book/{reg_id}")
    public List<ReservedBook> getStatusBook(@PathVariable int reg_id){
        return librarianService .getReservationListActive(reg_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/status-borrow/{reg_id}")
    public List<BorrowedBook> getStatusBorrow(@PathVariable int reg_id){
        return librarianService.getHistoryListByWithUserStatus(reg_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/user/{user_id}")
    public User getUserByUserIc(@PathVariable String user_id){
        return librarianService.getUserByUserId(user_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/user_details/{user_id}")
    public User getUserByUserId(@PathVariable int user_id){
        return librarianService.getUserById(user_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/book/reserve")
    public DtMonographBooking setReservedBook(@RequestParam("book_id") int book_id, @RequestParam("user_id") int user_id,
                                              @RequestParam("booking_date") Date booking_date){

        DtMonographBooking dtMonographBooking = new DtMonographBooking();
        dtMonographBooking.setBookingDate(booking_date);
        dtMonographBooking.setBookingMonoId(book_id);
        dtMonographBooking.setBookingUserId(user_id);
        dtMonographBooking.setBookingLibrarianId(user_id);
        dtMonographBooking.setBookingStatus(2);
        dtMonographBooking.setBookingCreatedDate(new Date());

        return librarianService.saveReservation(dtMonographBooking);


    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/reservation-list")
    public List<ReservedBook> getReservationList(){
        return librarianService.getReservationList();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/dashboard/reservation-list")
    public List<DtMonographBooking> getDashboardReservationList(){
        return librarianService.getReservationListPendingOrCompleted();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/reservation-list/accession-no/{acc_num}")
    public List<ReservedBook> getReservationListSearchResult(@PathVariable int acc_num){
        return librarianService.getReservationListSearch(String.valueOf(acc_num));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/reservation-list/accession-no/{acc_num}/test")
    public String getReservationListSearchResultTest(@PathVariable String acc_num){
        try {
            return librarianService.getReservationListSearch(acc_num).toString();
        }catch (Exception e){
            return e.toString();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/reservation-list/{reserve_id}")
    public ReservedBook getReservation(@PathVariable int reserve_id){
        return librarianService.getReservedBook(reserve_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/librarian/reservation-list/{reserve_id}")
    public DtMonographBooking updateReservationStatus(@PathVariable int reserve_id,
                                                       @RequestParam("reserved_date") Date reserved_date,
                                                       @RequestParam("status") int status,
                                                      @RequestParam("remark") String remark) throws ParseException {


        return librarianService.updateReservedBookStatus(reserve_id,reserved_date,status, remark);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/librarian/reservation-list/closed/{reserve_id}")
    public DtMonographBooking updateReservationStatusClosed(@PathVariable int reserve_id,
                                                      @RequestParam("status") int status) {

        return librarianService.updateReservedBookStatusClosed(reserve_id,status);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/borrow/{reserve_id}")
    public DtMonographHistoryStatus setBorrowedBook(@PathVariable int reserve_id,
                                        @RequestParam("librarian_id") int librarian_id,
                                        @RequestParam("return_date") Date return_date)throws ParseException{

        return librarianService.setBorrowedBook(reserve_id,librarian_id,return_date);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/extend-list")
    public List<BorrowedBook> getHistoryListByTrueExtend(){
        return librarianService.getHistoryListByTrueExtend();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/dashboard/extend-list")
    public List<DtMonographHistoryStatus> getHistoryListByTrueExtendPendingStatus(){
        return librarianService.getHistoryListByTrueExtendPendingStatus();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/extend-list/{history_id}")
    public BorrowedBook getHistoryById(@PathVariable int history_id){
        return librarianService.getHistoryById(history_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/librarian/extend-list/{history_id}")
    public DtMonographHistoryStatus updateExtendApplicationStatus(@PathVariable int history_id,
                                                      @RequestParam("extend_date") String extend_date,
                                                      @RequestParam("status") String status,
                                                                  @RequestParam("remark") String remark) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(extend_date);
        return librarianService.updateExtendApplicationStatus(history_id, date, status, remark);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/return-list")
    public List<BorrowedBook> getHistoryListByWithUserOrCompletedStatus(){
        return librarianService.getHistoryListByWithUserOrCompletedStatus();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/return-list/accession-no/{acc_number}")
    public List<BorrowedBook> getHistoryListByWithUserOrCompletedStatusSearch(@PathVariable String acc_number){
        return librarianService.getHistoryListByWithUserOrCompletedStatusAndMonoId(acc_number);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/return-list/accession-no/{acc_number}/test")
    public String getHistoryListByWithUserOrCompletedStatusSearchTest(@PathVariable String acc_number){
        try {
            return librarianService.getHistoryListByWithUserOrCompletedStatusAndMonoId(acc_number).toString();
        }catch (Exception e){
            return e.toString();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/librarian/return-list/{history_id}")
    public DtMonographHistoryStatus updateReturnBorrowedBook(@PathVariable int history_id,
                                                             @RequestParam("history_late") String history_late){

        return librarianService.updateReturnBorrowedBook(history_id,history_late);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/return-list/damage")
    public DtMonographDamaged setDamagedBook(@RequestParam("mono_id") int mono_id,
                                             @RequestParam("damaged_description") String damaged_description,
                                             @RequestParam("last_person") int last_person,
                                             @RequestParam("librarian_id") int librarian_id){

        return librarianService.setDamagedBook(mono_id, damaged_description, last_person, librarian_id);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/damaged-list")
    public List<DamagedBook> getDamagedBookList(){
        return librarianService.getDamagedBookList();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/damaged-list/{damaged_id}")
    public DamagedBook getDamagedBookDetails(@PathVariable int damaged_id){
        return librarianService.getDamagedBookDetails(damaged_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/librarian/damaged-list/{damaged_id}")
    public DtMonographDamaged updateDamagedBookDetails(@PathVariable int damaged_id,
                                                @RequestParam("damaged_details") String damaged_details){
        return librarianService.updateDamagedBookDetails(damaged_id, damaged_details);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/librarian/damaged-list/{damaged_id}")
    public void deleteDamagedBook(@PathVariable int damaged_id){
        librarianService.deleteDamagedBook(damaged_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph-list/{reg_id}")
    public AboutMonograph getRegMonographAbout(@PathVariable int reg_id){
        return librarianService.getMonographAbout(reg_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph-list/details/{reg_id}")
    public MonographDetails getMonographDetails(@PathVariable int reg_id){
        return librarianService.getMonographDetails(reg_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph-list/cataloging")
    public List<LtMonographCataloging> getLtCataloging(){
        return librarianService.getLtCataloging();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/monograph-list/add")
    public DtMonographRegistration setNewMonograph(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("title") String title,
                                                   @RequestParam("description") String description,
                                                   @RequestParam("reg_featured") String reg_featured,
                                                   @RequestParam("reg_publish") String reg_publish,
                                                   @RequestParam("reg_ebook") String reg_ebook,
                                                   @RequestParam("reg_by") String reg_by,
                                                   @RequestParam("status") String status){

       return librarianService.setMonographRegistration(file, title, description, reg_featured, reg_publish, reg_ebook, reg_by, status);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/ebook-list/add")
    public DtMonographRegistration setNewEbook(@RequestParam("file") MultipartFile file,
                                               @RequestParam("pdf") MultipartFile pdf,
                                                   @RequestParam("title") String title,
                                                   @RequestParam("description") String description,
                                                   @RequestParam("reg_featured") String reg_featured,
                                                   @RequestParam("reg_publish") String reg_publish,
                                                   @RequestParam("reg_ebook") String reg_ebook,
                                                   @RequestParam("reg_by") String reg_by,
                                                   @RequestParam("status") String status){

        return librarianService.setEbookRegistration(file, pdf, title, description, reg_featured, reg_publish, reg_ebook, reg_by, status);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/ebook-list/add/test")
    public String setNewEbookTest(@RequestParam("file") MultipartFile file,
                                               @RequestParam("pdf") MultipartFile pdf,
                                               @RequestParam("title") String title,
                                               @RequestParam("description") String description,
                                               @RequestParam("reg_featured") String reg_featured,
                                               @RequestParam("reg_publish") String reg_publish,
                                               @RequestParam("reg_ebook") String reg_ebook,
                                               @RequestParam("reg_by") String reg_by,
                                               @RequestParam("status") String status){

        try{
            librarianService.setEbookRegistration(file, pdf, title, description, reg_featured, reg_publish, reg_ebook, reg_by, status);
            return "success";
        }catch(Exception e){
            return e.toString();
        }

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/monograph-list/add-without-image")
    public DtMonographRegistration setNewMonographWithoutImage(@RequestParam("title") String title,
                                                   @RequestParam("description") String description,
                                                   @RequestParam("reg_featured") String reg_featured,
                                                   @RequestParam("reg_publish") String reg_publish,
                                                   @RequestParam("reg_ebook") String reg_ebook,
                                                               @RequestParam("reg_by") String reg_by,
                                                               @RequestParam("status") String status){

        return librarianService.setMonographRegistrationWithOutImage(title, description, reg_featured, reg_publish, reg_ebook, reg_by, status);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/ebook-list/add-without-image")
    public DtMonographRegistration setNewEbookWithoutImage(@RequestParam("pdf") MultipartFile pdf,
                                                           @RequestParam("title") String title,
                                                               @RequestParam("description") String description,
                                                               @RequestParam("reg_featured") String reg_featured,
                                                               @RequestParam("reg_publish") String reg_publish,
                                                               @RequestParam("reg_ebook") String reg_ebook,
                                                               @RequestParam("reg_by") String reg_by,
                                                               @RequestParam("status") String status){

        return librarianService.setEbookRegistrationWithOutImage(pdf, title, description, reg_featured, reg_publish, reg_ebook, reg_by, status);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/librarian/monograph-list/update/{reg_id}")
    public DtMonographRegistration updateNewMonograph(@PathVariable int reg_id,
                                                      @RequestParam("file") MultipartFile file,
                                                      @RequestParam("title") String title,
                                                   @RequestParam("description") String description,
                                                   @RequestParam("reg_featured") String reg_featured,
                                                   @RequestParam("reg_publish") String reg_publish,
                                                   @RequestParam("reg_ebook") String reg_ebook,
                                                      @RequestParam("status") String status) throws IOException {

        return librarianService.updateMonographRegistration(reg_id, file, title, description, reg_featured, reg_publish, reg_ebook, status);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/librarian/ebook-list/update/{reg_id}")
    public DtMonographRegistration updateNewEbook(@PathVariable int reg_id,
                                                  @RequestParam("pdf") MultipartFile pdf,
                                                      @RequestParam("file") MultipartFile file,
                                                      @RequestParam("title") String title,
                                                      @RequestParam("description") String description,
                                                      @RequestParam("reg_featured") String reg_featured,
                                                      @RequestParam("reg_publish") String reg_publish,
                                                      @RequestParam("reg_ebook") String reg_ebook,
                                                      @RequestParam("status") String status) throws IOException {

        return librarianService.updateEbookRegistration(reg_id, pdf, file, title, description, reg_featured, reg_publish, reg_ebook, status);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/librarian/monograph-list/update-without-image/{reg_id}")
    public DtMonographRegistration updateNewMonographWithoutImage(@PathVariable int reg_id,
                                                      @RequestParam("title") String title,
                                                      @RequestParam("description") String description,
                                                      @RequestParam("reg_featured") String reg_featured,
                                                      @RequestParam("reg_publish") String reg_publish,
                                                      @RequestParam("reg_ebook") String reg_ebook,
                                                      @RequestParam("status") String status) throws IOException {

        return librarianService.updateMonographRegistrationWithoutImage(reg_id, title, description, reg_featured, reg_publish, reg_ebook, status);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/librarian/ebook-list/update-without-image/{reg_id}")
    public DtMonographRegistration updateNewEbookWithoutImage(@PathVariable int reg_id,
                                                              @RequestParam("pdf") MultipartFile pdf,
                                                                  @RequestParam("title") String title,
                                                                  @RequestParam("description") String description,
                                                                  @RequestParam("reg_featured") String reg_featured,
                                                                  @RequestParam("reg_publish") String reg_publish,
                                                                  @RequestParam("reg_ebook") String reg_ebook,
                                                                  @RequestParam("status") String status) throws IOException {

        return librarianService.updateEbookRegistrationWithoutImage(pdf, reg_id, title, description, reg_featured, reg_publish, reg_ebook, status);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/monograph-list/catalog")
    public DtMonographCatalogRegistration setNewCatalog(@RequestParam("tag") int tag,
                                                        @RequestParam("cat_id") int cat_id,
                                                 @RequestParam("mono_id") int mono_id,
                                                 @RequestParam("ind1") String ind1,
                                                 @RequestParam("ind2") String ind2,
                                                 @RequestParam("data") String data){

        return librarianService.setNewCatalog(tag,cat_id,mono_id,ind1,ind2,data);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/librarian/monograph-list/catalog")
    public DtMonographCatalogRegistration updateNewCatalog(@RequestParam("tag") int tag,
                                                           @RequestParam("cat_id") int cat_id,
                                                        @RequestParam("mono_id") int mono_id,
                                                        @RequestParam("ind1") String ind1,
                                                        @RequestParam("ind2") String ind2,
                                                        @RequestParam("data") String data){

        return librarianService.updateNewCatalog(cat_id, mono_id,tag,ind1,ind2,data);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/lt-mono-cat")
    public List<LtMonographCataloging> getLtMonographCat(){
        return librarianService.getLtMonoCat();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph-list/marctag/{mono_id}")
    public List<DtMonographCatalogRegistration> getMonographMarcTag(@PathVariable int mono_id){
        return librarianService.getMarcTag(mono_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph-list/cataloging/language")
    public List<LtMonographLanguage> getLtCatalogingLanguage(){
        return librarianService.getLanguage();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph-list/cataloging/subject")
    public List<LtMonographSubject> getLtCatalogingSubject(){
        return librarianService.getSubject();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph-list/cataloging/type")
    public List<LtMonographType> getLtCatalogingType(){
        return librarianService.getType();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph-list/cataloging/options")
    public CatalogOptionsForm getLtCatalogingOptions(){
        return librarianService.getCatalogOptions();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph/author")
    public List<DtAuthor> getAuthorList(){
        return librarianService.getAuthor();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph/author/{author_id}")
    public DtAuthor getAuthor(@PathVariable int author_id){
        return librarianService.getAuthorById(author_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/monograph/author")
    public DtAuthor setAuthor(@RequestParam("author_name") String author_name,
                                       @RequestParam("author_email") String author_email,
                                       @RequestParam("author_telephone") String author_telephone,
                                       @RequestParam("publisher_id") int publisher_id){
        return librarianService.saveAuthor(author_name, author_email, author_telephone, publisher_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/librarian/monograph/author/{author_id}")
    public DtAuthor updateAuthor(@PathVariable int author_id,
                                 @RequestParam("author_name") String author_name,
                              @RequestParam("author_email") String author_email,
                              @RequestParam("author_telephone") String author_telephone,
                              @RequestParam("publisher_id") int publisher_id){
        return librarianService.updateAuthor(author_id, author_name, author_email, author_telephone, publisher_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/librarian/monograph/author/{author_id}")
    public void deleteAuthor(@PathVariable int author_id){
        librarianService.deleteAuthor(author_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph/publisher")
    public List<DtPublisher> getPublisher(){
        return librarianService.getPublisherList();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph/publisher/{publisher_id}")
    public DtPublisher getaPublisher(@PathVariable int publisher_id){
        return librarianService.getPublisherById(publisher_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/monograph/publisher")
    public DtPublisher setPublisher(@RequestParam("publisher_name") String publisher_name,
                                    @RequestParam("publisher_address1") String publisher_address1,
                                    @RequestParam("publisher_address2") String publisher_address2,
                                    @RequestParam("publisher_address3") String publisher_address3,
                                    @RequestParam("publisher_telephone") String publisher_telephone,
                                    @RequestParam("publisher_email") String publisher_email){

        return librarianService.savePublisher(publisher_name, publisher_address1, publisher_address2, publisher_address3, publisher_telephone, publisher_email);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/librarian/monograph/publisher/{publisher_id}")
    public DtPublisher updatePublisher(@PathVariable int publisher_id,
                                    @RequestParam("publisher_name") String publisher_name,
                                    @RequestParam("publisher_address1") String publisher_address1,
                                    @RequestParam("publisher_address2") String publisher_address2,
                                    @RequestParam("publisher_address3") String publisher_address3,
                                    @RequestParam("publisher_telephone") String publisher_telephone,
                                    @RequestParam("publisher_email") String publisher_email){

        return librarianService.updatePublisher(publisher_id, publisher_name, publisher_address1, publisher_address2, publisher_address3, publisher_telephone, publisher_email);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/librarian/monograph/publisher/{publisher_id}")
    public void deletePublisher(@PathVariable int publisher_id){
        librarianService.deletePublisher(publisher_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph/test/{reg_id}")
    public List<Object[]> getTest(@PathVariable("reg_id") int reg_id){
        return librarianService.pivotDataByCatRegTag(reg_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/librarian/monograph/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Get the bytes from the file
                byte[] bytes = file.getBytes();
                // Define the path where you want to save the file
                String path = "src/main/java/com/example/elibrary/uploads"+ File.separator + file.getOriginalFilename();
                file.transferTo(Path.of(path));
                return "File uploaded successfully!";
            } catch (IOException e) {
                return "Failed to upload file: " + e.getMessage();
            }
        } else {
            return "Failed to upload the file: File is empty";
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/resources/image/{image_name}")
    public ResponseEntity<Resource> getImage(@PathVariable String image_name) {
        try {
            Resource resource = new UrlResource(Path.of("src/main/java/com/example/elibrary/uploads/"+image_name).toUri());

            if (resource.exists() && resource.isReadable()) {
                // Return the image file as a response with appropriate content type
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_PNG)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/image/{mono_id}")
    public ResponseEntity<Resource> getMonoImage(@PathVariable int mono_id){
        return librarianService.getMonoImage(mono_id);
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/librarian/min-reserved-date/{book_id}")
//    public Date getMinReserveDate(@PathVariable int book_id){
//        return librarianService.getMinReserveDate(book_id);
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/min-reserved-date/{book_id}")
    public List<DateExclude> getMinReserveDate(@PathVariable int book_id){
        return librarianService.getExcludeDetails(book_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/available-return-date/{reserve_id}")
    public DateExclude getAvailableReturnDate(@PathVariable int reserve_id){
        return librarianService.getAvailableReturnDate(reserve_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/available-extend-date/{borrow_id}")
    public DateExclude getAvailableExtendDate(@PathVariable int borrow_id){
        return librarianService.getAvailableExtendDate(borrow_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/librarian/monograph-status")
    public List<LtMonographSts> getAllBookStatus(){
        return librarianService.getAllMonoStatus();
    }
}
