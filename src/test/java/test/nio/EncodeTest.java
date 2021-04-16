package test.nio;

import java.net.URLEncoder;

import org.junit.Assert;
import org.junit.Test;

import lombok.SneakyThrows;

public class EncodeTest {

    @Test
    @SneakyThrows
    public void test() {

        byte[] bytes = "1376PAY".getBytes("euc-kr");

        System.out.println(bytes);
    }

    @Test
    @SneakyThrows
    public void testEncode() {

        String actual = URLEncoder.encode("asd@asd.com", "utf-8");

        Assert.assertEquals("asd%40asd.com", actual);
    }

}
