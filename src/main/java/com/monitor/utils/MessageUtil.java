package com.monitor.utils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationContext;
import com.monitor.dto.wechat.Message;
import com.monitor.dto.wechat.TextMessage;
import com.thoughtworks.xstream.XStream;



public class MessageUtil {
	/**
	 * 返回文本类型
	 */
	public static final String RESP_TYPE_TEXT="text";
	/**
	 * 返回音乐类型
	 */
	public static final String RESP_TYPE_MUSIC="music";
	/**
	 * 返回图片类型
	 */
	public static final String RESP_TYPE_IMAGE="image";
	/**
	 * 返回图文类型
	 */
	public static final String RESP_TYPE_NEWS="news";
	/**
	 * 返回连接类型
	 */
	public static final String RESP_TYPE_LINK="link";
	/**
	 * 返回位置类型
	 */
	public static final String RESP_TYPE_LOCATION="location";
	/**
	 * 返回音频类型
	 */
	public static final String RESP_TYPE_VOICE="voice";
	/**
	 * 返回视频类型
	 */
	public static final String RESP_TYPE_VIDEO="video";
	/**
	 * 返回视频类型
	 */
	public static final String RESP_TYPE_SHORTVIDEO="shortvideo";
	
	/**
	 * 返回推送类型
	 */
	public static final String RESP_TYPE_EVENT="event";
	/**
	* 事件类型：subscribe(订阅)
	*/
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";


	/**
	* 事件类型：unsubscribe(取消订阅)
	*/
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";


	/**
	* 事件类型：CLICK(自定义菜单点击事件)
	*/
	public static final String EVENT_TYPE_CLICK = "CLICK";
	/**
	* 事件类型：VIEW(自定义菜单URl视图)
	*/
	public static final String EVENT_TYPE_VIEW = "VIEW";


	/**
	* 事件类型：LOCATION(上报地理位置事件)
	*/
	public static final String EVENT_TYPE_LOCATION = "LOCATION";
    
	/**
	 * 解析发送消息
	 * @param req
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public static Map<String,String> parseXML(HttpServletRequest req) throws IOException, DocumentException{
		Map<String,String> map=new HashMap<String,String>();
	    ServletInputStream in=req.getInputStream();
	    SAXReader reader = new SAXReader();
	    Document document = reader.read(in);
	    Element root = document.getRootElement();
	    @SuppressWarnings("unchecked")
		List<Element> elementList = root.elements();
	    for (Element e : elementList){
	    	 map.put(e.getName(), e.getText());
	    }
	    in.close();
	    return map;
		
	}
	/**
	 * 转换对象为XML
	 * @param message
	 * @return
	 */
	public static String MessageToXml(Message message) {
		ApplicationContext app=	ApplicationContextUtil.getApplicationContext();	
	   XStream xs=(XStream)app.getBean("xs");
	   xs.alias("xml", message.getClass());	  
	   return  xs.toXML(message);
	}
	/**
	 * 根据用户传入的响应类型返回相应的消息类型
	 * @param type
	 * @param map
	 * @return
	 */
	public static Message RespMessageType(String type,Map<String,String> map){
		 ApplicationContext app=	ApplicationContextUtil.getApplicationContext();	
		 	TextMessage tx=(TextMessage) app.getBean("tx");
		    if(type.equals(MessageUtil.RESP_TYPE_TEXT)){
		    //获取文本消息对象
		 	tx.setFromUserName(map.get("ToUserName"));
		 	tx.setToUserName(map.get("FromUserName"));
		 	tx.setCreateTime(new Date().getTime());
		 	if(map.get("Content").equals("1")){
		 		tx.setContent("hello world ");
		 	}else{
		 		tx.setContent("hello world my world");
		 	}
		 
		 	tx.setMsgType(MessageUtil.RESP_TYPE_TEXT);
		 	
		     
		    }
		    return tx;
		
	}
	/**
	 * 将用户发送数据转发到接口，由接口负责响应数据
	 * 图灵机器人接口
	 * @param map
	 * @return
	 */
	public static Message respFromInterface(Map<String,String> map){
		return null;
		
	}
}
