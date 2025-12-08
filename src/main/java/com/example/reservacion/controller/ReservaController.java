package com.example.reservacion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.reservacion.dto.ReservaRequest;
import com.example.reservacion.dto.ReservaResponse;
import com.example.reservacion.service.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ReservaResponse crear(@RequestBody ReservaRequest request) {
        return reservaService.crearReserva(request);
    }

    @GetMapping
    public List<ReservaResponse> listar() {
        return reservaService.listarReservas();
    }

    @GetMapping("/{id}")
    public ReservaResponse obtener(@PathVariable String id) {
        return reservaService.obtenerReserva(id);
    }

    @PutMapping("/{id}")
    public ReservaResponse actualizar(@PathVariable String id, @RequestBody ReservaRequest request) {
        return reservaService.actualizarReserva(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        reservaService.eliminarReserva(id);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return ResponseEntity.ok("Booking service running");
    }
}
