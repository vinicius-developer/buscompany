package test.domain.bus;

import main.br.com.buscompany.domain.bus.Seat;
import main.br.com.buscompany.domain.ticket.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

    @Test
    public void createSeatWithTicket() {
        Seat seat = new Seat("1234123", new Ticket("123123"));

        assertTrue(seat.occupied());
    }

    @Test
    public void createSeatWihtoutTicket() {
        Seat seat = new Seat("123123");

        assertFalse(seat.occupied());
    }


    @Test
    public void insertTicketAfterCreationOfSeat() {
        Seat seat = new Seat("123123");

        seat.toOccupy(new Ticket("123"));

        assertTrue(seat.occupied());
    }

}