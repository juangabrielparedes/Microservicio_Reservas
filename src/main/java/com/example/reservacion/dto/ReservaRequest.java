package com.example.reservacion.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservaRequest {
    private String clienteId;
    private String negocioId;
    private String direccion;
    private LocalDate fechaProgramada;
    private String modalidad;
    private String estado;
    private String observaciones;
    private Double costoEstimado;
    private Long servicioId;
}