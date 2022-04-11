package test.service.identifier;

import main.br.com.buscompany.service.identifier.Identifier;
import main.br.com.buscompany.service.identifier.IdentifierService;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class IdentifierServiceTest {

    @Test
    public void getExceptionInDeclareIdentifier() {

        Exception identifier = assertThrows(InvalidParameterException.class, () -> {
            new IdentifierService("");
        });

        String message = "Necessario informar o identificador do assento";

        assertEquals(message, identifier.getMessage());

    }

    @Test
    public void verifyIdentifier() {

        Identifier identifier = new IdentifierService("123");

        assertEquals("123", identifier.identifier());

    }

}