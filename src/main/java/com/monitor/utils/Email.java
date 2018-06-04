package com.monitor.utils;

import java.io.File;
import java.util.List;
/**
 * 
 * @author liushahe
 * 
 */
public class Email {

	/**
	 * 收件人
	 */
    private List<String> toAddress = null;

    /**
     * 抄送人地址
     */
    private List<String> ccAddress = null;
    /**
     * 密送人
     */
    private List<String> bccAddress = null;

    /**
     * 附件路径信息
     */
    private List<File> files = null;
    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件编码
     */
    private String charset;
    
    /**
     * 邮件的文本内容
     */
    private String content;
    
	public List<String> getToAddress() {
		return toAddress;
	}
	public void setToAddress(List<String> toAddress) {
		this.toAddress = toAddress;
	}
	public List<String> getCcAddress() {
		return ccAddress;
	}
	public void setCcAddress(List<String> ccAddress) {
		this.ccAddress = ccAddress;
	}
	public List<String> getBccAddress() {
		return bccAddress;
	}
	public void setBccAddress(List<String> bccAddress) {
		this.bccAddress = bccAddress;
	}
	
	public List<File> getFiles() {
		return files;
	}
	public void setFiles(List<File> files) {
		this.files = files;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	
    
}
