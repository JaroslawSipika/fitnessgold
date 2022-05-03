package com.example.fitnessgold.rest.DTO;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

    @Override
    public LocalDateTime parse(String text, Locale locale) throws ParseException {
        return LocalDateTime.parse(text, DateTimeFormatter.ISO_DATE_TIME);
    }

    @Override
    public String print(LocalDateTime object, Locale locale) {
        return DateTimeFormatter.ISO_DATE_TIME.format(object);
    }


}
