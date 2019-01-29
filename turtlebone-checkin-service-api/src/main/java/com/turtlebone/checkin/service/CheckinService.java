package com.turtlebone.checkin.service;

import java.util.List;

import com.turtlebone.checkin.common.GroupType;
import com.turtlebone.checkin.model.FavCheckinModel;
import com.turtlebone.main.model.ActivityModel;

public interface CheckinService {
	public int checkin(GroupType groupType, String username, String remark, String datetime);
	
	public List<ActivityModel> query(String username);
	
	public List<FavCheckinModel> queryFav(String username);
}
