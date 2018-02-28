/**
 * 文件：MsgTypeEnum.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.enums
 * 日期：2016-1-28上午9:31:48
 * 描述：
 */
package com.xugc.weixin.enums;


 /**
 * 描述：微信普通消息推送的消息类型枚举 <br/>
 * 类名：MsgTypeEnum <br/>
 * 日期：2016-1-28 上午9:31:48 <br/>
 *
 * @author	徐国诚
 * @version 
 * @since JDK 1.6
 */
public enum MsgTypeEnum {
	
	/**
	 * 文本消息
	 * 
	 * @author 徐国诚
	 * @since JDK 1.6
	 */
	Text("text"),
	
	/**
	 * 图片消息
	 */
	Image("image"),
	
	/**
	 * 语音消息
	 */
	Voice("voice"),
	
	/**
	 * 视频消息
	 */
	Video("video"),
	
	/**
	 * 小视频消息
	 */
	ShortVideo("shortvideo"),
	
	/**
	 * 地理位置消息
	 */
	Location("location"),
	
	/**
	 * 链接消息
	 */
	Link("link"),
	
	/**
	 * 事件
	 */
	Event("event");
	
	private String value;
	
	private MsgTypeEnum(String value){
		this.value = value;
	}
	
	public String value(){
		return this.value;
	}
}
