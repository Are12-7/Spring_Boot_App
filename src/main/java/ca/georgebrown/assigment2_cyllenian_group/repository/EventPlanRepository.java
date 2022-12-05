/*
Project: < Web Application - Cyllenian Group >
Assignment: < Assignment 2 >
Author(s): < Author name: Carlos Arellano - Renzzi Adorador - Ronak Gala >
Student Number: <101339585 - 101277841 - 101300174 >
Date: 30/11/2022
Description: This repository provides dependency injection for Event Plan POJOS
*/

package ca.georgebrown.assigment2_cyllenian_group.repository;

import ca.georgebrown.assigment2_cyllenian_group.model.EventPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventPlanRepository extends JpaRepository<EventPlan, Long> {

}
