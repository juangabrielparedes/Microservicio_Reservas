package com.example.reservacion.dto;

import lombok.Data;

@Data
public class ServicioRequest {
    private String nombre;
    private String descripcion;
    private Double precioBase;
}