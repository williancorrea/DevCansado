package br.com.devcansado.utils;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private DateUtils() {
    }

    public static OffsetDateTime fromString(String date) {
        return OffsetDateTime.parse(date);
    }

    public static String toString(OffsetDateTime date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return fmt.format(date);
    }
}
