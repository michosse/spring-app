package com.example.auicar.repository;

import com.example.auicar.entity.Car;
import com.example.auicar.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    public List<Car> findAllByMechanic(Mechanic mechanic);
}
