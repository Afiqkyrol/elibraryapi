package com.example.elibrary.repository;

import com.example.elibrary.entity.DtMonographCatalogRegistration;
import com.example.elibrary.entity.LtMonographLoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DtMonographCatalogRegistrationRepository extends JpaRepository<DtMonographCatalogRegistration, Integer> {
    @Query("SELECT b FROM DtMonographCatalogRegistration b WHERE b.catreg_mono_reg_id= :catreg_mono_reg_id ORDER BY catreg_tag")
    List<DtMonographCatalogRegistration> findByMonoId(@Param("catreg_mono_reg_id") int catreg_mono_reg_id);

    @Query("SELECT b FROM DtMonographCatalogRegistration b WHERE b.catreg_mono_reg_id= :mono_id AND catreg_tag= :catreg_tag")
    DtMonographCatalogRegistration findByMonoIdAndTag(@Param("mono_id") int mono_id, @Param("catreg_tag") int catreg_tag);

    @Query(value = "SET SESSION group_concat_max_len = 1000000; " +
            "SELECT GROUP_CONCAT(DISTINCT " +
            "CONCAT('MAX(CASE WHEN catreg_tag = ''', catreg_tag, ''' THEN catreg_data END) AS ', " +
            "CONCAT('`', catreg_tag, '`'))) " +
            "FROM dt_monograph_catalog_registration " +
            "WHERE catreg_mono_reg_id = 44;", nativeQuery = true)
    List<Object[]> pivotDataByCatregTag(@Param("regId") int regId);

    @Query(value = "SELECT catreg_mono_reg_id AS book_id, " +
            "GROUP_CONCAT(IF(catreg_tag = 13, catreg_data, NULL) ORDER BY catreg_created_date) AS book_title, " +
            "GROUP_CONCAT(IF(catreg_tag = 27, catreg_data, NULL) ORDER BY catreg_created_date) AS book_description " +
            "FROM dt_monograph_catalog_registration WHERE catreg_mono_reg_id = :reg_id GROUP BY catreg_mono_reg_id", nativeQuery = true)
    List<Object[]> getAllBooksCat(@Param("reg_id") int reg_id);

    @Query("SELECT b FROM DtMonographCatalogRegistration b WHERE b.catreg_tag= :catreg_tag AND b.catreg_data LIKE %:catreg_data%")
    List<DtMonographCatalogRegistration> findByTagAndData(@Param("catreg_tag") int catreg_tag, @Param("catreg_data") String catreg_data);

    @Query("SELECT b FROM DtMonographCatalogRegistration b WHERE b.catreg_tag= 14 AND b.catreg_data LIKE '%hamid%'")
    List<DtMonographCatalogRegistration> findByTagAndDataTest();

    @Query("SELECT DISTINCT b.catreg_data FROM DtMonographCatalogRegistration b WHERE b.catreg_cataloging_id = 3")
    List<String> findDistinctIsbnByCatregCatalogingId();

    @Query("SELECT b FROM DtMonographCatalogRegistration b WHERE b.catreg_cataloging_id = 3 and b.catreg_data= :isbn_num")
    List<DtMonographCatalogRegistration> findCatRegByIsbn(@Param("isbn_num") String isbn_num);

    @Query("SELECT b FROM DtMonographCatalogRegistration b WHERE b.catreg_mono_reg_id= :mono_id AND b.catreg_cataloging_id= :catreg_cataloging_id")
    DtMonographCatalogRegistration findByMonoIdAndCatalogingId(@Param("mono_id") int mono_id, @Param("catreg_cataloging_id") int catreg_cataloging_id);

    @Query("SELECT b FROM DtMonographCatalogRegistration b WHERE b.catreg_cataloging_id= 20 AND b.catreg_data= :catreg_data")
    DtMonographCatalogRegistration findMonoIdByAccNum(@Param("catreg_data") String catreg_data);

    @Query("SELECT b FROM DtMonographCatalogRegistration b WHERE b.catreg_cataloging_id= :cataloging_id AND b.catreg_data LIKE %:catreg_data%")
    List<DtMonographCatalogRegistration> findByCatIdAndData(@Param("cataloging_id") int cataloging_id, @Param("catreg_data") String catreg_data);

}
