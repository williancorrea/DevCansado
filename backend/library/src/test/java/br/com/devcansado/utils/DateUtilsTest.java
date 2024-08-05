package br.com.devcansado.utils;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateUtilsTest {

    private static final String DATE_STRING = "2024-08-04T15:30:00Z";
    private static final OffsetDateTime DATE_OBJECT = OffsetDateTime.of(2024, 8, 4, 15, 30, 0, 0, ZoneOffset.UTC);

    @Test
    void givenValidDateString_whenFromString_thenReturnsExpectedOffsetDateTime() {
        OffsetDateTime result = DateUtils.fromString(DATE_STRING);
        assertEquals(DATE_OBJECT, result, "The parsed OffsetDateTime should match the expected value.");
    }

    @Test
    void givenInvalidDateString_whenFromString_thenThrowsDateTimeParseException() {
        String invalidDateString = "invalid-date";
        assertThrows(DateTimeParseException.class, () -> DateUtils.fromString(invalidDateString),
                "Parsing an invalid date string should throw DateTimeParseException.");
    }

    @Test
    void givenOffsetDateTime_whenToString_thenReturnsExpectedDateString() {
        String result = DateUtils.toString(DATE_OBJECT);
        assertEquals(DATE_STRING, result, "The formatted date string should match the expected value.");
    }

    @Test
    void givenNullOffsetDateTime_whenToString_thenThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> DateUtils.toString(null),
                "Formatting a null OffsetDateTime should throw NullPointerException.");
    }

}
