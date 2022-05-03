package com.example.fitnessgold.dao;

import com.example.fitnessgold.model.Reservation;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO reservation VALUES(?1, ?2, ?3 , ?4, ?5)",
            nativeQuery = true)
    void createOneReservation(Integer idreservation, Float price, LocalDate beginDate, LocalDate endDate, Integer idclient);



}
