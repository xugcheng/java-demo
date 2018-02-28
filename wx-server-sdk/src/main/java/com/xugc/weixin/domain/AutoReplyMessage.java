/**
 * 文件：ReplyMessage.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.domain
 * 日期：2016-1-28上午11:01:35
 * 描述：
 */
package com.xugc.weixin.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;


 /**
 * 描述：被动响应消息实体			  <br/>
 * 类名：ReplyMessage <br/>
 * 日期：2016-1-28 上午11:01:35 <br/>
 *
 * @author	徐国诚
 * @version 
 * @since JDK 1.6
 */
public class AutoReplyMessage {
	protected static final String CDATA_FORMAT = "<![CDATA[%s]]>";
	/**
	 * 接收方帐号（收到的OpenID）
	 */
	@XStreamAlias("ToUserName")
	private String toUserName;
	
	/**
	 * 开发者微信号
	 */
	@XStreamAlias("FromUserName")
	private String fromUserName;
	
	/**
	 * 消息创建时间
	 */
	@XStreamAlias("CreateTime")
	private Long createTime;
	
	/**
	 * 消息类型
	 */
	@XStreamAlias("MsgType")
	private String msgType;
	
	public String getMsgType() {
		return msgType;
	}
	protected void setMsgType(String msgType) {
		this.msgType = String.format(CDATA_FORMAT, msgType);
	}
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = String.format(CDATA_FORMAT, toUserName);
	}
	
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = String.format(CDATA_FORMAT, fromUserName);
	}
	
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	} 
	
}
