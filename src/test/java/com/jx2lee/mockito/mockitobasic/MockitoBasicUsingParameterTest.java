package com.jx2lee.mockito.mockitobasic;

import com.jx2lee.mockito.domain.Member;
import com.jx2lee.mockito.member.MemberService;
import com.jx2lee.mockito.study.StudyRepository;
import com.jx2lee.mockito.study.StudyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MockitoBasicUsingParameterTest {

    @Test
    @DisplayName("Extension_을_사용하기_위해_Annotation_추가_후_Mock_객체를_파라미터로_넣어주고_테스트한다")
    void Extension_을_사용하기_위해_Annotation_추가_후_Mock_객체를_파라미터로_넣어주고_테스트한다(
            @Mock MemberService memberService,
            @Mock StudyRepository studyRepository) {

        Optional<Member> optional = memberService.findById(1L);
        assertNotNull(optional);

        memberService.validate(2L);

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }

    @Test
    @DisplayName("void_함수는_그냥_실행한다")
    void void_함수는_그냥_실행한다(@Mock MemberService memberService) {

        memberService.validate(2L);
    }
}
