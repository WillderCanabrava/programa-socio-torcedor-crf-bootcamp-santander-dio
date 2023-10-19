package com.flamengo.service;

import com.flamengo.model.ClubMember;

public interface ClubMemberService {

    ClubMember findById(Long id);

    ClubMember associate(ClubMember memberToAssociate);
}
