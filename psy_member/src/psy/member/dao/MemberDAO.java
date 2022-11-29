package psy.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import psy.member.dto.MemberDTO;
import psy.member.service.MemberService;

public class MemberDAO implements MemberService {

	@Override
	public ArrayList<MemberDTO> memberSelectAll(int page, int limit) {
		// 읽기 시작할 열 번호를 계산하고 페이지마다 출력될 행을 획득한다.
		int startrow = (page - 1) * 10 + 1;
		// 읽을 마지막 열 번호를 계산하고 페이지마다 출력될 행을 획득한다.
		int endrow = startrow + limit - 1;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			String sql = "select * from member ";
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MemberDTO memberInsert(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO memberUpdate(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO memberDelete(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO memberSelect(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
