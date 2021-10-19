package com.jx2lee.junitbasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JunitAssertionTest {

    @Test
    void assertNotNull_객체가_Null_인지_확인합니다_assertNotNull() {
        Class aClass = new Class(10);
        assertNotNull(aClass, () -> "일반 String 으로 생성가능하지만 lambda 표현식으로 생성이 가능하다.");
    }

    @Test
    void assertEquals_실제_값이_기대한_값과_같은지_확인() {
        Class aClass = new Class(10);
        assertEquals(ClassStatus.ON, aClass.getStatus(), "객체 기본 상태는 ON 이다.");
    }

    @Test
    void assertAll_각각의_테스트가_통과하지_못해도_모든_테스트를_수행한다() {
        Class aClass = new Class(10);
        assertAll(
                () -> assertEquals(ClassStatus.ON, aClass.getStatus(), "이 테스트가 실패해도 다른 테스트는 수행가능하다."),
                () -> assertNotNull(aClass, "일반 String 으로 생성가능하지만 lambda 표현식으로 생성이 가능하다."),
                () -> assertNotNull(aClass, "실패한 테스트가 존재해도 assertAll 안의 테스트는 결과가 모두 확인 가능하다.")
        );
    }

    @Test
    void assertThrows_예외를_발생한다() {
        assertThrows(IllegalArgumentException.class, ()-> new Class(-1));
    }
}
