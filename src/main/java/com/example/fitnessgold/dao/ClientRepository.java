package com.example.fitnessgold.dao;

import com.example.fitnessgold.model.Client;
import com.example.fitnessgold.model.ClientDateActivityActivityClubEmployeeUser;
import com.example.fitnessgold.model.UserClient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {



    @Query(
            value = "SELECT id_user FROM client",
            nativeQuery = true)
    List<Integer> findAllClientUserIdIds();

    @Query(
            value = "SELECT new com.example.fitnessgold.model.UserClient(u.iduser,u.createDate, u.updateDate, u.email, u.firstName, u.lastName, u.password, u.phone, c.idclient, c.birthDate, c.houseNumber, c.pesel, c.postalCode, c.street, c.city, c.idUser)  FROM User u left join Client c on u.iduser = c.idUser")
    List<UserClient> findAllClient();

    @Query(
            value = "SELECT new com.example.fitnessgold.model.UserClient(u.iduser,u.createDate, u.updateDate, u.email, u.firstName, u.lastName, u.password, u.phone, c.idclient, c.birthDate, c.houseNumber, c.pesel, c.postalCode, c.street, c.city, c.idUser)  FROM Client c left join User u on u.iduser = c.idUser")
    List<UserClient> findAllClient1();

    @Query(
            value = "SELECT new com.example.fitnessgold.model.UserClient(u.iduser, u.createDate, u.updateDate, u.email, u.firstName, u.lastName, u.password, u.phone, c.idclient, c.birthDate, c.houseNumber, c.pesel, c.postalCode, c.street, c.city, c.idUser)  FROM User u left join Client c on u.iduser = c.idUser where u.iduser = ?1")
    List<UserClient> findClientbyId(Integer id);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE client u SET u.birth_date = ?2, u.house_number = ?3, u.pesel = ?4, u.postal_code = ?5, u.street = ?6, u.city = ?7 WHERE u.idclient = ?1",
            nativeQuery = true)
    void updateUserClientById(int idclient, LocalDate birthDate, String houseNumber, String pesel, String postalCode, String street, String city);


    @Query(
            value = "SELECT new com.example.fitnessgold.model.ClientDateActivityActivityClubEmployeeUser(u.idclient, s.iddateactivity, s.startDate, s.endDate, s.status, s.clientId, s.activityId, e.idactivity, e.speciality, e.clubId, e.employeeId, r.idclub, r.name, f.idemployee, f.idUser, h.iduser, h.firstName, h.lastName)  FROM DateActivity s left join Client u on s.clientId = u.idclient left join Activity e on e.idactivity = s.activityId left join Club r on r.idclub = e.clubId left join Employee f on f.idemployee = e.employeeId left join User h on h.iduser = f.idUser where u.idUser = ?1")
    List<ClientDateActivityActivityClubEmployeeUser> findActivitybyId(Integer id);

    @Query(
            value = "SELECT new com.example.fitnessgold.model.ClientDateActivityActivityClubEmployeeUser(u.idclient, s.iddateactivity, s.startDate, s.endDate, s.status, s.clientId, s.activityId, e.idactivity, e.speciality, e.clubId, e.employeeId, r.idclub, r.name, f.idemployee, f.idUser, h.iduser, h.firstName, h.lastName)  FROM DateActivity s left join Client u on s.clientId = u.idclient left join Activity e on e.idactivity = s.activityId left join Club r on r.idclub = e.clubId left join Employee f on f.idemployee = e.employeeId left join User h on h.iduser = f.idUser")
    List<ClientDateActivityActivityClubEmployeeUser> findAllActivity();

    @Query(
            value = "SELECT new com.example.fitnessgold.model.ClientDateActivityActivityClubEmployeeUser(u.idclient, s.iddateactivity, s.startDate, s.endDate, s.status, s.clientId, s.activityId, e.idactivity, e.speciality, e.clubId, e.employeeId, r.idclub, r.name, f.idemployee, f.idUser, h.iduser, h.firstName, h.lastName)  FROM Activity e left join DateActivity s on s.activityId = e.idactivity left join Client u on u.idclient = s.clientId left join Employee f on e.employeeId = f.idemployee left join Club r on r.idclub = e.clubId left join User h on h.iduser = f.idUser")
    List<ClientDateActivityActivityClubEmployeeUser> findAllActivity1();


    @Query(
            value = "SELECT idclient FROM client WHERE id_user = ?1",
            nativeQuery = true)
    Integer getOneIdClient(Integer iduser);

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO client VALUES(?1, ?2, ?3 , ?4, ?5, ?6, ?7, ?8)",
            nativeQuery = true)
    void registrationOneUser(Integer idClient, LocalDate birthDate, String houseNumber, String pesel, String postalCode,String street, String city, Integer idUser);

    @Query(
            value = "SELECT id_user FROM client WHERE idclient = ?1",
            nativeQuery = true)
    Integer getOneIdClient1(Integer idclient);

    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM client WHERE idclient = ?1",
            nativeQuery = true)
    void deleteOneClient(Integer clientid);
}
