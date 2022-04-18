package br.com.buscompany.domain.busroute;

import main.br.com.buscompany.domain.busroute.BusStop;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BusStopTest {

    private BusStop busStop;

    @Before
    public void setUp() throws Exception {

        this.busStop = new BusStop(
                "Lugar de Teste",
                "2022-04-12 08:00:00",
                "2022-04-12 08:30:00"
        );

    }

    @Test
    public void getPlace() {

        assertEquals(this.busStop.name(), "Lugar de Teste");

    }

    @Test
    public void getArrivalDate() {

        assertEquals(this.busStop.arrivalDate(), "2022-04-12 08:00:00");

    }


    @Test
    public void getDepartureDate() {

        assertEquals(this.busStop.arrivalDate(), "2022-04-12 08:00:00");

    }

    @Test
    public void verifyThrowsNullParametersInBusStop() {

        InvalidParameterException invalidParameterException = assertThrows(
                InvalidParameterException.class,
                () -> new BusStop(null, null, null)
        );

        String message = "Parada não pode ter argumentos nulos";

        assertEquals(invalidParameterException.getMessage(), message);

    }



}
