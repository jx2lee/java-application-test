package com.jx2lee.junitbasic;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class JunitBasicAnnotationTest {

    @BeforeAll
    // BeforeAll 의 경우 static 사용
    static void beforeAll() {
        System.out.println("ClassTest.beforeAll");
        System.out.println();
    }

    @Test
    void testCaseV1() {
        System.out.println("JunitBasicAnnotationTest.testCaseV1");
    }

    @Test
    void testCaseV2() {
        System.out.println("JunitBasicAnnotationTest.testCaseV2");
    }

    @AfterEach
    void afterEach() {
        System.out.println("JunitBasicAnnotationTest.afterEach");
        System.out.println();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("JunitBasicAnnotationTest.beforeEach");
    }

    @AfterAll
    // AfterAll 의 경우 static 사용
    static void afterAll() {
        System.out.println("JunitBasicAnnotationTest.afterAll");
    }
}
