package test.br.com.buscompany.domain.busroute;

import main.br.com.buscompany.domain.trip.route.Route;
import main.br.com.buscompany.domain.trip.route.Stop;
import org.junit.Before;
import org.junit.Test;


import java.security.InvalidParameterException;
import java.util.List;

import static org.junit.Assert.*;

public class RouteTest {

    private final Route busRoute = new Route();

    private Stop busStop1;

    private Stop busStop2;

    private Stop busStop3;

    private Stop busStop4;

    @Before
    public void setUp() throws Exception {

        this.busStop1 = new Stop(
                "Parada1",
                "2022-04-12 08:00:00",
                "2022-04-12 08:30:00"
        );

        this.busStop2 = new Stop(
                "Parada2",
                "2022-04-12 08:00:00",
                "2022-04-12 08:30:00"
        );

        this.busStop3 = new Stop(
                "Parada3",
                "2022-04-12 08:00:00",
                "2022-04-12 09:30:00"
        );

        this.busStop4 = new Stop(
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