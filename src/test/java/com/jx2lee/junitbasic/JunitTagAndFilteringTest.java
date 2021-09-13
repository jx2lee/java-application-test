package com.jx2lee.junitbasic;

import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class JunitTagAndFilteringTest {

    @Test
    @DisplayName("태그가_dev_인_테스트를_수행한다")
    @Tag("dev")
    void 태그는_dev() {

        Class aClass = new Class(100);
        Assertions.assertNotNull(aClass);
        // System.out.println("태그가 dev 인 테스트만 수행합니다.");
    }

    @Test
    @DisplayName("태그가_real_인_테스트를 수행한다")
    @Tag("real")
    void 태그는_real() {

        Class aClass = new Class(100);
        Assertions.assertNotNull(aClass);
        // System.out.println("태그가 dev 인 테스트만 수행합니다.");
    }
}
