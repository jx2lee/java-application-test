package com.jx2lee.mockito.mockitobdd;

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
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
public class MockitoAsBddTest {

    @Test
    @DisplayName("BDD_패턴을_적용한_테스트_코드를_작성할_수_있다")
    void BDD_패턴을_적용한_테스트_코드를_작성할_수_있다(@Mock MemberService memberService,
                                              @Mock StudyRepository studyRepository) {

        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);
        Assertions.assertNotNull(studyService);

        Member member = new Member();
        member.setMemberId(1L);
        member.setEmail("jaejun.lee.1991@gmail.com");

        Study study = new Study("jx2lee");

        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);

        // When
        studyService.createNewStudy(1L, study);

        // Then
        Assertions.assertEquals(member.getName(), study.getOwner());
        then(memberService).should(times(1)).notify(study);
        then(memberService).should(times(1)).notify(member);
        verifyNoMoreInteractions(memberService);
    }

}
