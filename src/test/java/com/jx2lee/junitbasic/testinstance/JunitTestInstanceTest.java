package com.jx2lee.junitbasic.testinstance;

import com.jx2lee.junitbasic.Class;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 클래스마다 하나의 인스턴스를 생성한다.
public class JunitTestInstanceTest {
    int value = 1;

    @Test
    @DisplayName("테스트_메소드마다_인스턴스를_다르게_생성한다")
    void 테스트_메소드마다_인스턴스를_다르게_생성한다() {
        value ++;
        System.out.println("this = " + this);
        System.out.println("value = " + value);

        Class testClass = new Class(1);
        assertThat(testClass.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName("메소드마다_인스턴스를_생성하는_전략을_바꾼다")
    void 메소드마다_인스턴스를_생성하는_전략을_바꾼다_PER_CLASS() {
        System.out.println("this = " + this);
        System.out.println("value = " + value);
        // 해당 메서드의 hash 값이 "void 테스트_메소드마다_인스턴스를_다르게_생성한다()" 와 같은 것을 확인할 수 있다.

        assertThat(value).isEqualTo(2);
    }
}
