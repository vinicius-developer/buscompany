package main.br.com.buscompany.domain.busroute;

import main.br.com.buscompany.domain.bus.Bus;

import java.util.LinkedList;
import java.util.List;

public class BusRoute {

    private List<BusStop> route = new LinkedList<>();

    public void addStop(BusStop busStop) {
        this.route.add(busStop);
    }

}
