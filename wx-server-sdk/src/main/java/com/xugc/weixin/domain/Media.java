/**
 * 文件：Image.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.domain
 * 日期：2016-1-28下午3:47:22
 * 描述：
 */
package com.xugc.weixin.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;


 /**
 * 描述：多媒体文件对象			  <br/>
 * 类名：Image <br/>
 * 日期：2016-1-28 下午3:47:22 <br/>
 *
 * @author	徐国诚
 * @version 
 * @since JDK 1.6
 */
public class Media extends AutoReplyMessage{
	
	/**
	 * 通过素材管理接口上传多媒体文件，得到的id
	 */
	@XStreamAlias("MediaId")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}
	
	public void setMediaId(String mediaId) {
		this.mediaId = String.format(CDATA_FORMAT, mediaId);
	}
}
