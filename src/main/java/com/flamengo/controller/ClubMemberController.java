package com.flamengo.controller;


import com.flamengo.model.ClubMember;
import com.flamengo.service.ClubMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clubmembers")
public class ClubMemberController {

    private final ClubMemberService clubMemberService;

    public ClubMemberController(ClubMemberService clubMemberService) {
        this.clubMemberService = clubMemberService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubMember> findById(@PathVariable Long id) {
        var clubMember = clubMemberService.findById(id);
        return ResponseEntity.ok(clubMember);
    }

    @PostMapping
    public ResponseEntity<ClubMember> associate(@RequestBody ClubMember clubMemberToAssociate) {
        var newClubMember = clubMemberService.associate(clubMemberToAssociate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newClubMember.getId()).toUri();
        return ResponseEntity.created(location).body(newClubMember);
    }
}
