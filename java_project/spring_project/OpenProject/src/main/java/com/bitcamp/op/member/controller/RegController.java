package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.domain.Member;

@Controller
@RequestMapping("/member/regView")
public class RegController {

	@RequestMapping(method = RequestMethod.GET)
	public String regForm() {
		
		return "member/regForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String regView(
			
			@RequestParam("memberid") String memberid,
			@RequestParam("password") String password,
			@RequestParam("membername") String membername,
			@RequestParam("memberphoto") String memberphoto,
			HttpServletRequest request,
			@ModelAttribute ("regRequest") Member regRequest,
			Model model
			
			) {
		
			model.addAttribute("memberid", memberid);
			model.addAttribute("password", password);
			model.addAttribute("membername", membername);
			model.addAttribute("memberphoto", memberphoto);
		
			
			model.addAttribute("memberId", request.getParameter("memberid"));
		
		return "member/regView";
	}
	
}
