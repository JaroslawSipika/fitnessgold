package com.example.fitnessgold.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Admin {

    @Id
    private Integer id;
    @Column(name = "id_user")
    private Integer userId;

  //  public Admin(int id){
  //      this.id = id;
  //  }
}
