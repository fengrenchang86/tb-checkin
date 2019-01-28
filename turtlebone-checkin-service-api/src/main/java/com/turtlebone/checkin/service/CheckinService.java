package com.turtlebone.checkin.service;

import com.turtlebone.checkin.common.GroupType;

public interface CheckinService {
	public int checkin(GroupType groupType, String username, String remark, String datetime);
}
