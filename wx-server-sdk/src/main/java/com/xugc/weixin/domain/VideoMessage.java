/**
 * 文件：VideoMessage.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.domain
 * 日期：2016-1-28上午11:09:26
 * 描述：
 */
package com.xugc.weixin.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xugc.weixin.enums.MsgTypeEnum;


/**
 * 描述：视频消息			  <br/>
 * 类名：VideoMessage <br/>
 * 日期：2016-1-28 上午11:09:26 <br/>
 *
 * @author	徐国诚
 * @version 
 * @since JDK 1.6
 */
@XStreamAlias("xml")
public class VideoMessage extends AutoReplyMessage {
	
	@XStreamAlias("Video")
	private Video video;
	
	public VideoMessage(){
		super.setMsgType(MsgTypeEnum.Video.value());
	}


	
	public Video getVideo() {
		return video;
	}
	


	public void setVideo(Video video) {
		this.video = video;
	}
	
	
}
