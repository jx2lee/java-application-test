package com.jx2lee.junitbasic.sequence;

import com.jx2lee.junitbasic.Class;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitSequenceTest {

    @Order(2)
    @Test
    @DisplayName("테스트_순서를_Order_annotation_을_이용해_설정한다_2")
    void 테스트_순서를_Order_annotation_을_이용해_설정한다_2() {

        System.out.println("JunitTestSequenceTest.테스트_순서를_Order_annotation_을_이용해_설정한다_2");
        Class testClass = new Class(1);
        assertThat(testClass.getLimit()).isGreaterThan(0);

        System.out.println("testClass.getLimit() = " + testClass.getLimit());
        System.out.println("==========");
    }

    @Order(1)
    @Test
    @DisplayName("테스트_순서를_Order_annotation_을_이용해_설정한다_1")
    void 테스트_순서를_Order_annotation_을_이용해_설정한다_1() {

        System.out.println("JunitTestSequenceTest.테스트_순서를_Order_annotation_을_이용해_설정한다_1");
        Class testClass = new Class(2);
        assertThat(testClass.getLimit()).isGreaterThan(1);

        System.out.println("testClass.getLimit() = " + testClass.getLimit());
        System.out.println("==========");
    }

    @Order(3)
    @Test
    @DisplayName("테스트_순서를_Order_annotation_을_이용해_설정한다_3")
    void 테스트_순서를_Order_annotation_을_이용해_설정한다_3() {

        System.out.println("JunitTestSequenceTest.테스트_순서를_Order_annotation_을_이용해_설정한다_3");
        Class testClass = new Class(3);
        assertThat(testClass.getLimit()).isGreaterThan(2);

        System.out.println("testClass.getLimit() = " + testClass.getLimit());
        System.out.println("==========");
    }

}
