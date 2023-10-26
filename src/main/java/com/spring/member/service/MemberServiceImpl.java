package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl implements  MemberService{

	private MemberDAO memberDAO;
	
	
	
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}




	@Override
	public List<MemberVO> listMembers() throws DataAccessException {
		System.out.println("여기는 서비스");
		List<MemberVO> membersList=memberDAO.selectAllMembers();
		return membersList;
	}

}
