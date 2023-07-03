package com.librarymanagement.librarymanagement.controller;

import com.librarymanagement.librarymanagement.dto.MemberDto;
import com.librarymanagement.librarymanagement.model.Member;
import com.librarymanagement.librarymanagement.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String listMember(Model model) {
        List<MemberDto> members = memberService.findByMember();
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

    @GetMapping("/members/{memberId}/edit")
     public String editClubForm(@PathVariable("memberId") Long memberId, Model model) {
         MemberDto member = memberService.findByMemberId(memberId);
         model.addAttribute("members", member);
         return "members-edit";
        }

     @PostMapping("/members/{memberId}/edit")
        public String updateMember(@PathVariable("memberId") Long memberId, @Valid @ModelAttribute("members") MemberDto member, BindingResult result) {
        if (result.hasErrors()) {
            return "members-edit";
        }
        member.setId(memberId);
        memberService.updateMember(member);
        return "redirect:/members";
     }

}
