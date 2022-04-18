package br.com.buscompany.service.identifier;

import java.security.InvalidParameterException;

public class CpfIdentifierService implements Identifier {

    private final String identifier;

    public CpfIdentifierService(String identifier) {

        if(!this.isValid(identifier)) {
            throw new InvalidParameterException("cpf não é valido");
        }

        this.identifier = identifier;

    }

    private boolean isValid(String identifier) {
        return identifier.matches("([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})");
    }

    @Override
    public String identifier() {
        return this.identifier;
    }
}
