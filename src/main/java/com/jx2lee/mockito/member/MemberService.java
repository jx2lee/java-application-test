package com.jx2lee.mockito.member;

import com.jx2lee.mockito.domain.Member;
import com.jx2lee.mockito.domain.Study;

import java.util.Optional;

public interface MemberService {
    void validate(Long MemberId);

    Optional<Member> findById(Long MemberId);

    void notify(Study study);

    void notify(Member member);
}
