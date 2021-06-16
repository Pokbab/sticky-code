package test.jdk;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Test;

public class BigDecimalTest {

    @Test
    public void testFormat() {
        BigDecimal num = BigDecimal.valueOf(1.6);

        assertEquals("단순 String 비교", "1.6", num.toString());
        assertEquals("DecimalFormat 포맷팅", "01.60", new DecimalFormat("00.00").format(num.doubleValue()));

        BigDecimal negativeNum = BigDecimal.valueOf(-123);

        assertEquals("단순 String 비교", "-123", negativeNum.toString());
        assertEquals("DecimalFormat 포맷팅", -123, negativeNum.longValue());
        assertEquals("DecimalFormat 포맷팅", "-00000000000123", String.format("%015d", negativeNum.longValue()));
        assertEquals("DecimalFormat 포맷팅", "-00000000000000", String.format("%015d", -0));
    }

    @Test
    public void testAdd() {
        BigDecimal total = BigDecimal.valueOf(-5801315);
        BigDecimal amount = BigDecimal.valueOf(801685);
        BigDecimal cancel = BigDecimal.valueOf(-6603000);

        assertEquals(total, amount.add(cancel));
    }

}
