package com.monitor.controller.wechat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.monitor.utils.SHA1;

/**
 * signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
 * timestamp 时间戳 
 * nonce     随机数 
 * echostr   随机字符串
 * @author liushahe
 *@RequestParam(value="signature") String signature,@RequestParam(value="timestamp") String timestamp,@RequestParam(value="nonce") String nonce,@RequestParam(value="echostr") String echostr
 */
@Controller
@RequestMapping("/wechat")
public class WeChatServer {
	private static String Token = "mooc"; 
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	@ResponseBody
	public void authToken(HttpServletResponse response,HttpServletRequest req){
		System.out.println("获取微信请求");
	
		String signature=req.getParameter("signature");
		String timestamp=req.getParameter("timestamp");
		String nonce=req.getParameter("nonce");
		String echostr=req.getParameter("echostr");
		System.out.println(timestamp);
		System.out.println(nonce);
		System.out.println(echostr);
		List<String> params = new ArrayList<String>();    
        params.add(Token);    
        params.add(timestamp);    
        params.add(nonce);    
        //1. 将token、timestamp、nonce三个参数进行字典序排序    
        Collections.sort(params, new Comparator<String>() {    
            @Override    
            public int compare(String o1, String o2) {    
                return o1.compareTo(o2);    
            }    
        });   
        //2. 将三个参数字符串拼接成一个字符串进行sha1加密    
        String temp = SHA1.encode(params.get(0) + params.get(1) + params.get(2));    
        if (temp.equals(signature)) {    
            System.out.println("原:"+signature);  
            System.out.println("测试:"+temp);  
            System.out.println("匹配正确，传回微信了");  
            try {
				response.getWriter().write(echostr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
            System.out.println("传回微信成功");  
        }    
        else {    
       System.out.println("没有传回去数据，");  
    }   
   }  
 @RequestMapping(value = "/m", method = RequestMethod.GET)
 @ResponseBody
  public void getinfo(HttpServletResponse response){
	 System.out.println("mmmmm");
	 try {
		response.getWriter().write("qwqww");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
  }
		
}
	


