package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;  // 이 DataSource 객체가 나타내는 물리적 데이터 소스에 대한 연결을 위한 팩토리입니다.
							  //DriverManager 기능의 대안인 DataSource 객체는 연결을 얻는 데 선호되는 수단입니다

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate; //JDBC 사용을 도와주는 템플릿
import org.springframework.jdbc.core.RowMapper; //행 단위로 ResultSet의 행을 매핑하기 위해 JdbcTemplate에서 사용하는 인터페이스입니다

import com.spring.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	private JdbcTemplate jdbcTemplate;
	
	
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<MemberVO> selectAllMembers() throws DataAccessException {
		System.out.println("여기는 DAO");
		String query = "select id,pwd,name,email,joinDate" + " from t_member " + " order by joinDate desc";
		
		 List<MemberVO> membersList= new ArrayList<MemberVO>();
		 
		 
		 membersList =this.jdbcTemplate.query(query, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("ResultSet : " + rs + "행번호 : " +  rowNum);
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getDate("joinDate"));
				
				return memberVO;
			}
			 
		 });
		return membersList;
	}

}
