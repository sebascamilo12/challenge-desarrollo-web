package co.com.sofka.cargame.usecase.services;

import co.com.sofka.cargame.domain.juego.values.JuegoId;
import co.com.sofka.cargame.infra.services.PodioJuegoQueryService;

public interface PodioJuegoService {

    PodioJuegoQueryService.JuegoFinalizadoRecord.PodioJuego getPodioPor(JuegoId juegoId);
}
