package com.renuka.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renuka.location.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
