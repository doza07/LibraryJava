package com.doza.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateFormatter {
    public static final String PATTERN = "yyyy-MM-dd";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    public static LocalDate format(String date) {
        return LocalDate.parse(date, FORMATTER);
    }

    public static boolean isValid(String date) {
        try{
            format(date);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
