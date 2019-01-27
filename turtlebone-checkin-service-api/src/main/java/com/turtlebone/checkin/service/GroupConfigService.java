
package com.turtlebone.checkin.service;

import java.util.List;

import com.turtlebone.checkin.model.GroupConfigModel;


public interface GroupConfigService{
	
	public int create(GroupConfigModel groupConfigModel);
	
	public int createSelective(GroupConfigModel groupConfigModel);
	
	public GroupConfigModel findByPrimaryKey(Integer id);
	
	public int updateByPrimaryKey(GroupConfigModel groupConfigModel);
	
	public int updateByPrimaryKeySelective(GroupConfigModel groupConfigModel);
	
	public int deleteByPrimaryKey(Integer id);
	

	public int selectCount(GroupConfigModel groupConfigModel);
	
	public List<GroupConfigModel> queryByParent(Integer parentId);
	
}