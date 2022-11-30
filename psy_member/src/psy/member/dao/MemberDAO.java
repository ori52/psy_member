package psy.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import psy.member.dto.MemberDTO;
import psy.member.service.MemberService;

public class MemberDAO implements MemberService {
	private static final Log log = LogFactory.getLog(MemberDAO.class);

	@Override
	public ArrayList<MemberDTO> memberSelect() {
		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			String sql = "select id, password, name, gender, to_char(birth, 'yyyy-mm-dd')birth, nickname, introduce from member ";
			sql += "where id = ?";
			log.info("전체 조회 sql 확인 : " + sql);

			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				MemberDTO memberDTO = new MemberDTO();

				memberDTO.setId(resultSet.getString("id"));
				memberDTO.setPassword(resultSet.getString("password"));
				memberDTO.setName(resultSet.getString("name"));
				memberDTO.setGender(resultSet.getString("gender"));
				memberDTO.setBirth(resultSet.getString("birth"));
				memberDTO.setNickname(resultSet.getString("nickname"));
				memberDTO.setIntroduce(resultSet.getString("introduce"));
				log.info("멤버 조회 데이터 확인 : " + memberDTO);

				if (resultSet.getRow() == 0) {
					log.info("등록된 회원이 없습니다.");
				}
			}
		} catch (Exception e) {
			log.info("전체 회원 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	@Override
	public MemberDTO memberSelectdetail(MemberDTO memberDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			String sql = "select id, password, name, gender, to_char(birth, 'yyyy-mm-dd')birth, nickname, introduce from member ";
			sql += "where id = ?";
			log.info("개별 조회 sql 확인 : " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				memberDTO.setId(resultSet.getString("id"));
				memberDTO.setPassword(resultSet.getString("password"));
				memberDTO.setName(resultSet.getString("name"));
				memberDTO.setGender(resultSet.getString("gender"));
				memberDTO.setBirth(resultSet.getString("birth"));
				memberDTO.setNickname(resultSet.getString("nickname"));
				memberDTO.setIntroduce(resultSet.getString("introduce"));
				log.info("개별 회원 조회 데이터 확인 : " + memberDTO);
			}
		} catch (Exception e) {
			log.info("개별 회원 조회 실패 : " + e);

		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

	@Override
	public MemberDTO memberInsert(MemberDTO memberDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "insert into member(id, password, name, gender, bitrh, nickname, introduce) ";
			sql += "values (?, ?, ?, ?, to_date(?, 'yyyy-mm-dd'), ?, ?)";
			log.info("회원 등록 sql 확인 : " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			preparedStatement.setString(2, memberDTO.getPassword());
			preparedStatement.setString(3, memberDTO.getName());
			preparedStatement.setString(4, memberDTO.getGender());
			preparedStatement.setString(5, memberDTO.getBirth());
			preparedStatement.setString(6, memberDTO.getNickname());
			preparedStatement.setString(7, memberDTO.getIntroduce());
			int count = preparedStatement.executeUpdate();
			log.info("입력 데이터 확인 : " + memberDTO);

			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("회원 가입 실패 : " + e);
		}
		return memberDTO;
	}

	@Override
	public MemberDTO memberUpdate(MemberDTO memberDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		log.info("업데이트 정보 : " + memberDTO);

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			String sql = "update member set id=?, password=?, name=?, gender=?, birth=to_date(?, 'yyyy-mm-dd'), nickname=?, introduce=? ";
			sql += "where id=?";
			log.info("업데이트 sql 확인 : " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			preparedStatement.setString(2, memberDTO.getPassword());
			preparedStatement.setString(3, memberDTO.getName());
			preparedStatement.setString(4, memberDTO.getGender());
			preparedStatement.setString(5, memberDTO.getBirth());
			preparedStatement.setString(6, memberDTO.getNickname());
			preparedStatement.setString(7, memberDTO.getIntroduce());
			int count = preparedStatement.executeUpdate();
			log.info("수정 데이터 확인 : " + memberDTO);

			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("회원 정보 수정 실패 - " + e);
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

	@Override
	public MemberDTO memberDelete(MemberDTO memberDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "delete from member ";
			sql += " where id = ? ";
			log.info("회원 삭제 sql : " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("회원 삭제 실패 - " + e);
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Context context;
		try {
			context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select * from member ";
			sql += "where id=?";
			log.info("회원 로그인 sql : " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getId());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				memberDTO.setId(resultSet.getString("id"));
				log.info("아이디 확인 - " + resultSet.getString("id"));

				if (resultSet.getString("password").equals(memberDTO.getPassword())) {
					memberDTO.setPassword(resultSet.getString("password"));
					log.info("비밀번호 확인 - " + resultSet.getString("password"));
				} else {
					memberDTO.setPassword("");
				}
			} else {
				memberDTO.setId("");
			}
		} catch (Exception e) {
			log.info("로그인 실패 - " + e);

		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

}
