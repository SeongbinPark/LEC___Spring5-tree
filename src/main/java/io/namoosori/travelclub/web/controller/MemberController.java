package io.namoosori.travelclub.web.controller;


import io.namoosori.travelclub.web.aggregate.club.CommunityMember;
import io.namoosori.travelclub.web.service.MemberService;
import io.namoosori.travelclub.web.service.sdo.MemberCdo;
import io.namoosori.travelclub.web.shared.NameValueList;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {//memberService 주입 받음.
        this.memberService = memberService;
    }

    @PostMapping
    public String register(@RequestBody MemberCdo memberCdo) {
        return memberService.registerMember(memberCdo);
    }

    @GetMapping("/{memberId}")
    public CommunityMember findById(@PathVariable String memberId) {
        return memberService.findMemberById(memberId);
    }

    @GetMapping
    public List<CommunityMember> findByName(@RequestParam String name) {
        return memberService.findMembersByName(name);
    }



    @PutMapping("/{memberId}")
    public void modify(@PathVariable String memberId,@RequestBody NameValueList nameValueList) {
        memberService.modifyMember(memberId, nameValueList);
    }

    @DeleteMapping("/{memberId}")
    public void remove(@PathVariable String memberId) {
        memberService.removeMember(memberId);
    }
}
