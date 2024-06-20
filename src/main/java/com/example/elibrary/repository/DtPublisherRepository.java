package com.example.elibrary.repository;

import com.example.elibrary.entity.DtAuthor;
import com.example.elibrary.entity.DtPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DtPublisherRepository extends JpaRepository<DtPublisher, Integer> {

    @Query("SELECT b FROM DtPublisher b WHERE b.publisher_id= :publisher_id")
    DtPublisher findByPublisherId(@Param("publisher_id") int publisher_id);
}
