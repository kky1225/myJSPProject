package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.member.vo.MemberVO;
import kr.util.DBUtil;

// 2021-09-06 ����ȭ
public class MemberDAO {
	// �̱��� ����
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private MemberDAO() {}
	
	// ȸ�� ���� ����
	public void updateMember(MemberVO member) throws Exception{
		// ���� ���� : name,phone,email,zipcode,address1,address2,modify_date=SYSDATE
		// PK : mem_num
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ�
			conn = DBUtil.getConnection();
			// ���� ���� : name,phone,email,zipcode,address1,address2,modify_date=SYSDATE
			// SQL�� �ۼ�
			sql = "update xmember_detail set name=?,phone=?,email=?,zipcode=?,address1=?,address2=?,"
					+ "modify_date=SYSDATE where mem_num=?";
			// PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ?�� ������ ���ε�
			pstmt.setString(1,member.getName());
			pstmt.setString(2,member.getPhone());
			pstmt.setString(3,member.getEmail());
			pstmt.setString(4,member.getZipcode());
			pstmt.setString(5,member.getAddress1());
			pstmt.setString(6,member.getAddress2());
			pstmt.setInt(7, member.getMem_num());
			
			// SQL�� ����
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			// �ڿ� ����
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// ��й�ȣ ����
	public void updatePassword(String passwd, int mem_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ�
			conn = DBUtil.getConnection();
			
			// SQL�� �ۼ�
			sql = "update xmember_detail set passwd=? where mem_num=?";
			
			// PreparedStatement ��ü�� ����
			pstmt = conn.prepareStatement(sql);
			// ?�� ������ ���ε�
			pstmt.setString(1, passwd);	// �� ��й�ȣ
			pstmt.setInt(2, mem_num);	// ȸ����ȣ
			
			// SQL�� ����
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			throw new Exception(e);
		}finally {
			// �ڿ� ����
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// ȸ�� Ż��(ȸ�� ���� ����)
	public void deleteMember(int mem_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = null;
		
		try {
			// Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ� �Ҵ�
			conn = DBUtil.getConnection();
			// ����Ŀ�� ����
			conn.setAutoCommit(false);
			
			// SQL�� �ۼ� zmember�� auth �� ����
			sql = "update xmember set auth=0 where mem_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			pstmt.executeUpdate();
			
			// SQL�� �ۼ� zmember_detail�� ���ڵ� ����
			sql = "delete from xmember_detail where mem_num=?";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, mem_num);
			pstmt2.executeUpdate();
			
			// ��� SQL���� ������ ����
			conn.commit();
		}catch (Exception e) {
			// SQL ������ �ϳ��� �����ϸ� rollback;
			conn.rollback();
			throw new Exception(e);
		}finally {
			// �ڿ� ����
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	// �뿩 ��� ȣ��
	
	// �뿩 ���
	
	// �뿩 ���� ����
	
	// ȸ�� ���(auth) ���� -> �뿩����(2)�� �����ϴ� �޼ҵ�
	// 0���� �ٲٴ°� deleteMember(int mem_num)���� ����
	public void updateAuth(int mem_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			// Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ�
			conn = DBUtil.getConnection();
			// SQL�� �ۼ�
			sql = "update xmember set auth = 1 where mem_num=?";
			// PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ?�� ������ ���ε�
			pstmt.setInt(1, mem_num);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			// �ڿ� ����
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}





























