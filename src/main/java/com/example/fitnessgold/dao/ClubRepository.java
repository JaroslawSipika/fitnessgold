package com.example.fitnessgold.dao;

import com.example.fitnessgold.model.Club;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ClubRepository extends CrudRepository<Club, Integer> {

    @Query(
            value = "SELECT * FROM club",
            nativeQuery = true)
    List<Club> findAllClubs();


    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO club VALUES(:#{#club.idclub},:#{#club.country},:#{#club.city},:#{#club.postalCode},:#{#club.street},:#{#club.houseNumber},:#{#club.name})",
            nativeQuery = true)
    void createOneClub(Club club);


    @Query(
            value = "SELECT idclub FROM club",
            nativeQuery = true)
    List<Integer> findAllClubId();


    @Query(
            value = "SELECT idclub FROM club u WHERE u.name = ?1",
            nativeQuery = true)
    Integer getOneIdClub(String clubName);


    @Query(
            value = "SELECT name FROM club",
            nativeQuery = true)
    List<String> findAllClubName();

    @Query(
            value = "SELECT * FROM club u WHERE u.idclub = ?1",
            nativeQuery = true)
    Club getOneClub(Integer clubId);

    @Query(
            value = "SELECT name FROM club u WHERE u.idclub = ?1",
            nativeQuery = true)
    Club getOneClubName(Integer clubId);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE club u SET u.country = ?2, u.city = ?3, u.postal_code = ?4, u.street = ?5, u.house_number =?6, u.name = ?7 WHERE u.idclub = ?1",
            nativeQuery = true)
    void updateOneClub(int idclub, String country, String city, String postalCode, String Street, String houseNumber, String name);

    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM club WHERE idclub = ?1",
            nativeQuery = true)
    void deleteOneClub(Integer idclub);



}
