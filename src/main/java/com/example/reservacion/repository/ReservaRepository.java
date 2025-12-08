package com.example.reservacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.reservacion.model.Reserva;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, String> {
    List<Reserva> findByClienteId(Long clienteId);
}