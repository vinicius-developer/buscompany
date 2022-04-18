package main.br.com.buscompany.domain.busroute;

import main.br.com.buscompany.service.date.DateFormater;
import main.br.com.buscompany.service.date.TimeStampDateFormatterService;

import java.security.InvalidParameterException;
import java.util.Objects;

public class BusStop {

    private final String placeName;

    private final DateFormater arrivalDate;

    private final DateFormater departureDate;

    public BusStop(String placeName, String arrivalDate, String departureDate) {
        if(placeName == null || arrivalDate == null || departureDate == null ) {
            throw new InvalidParameterException("Parada não pode ter argumentos nulos");
        }

        this.placeName = placeName;
        this.arrivalDate = new TimeStampDateFormatterService(arrivalDate);
        this.departureDate = new TimeStampDateFormatterService(departureDate);
    }




    public String arrivalDate() {
        return this.arrivalDate.getDate();
    }

    public String departureDate() {
        return this.departureDate.getDate();
    }

    public String name() {
        return this.placeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusStop busStop = (BusStop) o;
        return Objects.equals(placeName, busStop.placeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeName);
    }
}
