package org.example.AUI.repository;

import org.example.AUI.entity.Car;
import org.example.AUI.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    public List<Car> findAllByMechanic(Mechanic mechanic);
}
