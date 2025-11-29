package com.example.reservacion.service;

import org.springframework.stereotype.Service;

import com.example.reservacion.dto.ReservaRequest;
import com.example.reservacion.dto.ReservaResponse;
import com.example.reservacion.model.Reserva;
import com.example.reservacion.model.Servicio;
import com.example.reservacion.repository.ReservaRepository;
import com.example.reservacion.repository.ServicioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepo;
    private final ServicioRepository servicioRepo;

    public ReservaServiceImpl(ReservaRepository reservaRepo, ServicioRepository servicioRepo) {
        this.reservaRepo = reservaRepo;
        this.servicioRepo = servicioRepo;
    }

    @Override
    public ReservaResponse crearReserva(ReservaRequest reservaRequest) {
        Servicio servicio = servicioRepo.findById(reservaRequest.getServicioId())
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        Reserva reserva = new Reserva();
        reserva.setClienteId(reservaRequest.getClienteId());
        reserva.setNegocioId(reservaRequest.getNegocioId());
        reserva.setDireccion(reservaRequest.getDireccion());
        reserva.setFechaProgramada(reservaRequest.getFechaProgramada());
        reserva.setModalidad(reservaRequest.getModalidad());
        reserva.setEstado(reservaRequest.getEstado());
        reserva.setObservaciones(reservaRequest.getObservaciones());
        reserva.setCostoEstimado(reservaRequest.getCostoEstimado());
        reserva.setServicio(servicio);

        reservaRepo.save(reserva);

        return mapToResponse(reserva);
    }

    @Override
    public List<ReservaResponse> listarReservas() {
        return reservaRepo.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaResponse obtenerReserva(String id) {
        return reservaRepo.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    @Override
    public ReservaResponse actualizarReserva(String id, ReservaRequest req) {
        Reserva reserva = reservaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        Servicio servicio = servicioRepo.findById(req.getServicioId())
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        reserva.setDireccion(req.getDireccion());
        reserva.setModalidad(req.getModalidad());
        reserva.setEstado(req.getEstado());
        reserva.setCostoEstimado(req.getCostoEstimado());
        reserva.setObservaciones(req.getObservaciones());
        reserva.setFechaProgramada(req.getFechaProgramada());
        reserva.setServicio(servicio);

        reservaRepo.save(reserva);
        return mapToResponse(reserva);
    }

    @Override
    public void eliminarReserva(String id) {
        reservaRepo.deleteById(id);
    }

    private ReservaResponse mapToResponse(Reserva r) {
        ReservaResponse res = new ReservaResponse();
        res.setIdReserva(r.getIdReserva());
        res.setClienteId(r.getClienteId());
        res.setNegocioId(r.getNegocioId());
        res.setDireccion(r.getDireccion());
        res.setEstado(r.getEstado());
        res.setModalidad(r.getModalidad());
        res.setServicioNombre(r.getServicio().getNombre());
        res.setCostoEstimado(r.getCostoEstimado());
        return res;
    }
}
