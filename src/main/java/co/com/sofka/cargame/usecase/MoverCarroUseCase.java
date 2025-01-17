package co.com.sofka.cargame.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cargame.domain.carro.Carro;
import co.com.sofka.cargame.domain.carro.command.MoverCarroCommand;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MoverCarroUseCase extends UseCase<RequestCommand<MoverCarroCommand>, ResponseEvents> {
    private static final Logger logger = Logger.getLogger(MoverCarroUseCase.class.getName());

    @Override
    public void executeUseCase(RequestCommand<MoverCarroCommand> moverCarroCommandRequestCommand) {
        var command = moverCarroCommandRequestCommand.getCommand();
        var carro = Carro.from(command.getCarroId(), retrieveEvents());
        carro.avanzarEnCarril(command.getCarrilId());
        logger.info("Run => " + carro.conductor() + " -- " + carro.distancia());
        emit().onResponse(new ResponseEvents(carro.getUncommittedChanges()));
    }
}
