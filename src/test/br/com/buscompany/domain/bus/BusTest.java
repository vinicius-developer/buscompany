package test.br.com.buscompany.domain.bus;

import main.br.com.buscompany.domain.bus.Bus;
import main.br.com.buscompany.domain.bus.Seat;
import main.br.com.buscompany.domain.ticket.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {

    private final List<Seat> seats = new LinkedList<Seat>();

    private Bus bus;

    @BeforeEach
    void setUp() {

        Seat seat1 = new Seat("123");
        Seat seat2 = new Seat("321",  new Ticket("432"));
        Seat seat3 = new Seat("2212");

        this.seats.add(seat1);
        this.seats.add(seat2);
        this.seats.add(seat3);

        this.bus = new Bus("3212312", seats);

    }

    @Test
    public void getListOfOccupiedSeats() {

        List<String> allUnOccupiedSeats = this.bus.getAllUnOccupiedSeats();

        List<String> list = List.of(
                this.seats.get(0).identifier(),
                this.seats.get(2).identifier()
        );

        assertEquals(allUnOccupiedSeats, list);

    }

    @Test
    public void getErrorOfInvalidSeatToOccupy() {

        Exception errorInvalidSeat = assertThrows(InvalidParameterException.class, () -> {
            this.bus.toOccupy("AAAA", new Ticket("ASDADASD"));
        });

        String message = "Esse assento nao esta presente nesse onibus";

        assertEquals(message, errorInvalidSeat.getMessage());

    }

    @Test
    public void getErrorSeatIsOccupied() {

        Exception errorOccupiedSeat = assertThrows(InvalidParameterException.class, () -> {
            this.bus.toOccupy("321", new Ticket("ASDADASD"));
        });

        String message = "Esse assento ja esta ocupado";

        assertEquals(message, errorOccupiedSeat.getMessage());

    }

}