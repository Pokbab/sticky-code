package test.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Assert;
import org.junit.Test;

public class NioTest {

	@Test
	public void test() {

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.put("1376".getBytes());
		byte[] bytes = new byte[buffer.position()];
		buffer.flip();
		buffer.get(bytes);
		String s = new String(bytes);
		System.out.println(s);
	}

	@Test
	public void testIntToByte() {

		int testInt = 1376;

		byte[] bytes = intTobyte(testInt, ByteOrder.BIG_ENDIAN);

		Assert.assertArrayEquals(bytes, new byte[] {0, 0, 5, 96});
	}

	/**
	 * int형을 byte배열로 바꿈<br>
	 * @param integer
	 * @param order
	 * @return
	 */
	public static byte[] intTobyte(int integer, ByteOrder order) {

		ByteBuffer buff = ByteBuffer.allocate(Integer.SIZE/8);
		buff.order(order);

		// 인수로 넘어온 integer을 putInt로설정
		buff.putInt(integer);

		System.out.println("intTobyte : " + buff);
		return buff.array();
	}

	/**
	 * byte배열을 int형로 바꿈<br>
	 * @param bytes
	 * @param order
	 * @return
	 */
	public static int byteToInt(byte[] bytes, ByteOrder order) {

		ByteBuffer buff = ByteBuffer.allocate(Integer.SIZE/8);
		buff.order(order);

		// buff사이즈는 4인 상태임
		// bytes를 put하면 position과 limit는 같은 위치가 됨.
		buff.put(bytes);
		// flip()가 실행 되면 position은 0에 위치 하게 됨.
		buff.flip();

		System.out.println("byteToInt : " + buff);

		return buff.getInt(); // position위치(0)에서 부터 4바이트를 int로 변경하여 반환
	}

}
