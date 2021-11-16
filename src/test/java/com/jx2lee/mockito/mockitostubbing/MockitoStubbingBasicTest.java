package com.jx2lee.mockito.mockitostubbing;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoStubbingBasicTest {
    @Test
    @DisplayName("원하는_값으로_return_하기_위해_stubbing_을_수행한다")
    void 원하는_값으로_return_하기_위해_stubbing_을_수행한다(
            @Mock MemberService memberService,
            @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setMemberId(1L);
        member.setEmail("jaejun.lee.1991@gmail.com");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        Optional<Member> findById = memberService.findById(1L);
        assertEquals("jaejun.lee.1991@gmail.com", findById.get().getEmail());
    }

    @Test
    @DisplayName("argument_matcher_를_통해_어떤_id_값이_들어와도_상관없이_객체를_생성한다")
    void argument_matcher_를_통해_어떤_id_값이_들어와도_상관없이_객체를_생성한다(
            @Mock MemberService memberService,
            @Mock StudyRepository studyRepository) {

        /**
         * 참고: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#3
         * */

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setMemberId(1L);
        member.setEmail("jaejun.lee.1991@gmail.com");

        when(memberService.findById(any())).thenReturn(Optional.of(member));

        assertEquals("jaejun.lee.1991@gmail.com", memberService.findById(1L).get().getEmail());
        assertEquals("jaejun.lee.1991@gmail.com", memberService.findById(2L).get().getEmail());
    }

    @Test
    @DisplayName("특정조건_일_경우_에러를_발생한다_thenThrow")
    void 특정조건_일_경우_에러를_발생한다_thenThrow(
            @Mock MemberService memberService,
            @Mock StudyRepository studyRepository) {

        /**
         * 참고: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#5
         */
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setMemberId(2L);
        member.setEmail("jaejun.lee.1991@gmail.com");

        when(memberService.findById(1L)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> memberService.findById(1L));
    }

    @Test
    @DisplayName("특정조건_일_경우_에러를_발생한다_doThrow")
    void 특정조건_일_경우_에러를_발생한다_doThrow(
            @Mock MemberService memberService,
            @Mock StudyRepository studyRepository) {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setMemberId(1L);
        member.setEmail("jaejun.lee.1991@gmail.com");

        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);

        assertThrows(IllegalArgumentException.class, () -> memberService.validate(1L));
        memberService.validate(2L);
    }

    @Test
    @DisplayName("동일한_메서드를_호출할_때마다_다르게_설정할_수_있다")
    void 동일한_메서드를_호출할_때마다_다르게_설정할_수_있다(
            @Mock MemberService memberService,
            @Mock StudyRepository studyRepository) {

        /**
         * https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#10
         */

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setMemberId(1L);
        member.setEmail("jaejun.lee.1991@gmail.com");

        when(memberService.findById(any()))
                .thenReturn(Optional.of(member))
                .thenThrow(new RuntimeException())
                .thenReturn(Optional.empty());

        assertEquals("jaejun.lee.1991@gmail.com", memberService.findById(1L).get().getEmail());
        assertThrows(RuntimeException.class, () -> memberService.findById(2L));
        assertEquals(Optional.empty(), memberService.findById(3L));
    }
}
