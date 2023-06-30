package com.librarymanagement.librarymanagement.controller;

import com.librarymanagement.librarymanagement.dto.MemberDto;
import com.librarymanagement.librarymanagement.model.Member;
import com.librarymanagement.librarymanagement.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String listMember(Model model) {
        List<MemberDto> members = memberService.findByMemberId();
        model.addAttribute("members", members);
        return "members-list";
    }

    @GetMapping("/members/new")
    public String createMemberForm(Model model) {
        Member member = new Member();
        model.addAttribute("members", member);
        return "members-create";
    }

    @PostMapping("/members/new")
    public String saveMember(@ModelAttribute("members") Member member){
         memberService.saveMember(member);
        return "redirect:/members";
    }
}
