package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseRdsEntHolder<M extends BaseRdsEntHolder<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "rds_ent_holder";

	/**
	 * 企业编码
	 */
	public void setUuid(java.lang.String uuid) {
		set("uuid", uuid);
	}

	/**
	 * 企业编码
	 */
	public java.lang.String getUuid() {
		return get("uuid");
	}

	/**
	 * 企业股东信息（企业名称、股东类型、实缴出资情况、应缴出资情况）
	 */
	public void setRecord(java.lang.String record) {
		set("record", record);
	}

	/**
	 * 企业股东信息（企业名称、股东类型、实缴出资情况、应缴出资情况）
	 */
	public java.lang.String getRecord() {
		return get("record");
	}

}
