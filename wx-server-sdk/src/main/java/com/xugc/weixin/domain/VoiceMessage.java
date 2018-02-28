/**
 * 文件：VoiceMessage.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.domain
 * 日期：2016-1-28上午11:08:20
 * 描述：
 */
package com.xugc.weixin.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xugc.weixin.enums.MsgTypeEnum;


/**
 * 描述：语音消息 <br/>
 * 类名：VoiceMessage <br/>
 * 日期：2016-1-28 上午11:08:20 <br/>
 *
 * @author	徐国诚
 * @version 
 * @since JDK 1.6
 */
@XStreamAlias("xml")
public class VoiceMessage extends AutoReplyMessage {
	
	@XStreamAlias("Voice")
	private Media voice;

	public VoiceMessage(){
		super.setMsgType(MsgTypeEnum.Voice.value());
	}
	
	public Media getVoice() {
		return voice;
	}

	public void setVoice(Media voice) {
		this.voice = voice;
	}
	
}
