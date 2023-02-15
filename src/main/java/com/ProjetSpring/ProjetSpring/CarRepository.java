package com.ProjetSpring.ProjetSpring;

import com.ProjetSpring.ProjetSpring.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByUserIdUser(Long idUser);

    //@Query("SELECT a FROM Animal a WHERE a.idUser = :userId")
    //List<Animal> findByUserID(@Param("userId") Long userId);

}
