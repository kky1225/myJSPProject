/*
package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDAO;
import kr.member.vo.MemberVO;

public class ModifyPasswordAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ȸ���� ����
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num == null) {	// �α����� �ȵ� ���
			return "redirect:/member/loginForm.do";
		}
		// ���۵� ������ ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		// ���۵� ������ ��ȯ
		String id = request.getParameter("id");
		String origin_passwd = request.getParameter("origin_passwd");	// �����й�ȣ
		String passwd = request.getParameter("passwd");					// �� ��й�ȣ
				
		// ���� �α��� �� ���̵�
		String user_id = (String)session.getAttribute("user_id");
					
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO member = dao.checkMember(id);
		boolean check = false;
				
		//����ڰ� �Է��� ID�� �����ϰ� �α��� �� ���̵�� ��ġ�ϴ��� üũ 
		if(member != null && id.equals(user_id)) {
			// ��й�ȣ ��ġ ���� üũ
			check = member.isCheckedPassword(origin_passwd);
		}
				
		if(check) {	// ���� ����
			// ��й�ȣ ����
			dao.updatePassword(passwd, user_num);
		}
				
		request.setAttribute("check", check);
				
		return "/WEB-INF/views/member/modifyPassword.jsp";
		
	}

}
*/