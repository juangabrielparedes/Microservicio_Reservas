package com.example.reservacion.dto;

import lombok.Data;

@Data
public class ReservaResponse {
    private String idReserva;
    private String clienteId;
    private String negocioId;
    private String direccion;
    private String modalidad;
    private String estado;
    private String servicioNombre;
    private Double costoEstimado;
}