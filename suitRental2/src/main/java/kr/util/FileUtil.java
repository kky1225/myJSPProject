package kr.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//���� ���ε� ����� �����ϱ� ���� cos.jar ������ �ʼ������� �䱸��
public class FileUtil {
	//���ڵ� Ÿ��
	public static final String ENCODING_TYPE = "utf-8";
	//�ִ� ���ε� ������
	public static final int MAX_SIZE=10*1024*1024;
	//���ε� ��� 
	public static final String UPLOAD_PATH = "/upload";
	
	//���� ���ε�
	public static MultipartRequest createFile(HttpServletRequest request)throws IOException{
		//���ε� ���� ���
		String upload = request.getServletContext().getRealPath(UPLOAD_PATH);
		return new MultipartRequest(request,upload,MAX_SIZE,ENCODING_TYPE,new DefaultFileRenamePolicy());
	}
	//���� ����
	public static void removeFile(HttpServletRequest request, String filename) {
		if(filename!=null) {
			//���ε� ���� ���
			String upload = request.getServletContext().getRealPath(UPLOAD_PATH);
			File file = new File(upload+"/"+filename);
			if(file.exists()) file.delete();
		}
	}
}










