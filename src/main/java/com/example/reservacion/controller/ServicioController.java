package com.example.reservacion.controller;

import org.springframework.web.bind.annotation.*;

import com.example.reservacion.dto.ServicioRequest;
import com.example.reservacion.dto.ServicioResponse;
import com.example.reservacion.service.ServicioService;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @PostMapping
    public ServicioResponse crear(@RequestBody ServicioRequest request) {
        return servicioService.crearServicio(request);
    }

    @GetMapping
    public List<ServicioResponse> listar() {
        return servicioService.listarServicios();
    }

    @GetMapping("/{id}")
    public ServicioResponse obtener(@PathVariable Long id) {
        return servicioService.obtenerServicio(id);
    }

    @PutMapping("/{id}")
    public ServicioResponse actualizar(@PathVariable Long id, @RequestBody ServicioRequest request) {
        return servicioService.actualizarServicio(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
    }
}