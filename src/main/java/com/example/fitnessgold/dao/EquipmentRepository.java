package com.example.fitnessgold.dao;

import com.example.fitnessgold.model.*;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Integer> {


    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO equipment VALUES(:#{#equipment.id},:#{#equipment.status},:#{#equipment.buy_date},:#{#equipment.last_conservation},:#{#equipment.next_conservation},:#{#equipment.note},:#{#equipment.name}),:#{#equipment.image_url},:#{#equipment.price_per_day},:#{#equipment.id_club},:#{#equipment.id_reservation}",
            nativeQuery = true)
    void createOneEquipment(Equipment equipment);


    @Query(
            value = "SELECT * FROM equipment",
            nativeQuery = true)
    List<Equipment> findAllEquipment();

    @Query(
            value = "SELECT id FROM club",
            nativeQuery = true)
    List<Integer> findAllEquipmentId();


    @Query(
            value = "SELECT * FROM equipment u WHERE u.id = ?1",
            nativeQuery = true)
    Equipment getOneEquipment(Integer equipmentId);


//    @Query(
//            value = "SELECT * FROM equipment left join club on equipment.id_club = club.idclub",
//            nativeQuery = true)
//    List<EquipmentClubReservation> findAllEquipment1();


    @Query(
            value = "SELECT new com.example.fitnessgold.model.EquipmentClubReservationClientUser(e.idequipment, e.status, e.buyDate, e.lastConservation, e.nextConservation, e.note, e.nameEquipment, e.pricePerDay, s.idclub, s.name, d.beginDate, d.endDate, g.firstName, g.lastName)  FROM Equipment e left join Club s on e.idClub = s.idclub left join Reservation d on e.idReservation = d.idreservation left join Client f on d.idClient = f.idclient left join User g on f.idUser = g.iduser ")
    List<EquipmentClubReservationClientUser> findAllEquipment2();

    @Query(
            value = "SELECT new com.example.fitnessgold.model.EquipmentClubReservationClientUser(e.idequipment, e.status, e.buyDate, e.lastConservation, e.nextConservation, e.note, e.nameEquipment, e.pricePerDay, s.idclub, s.name, d.beginDate, d.endDate, g.firstName, g.lastName)  FROM Equipment e left join Club s on e.idClub = s.idclub left join Reservation d on e.idReservation = d.idreservation left join Client f on d.idClient = f.idclient left join User g on f.idUser = g.iduser WHERE g.iduser =?1")
    List<EquipmentClubReservationClientUser> findAllEquipment3(Integer iduser);




    @Query(
            value = "SELECT idclub FROM club WHERE name = ?1",
            nativeQuery = true)
    Integer findIdClub(String name);

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO equipment VALUES(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10)",
            nativeQuery = true)
    void createOneEquipment1(Integer idequipment, String status, LocalDate buyDate, LocalDate lastConservation, LocalDate nextConservation, String note, String nameEquipment, float pricePerDay, Integer idClub, Integer idReservation);


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE equipment u SET u.status = ?2, u.last_conservation = ?3, u.next_conservation = ?4, u.note =?5, u.name_e = ?6, u.price_per_day =?7, u.id_club =?8 WHERE u.idequipment = ?1",
            nativeQuery = true)
    void updateOneEquipment(Integer idequipment, String status, LocalDate lastConservation, LocalDate nextConservation, String note, String nameEquipment, float pricePerDay, Integer idClub);


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE equipment u SET u.id_reservation = ?3, u.status = ?2 WHERE u.idequipment = ?1",
            nativeQuery = true)
    void updateOneEquipment1(Integer idequipment, String status, Integer idreservation);

    @Query(
            value = "SELECT new com.example.fitnessgold.model.EquipmentClubReservationClientUser(e.idequipment, e.status, e.buyDate, e.lastConservation, e.nextConservation, e.note, e.nameEquipment, e.pricePerDay, e.idReservation, s.idclub, s.name, d.beginDate, d.endDate, g.firstName, g.lastName)  FROM Equipment e left join Club s on e.idClub = s.idclub left join Reservation d on e.idReservation = d.idreservation left join Client f on d.idClient = f.idclient left join User g on f.idUser = g.iduser ")
    List<EquipmentClubReservationClientUser> findAllEquipment4();

}
