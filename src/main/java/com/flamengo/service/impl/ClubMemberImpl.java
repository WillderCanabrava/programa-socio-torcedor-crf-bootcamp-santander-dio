package com.flamengo.service.impl;

import com.flamengo.domain.repository.ClubMemberRepository;
import com.flamengo.model.ClubMember;
import com.flamengo.service.ClubMemberService;

import java.util.NoSuchElementException;

public class ClubMemberImpl implements ClubMemberService {

   private final ClubMemberRepository clubMemberRepository;

    public ClubMemberImpl(ClubMemberRepository clubMemberRepository) {
        this.clubMemberRepository = clubMemberRepository;
    }

    @Override
    public ClubMember findById(Long id) {
        return clubMemberRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public ClubMember associate(ClubMember memberToAssociate) {
        if (clubMemberRepository.existsByMemberProfileRegistration(memberToAssociate.getMemberProfile().getRegistration())) {
            throw new IllegalArgumentException("This member profile registration already exists!");
        }
        return clubMemberRepository.save(memberToAssociate);
    }
}
