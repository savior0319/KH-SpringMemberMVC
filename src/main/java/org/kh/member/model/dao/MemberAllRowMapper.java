package org.kh.member.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.member.model.vo.MemberVO;
import org.springframework.jdbc.core.RowMapper;

public class MemberAllRowMapper implements RowMapper<Object> {

	@Override
	public ArrayList<MemberVO> mapRow(ResultSet rs, int rowNum) throws SQLException {
		ArrayList<MemberVO> aList = new ArrayList<MemberVO>();

		while (rs.next()) {
			MemberVO m = new MemberVO();
			m.setUserId(rs.getString("USER_ID"));
			m.setUserPw(rs.getString("USER_PWD"));
			m.setUserName(rs.getString("USER_NAME"));
			m.setPhone(rs.getString("USER_PHONE"));
			aList.add(m);
		}
		return aList;
	}

}
