package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.NcsRegRequest;
import com.bitcamp.op.member.service.NcsRegService;

@Controller
@RequestMapping("/member/regView")
public class NcsRegController {

	@Autowired
	private NcsRegService regService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String regForm() {
		
		return "member/ncsRegForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String regView(
			@ModelAttribute("regReq") NcsRegRequest regReq,
			HttpServletRequest request,
			Model model
			) {			
		model.addAttribute("result", regService.regService(regReq, request));
		return "member/ncsRegView";
	}
	
}
