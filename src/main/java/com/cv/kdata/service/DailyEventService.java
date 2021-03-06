package com.cv.kdata.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cv.kdata.cont.RDDWebConst;
import com.cv.kdata.model.PMExitEvent;
import com.cv.kdata.model.PMInvestEvent;
import com.cv.kdata.response.DailyEventResponse;
import com.cv.kdata.util.BeanConverter;
import com.cv.kdata.util.MysqlHelper;
import com.cv.kdata.util.MysqlHelper75;
import com.cv.kdata.util.StringUtil;
import com.kdata.defined.model.DailyEventGeneralObject;


@Service
public class DailyEventService {

	private static final Logger logger = LoggerFactory.getLogger(DailyEventService.class);

	public void getDailyInvestEvent(DailyEventResponse response) {

//		String date = TimeUtil.getCurrentTime("yyyy-MM-dd");
		String date = "2017-08-10";

		List<DailyEventGeneralObject> objectList = new ArrayList<>();
		List<Object> para = new ArrayList<>();
		para.add(date);

		String sql = "select event_id, event_title, create_time, event_desc, ent_cn_name,invest_type as event_type, 'invest' as event from ops_invest_event_detail where create_time > ? group by event_title order by create_time desc";

		if (response.getTotal() > 0) {
			sql = sql + " limit ?,?";
			para.add(response.getFrom());
			para.add(response.getTotal());
		}

		ResultSet rs = null;
		try {

			rs = MysqlHelper75.getInstance(RDDWebConst.ops_rdd).executeQuery(sql, para);

			while (rs.next()) {
				DailyEventGeneralObject record = (DailyEventGeneralObject) BeanConverter.convert(rs,
						DailyEventGeneralObject.class);
				if (record != null) {
					record.setEventClass("invest");
					objectList.add(record);
				}
			}
			response.addEventList(objectList);
		} catch (Exception e) {
			logger.error(e.toString());
		}finally{
			MysqlHelper75.getInstance(RDDWebConst.ops_rdd).close(rs);
		}
	}

	public void getDailyExitEvent(DailyEventResponse response) {

//		String date = TimeUtil.getCurrentTime("yyyy-MM-dd");
		String date = "2017-08-10";

		List<DailyEventGeneralObject> objectList = new ArrayList<>();
		List<Object> para = new ArrayList<>();
		para.add(date);

		String sql = "select event_id, event_title, create_time, event_desc, ent_cn_name,exit_type as event_type,'exit' as event from ops_exit_event_detail where create_time > ? group by event_title order by create_time desc";

		if (response.getTotal() > 0) {
			sql = sql + " limit ?,?";
			para.add(response.getFrom());
			para.add(response.getTotal());
		}

		ResultSet rs = null;
		try {

			rs = MysqlHelper75.getInstance(RDDWebConst.ops_rdd).executeQuery(sql, para);

			while (rs.next()) {
				DailyEventGeneralObject record = (DailyEventGeneralObject) BeanConverter.convert(rs,
						DailyEventGeneralObject.class);
				if (record != null) {
					record.setEventClass("exit");
					objectList.add(record);
				}
			}
			response.addEventList(objectList);
		} catch (Exception e) {
			logger.error(e.toString());
		}finally{
			MysqlHelper75.getInstance(RDDWebConst.ops_rdd).close(rs);
		}
	}


	public void getDailyEventDetail(String event, String type, DailyEventResponse response) {

		if (StringUtil.isNullOrEmpty(event)) {
			return;
		}

		List<DailyEventGeneralObject> objectList = new ArrayList<>();
		List<Object> para = new ArrayList<>();
		para.add(event);

		String sql = "select * from daily_event_75 where event_title = ? order by happen_date desc";

		ResultSet rs = null;
		try {

			rs = MysqlHelper.getInstance(RDDWebConst.PESEER_DB_ONLINE).executeQuery(sql, para);

			while (rs.next()) {
				DailyEventGeneralObject record = (DailyEventGeneralObject) BeanConverter.convert(rs,
						DailyEventGeneralObject.class);
				if (record != null) {
					objectList.add(record);
				}
			}
			response.addEventList(objectList);
		} catch (Exception e) {
			logger.error(e.toString());
		}finally{
			MysqlHelper.getInstance(RDDWebConst.PESEER_DB_ONLINE).close(rs);
		}
	}

	/**
	 * 根据退出类型获取今日投资事件
	 * 到datanode-03库里查询
	 * @param type
	 * @param from
	 * @param count
	 * @return
	 */
	public List<PMInvestEvent> getCurrentDateInvestEvents(String type, int from, int count) {
//		String date = TimeUtil.getCurrentTime("yyyy-MM-dd");
		String date = "2017-08-10"; //测试时间

		List<PMInvestEvent> objectList = new ArrayList<>();
		List<Object> para = new ArrayList<>();
		para.add(date);

		String sql = "select event_id, event_title, happen_date, ent_cn_name,invest_type "
				+ "from ops_invest_event_detail "
				+ "where update_time > ? ";

		if(!StringUtil.isNullOrEmpty(type)){
			sql = sql + "and invest_type=? ";
			para.add(type);
		}

		sql = sql + "group by event_title order by happen_date desc limit ?,?";

		para.add(from);
		para.add(count);

		ResultSet rs = null;
		try {

			rs = MysqlHelper75.getInstance(RDDWebConst.ops_rdd).executeQuery(sql, para);

			while (rs.next()) {
				PMInvestEvent record = (PMInvestEvent) BeanConverter.convert(rs,
						PMInvestEvent.class);
				if (record != null) {
					objectList.add(record);
				}
			}

		} catch (Exception e) {
			logger.error(e.toString());
		}finally{
			MysqlHelper75.getInstance(RDDWebConst.ops_rdd).close(rs);
		}

		return objectList;
	}


	/**
	 * 根据退出类型获取今日退出事件
	 * 到datanode-03库里查询
	 * @param type
	 * @param from
	 * @param count
	 * @return
	 */
	public List<PMExitEvent> getCurrentDateExitEvents(String type, int from, int count){
//		String date = TimeUtil.getCurrentTime("yyyy-MM-dd");
		String date = "2017-08-10";; //测试时间

		List<PMExitEvent> objectList = new ArrayList<>();
		List<Object> para = new ArrayList<>();
		para.add(date);

		String sql = "select event_id, event_title, happen_date, ent_cn_name,exit_type "
				+ "from ops_exit_event_detail "
				+ "where update_time > ? ";
		if(!StringUtil.isNullOrEmpty(type)){
			sql = sql + "and exit_type=? ";
			para.add(type);
		}

		sql = sql + "group by event_title order by happen_date desc limit ?,?";

		para.add(from);
		para.add(count);

		ResultSet rs = null;
		try {

			rs = MysqlHelper75.getInstance(RDDWebConst.ops_rdd).executeQuery(sql, para);

			while (rs.next()) {
				PMExitEvent record = (PMExitEvent) BeanConverter.convert(rs,
						PMExitEvent.class);
				if (record != null) {
					objectList.add(record);
				}
			}

		} catch (Exception e) {
			logger.error(e.toString());
		}finally{
			MysqlHelper75.getInstance(RDDWebConst.ops_rdd).close(rs);
		}

		return objectList;
	}
}
