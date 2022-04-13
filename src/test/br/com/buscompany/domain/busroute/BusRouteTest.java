package test.br.com.buscompany.domain.busroute;

import main.br.com.buscompany.domain.busroute.BusRoute;
import main.br.com.buscompany.domain.busroute.BusStop;
import org.junit.Before;
import org.junit.Test;


import java.security.InvalidParameterException;
import java.util.List;

import static org.junit.Assert.*;

public class BusRouteTest {

    private final BusRoute busRoute = new BusRoute();

    private BusStop busStop1;

    private BusStop busStop2;

    private BusStop busStop3;

    private BusStop busStop4;

    @Before
    public void setUp() throws Exception {

        this.busStop1 = new BusStop(
                "Parada1",
                "2022-04-12 08:00:00",
                "2022-04-12 08:30:00"
        );

        this.busStop2 = new BusStop(
                "Parada2",
                "2022-04-12 08:00:00",
                "2022-04-12 08:30:00"
        );

        this.busStop3 = new BusStop(
                "Parada3",
                "2022-04-12 08:00:00",
                "2022-04-12 09:30:00"
        );

        this.busStop4 = new BusStop(
                "Parada4",
                "2022-04-12 08:00:00",
                "2022-04-12 11:00:00"
        );

        this.busRoute.addStop(this.busStop1);
        this.busRoute.addStop(this.busStop2);
        this.busRoute.addStop(this.busStop3);
        this.busRoute.addStop(this.busStop4);

    }

    @Test
    public void verifyGetBusStop() {

        assertEquals(busRoute.showRoute(), List.of(
                this.busStop1,
                this.busStop2,
                this.busStop3,
                this.busStop4
        ));

    }

    @Test
    public void addNullInBusStop() {

        Exception invalidParameterException = assertThrows(InvalidParameterException.class, () -> {
            this.busRoute.addStop(null);
        });

        String message = "A parada de onibus nao pode ser igual a null";

        assertEquals(message, invalidParameterException.getMessage());

    }

    @Test
    public void addExistentBusStopInRoute() {

        InvalidParameterException invalidParameterException = assertThrows(InvalidParameterException.class, () -> {
            this.busRoute.addStop(this.busStop1);
        });

       String message = "Parada ja existe nessa rota";

       assertEquals(message, invalidParameterException.getMessage());

    }


}