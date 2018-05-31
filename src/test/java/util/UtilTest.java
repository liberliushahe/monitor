package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.monitor.utils.Email;
import com.monitor.utils.MailUtil;
import com.monitor.utils.Utils;

public class UtilTest {

	public void sendEmailByQQTest1(){
        Email email=new Email();
        email.setCharset("UTF-8");
        email.setSubject("�ĵ�");
        List<String> list=new ArrayList<String>();
        list.add("18919927184@163.com");
        email.setToAddress(list);
        email.setContent("�ĵ�");
        File file=new File("D:/text.doc");
        File file1=new File("D:/text.pptx");
        System.out.println(file.exists());
        List<File> list1=new ArrayList<File>();
        list1.add(file);
        list1.add(file1);
        email.setFiles(list1);
        MailUtil.sendMail("smtp.163.com", "18919927184@163.com", "jjx748399", email);
             
	}
	@Test
	public void getUid(){
		String s=Utils.getUid();
		System.out.println(s);
	}
	
}
