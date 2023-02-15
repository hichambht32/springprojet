package com.ProjetSpring.ProjetSpring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name =  "Entretien", uniqueConstraints = @UniqueConstraint(columnNames = "idEntretien"))
public class Entretien {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idEntretien;
    private String nomEntretien;

    public Entretien() {

    }

    public Entretien(String nomEntretien) {
        super();
        this.nomEntretien = nomEntretien;
    }
    public int getIdEntretien() {
        return idEntretien;
    }
    public void setIdEntretien(int idEntretien) {
        this.idEntretien = idEntretien;
    }
    public String getNomEntretien() {
        return nomEntretien;
    }
    public void setNomEntretien(String nomEntretien) {
        this.nomEntretien = nomEntretien;
    }



}
