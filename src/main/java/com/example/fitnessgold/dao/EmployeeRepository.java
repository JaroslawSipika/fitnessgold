package com.example.fitnessgold.dao;

import com.example.fitnessgold.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query(
            value = "SELECT id_user FROM employee",
            nativeQuery = true)
    List<Integer> findAllEmployeeUserIdIds();


    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO employee VALUES(:#{#employee.idemployee},:#{#employee.note},:#{#employee.speciality},:#{#employee.idUser},:#{#employee.idClub})",
            nativeQuery = true)
    void createOneEmployee(Employee employee);


    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO employee VALUES(?1, ?2, ?3, ?4, ?5)",
            nativeQuery = true)
    void createOneEmployee1(int idemployee, String note, String speciality, int idUser, int idClub);


    @Query(
            value = "SELECT new com.example.fitnessgold.model.UserEmployee(u.firstName, u.lastName, e.speciality, e.idClub)  FROM Employee e left join User u on e.idUser = u.iduser")
    List<UserEmployee> findAll1Employees();


    @Query(
            value = "SELECT new com.example.fitnessgold.model.UserEmployeeClub(e.idemployee, u.firstName, u.lastName, u.email, u.password, e.speciality, s.name, e.note, u.phone, u.iduser)  FROM Employee e left join User u on e.idUser = u.iduser left join Club s on e.idClub = s.idclub")
    List<UserEmployeeClub> findAll2Employees();


    @Query(
            value = "SELECT * FROM employee u WHERE u.idemployee = ?1",
            nativeQuery = true)
    Employee getOneEmployee(Integer EmployeeId);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE employee u SET u.note = ?2, u.speciality = ?3 WHERE u.idemployee = ?1",
            nativeQuery = true)
    void updateEmployeeById(int idemployee, String note, String speciality);



    @Query(
            value = "SELECT idemployee u  FROM employee u WHERE u.id_user = ?1",
            nativeQuery = true)
    Integer getOneEmployeeIDEmployee(Integer id_user);

//    @Query(
//            value = "SELECT iduser u  FROM user u WHERE u.email = ?1",
//            nativeQuery = true)
//    User getOneEmployeeIDUser(String email);

    @Query(
            value = "SELECT id_user FROM employee WHERE idemployee = ?1",
            nativeQuery = true)
    Integer getOneEmployeeIDiduser(Integer idemployee);

    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM employee WHERE idemployee = ?1",
            nativeQuery = true)
    void deleteOneEmployee(Integer employeeid);


    @Query(
            value = "SELECT iduser FROM user WHERE last_name = ?1",
            nativeQuery = true)
    Integer getOneiduser(String lastName);

    @Query(
            value = "SELECT new com.example.fitnessgold.model.UserEmployeeClub(e.idemployee, u.firstName, u.lastName, u.email, u.password, e.speciality, s.name, e.note, u.phone, u.iduser)  FROM Employee e left join User u on e.idUser = u.iduser left join Club s on e.idClub = s.idclub WHERE u.iduser=?1")
    List<UserEmployeeClub> findEmployeeById(Integer iduser);



}


