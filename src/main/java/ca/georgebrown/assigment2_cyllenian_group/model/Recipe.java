/*
Project: < Web Application - Cyllenian Group >
Assignment: < Assignment 2 >
Author(s): < Author name: Carlos Arellano - Renzzi Adorador - Ronak Gala >
Student Number: <101339585 - 101277841 - 101300174 >
Date: 30/11/2022
Description: The POJO for the recipe class. It is used to connect to H2 database for data handling.
*/

package ca.georgebrown.assigment2_cyllenian_group.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "RECIPE")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long rid;
    @NotBlank(message="Please input a name.")
    private String rname;
    @Column(columnDefinition = "TEXT")
    @NotBlank(message="Please input a description.")
    private String rdescription;
    @NotBlank(message="Please input country of origin.")
    private String rcountry;

    private boolean favourite;

    @Column(columnDefinition = "TEXT")
    private String steps;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdescription() {
        return rdescription;
    }

    public void setRdescription(String rdescription) {
        this.rdescription = rdescription;
    }

    public String getRcountry() {
        return rcountry;
    }

    public void setRcountry(String rcountry) {
        this.rcountry = rcountry;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}
