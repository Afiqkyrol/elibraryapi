package com.example.elibrary.repository;

import com.example.elibrary.entity.DtMonographBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DtMonographBookingRepository extends JpaRepository<DtMonographBooking, Integer> {


    @Query("SELECT b FROM DtMonographBooking b WHERE (b.bookingStatus=1 OR b.bookingStatus=2) AND b.bookingMonoId= :booking_mono_id")
    List<DtMonographBooking> findPendingOrCompletedBookingStatusByBookId(@Param("booking_mono_id") int booking_mono_id);

    @Query("SELECT b FROM DtMonographBooking b WHERE b.bookingUserId= :user_id")
    List<DtMonographBooking> findByUserId(@Param("user_id") int user_id);

    @Query("SELECT b FROM DtMonographBooking b WHERE b.bookingId= :reserve_id")
    DtMonographBooking findByReserveId(@Param("reserve_id") int reserve_id);

}
