package test.nio;

import org.junit.Test;

import lombok.SneakyThrows;

public class EncodeTest {

	@Test
	@SneakyThrows
	public void test() {

		byte[] bytes = "1376PAY".getBytes("euc-kr");


		System.out.println(bytes);
	}

}
