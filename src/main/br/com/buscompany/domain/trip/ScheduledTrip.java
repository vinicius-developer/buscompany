package main.br.com.buscompany.domain.trip;

import main.br.com.buscompany.domain.trip.bus.Bus;
import main.br.com.buscompany.domain.trip.route.Route;

public class ScheduledTrip {

    private final Bus bus;

    private final Route route;

    public ScheduledTrip(Bus bus, Route route) {
        this.bus = bus;
        this.route = route;
    }

    public Bus busInformation() {
        return this.bus;
    }

    public Route routeInformation() {
        return this.route;
    }

}
