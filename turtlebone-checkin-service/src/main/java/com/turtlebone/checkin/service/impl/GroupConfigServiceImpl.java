
package com.turtlebone.checkin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.turtlebone.base.util.BeanCopyUtils;
import com.turtlebone.checkin.entity.GroupConfig;
import com.turtlebone.checkin.repository.GroupConfigRepository;
import com.turtlebone.checkin.model.GroupConfigModel;
import com.turtlebone.checkin.service.GroupConfigService;
import com.turtlebone.main.model.ActivityModel;
import com.turtlebone.main.service.ActivityService;

@Component
@Service(interfaceClass = GroupConfigService.class)
public class GroupConfigServiceImpl implements GroupConfigService {

	@Autowired
	private GroupConfigRepository groupConfigRepo;
	
	@Reference(check=false)
	private ActivityService activityService;

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return groupConfigRepo.deleteByPrimaryKey(id);
	}
	

    /*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public GroupConfigModel findByPrimaryKey(Integer id) {
		GroupConfig groupConfig = groupConfigRepo.selectByPrimaryKey(id);
		return BeanCopyUtils.map(groupConfig, GroupConfigModel.class);
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKey(GroupConfigModel groupConfigModel) {
		return groupConfigRepo.updateByPrimaryKey(BeanCopyUtils.map(groupConfigModel, GroupConfig.class));
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKeySelective(GroupConfigModel groupConfigModel) {
		return groupConfigRepo.updateByPrimaryKeySelective(BeanCopyUtils.map(groupConfigModel, GroupConfig.class));
	}
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int create(GroupConfigModel groupConfigModel) {
		return groupConfigRepo.insert(BeanCopyUtils.map(groupConfigModel, GroupConfig.class));
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int createSelective(GroupConfigModel groupConfigModel) {
		return groupConfigRepo.insertSelective(BeanCopyUtils.map(groupConfigModel, GroupConfig.class));
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int selectCount(GroupConfigModel groupConfigModel) {
		return groupConfigRepo.selectCount(BeanCopyUtils.map(groupConfigModel, GroupConfig.class));
	}


	@Override
	public List<GroupConfigModel> queryByParent(Integer parentId) {
		GroupConfig gc = new GroupConfig();
		gc.setParentid(parentId);
		List<GroupConfig> list = groupConfigRepo.selectPage(gc, new PageRequest(0, 1000));
		return BeanCopyUtils.mapList(list, GroupConfigModel.class);
	}



}
