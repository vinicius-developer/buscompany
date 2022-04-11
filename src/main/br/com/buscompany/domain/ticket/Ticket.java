package main.br.com.buscompany.domain.ticket;

import main.br.com.buscompany.service.identifier.Identifier;
import main.br.com.buscompany.service.identifier.IdentifierService;

public class Ticket {

    private final Identifier identifierService;

    public Ticket(String identifier) {
        this.identifierService = new IdentifierService(identifier);
    }

    public String identifier() {
        return this.identifierService.identifier();
    }

}
