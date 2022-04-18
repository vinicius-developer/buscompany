package main.br.com.buscompany.domain.trip;

import main.br.com.buscompany.domain.trip.bus.Seat;

import java.util.List;
import java.util.stream.Collectors;

public class TripManager {

    private final ScheduledTrip trip;

    public TripManager(ScheduledTrip trip) {
        this.trip = trip;
    }

    public void moveBusOnTrip() {

        this.trip.routeInformation().move();

        List<String> ticketsIdentifiers = this.trip
                .busInformation()
                .getAllOccupiedSeats()
                .stream()
                .map(Seat::ticketIdentifier)
                .collect(Collectors.toList());




    }


}
