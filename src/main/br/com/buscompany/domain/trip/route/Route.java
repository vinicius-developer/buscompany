package main.br.com.buscompany.domain.trip.route;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

public class Route {

    private final List<Stop> route = new LinkedList<>();

    private Integer lastBusStop = 0;

    private Integer nextBusStop = 0;

    public void addStop(Stop busStop) {
        this.verifyBusStopIsNotNull(busStop);

        this.verifyIfStopExistInRoute(busStop);

        this.route.add(busStop);
    }

    private void verifyIfStopExistInRoute(Stop busStop) {
        for (Stop currentBusStop: this.route) {
            if(currentBusStop.equals(busStop)) {
                throw new InvalidParameterException("Parada ja existe nessa rota");
            }
        }
    }

    private void verifyBusStopIsNotNull(Stop busStop) {
        if(busStop == null) {
            throw new InvalidParameterException("A parada de onibus nao pode ser igual a null");
        }
    }

    public List<Stop> showRoute() {
        return this.route;
    }

    public void move() {
        this.setLastBusStop(this.nextBusStop);
        this.setNextBusStop(this.nextBusStop + 1);
    }

    private void setLastBusStop(Integer lastBusStop) {
        this.verifyStopIsNull(lastBusStop);

        this.verifyIfBusStopNotIsLessZero(lastBusStop);

        this.verifyIfStopNotIsMoreOfRouteSize(lastBusStop);

        this.verifyIfStopNotIsMoreOfNextStop(lastBusStop);

        this.lastBusStop = lastBusStop;
    }

    private void setNextBusStop(Integer nextBusStop) {
        this.verifyStopIsNull(nextBusStop);

        this.verifyIfStopNotIsMoreOfRouteSize(nextBusStop);

        this.verifyIfBusStopNotIsLessZero(nextBusStop);

        this.verifyIfStopIsLessLastBusStop(nextBusStop);

        this.nextBusStop = nextBusStop;
    }

    private void verifyIfStopIsLessLastBusStop(Integer nextBusStop) {
        if(nextBusStop < this.lastBusStop) {
            throw new InvalidParameterException("Nao é possivel retornar uma parada");
        }
    }

    private void verifyIfStopNotIsMoreOfNextStop(Integer lastBusStop) {
        if(lastBusStop > this.nextBusStop) {
            throw new InvalidParameterException("A ultima para nao pode ser maior que a proxima");
        }
    }

    private void verifyIfBusStopNotIsLessZero(Integer nextBusStop) {
        if(nextBusStop < 0) {
            throw new InvalidParameterException("Proxima para da e menor que tamanho minimo da rota");
        }
    }

    private void verifyIfStopNotIsMoreOfRouteSize(Integer nextBusStop) {
        if(nextBusStop > this.route.size()) {
            throw new InvalidParameterException("Proxima parada e maior que o tamanho da rota");
        }
    }

    private void verifyStopIsNull(Integer nextBusStop) {
        if(nextBusStop == null) {
            throw new InvalidParameterException("Proxima parada nao deve ser nulo");
        }
    }

}
