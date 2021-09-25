package com.jx2lee.junitbasic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JunitRepeatedTest {

    @DisplayName("RepeatedTest_를_통한_테스트_반복하기_1부_RepeatedTest")
    @RepeatedTest(value = 10, name = "{displayName}: {currentRepetition}/{totalRepetitions}")
    void RepeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println("반복횟수 만큼 테스트를 진행한다. 테스트 이름에 대한 인자를 자유롭게 사용할 수 있다: " +
                repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("RepeatedTest_를_통한_테스트_반복하기_1부_ParameterizedTest")
    @ParameterizedTest(name = "{index}: {displayName}: message={arguments}")
    // @ParameterizedTest(name = "{index}: {displayName}: message={0}")
    @ValueSource(strings = {"one", "two", "three", "four"})
    void ParameterizedTest(String message) {
        System.out.println("ValueSource 에 지정한 인자만큼 테스트를 진행한다: message = " + message);
    }

}
