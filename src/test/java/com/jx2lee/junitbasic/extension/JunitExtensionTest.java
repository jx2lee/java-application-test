package com.jx2lee.junitbasic.extension;

import com.jx2lee.junitbasic.Class;
import com.jx2lee.junitbasic.customtag.DevTest;
import com.jx2lee.junitbasic.customtag.RealTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static java.lang.Thread.sleep;

@ExtendWith(FindDevTestExtension.class)
public class JunitExtensionTest {

    @Test
    @DisplayName("Extension_을_ExtendWith_을_통해_설정하고_테스트한다_dev.")
    @Tag("dev")
    void Extension_을_ExtendWith_을_통해_설정하고_테스트한다_dev() throws InterruptedException {

        sleep(1005L);
        Class testClass = new Class(100);
        Assertions.assertNotNull(testClass);
        System.out.println("JunitExtensionTest.Extension_을_ExtendWith_을_통해_설정하고_테스트한다");
    }

    @RealTest
    @DisplayName("Extension_을_ExtendWith_을_통해_설정하고_테스트한다_real")
    void Extension_을_ExtendWith_을_통해_설정하고_테스트한다_real() {

        Class aClass = new Class(100);
        Assertions.assertNotNull(aClass);
        System.out.println("JunitExtensionTest.Extension_을_ExtendWith_을_통해_설정하고_테스트한다_real");
    }

    @DevTest
    @DisplayName("테스트가_1분을_넘어가지만_annotation_DevTest_가_적용되어_print_하지_않는다.")
    void 테스트가_1분을_넘어가지만_annotation_DevTest_가_적용되어_print_하지_않는다() throws InterruptedException {

        sleep(1005L);
        Class testClass = new Class(100);
        Assertions.assertNotNull(testClass);
        System.out.println("JunitExtensionTest.Extension_을_ExtendWith_을_통해_설정하고_테스트한다");
    }

    /**
     * 만약 THRESHOLD 값을 동적으로 변경하고 싶다면
     * 코드로 extension instance 생성이 가능
     * 방법
     *      1. FindSlowTestExtension 의 THRESHOLD 를 받는 생성자 추가
     *      2. 아래 코드로 Extension instance 를 생성
     *      static FindDevTestExtension findDevTestExtension = new FindDevTestExtension();
     *      3. Test 진행
     */
}
