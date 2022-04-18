package br.com.buscompany.domain.trip.bus;

import br.com.buscompany.domain.ticket.Ticket;
import br.com.buscompany.service.identifier.Identifier;
import br.com.buscompany.service.identifier.IdentifierService;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Bus {

    private final Identifier identifierService;

    private final List<Seat> seats;

    public Bus(String identifier, List<Seat> seats) {
        this.identifierService = new IdentifierService(identifier);
        this.seats = seats;
    }

    public List<Seat> getAllUnOccupiedSeats() {

        return this.seats
                .stream()
                .filter(seat -> !seat.occupied())
                .collect(Collectors.toList());

    }

    public List<Seat> getAllOccupiedSeats() {

        return this.seats
                .stream()
                .filter(Seat::occupied)
                .collect(Collectors.toList());
    }

    public void toOccupy(String seatIdentifier, String ticket) {
        Seat chosenSeat = this.getSpecificSeat(seatIdentifier);

        if(chosenSeat.occupied()) {
            throw new InvalidParameterException("Esse assento ja esta ocupado");
        }

        chosenSeat.toOccupy(ticket);
    }

    private Seat getSpecificSeat(String seatIdentifier) {
        for (Seat seat : this.seats) {
            if(seat.identifier().equals(seatIdentifier)) {
                return seat;
            }
        }

        throw new InvalidParameterException("Esse assento nao esta presente nesse onibus");
    }


    public String identifier() {
        return this.identifierService.identifier();
    }

}
