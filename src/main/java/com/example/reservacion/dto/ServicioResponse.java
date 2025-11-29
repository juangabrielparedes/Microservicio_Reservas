package com.example.reservacion.dto;

import lombok.Data;

@Data
public class ServicioResponse {
    private Long servicioId;
    private String nombre;
    private String descripcion;
    private Double precioBase;
}