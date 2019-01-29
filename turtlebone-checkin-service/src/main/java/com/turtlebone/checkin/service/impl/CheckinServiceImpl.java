package com.turtlebone.checkin.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.turtlebone.base.util.DateUtil;
import com.turtlebone.checkin.common.GroupType;
import com.turtlebone.checkin.entity.GroupConfig;
import com.turtlebone.checkin.model.FavCheckinModel;
import com.turtlebone.checkin.repository.GroupConfigRepository;
import com.turtlebone.checkin.service.CheckinService;
import com.turtlebone.main.model.ActivityModel;
import com.turtlebone.main.service.ActivityService;

import lombok.extern.slf4j.Slf4j;

@Component
@Service(interfaceClass = CheckinService.class)
@Slf4j
public class CheckinServiceImpl implements CheckinService {

	@Reference(check = false)
	private ActivityService activityService;

	@Autowired
	private GroupConfigRepository groupConfigRepository;

	@Override
	public int checkin(GroupType groupType, String username, String remark, String datetime) {
		if (StringUtils.isEmpty(username)) {
			log.error("username不能为空");
			return 0;
		}
		ActivityModel activity = new ActivityModel();
		datetime = getDateTime(datetime);
		activity.setDatetime(datetime);
		activity.setType("CHECKIN");
		activity.setResult1((long) groupType.getId());
		activity.setStrresult2(groupType.name());
		activity.setStrresult3(groupType.getDescription());
		activity.setStrresult1(remark);
		activity.setUsername(username);
		activity.setDescription(String.format("%s 打卡进行 %s", username, groupType.getDescription()));
		return activityService.create(activity);
	}

	private String getDateTime(String datetime) {
		try {
			Date date = DateUtil.parse(datetime);
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss");
	}

	@Override
	public List<ActivityModel> query(String username) {
		return activityService.selectByCondition(username, "CHECKIN", null, null, 0, 200);
	}

	@Override
	public List<FavCheckinModel> queryFav(String username) {
		List<GroupConfig> gcList = groupConfigRepository.selectPage(new GroupConfig(), new PageRequest(0, 1000));
		Map<String, GroupConfig> gcMap = new HashMap<>();
		for (GroupConfig gc : gcList) {
			gcMap.put(gc.getType(), gc);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		List<FavCheckinModel> favList = groupConfigRepository.queryFav(map);
		for (FavCheckinModel fav : favList) {
			String type = fav.getType();
			gcMap.remove(type);
		}
		for (Entry<String, GroupConfig> entry : gcMap.entrySet()) {
			GroupConfig gc = entry.getValue();
			FavCheckinModel fav = new FavCheckinModel();
			fav.setCount(0);
			fav.setType(gc.getType());
			fav.setName(gc.getName());
			fav.setDateTime("");
			favList.add(fav);
		}
		Collections.sort(favList, new Comparator<FavCheckinModel>() {
			@Override
			public int compare(FavCheckinModel x, FavCheckinModel y) {
				int cnt = y.getCount() - x.getCount();
				if (cnt != 0) {
					return cnt;
				} else {
					return x.getDateTime().compareTo(y.getDateTime());
				}
			}});
		return favList;
		
	}
}
