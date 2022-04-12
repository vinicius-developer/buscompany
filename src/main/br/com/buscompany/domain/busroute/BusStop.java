package main.br.com.buscompany.domain.busroute;

import main.br.com.buscompany.service.date.DateFormater;
import main.br.com.buscompany.service.date.TimeStampDateFormatterService;

public class BusStop {

    private String placeName;

    private DateFormater arrivalDate;

    private DateFormater departureDate;

    public BusStop(String placeName, String arrivalDate, String departureDate) {
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
}
