package test.utils;

import static org.junit.Assert.*;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class OptionalTest {

    @Test
    public void testContains() {
        String a = "A";
        String b = "B";
        String c = "C";

        String actual = Optional.ofNullable(a)
            .map(x -> b)
            .map(x -> c)
            .get();

        assertEquals("문자열 속에 찾는 키워드가 있으면 성공", a, actual);
    }

}
