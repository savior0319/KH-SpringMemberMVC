package org.kh.member.model.dao;

import org.kh.member.model.vo.MemberVO;
import org.springframework.jdbc.core.JdbcTemplate;

public interface MemberDAO {


	MemberVO selectOneMember(JdbcTemplate jdbc, MemberVO mv);


}
