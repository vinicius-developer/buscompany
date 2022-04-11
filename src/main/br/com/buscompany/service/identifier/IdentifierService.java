package main.br.com.buscompany.service.identifier;

import java.security.InvalidParameterException;
import java.util.Objects;

public class IdentifierService implements Identifier{

    private final String identifier;

    public IdentifierService(String identifier) {
        if(identifier == null || identifier.isEmpty() || identifier.isBlank()) {
            throw new InvalidParameterException("Necessario informar o identificador do assento");
        }

        this.identifier = identifier;
    }

    public String identifier() {
        return this.identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentifierService that = (IdentifierService) o;
        return Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
