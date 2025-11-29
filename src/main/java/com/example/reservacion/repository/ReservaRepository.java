package com.example.reservacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.reservacion.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, String> {
}