package test.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

	@Test
	public void testContains() {
		assertTrue("문자열 속에 찾는 키워드가 있으면 성공", StringUtils.contains("123pokbabzzz", "pokbab"));
		assertTrue("공백으로 감싸진 키워드도 성공", StringUtils.contains(" pokbab	", "pokbab"));
		assertFalse("깨진 문자열은 실패", StringUtils.contains("pok bab", "pokbab"));

		assertTrue("여러개의 키워드 중 하나라도 맞으면 성공", StringUtils.containsAny("abcdefg", "cd", "lnm"));
		assertFalse("여러개의 키워드 중 하나도 안맞으면 실패", StringUtils.containsAny("abcdefg", "zz", "lnm"));

		assertTrue("키워드가 포함되지 않으면 성공", StringUtils.containsNone("abcdefg", "lnm"));

		assertTrue("문자열에 유효한 char만 포함해야 성공", StringUtils.containsOnly("pokbab", "pokba"));

		assertTrue("문자열 속에 찾는 키워드가 있으면 성공(대소문자 무시)", StringUtils.containsIgnoreCase("123pokbabzzz", "POKBAB"));

		assertTrue("문자열에 공백이 포함되면 성공", StringUtils.containsWhitespace("abcde fg"));
	}

}
