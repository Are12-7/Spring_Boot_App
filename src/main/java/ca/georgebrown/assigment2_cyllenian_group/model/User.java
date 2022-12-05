/*
Project: < Web Application - Cyllenian Group >
Assignment: < Assignment 2 >
Author(s): < Author name: Carlos Arellano - Renzzi Adorador - Ronak Gala >
Student Number: <101339585 - 101277841 - 101300174 >
Date: 30/11/2022
Description: The POJO for the user class. It is used to connect to H2 database for data handling.
*/

package ca.georgebrown.assigment2_cyllenian_group.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "MYUSER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;


    private String first_name;


    private String last_name;


    @Email(message = "Enter a valid email address")
    private String email;


    private String password;


    private String rpassword;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }
}
