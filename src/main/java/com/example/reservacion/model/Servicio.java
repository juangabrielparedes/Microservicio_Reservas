package com.example.reservacion.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicioId;
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    private Double precioBase;
}
