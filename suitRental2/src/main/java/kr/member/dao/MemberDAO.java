package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.member.vo.MemberVO;
import kr.util.DBUtil;

// 2021-09-06 서준화
public class MemberDAO {
	// 싱글톤 패턴
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private MemberDAO() {}
	
	// 회원 정보 수정
	public void updateMember(MemberVO member) throws Exception{
		// 수정 가능 : name,phone,email,zipcode,address1,address2,modify_date=SYSDATE
		// PK : mem_num
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			// 수정 가능 : name,phone,email,zipcode,address1,address2,modify_date=SYSDATE
			// SQL문 작성
			sql = "update xmember_detail set name=?,phone=?,email=?,zipcode=?,address1=?,address2=?,"
					+ "modify_date=SYSDATE where mem_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setString(1,member.getName());
			pstmt.setString(2,member.getPhone());
			pstmt.setString(3,member.getEmail());
			pstmt.setString(4,member.getZipcode());
			pstmt.setString(5,member.getAddress1());
			pstmt.setString(6,member.getAddress2());
			pstmt.setInt(7, member.getMem_num());
			
			// SQL문 실행
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 비밀번호 수정
	public void updatePassword(String passwd, int mem_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			
			// SQL문 작성
			sql = "update xmember_detail set passwd=? where mem_num=?";
			
			// PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setString(1, passwd);	// 새 비밀번호
			pstmt.setInt(2, mem_num);	// 회원번호
			
			// SQL문 실행
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			throw new Exception(e);
		}finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 회원 탈퇴(회원 정보 삭제)
	public void deleteMember(int mem_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = null;
		
		try {
			// 커넥션풀로부터 커넥션 할당
			conn = DBUtil.getConnection();
			// 오토커밋 해제
			conn.setAutoCommit(false);
			
			// SQL문 작성 zmember의 auth 값 변경
			sql = "update xmember set auth=0 where mem_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			pstmt.executeUpdate();
			
			// SQL문 작성 zmember_detail의 레코드 삭제
			sql = "delete from xmember_detail where mem_num=?";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, mem_num);
			pstmt2.executeUpdate();
			
			// 모든 SQL문의 실행이 성공
			conn.commit();
		}catch (Exception e) {
			// SQL 문장이 하나라도 실패하면 rollback;
			conn.rollback();
			throw new Exception(e);
		}finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// 대여 목록 호출
	
	// 대여 취소
	
	// 대여 정보 변경
	
	// 회원 등급(auth) 변경 -> 대여금지(2)로 변경하는 메소드 0
	// 0으로 바꾸는건 deleteMember(int mem_num)에서 실행
	public void updateAuth(int mem_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// 커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "update xmember set auth = 1 where mem_num=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setInt(1, mem_num);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			// 자원 정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}





























