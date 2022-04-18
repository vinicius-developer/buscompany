package br.com.buscompany.service.date;

import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampDateFormatterService implements DateFormater {

    private final String TIME_STAMP_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    private final Date date;

    public TimeStampDateFormatterService(String date) {
        try {
            this.date = new SimpleDateFormat(this.TIME_STAMP_DEFAULT)
                    .parse(date);
        } catch (ParseException parseException) {
            throw new InvalidParameterException("A data fornecida nao esta no padrao timestamp");
        }
    }

    @Override
    public String getDate() {
        Timestamp timestamp = new Timestamp(this.date.getTime());

        SimpleDateFormat formatter = new SimpleDateFormat(this.TIME_STAMP_DEFAULT);

        return formatter.format(timestamp);
    }
}
