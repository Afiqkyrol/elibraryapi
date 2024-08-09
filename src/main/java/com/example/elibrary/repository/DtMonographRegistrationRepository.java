package com.example.elibrary.repository;

import com.example.elibrary.entity.DtMonographRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DtMonographRegistrationRepository extends JpaRepository<DtMonographRegistration, Integer> {

    @Query("SELECT b FROM DtMonographRegistration b WHERE b.reg_id= :reg_id")
    DtMonographRegistration findByBookId(@Param("reg_id") int reg_id);

    @Query("SELECT b FROM DtMonographRegistration b WHERE b.reg_title LIKE %:reg_title%")
    List<DtMonographRegistration> searchBookByTitle(@Param("reg_title") String reg_title);

    @Query("SELECT b FROM DtMonographRegistration b WHERE b.reg_id= :book_id")
    List<DtMonographRegistration> searchBookByBookId(@Param("book_id") int book_id);

    @Query("SELECT b FROM DtMonographRegistration b WHERE b.reg_author_id= :author_id")
    List<DtMonographRegistration> searchBookByAuthorId(@Param("author_id") int author_id);

    @Query("SELECT b FROM DtMonographRegistration b WHERE b.reg_publisher_id= :publisher_id")
    List<DtMonographRegistration> searchBookByPublisherId(@Param("publisher_id") int publisher_id);

    @Query("SELECT b FROM DtMonographRegistration b WHERE b.reg_featured= 'yes'")
    List<DtMonographRegistration> findRegFeatured();

    @Query("SELECT b FROM DtMonographRegistration b WHERE b.reg_ebook= 'no'")
    List<DtMonographRegistration> findAllbooks();

    @Query("SELECT b FROM DtMonographRegistration b WHERE b.reg_ebook= 'no' and b.reg_ISBN= :isbn_num")
    List<DtMonographRegistration> findAllbooksByIsbn(@Param("isbn_num") String isbn_num);

    @Query("SELECT b FROM DtMonographRegistration b WHERE b.reg_ebook= 'yes'")
    List<DtMonographRegistration> findAllEbooks();

    @Query("SELECT reg_image_link FROM DtMonographRegistration b WHERE b.reg_id= :mono_id")
    String findImageById(@Param("mono_id") int mono_id);

    @Query("SELECT reg_ebook_path FROM DtMonographRegistration b WHERE b.reg_id= :mono_id")
    String findEbookById(@Param("mono_id") int mono_id);
}
