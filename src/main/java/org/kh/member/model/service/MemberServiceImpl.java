package org.kh.member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.kh.member.model.dao.MemberDAOImpl;
import org.kh.member.model.vo.MemberVO;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource(name = "memberDAO")
	private MemberDAOImpl memberDAO;

	public MemberServiceImpl() {
	}

	@Override
	public MemberVO selectOneMember(MemberVO mv) {
		Connection conn = getConnection();
		MemberVO m = memberDAO.selectOneMember(conn, mv);
		try {
			conn.close();
		} catch (Exception e) {

		}
		return m;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SPRING", "SPRING");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
