package br.com.buscompany.domain.trip.bus;

import br.com.buscompany.domain.ticket.Ticket;
import br.com.buscompany.service.identifier.Identifier;
import br.com.buscompany.service.identifier.IdentifierService;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Seat {

    private final Identifier identifierService;

    private String ticketIdentifier;

    public Seat(String identifier) {

        this.identifierService = new IdentifierService(identifier);

    }

    public Seat(String identifier, String ticketIdentifier) {
        this.identifierService = new IdentifierService(identifier);
        this.setTicket(ticketIdentifier);
    }

    private void setTicket(String ticketIdentifier) {
        if(ticketIdentifier == null) {
            throw new InvalidParameterException("Necessario informar um ticket valido");
        }

        this.ticketIdentifier = ticketIdentifier;
    }

    public String identifier() {
        return this.identifierService.identifier();
    }

    public boolean occupied() {
        return this.ticketIdentifier != null;
    }

    public void toOccupy(String ticketIdentifier) {
        this.setTicket(ticketIdentifier);
    }

    public String ticketIdentifier() {
        return this.ticketIdentifier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return identifierService.equals(seat.identifierService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifierService);
    }

}
