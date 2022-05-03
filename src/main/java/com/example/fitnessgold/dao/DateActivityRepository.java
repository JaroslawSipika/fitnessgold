package com.example.fitnessgold.dao;

import com.example.fitnessgold.model.DateActivity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface DateActivityRepository extends CrudRepository<DateActivity, Integer> {

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE date_activity u SET u.id_client = ?2, u.status = ?3 WHERE u.iddateactivity = ?1",
            nativeQuery = true)
    void updateDateActivity(Integer iddateactivity, Integer id, String status);


    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO activity VALUES(?1, ?2, ?3 , ?4)",
            nativeQuery = true)
    void createActivity(Integer idactivity, String speciality, Integer idclub, Integer idemployee);

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO date_activity VALUES(?1, ?2, ?3 , ?4, ?5, ?6)",
            nativeQuery = true)
    void createDateActivity(Integer iddateactivity, LocalDateTime startDate, LocalDateTime endDate, String status, Integer idclient, Integer idactivity);


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE date_activity u SET u.start_date = ?2, u.end_date = ?3, u.status = ?4, u.id_client =?5, u.id_activity=?6  WHERE u.iddateactivity = ?1",
            nativeQuery = true)
    void updateDateActivity1(int iddateactivity, LocalDateTime startDate, LocalDateTime endDate, String status, Integer clientId, Integer activityId);

    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM date_activity WHERE id_activity = ?1",
            nativeQuery = true)
    void deleteDateActivity(Integer activityId);


//    @Modifying
//    @Transactional
//    @Query(
//            value = "UPDATE date_activity u SET u.id_client =?1, u.id_activity=?2  WHERE u.id_activity = ?2",
//            nativeQuery = true)
//    void setToDelete(Integer clientId, Integer activityId);


}
