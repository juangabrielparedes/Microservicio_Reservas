package com.example.reservacion.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idReserva;
    private String clienteId;
    private String negocioId;
    private String direccion;
    private LocalDate fechaReservada;
    private LocalDate fechaProgramada;
    private String modalidad;
    private String estado;
    @Column(columnDefinition = "TEXT")
    private String observaciones;
    private Double costoEstimado;
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;
}
