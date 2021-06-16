package test.jdk;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class DateTimeFormatterTest {

    @Test
    public void testFormat() {
        assertEquals("20211025", LocalDate.of(2021, 10, 25).format(DateTimeFormatter.BASIC_ISO_DATE));

        assertEquals("202110251355", LocalDateTime.of(2021, 10, 25, 13, 55).format(DateTimeFormatter.BASIC_ISO_DATE));
    }


    public void test() {

        int aaa = 123;

        long bb;
        char sd;
        boolean asd;


        DateTimeFormatterTest asdasd = new DateTimeFormatterTest();

        // 메모리.. 스택, 힙



    }




}
