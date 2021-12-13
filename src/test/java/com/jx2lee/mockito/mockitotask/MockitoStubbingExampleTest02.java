package com.jx2lee.mockito.mockitotask;

import com.jx2lee.mockito.domain.Study;
import com.jx2lee.mockito.member.MemberService;
import com.jx2lee.mockito.study.StudyRepository;
import com.jx2lee.mockito.study.StudyService;
import com.jx2lee.mockito.study.StudyStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class MockitoStubbingExampleTest02 {

    @DisplayName("다른 사용자가 볼 수 있도록 스터디를 공개한다.")
    @Test
    void openStudy(@Mock MemberService memberService,
                   @Mock StudyRepository studyRepository) {
        // Given
        StudyService studyService = new StudyService(memberService,
                studyRepository);
        Study study = new Study("더 자바, 테스트");

        // TODO studyRepository Mock 객체의 save 메소드를호출 시 study를 리턴하도록 만들기.
        given(studyRepository.save(study)).willReturn(study);

        // When
        studyService.openStudy(study);

        // Then
        // TODO study의 status가 OPENED로 변경됐는지 확인
        // TODO study의 openedDataTime이 null이 아닌지 확인
        // TODO memberService의 notify(study)가 호출 됐는지 확인.
        then(study.getStatus()).equals(StudyStatus.OPENED);
        then(memberService).should(times(1)).notify(study);
        Assertions.assertNotNull(study.getOpenDateTime());
        Assertions.assertEquals(StudyStatus.OPENED, study.getStatus()); // then 첫번째 라인과 동일
    }
}
