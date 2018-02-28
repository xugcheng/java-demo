/**
 * 文件：TextMessage.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.domain
 * 日期：2016-1-28上午11:06:09
 * 描述：
 */
package com.xugc.weixin.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xugc.weixin.enums.MsgTypeEnum;


/**
 * 描述：文本消息<br/>
 * 类名：TextMessage <br/>
 * 日期：2016-1-28 上午11:06:09 <br/>
 *
 * @author	徐国诚
 * @version 
 * @since JDK 1.6
 */
@XStreamAlias("xml")
public class TextMessage extends AutoReplyMessage {
	
	/**
	 * 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	 */
	@XStreamAlias("Content")
	private String content;
	
	public TextMessage(){
		super.setMsgType(MsgTypeEnum.Text.value());
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = String.format(CDATA_FORMAT, content);
	}
	
}
