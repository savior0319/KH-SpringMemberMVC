package org.kh.member.controller;

import javax.servlet.http.HttpServletRequest;

public interface MemberController {

	String insertMember();

	String selectOneMember(HttpServletRequest request, String userId, String userPw);

	String logout(HttpServletRequest request);
}
