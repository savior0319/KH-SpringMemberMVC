package org.kh.member.model.service;

import javax.annotation.Resource;

import org.kh.member.model.dao.MemberDAOImpl;
import org.kh.member.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource(name = "memberDAO")
	private MemberDAOImpl memberDAO;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MemberServiceImpl() {
	}

	@Override
	public MemberVO selectOneMember(MemberVO mv) {
		MemberVO m = memberDAO.selectOneMember(jdbcTemplate, mv);
		return m;
	}


}
