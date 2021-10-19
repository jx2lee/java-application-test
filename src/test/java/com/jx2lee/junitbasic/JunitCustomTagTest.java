package com.jx2lee.junitbasic;

import com.jx2lee.junitbasic.customtag.DevTest;
import com.jx2lee.junitbasic.customtag.RealTest;
import org.junit.jupiter.api.DisplayName;

public class JunitCustomTagTest {

    @DisplayName("커스텀_어노테이션을_이용해_dev_태그를_가진_테스트를_실행한다")
    @DevTest
    void dev_태그를_가진_테스트를_실행한다() {
        System.out.println("JunitCustomTagTest.dev_태그를_가진_테스트를_생성한다");
    }

    @DisplayName("커스텀_어노테이션을_이용해_real_태그를_가진_테스트를_실행한다")
    @RealTest
    void real_태그를_가진_테스트를_실행한다() {
        System.out.println("JunitCustomTagTest.real_태그를_가진_테스트를_생성한다");
    }
}
