/**
 * 文件：ImageMessage.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.domain
 * 日期：2016-1-28上午11:07:16
 * 描述：
 */
package com.xugc.weixin.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xugc.weixin.enums.MsgTypeEnum;


/**
 * 描述：图片消息			  <br/>
 * 类名：ImageMessage <br/>
 * 日期：2016-1-28 上午11:07:16 <br/>
 *
 * @author	徐国诚
 * @version 
 * @since JDK 1.6
 */
@XStreamAlias("xml")
public class ImageMessage extends AutoReplyMessage {
	
	@XStreamAlias("Image")
	private Media image;
	
	public ImageMessage(){
		super.setMsgType(MsgTypeEnum.Image.value());
	}

	
	public Media getImage() {
		return image;
	}
	

	public void setImage(Media image) {
		this.image = image;
	}
	
	
}
