package org.kh.member.model.dao;

import java.util.List;

import org.kh.member.model.vo.MemberVO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	public MemberDAOImpl() {
	}

	@Override
	public MemberVO selectOneMember(JdbcTemplate jdbc, MemberVO mv) {

		String query = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?";

		// query 메소드는 인자값 2개 혹은 3개
		// 2개 -> query, RowMapper
		// 3개 -> query, query parameter, RowMapper
		// query : SQL 구문
		// RowMapper : 작동한 쿼리문에 대한 결과값을 처리하는것이 명시된 객체
		// query parameter : 쿼리문에 ? 가 있을 경우에 사용되는 인자 값

		// query parameter (Object 배열)
		Object[] params = { mv.getUserId(), mv.getUserPw() };

		List<Object> list = jdbc.query(query, params, new MemberRowMapper());

		if (!list.isEmpty()) {
			return (MemberVO) list.get(0);
		} else {
			return null;
		}

	}
}
