package com.turtlebone.checkin.repository;

import com.turtlebone.checkin.entity.GroupConfig;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupConfigRepository{

  	int deleteByPrimaryKey(Integer id);
	
	GroupConfig selectByPrimaryKey(Integer id);
	
	    
    int updateByPrimaryKey(GroupConfig groupConfig);

    int updateByPrimaryKeySelective(GroupConfig groupConfig);

  	int insert(GroupConfig groupConfig);
  	
	int insertSelective(GroupConfig groupConfig);


    int selectCount(GroupConfig groupConfig);

    List<GroupConfig> selectPage(@Param("groupConfig") GroupConfig groupConfig, @Param("pageable") Pageable pageable);
	
}