package br.com.buscompany.domain.trip.route;

import br.com.buscompany.service.date.DateFormatter;
import br.com.buscompany.service.date.TimeStampDateFormatterService;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Stop {

    private final String placeName;

    private final DateFormatter arrivalDate;

    private final DateFormatter departureDate;

    public Stop(String placeName, String arrivalDate, String departureDate) {
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
        Stop busStop = (Stop) o;
        return Objects.equals(placeName, busStop.placeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeName);
    }
}
