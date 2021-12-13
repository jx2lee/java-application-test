package com.jx2lee.mockito.study;

import com.jx2lee.mockito.domain.Member;
import com.jx2lee.mockito.domain.Study;
import com.jx2lee.mockito.member.MemberService;

import java.util.Optional;

public class StudyService {

    private final MemberService memberService;
    private final StudyRepository repository;

    public StudyService(MemberService memberService, StudyRepository repository) {

        assert memberService != null;
        assert repository != null;

        this.memberService = memberService;
        this.repository = repository;
    }

    public Study createNewStudy(Long memberId, Study study) {

        Optional<Member> member = memberService.findById(memberId);
        study.setOwner(member.orElseThrow(
                () -> new IllegalArgumentException("Member doesn't exist for id: '" + memberId)));
        Study savedStudy = repository.save(study);
        memberService.notify(savedStudy);
        memberService.notify(member.get());
        return repository.save(study);
    }

    public Study openStudy(Study study) {
        study.open();
        Study openedStudy = repository.save(study);
        memberService.notify(openedStudy);
        return openedStudy;
    }
}
