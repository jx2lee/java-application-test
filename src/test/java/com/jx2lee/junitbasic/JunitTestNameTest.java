package com.jx2lee.junitbasic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class JunitTestNameTest {

    @Test
    void under_score_remove() {
        System.out.println("under_score 가 제거되는 것을 확인할 수 있습니다.");
    }

    @Test
    void 함수명을_따라_테스트_이름이_설정됩니다() {
        System.out.println("TestNameTest.함수명을_따라_테스트_이름이_설정됩니다");
    }

    @Test
    @DisplayName("하지만_DisplayName_을_적용하면_우선순위가_높다")
    void 하지만_DisplayName_을_적용하면_우선순위가_높다() {
        System.out.println("TestNameTest.하지만_DisplayName_을_적용하면_우선순위가_높다");
    }
}
