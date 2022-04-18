package br.com.buscompany.domain.ticket;

import br.com.buscompany.service.identifier.Identifier;
import br.com.buscompany.service.identifier.IdentifierService;

public class Ticket {

    private final Identifier identifierService;

    public Ticket(String identifier) {
        this.identifierService = new IdentifierService(identifier);
    }

    public String identifier() {
        return this.identifierService.identifier();
    }

}
