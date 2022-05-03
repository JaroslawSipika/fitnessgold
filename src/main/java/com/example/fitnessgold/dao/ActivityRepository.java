package com.example.fitnessgold.dao;

import com.example.fitnessgold.model.Activity;
import com.example.fitnessgold.model.Equipment;
import com.example.fitnessgold.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ActivityRepository extends CrudRepository <Activity, Integer> {

    @Query(
            value = "SELECT * FROM activity",
            nativeQuery = true)
    List<Activity> findAllActivities();

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO activity VALUES(:#{#activity.id},:#{#activity.speciality},:#{#activity.status},:#{#activity.id_club},:#{#activity.id_date_activity},:#{#activity.id_employee}",
            nativeQuery = true)
    void createOneActivity(Activity activity);


    @Query(
            value = "SELECT id FROM activity",
            nativeQuery = true)
    List<Integer> findAllActivityId();

    @Query(
            value = "SELECT * FROM activity u WHERE u.id = ?1",
            nativeQuery = true)
    Activity getOneActivity(Integer activityId);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE activity u SET u.speciality = ?2, u.id_club = ?3, u.id_employee = ?4 WHERE u.idactivity = ?1",
            nativeQuery = true)
    void updateOneActivity(int idactivity, String speciality, Integer clubId, Integer employeeId);



    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM activity WHERE idactivity = ?1",
            nativeQuery = true)
    void deleteOneActivity(Integer idactivity);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE activity u SET u.id_club =?2, u.id_employee=?3  WHERE u.idactivity = ?1",
            nativeQuery = true)
    void setToDelete(Integer idactivity, Integer clubId, Integer employeeId);



}
