package com.example.reservacion.service;

import java.util.List;

import com.example.reservacion.dto.ReservaRequest;
import com.example.reservacion.dto.ReservaResponse;

public interface ReservaService {
    ReservaResponse crearReserva(ReservaRequest request);
    List<ReservaResponse> listarReservas();
    ReservaResponse obtenerReserva(String id);
    ReservaResponse actualizarReserva(String id, ReservaRequest request);
    void eliminarReserva(String id);
}
