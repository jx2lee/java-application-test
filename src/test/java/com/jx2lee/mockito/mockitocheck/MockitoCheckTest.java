package com.jx2lee.mockito.mockitocheck;


import com.jx2lee.mockito.domain.Member;
import com.jx2lee.mockito.domain.Study;
import com.jx2lee.mockito.member.MemberService;
import com.jx2lee.mockito.study.StudyRepository;
import com.jx2lee.mockito.study.StudyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoCheckTest {

    @Test
    @DisplayName("특정_함수가_몇번_호출되었는지_확인한다.")
    void 특정_함수가_몇번_호출되었는지_확인한다(@Mock MemberService memberService,
                                      @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        Assertions.assertNotNull(studyService);

        Member member = new Member();
        member.setMemberId(1L);
        member.setEmail("jaejun.lee.1991@gmail.com");

        Study study = new Study("jx2lee");

        lenient().when(memberService.findById(1L))
                .thenReturn(Optional.of(member));
        lenient().when(studyRepository.save(study)).thenReturn(study);
        studyService.createNewStudy(1L, study);

        Assertions.assertEquals(member.getName(), study.getOwner());

        verify(memberService, times(1)).notify(study);
        verify(memberService, times(1)).notify(member);
        verify(memberService, never()).validate(any());
    }

    @Test
    @DisplayName("특정_함수가_순서대로_호출하는지_확인한다.")
    void 특정_함수가_순서대로_호출하는지_확인한다(@Mock MemberService memberService,
                                        @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        Assertions.assertNotNull(studyService);

        Member member = new Member();
        member.setMemberId(1L);
        member.setEmail("jaejun.lee.1991@gmail.com");

        Study study = new Study("jx2lee");

        lenient().when(memberService.findById(1L))
                .thenReturn(Optional.of(member));
        lenient().when(studyRepository.save(study)).thenReturn(study);
        studyService.createNewStudy(1L, study);

        Assertions.assertEquals(member.getName(), study.getOwner());

        InOrder inOrder = inOrder(memberService);
        inOrder.verify(memberService).notify(study);
        inOrder.verify(memberService).notify(member);

        // verifyNoMoreInteractions(memberService);
    }
}
