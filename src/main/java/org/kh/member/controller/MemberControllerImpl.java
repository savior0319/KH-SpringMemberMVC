package org.kh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberControllerImpl implements MemberController {

	@Autowired
	@Qualifier(value = "memberService")
	private MemberServiceImpl memberService;

	@Override
	@RequestMapping(value = "/login.do")
	public String selectOneMember(HttpServletRequest request, @RequestParam String userId,
			@RequestParam String userPw) {

		// 1. 값 추출(request 어노테이션 방법)
		MemberVO mv = new MemberVO();
		mv.setUserId(userId);
		mv.setUserPw(userPw);

		// 2. 비즈니스 로직
		MemberVO m = memberService.selectOneMember(mv);

		// 로그인 세션
		HttpSession session = request.getSession();

		// 3. viewName 리턴
		// viewName을 처 할 때 주의할 점
		// viewName을 dispatcherServlet에게 돌려주고 자동으로
		// 처리 되도록 만들지만 DispatcherServlet에서는
		// 무조건 forward 방식을 사용함
		if (m != null) {
			session.setAttribute("member", m);
			// session.setAttribute("loc", "member/loginSuccess");
			return "member/loginSuccess";
		} else {
			// session.setAttribute("loc", "member/loginFailed");
			return "member/loginFailed";
		}
		// return "redirect;/location.do";
	}

	@Override
	@RequestMapping(value = "/enroll.do")
	public String insertMember() {
		return null;
	}

	@Override
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		MemberVO mv = (MemberVO) session.getAttribute("member");

		if (mv != null) {
			session.invalidate();
			return "member/logoutSuccess";
		} else {
			return "member/logutFail";
		}
	}

}
