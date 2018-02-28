/**
 * 文件：Video.java
 * 系统：WECARE-WEIXIN-WEB
 * 版权：Copyright (c) 2016, All Rights Reserved.
 * 包名：com.wecare.weixin.domain
 * 日期：2016-1-28下午4:03:07
 * 描述：
 */
package com.xugc.weixin.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;


 /**
 * 描述：多媒体-视频类 <br/>
 * 类名：Video <br/>
 * 日期：2016-1-28 下午4:03:07 <br/>
 *
 * @author	徐国诚
 * @version 
 * @since JDK 1.6
 */
public class Video extends Media{
	
	/**
	 * 视频消息的标题
	 */
	@XStreamAlias("Title")
	private String title;
	
	/**
	 * 视频消息的描述
	 */
	@XStreamAlias("Description")
	private String description;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = String.format(CDATA_FORMAT, title);
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = String.format(CDATA_FORMAT, description);
	}
}
