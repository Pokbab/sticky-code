package test.utils;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

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

	@Test
	public void testIsAlpha() {
		assertTrue("문자열 속에 영문자만 있으면 성공", StringUtils.isAlpha("test"));
		assertTrue("문자열 속에 한글이 포함되어도 성공", StringUtils.isAlpha("테스트"));
	}

	@Test
	public void testPad() {
		assertEquals("우측으로 남은공간을 공백으로 채움", "test      ", StringUtils.rightPad("test", 10, ' '));
		assertEquals("좌측으로 남은공간을 공백으로 채움", "      test", StringUtils.leftPad("test", 10, ' '));
	}

	@Test
	public void testSubstring() {
		assertEquals("문자열 범위를 벗어난 인덱스를 지정하면 공백 반환", "", StringUtils.substring("test", 5, 10));

		assertEquals("지정된 tag 사이에 속한 문자열 추출, 여러개인 경우 첫번째 선택", "20200910", StringUtils.substringBetween("SECURE.20200910..111703206..66799", "."));
		assertEquals("지정된 문자열(open, close) 사이에 속한 문자열 추출, 여러개인 경우 첫번째 선택", "20200", StringUtils.substringBetween("SECURE.20200910.111703206.66799", ".", "9"));
		assertArrayEquals("지정된 문자열(open, close) 사이에 속한 문자열을 배열로 추출", new String[] {"20200910", "111703206"}, StringUtils.substringsBetween("SECURE.20200910..111703206..66799", ".", "."));
	}

	@Test
	public void testAppendIfMissing() {
		assertEquals("마지막 단어가 다를 경우 추가", "/irteam/file/path/", StringUtils.appendIfMissing("/irteam/file/path", "/"));
		assertEquals("마지막 단어가 다를 경우 추가", "/irteam/file/path/", StringUtils.appendIfMissing("/irteam/file/path", "/", "/"));
		assertEquals("마지막 단어가 다를 경우 추가", "/irteam/file/path/", StringUtils.appendIfMissing("/irteam/file/path/", "/", "/"));
	}

	@Test
	public void testRemoveEnd() {
		assertEquals("특정 문자열 삭제", "irteamfilepathfile.gz", StringUtils.remove("/irteam/file/path/file.gz", "/"));
		assertEquals("지정된 단어가 마지막 문자열일 경우 삭제", "/irteam/file/path/file", StringUtils.removeEnd("/irteam/file/path/file.gz", ".gz"));
	}

	@Test
	public void testEndsWith() {
		assertTrue("문자열 끝자리 체크", StringUtils.endsWith("aaa_real", "_real"));
		assertTrue("문자열 끝자리 체크", StringUtils.endsWithAny("aaa_alpha", "_alpha", "_beta", "_local"));
		assertTrue("문자열 끝자리 체크", StringUtils.endsWithIgnoreCase("aaa_ALPHA", "_alpha"));
	}

}
