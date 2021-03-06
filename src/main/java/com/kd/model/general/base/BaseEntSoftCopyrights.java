package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseEntSoftCopyrights<M extends BaseEntSoftCopyrights<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "ent_soft_copyrights";

	/**
	 * 企业UUID
	 */
	public void setUuid(java.lang.String uuid) {
		set("uuid", uuid);
	}

	/**
	 * 企业UUID
	 */
	public java.lang.String getUuid() {
		return get("uuid");
	}

	/**
	 * 软件著作权名称
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}

	/**
	 * 软件著作权名称
	 */
	public java.lang.String getName() {
		return get("name");
	}

	/**
	 * 软件著作权登记号
	 */
	public void setNumber(java.lang.String number) {
		set("number", number);
	}

	/**
	 * 软件著作权登记号
	 */
	public java.lang.String getNumber() {
		return get("number");
	}

	/**
	 * 登记批准日期
	 */
	public void setAppDate(java.lang.String appDate) {
		set("app_date", appDate);
	}

	/**
	 * 登记批准日期
	 */
	public java.lang.String getAppDate() {
		return get("app_date");
	}

	/**
	 * 软件简称
	 */
	public void setShortName(java.lang.String shortName) {
		set("short_name", shortName);
	}

	/**
	 * 软件简称
	 */
	public java.lang.String getShortName() {
		return get("short_name");
	}

	/**
	 * 版本号
	 */
	public void setVersion(java.lang.String version) {
		set("version", version);
	}

	/**
	 * 版本号
	 */
	public java.lang.String getVersion() {
		return get("version");
	}

}
