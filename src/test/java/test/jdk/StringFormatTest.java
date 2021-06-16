package test.jdk;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringFormatTest {

    @Test
    public void testFormat() {
        assertEquals("자리수 맞춰서 포맷팅", "210417", String.format("%6s", "210417"));
        assertEquals("좌측 정렬 space 공백 추가", "168426593      ", String.format("%-15s", "168426593"));
        assertEquals("우측 정렬 space 공백 추가", "      168426593", String.format("%15s", "168426593"));
        assertEquals("우측 정렬 0 공백 추가", "000000168426593", String.format("%015d", 168426593));
    }

}
