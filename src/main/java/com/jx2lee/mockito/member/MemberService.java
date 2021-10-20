package com.jx2lee.mockito.member;

import com.jx2lee.mockito.domain.Member;

import java.util.Optional;

public interface MemberService {
    void validate(Long MemberId) throws InvalidMemberException;

    Optional<Member> findById(Long MemberId);
}
