package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseOpsCategoryMedia<M extends BaseOpsCategoryMedia<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "ops_category_media";

	/**
	 * 自增Id
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	/**
	 * 自增Id
	 */
	public java.lang.Integer getId() {
		return get("id");
	}

	/**
	 * 基础分类ID
	 */
	public void setBizCatId(java.lang.Integer bizCatId) {
		set("biz_cat_id", bizCatId);
	}

	/**
	 * 基础分类ID
	 */
	public java.lang.Integer getBizCatId() {
		return get("biz_cat_id");
	}

	/**
	 * 媒体分类名称（别称，派生于基础分类名称）
	 */
	public void setMediaCatName(java.lang.String mediaCatName) {
		set("media_cat_name", mediaCatName);
	}

	/**
	 * 媒体分类名称（别称，派生于基础分类名称）
	 */
	public java.lang.String getMediaCatName() {
		return get("media_cat_name");
	}

	/**
	 * topic语义分类ID
	 */
	public void setTopicId(java.lang.Integer topicId) {
		set("topic_id", topicId);
	}

	/**
	 * topic语义分类ID
	 */
	public java.lang.Integer getTopicId() {
		return get("topic_id");
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}

	/**
	 * 创建时间
	 */
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	/**
	 * 更新时间
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}

	/**
	 * 更新时间
	 */
	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

}