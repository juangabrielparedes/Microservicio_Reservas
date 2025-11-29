package com.example.reservacion.service;

import java.util.List;

import com.example.reservacion.dto.ServicioRequest;
import com.example.reservacion.dto.ServicioResponse;

public interface ServicioService {

    ServicioResponse crearServicio(ServicioRequest request);

    List<ServicioResponse> listarServicios();

    ServicioResponse obtenerServicio(Long id);

    ServicioResponse actualizarServicio(Long id, ServicioRequest request);

    void eliminarServicio(Long id);
}
