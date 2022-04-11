package main.br.com.buscompany.domain.bus;

import main.br.com.buscompany.domain.ticket.Ticket;
import main.br.com.buscompany.service.identifier.Identifier;
import main.br.com.buscompany.service.identifier.IdentifierService;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

public class Bus {

    private final Identifier identifierService;

    private final List<Seat> seats;

    public Bus(String identifier, List<Seat> seats) {
        this.identifierService = new IdentifierService(identifier);
        this.seats = seats;
    }

    public List<String> getAllUnOccupiedSeats() {
        List<String> unOccupiedIdentifierSeats = new LinkedList<String>();

        this.seats.forEach(seat -> {
            if(!seat.occupied()) {
                unOccupiedIdentifierSeats.add(seat.identifier());
            }
        });

        return unOccupiedIdentifierSeats;
    }

    public void toOccupy(String seatIdentifier, Ticket ticket) {
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
