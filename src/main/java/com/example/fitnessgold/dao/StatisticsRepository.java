package com.example.fitnessgold.dao;

import com.example.fitnessgold.model.ClientStatisticsDateActivityActivityEmployeeUser;
import com.example.fitnessgold.model.EquipmentClubReservationClientUser;
import com.example.fitnessgold.model.Statistics;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface StatisticsRepository extends CrudRepository<Statistics, Integer> {

    @Query(
            value = "SELECT new com.example.fitnessgold.model.ClientStatisticsDateActivityActivityEmployeeUser(e.idclient, e.idUser, f.idstatistics, f.note, f.weight, f.heartbeatStats, f.bodyFatLevel, f.clientId, f.dateactivityId, g.iddateactivity, g.startDate, g.endDate, g.activityId, h.idactivity, h.speciality, h.employeeId, j.idemployee, k.iduser, k.firstName, k.lastName) FROM Statistics f left join DateActivity g on f.dateactivityId = g.iddateactivity left join Client e on e.idclient = f.clientId  left join Activity h on h.idactivity = g.activityId left join Employee j on j.idemployee = h.employeeId left join User k on j.idUser = k.iduser")
    List<ClientStatisticsDateActivityActivityEmployeeUser> findAllStatistics();


    @Query(
            value = "SELECT new com.example.fitnessgold.model.ClientStatisticsDateActivityActivityEmployeeUser(e.idclient, e.idUser, f.idstatistics, f.note, f.weight, f.heartbeatStats, f.bodyFatLevel, f.clientId, f.dateactivityId, g.iddateactivity, g.startDate, g.endDate, g.activityId, h.idactivity, h.speciality, h.employeeId, j.idemployee, k.iduser, k.firstName, k.lastName) FROM Statistics f left join DateActivity g on f.dateactivityId = g.iddateactivity left join Client e on e.idclient = f.clientId  left join Activity h on h.idactivity = g.activityId left join Employee j on j.idemployee = h.employeeId left join User k on j.idUser = k.iduser WHERE e.idclient = ?1")
    List<ClientStatisticsDateActivityActivityEmployeeUser> findAllStatistics1(Integer idclient);

     @Query(
            value = "SELECT idemployee FROM employee WHERE id_user = ?1",
            nativeQuery = true)
    Integer findIdEmployee(Integer iduser);


    @Query(
            value = "SELECT new com.example.fitnessgold.model.ClientStatisticsDateActivityActivityEmployeeUser(e.idclient, e.idUser, g.iddateactivity, g.startDate, g.endDate, g.activityId, h.idactivity, h.speciality, h.employeeId, j.idemployee, k.iduser, k.firstName, k.lastName,l.idstatistics, l.note, l.weight, l.heartbeatStats, l.bodyFatLevel, l.clientId, l.dateactivityId) FROM User k left join Client e on e.idUser = k.iduser left join DateActivity g on e.idclient = g.clientId left join Statistics l on l.dateactivityId = g.iddateactivity left join Activity h on h.idactivity = g.activityId left join Employee j on j.idemployee = h.employeeId WHERE j.idemployee = ?1")
    List<ClientStatisticsDateActivityActivityEmployeeUser> findAllStatistics2(Integer idemployee);


    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO statistics VALUES(?1, ?2, ?3 , ?4, ?5, ?6, ?7)",
            nativeQuery = true)
    void createStatistics(Integer idstatistics, String note, String weight, String heartbeatStats, String bodyFatLevel, Integer clientId, Integer dateactivityId);



}
