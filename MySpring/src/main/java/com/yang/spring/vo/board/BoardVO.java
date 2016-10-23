/**
 * 
 */
package com.yang.spring.vo.board;

import java.util.Date;

/**
 * @author Yang Yi-hyun
 *
 */
public class BoardVO {

	private int seq;
	private String title;
	private String content;
	private int viewCnt;
	private String creator;
	private Date createDatetime;
	private String updater;
	private Date updateDatetime;
	private String delFlg;
	private int version;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Date getUpdateDatetime() {
		return updateDatetime;
	}
	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	public String getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		return "Board [seq=" + seq + ",title=" + title + ",content=" + content
		+ ",viewCnt=" + viewCnt + ",creator=" + creator + ",createDatetime=" + createDatetime
		+ ",updater=" + updater + ",delFlg=" + delFlg + ",version=" + version
		+ "]";
	}
}
