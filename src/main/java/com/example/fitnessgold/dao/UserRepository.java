package com.example.fitnessgold.dao;

import com.example.fitnessgold.model.Employee;
import com.example.fitnessgold.model.User;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(
            value = "SELECT * FROM user",
            nativeQuery = true)
    List<User> findAllUsers();

    @Query(
            value = "SELECT iduser FROM user",
            nativeQuery = true)
    List<Integer> findAllUserId();


    @Query(
            value = "SELECT * FROM user u WHERE u.iduser = ?1",
            nativeQuery = true)
    User getOneUser(Integer userID);

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO user VALUES(:#{#user.iduser},:#{#user.createDate},:#{#user.updateDate},:#{#user.email},:#{#user.firstName},:#{#user.lastName},:#{#user.password},:#{#user.phone})",
            nativeQuery = true)
    void createOneUser(User user);

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO user VALUES(?1, ?2, ?3 , ?4, ?5, ?6, ?7, ?8)",
            nativeQuery = true)
    void createOneUser1(Integer iduser, LocalDate createDate, LocalDate updateDate, String email, String firstName, String lastName, String password, String phone);


    @Query(
            value = "SELECT * FROM user u WHERE u.email = ?1",
            nativeQuery = true)
    User getUserByEmail(String email);


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE user u SET u.create_date = ?2, u.update_date = ?3, u.email = ?4, u.first_name = ?5, u.last_name = ?6, u.password = ?7, u.phone = ?8 WHERE u.iduser = ?1",
            nativeQuery = true)
    void updateUserById(int iduser, LocalDate createDate, LocalDate updateDate, String email, String firstName, String lastName, String password, String phone);

    @Query(
            value = "SELECT iduser u  FROM user u WHERE u.email = ?1",
            nativeQuery = true)
    Integer getOneEmployeeIDUser(String email);


    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM user WHERE iduser = ?1",
            nativeQuery = true)
    void deleteOneUser(Integer userId);


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE user u SET u.update_date = ?2, u.email = ?3, u.password = ?4, u.phone = ?5 WHERE u.iduser = ?1",
            nativeQuery = true)
    void updateUserById1(int iduser, LocalDate updateDate, String email, String password, String phone);


    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO user VALUES(?1, ?2, ?3 , ?4, ?5, ?6, ?7, ?8)",
            nativeQuery = true)
    void registrationOneUser(Integer iduser, LocalDate createDate, LocalDate updateDate, String email, String firstName, String lastName, String password, String phone);



}
