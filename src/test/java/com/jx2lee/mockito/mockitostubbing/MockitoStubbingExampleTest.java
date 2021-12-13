package com.jx2lee.mockito.mockitostubbing;

import com.jx2lee.mockito.domain.Member;
import com.jx2lee.mockito.domain.Study;
import com.jx2lee.mockito.member.MemberService;
import com.jx2lee.mockito.study.StudyRepository;
import com.jx2lee.mockito.study.StudyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MockitoStubbingExampleTest {

    @Test
    @DisplayName("아래_TODO_를_만족하는_테스트_코드를_작성한다")
    void 아래_TODO_를_만족하는_테스트_코드를_작성한다(@Mock MemberService memberService,
                                             @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        Assertions.assertNotNull(studyService);

        Member member = new Member();
        member.setMemberId(1L);
        member.setEmail("jaejun.lee.1991@gmail.com");

        Study study = new Study("jx2lee");

        // TODO memberService 객체에 findById 메소드를 1L 값으로 호출하면 Optional.of(member) 객체를 리턴하도록 Stubbing
        Mockito.lenient().when(memberService.findById(1L))
                .thenReturn(Optional.of(member));

        // TODO studyRepository 객체에 save 메소드를 study 객체로 호출하면 study 객체 그대로 리턴하도록 Stubbing
        Mockito.lenient().when(studyRepository.save(study)).thenReturn(study);
    }
}
