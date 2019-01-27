package com.turtlebone.checkin.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.turtlebone.base.util.DateUtil;
import com.turtlebone.checkin.common.GroupType;
import com.turtlebone.checkin.service.CheckinService;
import com.turtlebone.main.model.ActivityModel;
import com.turtlebone.main.service.ActivityService;

import lombok.extern.slf4j.Slf4j;

@Component
@Service(interfaceClass = CheckinService.class)
@Slf4j
public class CheckinServiceImpl implements CheckinService {

	@Reference(check=false)
	private ActivityService activityService;
	
	@Override
	public int checkin(GroupType groupType, String username) {
		if (StringUtils.isEmpty(username)) {
			log.error("username不能为空");
			return 0;
		}
		ActivityModel activity = new ActivityModel();
		activity.setDatetime(DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss"));
		activity.setType("CHECKIN");
		activity.setResult1((long)groupType.getId());
		activity.setUsername(username);
		activity.setDescription(String.format("%s 打卡进行 %s", username, groupType.getDescription()));
		return activityService.create(activity);
	}

}
