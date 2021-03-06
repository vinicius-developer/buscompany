package br.com.buscompany.domain.bus;

import br.com.buscompany.domain.trip.bus.Seat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

    @Test
    public void createSeatWithTicket() {
        Seat seat = new Seat("1234123", "123123");

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

        seat.toOccupy("123");

        assertTrue(seat.occupied());
    }

}