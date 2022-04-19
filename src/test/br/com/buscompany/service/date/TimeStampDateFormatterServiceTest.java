package br.com.buscompany.service.date;

import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class TimeStampDateFormatterServiceTest {

    @Test
    public void createDateByInvalidString() {

        Exception invalidParameter = assertThrows(InvalidParameterException.class, () -> {
            new TimeStampDateFormatterService("asdasdasada");
        });

        String message = "A data fornecida nao esta no padrao timestamp";

        assertEquals(message, invalidParameter.getMessage());

    }
    
    @Test
    public void createValidaDate() {
        
        String date = "2002-02-25 10:30:25";

        DateFormatter time = new TimeStampDateFormatterService(date);

        assertEquals(date, time.getDate());
        
    }
    


}