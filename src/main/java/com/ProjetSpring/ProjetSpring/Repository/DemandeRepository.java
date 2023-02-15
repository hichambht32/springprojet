package com.ProjetSpring.ProjetSpring.Repository;

import com.ProjetSpring.ProjetSpring.model.Car;
import com.ProjetSpring.ProjetSpring.model.DemandeRemboursement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DemandeRepository extends JpaRepository<DemandeRemboursement, Integer> {
	 List<DemandeRemboursement> findByUserIdUser(Long idCar);
}
