package main.br.com.buscompany.domain.bus;

import main.br.com.buscompany.domain.ticket.Ticket;
import main.br.com.buscompany.service.identifier.Identifier;
import main.br.com.buscompany.service.identifier.IdentifierService;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Seat {

    private final Identifier identifierService;

    private Ticket ticket;

    public Seat(String identifier) {
        this.identifierService = new IdentifierService(identifier);
    }

    public Seat(String identifier, Ticket ticket) {
        this.identifierService = new IdentifierService(identifier);
        this.setTicket(ticket);
    }

    private void setTicket(Ticket ticket) {
        if(ticket == null) {
            throw new InvalidParameterException("Necessario informar um ticket valido");
        }

        this.ticket = ticket;
    }

    public String identifier() {
        return this.identifierService.identifier();
    }

    public boolean occupied() {
        return this.ticket != null;
    }

    public void toOccupy(Ticket ticket) {
        this.setTicket(ticket);
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
