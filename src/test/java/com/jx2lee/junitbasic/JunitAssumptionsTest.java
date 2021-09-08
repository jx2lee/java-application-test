package com.jx2lee.junitbasic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class JunitAssumptionsTest {

    @Test
    void assumeTrue_를_통과하면_테스트를_시작한다() {
        Class aClass = new Class(10);

        assumeTrue("nhn".equalsIgnoreCase(System.getenv("LOGNAME")));
        assertNotNull(aClass, () -> "aClass 는 Null 이 아니다.");
    }

    @Test
    void assumeTrue_를_통과하지_못하면_테스트를_멈춘다() {
        Class aClass = new Class(10);

        assumeTrue("nhn2".equalsIgnoreCase(System.getenv("LOGNAME")), () -> "nhn2 는 LOGNAME 환경변수 값이 아니기 때문에 실패한다.");
        assertNotNull(aClass, () -> "aClass 는 Null 이 아니다.");
        }

    @Test
    void assumingThat_을_이용하여_조건과_테스트를_모두_수행한다() {
        assumingThat("nhn".equalsIgnoreCase(System.getenv("LOGNAME")), () -> {
            Class aClass = new Class(10);
            assertNotNull(aClass, () -> "aClass 는 Null 이 아니다.");
        });
    }

    @Test
    void assumingThat_을_이용하여_조건과_테스트를_모두_수행하지만_조건을_만족하지_못하면_넘어가고_성공한다() {
        Class aClass = new Class(10);
        assumingThat("nhn2222".equalsIgnoreCase(System.getenv("LOGNAME")), () -> {
            assertNotNull(aClass, () -> "aClass 는 Null 이 아니다.");
        });

        assertNull(aClass, () -> "aClass 는 Null 이 아니다.");

    }

    @Test
    @EnabledOnOs(OS.MAC)
    void EnabledOnOs_어노테이션으로도_사용가능하다() {
        Class aClass = new Class(10);
        assertNotNull(aClass, () -> "aClass 는 Null 이 아니다.");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void 이는_리눅스이기_때문에_테스트를_수행하지_않는다() {
        Class aClass = new Class(10);
        assertNotNull(aClass, () -> "aClass 는 Null 이 아니다.");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "LOGNAME", matches = "nhn")
    void assumingThat_과_같이_어노테이션_EnabledIfEnvironmentVariable_로도_사용이_가능하다() {
        Class aClass = new Class(10);
        assertNotNull(aClass, () -> "aClass 는 Null 이 아니다.");
    }
}
