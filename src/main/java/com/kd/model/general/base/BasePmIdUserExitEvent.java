package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePmIdUserExitEvent<M extends BasePmIdUserExitEvent<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "pm_id_user_exit_event";

	/**
	 * 自增ID
	 */
	public void setEventId(java.lang.Integer eventId) {
		set("event_id", eventId);
	}

	/**
	 * 自增ID
	 */
	public java.lang.Integer getEventId() {
		return get("event_id");
	}

	/**
	 * 管理人ID (关联 ops_rdd.ops_org_user_info)
	 */
	public void setUserId(java.lang.Integer userId) {
		set("user_id", userId);
	}

	/**
	 * 管理人ID (关联 ops_rdd.ops_org_user_info)
	 */
	public java.lang.Integer getUserId() {
		return get("user_id");
	}

}
