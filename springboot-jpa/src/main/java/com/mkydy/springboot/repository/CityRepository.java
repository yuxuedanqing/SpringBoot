package com.mkydy.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkydy.springboot.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
