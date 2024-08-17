package com.example.elibrary.repository;

import com.example.elibrary.entity.DtMonographHistoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DtMonographHistoryStatusRepository extends JpaRepository<DtMonographHistoryStatus, Integer> {

    @Query("SELECT b FROM DtMonographHistoryStatus b WHERE b.history_user_id= :user_id")
    List<DtMonographHistoryStatus> findByUserId(@Param("user_id") int user_id);

    @Query("SELECT b FROM DtMonographHistoryStatus b WHERE b.history_user_id= :user_id AND b.history_status=2")
    List<DtMonographHistoryStatus> findByUserIdAndCompletedHistoryStatus(@Param("user_id") int user_id);

    @Query("SELECT b FROM DtMonographHistoryStatus b WHERE b.history_status=1 AND b.history_user_id= :user_id")
    List<DtMonographHistoryStatus> findByUserIdAndWithUserStatus(@Param("user_id") int user_id);

    @Query("SELECT b FROM DtMonographHistoryStatus b WHERE b.history_status=2")
    List<DtMonographHistoryStatus> findByCompletedHistoryStatus();

    @Query("SELECT b FROM DtMonographHistoryStatus b WHERE b.history_status=1 AND history_mono_id= :reg_id")
    List<DtMonographHistoryStatus> findByWithUserHistoryStatus(@Param("reg_id") int reg_id);

    @Query("SELECT b FROM DtMonographHistoryStatus b WHERE b.history_id= :history_id")
    DtMonographHistoryStatus findById(@Param("history_id") int history_id);

    @Query("SELECT b FROM DtMonographHistoryStatus b WHERE b.extend=true AND b.history_status=1")
    List<DtMonographHistoryStatus> findByTrueExtend();

    @Query("SELECT b FROM DtMonographHistoryStatus b WHERE b.extend=true AND b.history_status=1 AND b.extend_status='pending'")
    List<DtMonographHistoryStatus> findByTrueExtendAndPendingStatus();

    @Query("SELECT b FROM DtMonographHistoryStatus b WHERE b.history_status=1 OR b.history_status=2")
    List<DtMonographHistoryStatus> findByWithUserOrCompletedHistoryStatus();

    @Query("SELECT b FROM DtMonographHistoryStatus b WHERE (b.history_status=1 OR b.history_status=2) AND b.history_mono_id= :mono_id")
    List<DtMonographHistoryStatus> findByWithUserOrCompletedHistoryStatusAndMonoId(@Param("mono_id") int mono_id);

    @Query("SELECT b FROM DtMonographHistoryStatus b WHERE b.history_mono_id= :mono_id")
    List<DtMonographHistoryStatus> findByMonoId(@Param("mono_id") int mono_id);


}
