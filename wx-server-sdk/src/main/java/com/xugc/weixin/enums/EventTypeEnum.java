/**
 * 文件：EventTypeEnum.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.enums
 * 日期：2016-1-28上午9:39:27
 * 描述：
 */
package com.xiu.enums;


 /**
 * 描述：微信事件推送的时间类型枚举.<br/>
 * 类名：EventTypeEnum <br/>
 * 日期：2016-1-28 上午9:39:27 <br/>
 *
 * @author	徐国诚
 * @version 
 * @since JDK 1.6
 */
public enum EventTypeEnum {

	/**
	 * 关注事件
	 */
	Subscribe("subscribe"),
	
	/**
	 * 取消关注事件
	 */
	UnSubscribe("unsubscribe"),
	
	/**
	 * 上报地理位置事件
	 */
	Location("LOCATION"),
	
	/**
	 * 点击自定义菜单拉取消息事件
	 */
	Click("CLICK"),
	
	/**
	 * 点击自定义菜单跳转链接事件
	 */
	View("VIEW"),
	
	/**
	 * 扫码事件推送
	 */
	SCAN("SCAN");
	
	private String value;
	
	private EventTypeEnum(String value){
		this.value = value;
	}
	
	public String value(){
		return this.value;
	}
}
