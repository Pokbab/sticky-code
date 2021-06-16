package test.nio;

import java.net.URLEncoder;

import org.junit.Assert;
import org.junit.Test;

import lombok.SneakyThrows;

public class EncodeTest {

    @Test
    @SneakyThrows
    public void test() {

        byte[] bytes1 = "���θ�".getBytes("euc-kr");

        byte[] bytes2 = "법인명".getBytes("euc-kr");

        String asdasd = new String("법인명".getBytes("euc-kr"));
        String asdasd2 = new String("법인명".getBytes("euc-kr"), "utf-8");

        String dd = new String("���θ�".getBytes("euc-kr"), "utf-8");
        String ss = new String("법인명".getBytes("euc-kr"), "euc-kr");

        System.out.println(new String(dd.getBytes(), "euc-kr"));

        // byte[] bytes = "테스트".getBytes("euc-kr");
        // System.out.println(new String(bytes, "utf-8"));
        // Assert.assertEquals("테스트", new String(bytes, "euc-kr"));
        // Assert.assertEquals("테스트", new String("테스트".getBytes("euc-kr"), "euc-kr"));


        // new String("¹ýÀÎ¸í", "euc-kr");
        String aa = new String("¹ýÀÎ¸í".getBytes(), "euc-kr");

        System.out.println(new String(dd.getBytes(), "euc-kr"));
    }

    @Test
    @SneakyThrows
    public void testEncode() {

        String actual = URLEncoder.encode("asd@asd.com", "utf-8");

        Assert.assertEquals("asd%40asd.com", actual);
    }

}
