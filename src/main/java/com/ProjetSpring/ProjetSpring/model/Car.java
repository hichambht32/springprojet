package com.ProjetSpring.ProjetSpring.model;

import java.sql.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name =  "Car", uniqueConstraints = @UniqueConstraint(columnNames = "idCar"))
public class Car {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idCar;
    @Column(name = "carrosserie")
    private String carrosserie;
    @Column(name = "marque")
    private String marque;
    @Column(name = "modele")
    private int modele;
    @Column(name = "motorisation")
    private String motorisation;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUser", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car() {

    }

    public Car(String carrosserie, String marque, int modele, String motorisation) {
        super();
        this.carrosserie = carrosserie;
        this.marque = marque;
        this.modele = modele;
        this.motorisation = motorisation;
    }
    public int getIdCar() {
        return idCar;
    }
    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }
    public String getCarrosserie() {
        return carrosserie;
    }
    public void setCarrosserie(String carrosserie) {
        this.carrosserie = carrosserie;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public int getModele() {
        return modele;
    }
    public void setModele(int modele) {
        this.modele = modele;
    }
    public String getMotorisation() {
        return motorisation;
    }
    public void setMotorisation(String motorisation) {
        this.motorisation = motorisation;
    }

}