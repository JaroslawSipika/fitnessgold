package com.example.fitnessgold.dao;

import com.example.fitnessgold.model.Activity;
import com.example.fitnessgold.model.Email;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmailRepository extends CrudRepository <Email, Integer> {


    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO email VALUES(:#{#email.id},:#{#email.text},:#{#email.send_date},:#{#email.receive_date},:#{#email.reseiver_email},:#{#email.sender_email}",
            nativeQuery = true)
    void createOneEmail(Email email);

    @Query(
            value = "SELECT id FROM email",
            nativeQuery = true)
    List<Integer> findAllEmailId();



}
