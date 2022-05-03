package com.example.fitnessgold.dao;


import com.example.fitnessgold.model.Admin;
import com.example.fitnessgold.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

    @Query(
            value = "SELECT id_user FROM admin",
            nativeQuery = true)
    List<Integer> findAllAdminUserIdIds();

}
