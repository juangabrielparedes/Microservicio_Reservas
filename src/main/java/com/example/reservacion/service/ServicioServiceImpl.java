package com.example.reservacion.service;

import org.springframework.stereotype.Service;

import com.example.reservacion.dto.ServicioRequest;
import com.example.reservacion.dto.ServicioResponse;
import com.example.reservacion.model.Servicio;
import com.example.reservacion.repository.ServicioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioServiceImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public ServicioResponse crearServicio(ServicioRequest req) {
        Servicio servicio = new Servicio();
        servicio.setNombre(req.getNombre());
        servicio.setDescripcion(req.getDescripcion());
        servicio.setPrecioBase(req.getPrecioBase());

        servicioRepository.save(servicio);

        return mapToResponse(servicio);
    }

    @Override
    public List<ServicioResponse> listarServicios() {
        return servicioRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ServicioResponse obtenerServicio(Long id) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        return mapToResponse(servicio);
    }

    @Override
    public ServicioResponse actualizarServicio(Long id, ServicioRequest req) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        servicio.setNombre(req.getNombre());
        servicio.setDescripcion(req.getDescripcion());
        servicio.setPrecioBase(req.getPrecioBase());

        servicioRepository.save(servicio);

        return mapToResponse(servicio);
    }

    @Override
    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }

    private ServicioResponse mapToResponse(Servicio s) {
        ServicioResponse res = new ServicioResponse();
        res.setServicioId(s.getServicioId());
        res.setNombre(s.getNombre());
        res.setDescripcion(s.getDescripcion());
        res.setPrecioBase(s.getPrecioBase());
        return res;
    }
}