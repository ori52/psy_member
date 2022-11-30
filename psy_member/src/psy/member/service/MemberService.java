package psy.member.service;

import java.util.ArrayList;

import psy.member.dto.MemberDTO;

public interface MemberService {
	public ArrayList<MemberDTO> memberSelect();

	// MemberDTO 클래스 반환 자료형으로 특정 회원 데이터를 조회한다.
	public MemberDTO memberSelectdetail(MemberDTO memberDTO);

	// MemberDTO 반환 자료형으로 데이터를 입력한다.
	public MemberDTO memberInsert(MemberDTO memberDTO);

	// MemberDTO 클래스 반환 자료형으로 데이터를 수정한다.
	public MemberDTO memberUpdate(MemberDTO memberDTO);

	// MemberDTO 클래스 반환 자료형으로 데이터를 삭제한다.
	public MemberDTO memberDelete(MemberDTO memberDTO);

	//////////////////////////////////////////////////////////////////////////////////
	// MemberDTO 클래스 반환 자료형으로 로그인 데이터를 조회한다.
	public MemberDTO memberLogin(MemberDTO memberDTO);

}
