package org.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.kh.member.model.vo.MemberVO;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public MemberDAOImpl() {
	}

	@Override
	public MemberVO selectOneMember(Connection conn, MemberVO mv) {

		MemberVO m = null;

		String query = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mv.getUserId());
			pstmt.setString(2, mv.getUserPw());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				m = new MemberVO();
				m.setUserId(rs.getString("USER_ID"));
				m.setUserPw(rs.getString("USER_PWD"));
				m.setUserName(rs.getString("USER_NAME"));
				m.setPhone(rs.getString("USER_PHONE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
}
