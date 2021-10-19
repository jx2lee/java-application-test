package com.jx2lee.junitbasic.properties;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitPropertiesTest {

    int value = 0;

    @Order(2)
    @Test
    @DisplayName("PER_CLASS_설정이_적용되어_value_값을_변경한다_2")
    void 테스트_순서를_Order_annotation_을_이용해_설정한다_2() {

        System.out.println("JunitTestSequenceTest.테스트_순서를_Order_annotation_을_이용해_설정한다_2");
        System.out.println("value = " + value++);

        assertThat(value).isEqualTo(2);
        System.out.println("==========");
    }

    @Order(1)
    @Test
    @DisplayName("PER_CLASS_설정이_적용되어_value_값을_변경한다_1")
    void 테스트_순서를_Order_annotation_을_이용해_설정한다_1() {

        System.out.println("JunitTestSequenceTest.테스트_순서를_Order_annotation_을_이용해_설정한다_1");
        System.out.println("value = " + value++);

        assertThat(value).isEqualTo(1);
        System.out.println("==========");
    }

    @Order(3)
    @Test
    @DisplayName("PER_CLASS_설정이_적용되어_value_값을_변경한다_3")
    void 테스트_순서를_Order_annotation_을_이용해_설정한다_3() {

        System.out.println("JunitTestSequenceTest.테스트_순서를_Order_annotation_을_이용해_설정한다_3");
        System.out.println("value = " + value++);

        assertThat(value).isEqualTo(3);
        System.out.println("==========");
    }

    @Test
    @DisplayName("disabled_어노테이션이_붙은_테스트를_실행한다")
    @Disabled
    void disabled_어노테이션이_붙은_테스트를_실행한다() {

        System.out.println("JunitTestSequenceTest.disabled_어노테이션이_붙은_테스트를_실행한다");
        System.out.println("properties 에 설정된 disabled 옵션으로 해당 테스트를 수행한다.");
        System.out.println("==========");
    }

    @Test
    @Disabled
    void DisplayName_전략을_properties_에_적용할_수_있다() {

        System.out.println("JunitTestSequenceTest.DisplayName_전략을_properties_에_적용할_수_있다");
        System.out.println("DisplayName 이 DisplayNameGeneration 보다 우선순위가 높다. 즉, DisplayName 이 설정되어 있으면 해당 내용으로 태스트 이름을 설정한다.");
        System.out.println("==========");
    }

}
