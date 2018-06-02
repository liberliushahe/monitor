package com.monitor.utils;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * 发送邮件工具类
 * 
 * @author liushahe
 *
 */
public class MailUtil {
	static Properties props = new Properties();
	static Session session;
	static Message msg;
    /**
     * 解析地址
     * @param list
     * @return
     */
	private static InternetAddress[] getInternetAddress(List<String> list) {
		InternetAddress[] internetAddresses = new InternetAddress[list.size()];
		for (int i = 0; i < list.size(); i++) {
			String address = list.get(i);
			InternetAddress internetAddress = null;
			try {
				internetAddress = new InternetAddress(address);
			} catch (AddressException e) {
				e.printStackTrace();
			}
			internetAddresses[i] = internetAddress;
		}
		return internetAddresses;
	}
    /**
     * 发送邮件
     * @param host
     * @param username
     * @param password
     * @param email
     */
	public static void sendMail(String host, String username, String password, Email email) {
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");
		// 设置邮件服务器主机名
		props.setProperty("mail.host", host);
		// 开启ssl验证
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		// 设置环境信息
		session = Session.getInstance(props);
		// 创建邮件对象
		msg = new MimeMessage(session);
		Transport transport = null;
		try {

			// 设置收件人地址
			if (email.getToAddress() != null && !email.getToAddress().isEmpty()) {
				InternetAddress[] internetAddressTo = getInternetAddress(email.getToAddress());
				System.out.println(email.getToAddress().toString());
				msg.setRecipients(javax.mail.Message.RecipientType.TO, internetAddressTo);
			}
			// 设置抄送人地址
			if (email.getCcAddress() != null && !email.getCcAddress().isEmpty()) {

				InternetAddress[] internetAddressCc = getInternetAddress(email.getCcAddress());

				msg.setRecipients(javax.mail.Message.RecipientType.CC, internetAddressCc);
			}
			// 设置密送人地址
			if (email.getBccAddress() != null && !email.getBccAddress().isEmpty()) {

				InternetAddress[] internetAddressBcc = getInternetAddress(email.getBccAddress());

				msg.setRecipients(javax.mail.Message.RecipientType.BCC, internetAddressBcc);
			}

			// 设置邮件主题
			msg.setSubject(email.getSubject());
			// 设置邮件发送时间
			msg.setSentDate(new Date());
			// 设置发件人
			msg.setFrom(new InternetAddress(username, email.getSubject(), email.getCharset()));
			// 设置邮件内容和附件
			Multipart part = new MimeMultipart();
			// 设置邮件正文
			BodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setContent(email.getContent(), "text/html; charset = utf-8");
			part.addBodyPart(textBodyPart);
			// 设置附件 首先判断是否有附件
			if (email.getFiles()!= null && !email.getFiles().isEmpty()) {
				List<File> attachment = email.getFiles();
				Iterator<File> files = attachment.iterator();
				BodyPart attachmentBodyPart = null;
				while (files.hasNext()) {
					File file = files.next();
					attachmentBodyPart = new MimeBodyPart();
					DataSource source = new FileDataSource(file);
					DataHandler dataHandle = new DataHandler(source);
					attachmentBodyPart.setDataHandler(dataHandle);
					// MimeUtility.encodeWord可以避免文件名乱码
					attachmentBodyPart.setFileName(MimeUtility.encodeWord(file.getName()));
					part.addBodyPart(attachmentBodyPart);
				}
			}

			msg.setContent(part);
			// 保存邮件
			 msg.saveChanges();
			transport = session.getTransport();
			// 连接邮件服务器
			transport.connect(username, password);
			// 发送邮件
			transport.sendMessage(msg, msg.getAllRecipients());
			System.out.println("email send success!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (transport != null) {
				try {
					transport.close();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}