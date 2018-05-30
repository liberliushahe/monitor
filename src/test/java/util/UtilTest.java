package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import com.monitor.utils.Email;
import com.monitor.utils.MailUtil;

public class UtilTest {

	public void sendEmailByQQTest1(){
        Email email=new Email();
        email.setCharset("UTF-8");
        email.setSubject("ÎÄµµ");
        List<String> list=new ArrayList<String>();
        list.add("18919927184@163.com");
        email.setToAddress(list);
        email.setContent("ÎÄµµ");
        File file=new File("D:/text.doc");
        File file1=new File("D:/text.pptx");
        System.out.println(file.exists());
        List<File> list1=new ArrayList<File>();
        list1.add(file);
        list1.add(file1);
        email.setFiles(list1);
        MailUtil.sendMail("smtp.163.com", "18919927184@163.com", "jjx748399", email);
             
	}
	
	
}
