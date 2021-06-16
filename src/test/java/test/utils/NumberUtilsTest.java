package test.utils;

import static org.junit.Assert.*;

import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import lombok.SneakyThrows;

public class NumberUtilsTest {

    @Test
    @SneakyThrows
    public void testIsCreatable() {
        assertTrue(NumberUtils.isCreatable("+1234567890"));
        assertTrue(NumberUtils.isCreatable("-1234567890"));
        assertTrue(NumberUtils.isCreatable("+123"));
        assertTrue(NumberUtils.isCreatable("-0"));
        // assertTrue(NumberUtils.isDigits("+00001800"));
        // assertTrue(NumberFormat.getInstance(Locale.US).parse("001800").intValue() == 1800);
        assertTrue(Double.parseDouble("+0001234567890") == 1234567890);
        assertTrue(Double.parseDouble("-0001234567890") == -1234567890);
        assertTrue(Integer.parseInt("+0001234567890") == 1234567890);
        assertTrue(Integer.parseInt("-0001234567890") == -1234567890);

        assertTrue(NumberUtils.isParsable("+0001234567890"));
        assertTrue(NumberUtils.isParsable("-0001234567890"));


        assertFalse(NumberUtils.isCreatable("+"));
        assertFalse(NumberUtils.isCreatable("-"));

    }

}
