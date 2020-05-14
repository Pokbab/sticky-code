package test.utils;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.util.ReflectionUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ReflectionUtilsTest {

	@AllArgsConstructor
	@Setter
	@Getter
	public static class Dog {

		private String name;
		private int age;

	}

	@Test
	public void testDoWithFields() {
		Dog leeSyong = new Dog("리숑", 5);

		ReflectionUtils.doWithFields(
			Dog.class,
			field -> {
				String name = (String) field.get(leeSyong);
				assertEquals(name, "리숑");
			},
			field -> field.getType() == String.class
		);
	}

}
