


package com.turtlebone.checkin.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.turtlebone.checkin.service.GroupConfigService;
import com.turtlebone.checkin.model.GroupConfigModel;


public class GroupConfigServiceTest{

	@Autowired
	private GroupConfigService groupConfigService;

	@Test
	public void testCreate(){
		GroupConfigModel groupConfigModel = new GroupConfigModel();
		groupConfigModel.setId(3);
		groupConfigModel.setParentid(8);
		groupConfigModel.setName("5e20be27-6d68-48eb-98de-061ebdd79427");
		groupConfigModel.setType("2f04db71-982c-4674-b93c-a38548b9477a");
		groupConfigModel.setApp(5);
		saveModel(groupConfigModel);
		
				Integer pkValue = groupConfigModel.getId();
		GroupConfigModel findModel = groupConfigService.findByPrimaryKey(pkValue);
		assertEquals(pkValue, findModel.getId());
		assertEquals(groupConfigModel.getParentid(), findModel.getParentid());
		cleanModel(pkValue);
        		
	}

	@Test
	public void testFindByPrimaryKey(){
		GroupConfigModel groupConfigModel = new GroupConfigModel();
		groupConfigModel.setId(9);
		groupConfigModel.setParentid(7);
		groupConfigModel.setName("73b602f5-5e88-4acb-8fe7-cdce4b3692c3");
		groupConfigModel.setType("16aa72ff-6e65-4fa8-9495-1631dc8c841e");
		groupConfigModel.setApp(3);
		Integer pkValue = groupConfigModel.getId();
		saveModel(groupConfigModel);

		GroupConfigModel findModel = groupConfigService.findByPrimaryKey(pkValue);
		assertEquals(pkValue, findModel.getId());
		assertEquals(groupConfigModel.getParentid(), findModel.getParentid());

		cleanModel(pkValue);
	}

	@Test
	public void testUpdateByPrimaryKey(){
		GroupConfigModel groupConfigModel = new GroupConfigModel();
		groupConfigModel.setId(6);
		groupConfigModel.setParentid(4);
		groupConfigModel.setName("0cec0444-fab9-4f88-80c9-46c0c82e9239");
		groupConfigModel.setType("6bcb933f-5d50-483a-bfe1-f528d3dcf8ed");
		groupConfigModel.setApp(3);
		Integer pkValue = groupConfigModel.getId();
		saveModel(groupConfigModel);

		//GroupConfigModel updateModel = createModel();
		GroupConfigModel updateModel = new GroupConfigModel();
		updateModel.setId(4);
		updateModel.setParentid(8);
		updateModel.setName("9908084c-34ab-4b93-9595-bc518d5ff7e5");
		updateModel.setType("c0acc6ed-f22a-4173-9507-8b0c9de0c34d");
		updateModel.setApp(1);
		
		updateModel.setId(pkValue);
		Integer updateResult = groupConfigService.updateByPrimaryKey(updateModel);
		assertEquals(new Integer(1), updateResult);
		GroupConfigModel findModel = groupConfigService.findByPrimaryKey(pkValue);
		assertEquals(pkValue, findModel.getId());
		assertEquals(updateModel.getParentid(), findModel.getParentid());

		cleanModel(pkValue);
	}

	@Test
	public void testDeleteByPrimaryKey(){
		GroupConfigModel groupConfigModel = new GroupConfigModel();
		groupConfigModel.setId(7);
		groupConfigModel.setParentid(8);
		groupConfigModel.setName("d64d0544-f597-453e-84ea-c7644b98f88d");
		groupConfigModel.setType("a888370e-fe53-4e8b-9673-cb7db99a1596");
		groupConfigModel.setApp(3);
		Integer pkValue = groupConfigModel.getId();
		saveModel(groupConfigModel);
	
		Integer deleteResult = groupConfigService.deleteByPrimaryKey(pkValue);
		assertEquals(new Integer(1), deleteResult);
		GroupConfigModel findModel = groupConfigService.findByPrimaryKey(pkValue);
		assertNull(findModel);
	}
	
	private void saveModel(GroupConfigModel groupConfigModel){
		Integer createResult = groupConfigService.create(groupConfigModel);
		assertEquals(createResult, new Integer(1));
	}

	private void cleanModel(Integer pk){
		Integer deleteResult = groupConfigService.deleteByPrimaryKey(pk);
		assertEquals(deleteResult, new Integer(1));
	}

	@SuppressWarnings("unused")
	private GroupConfigModel createModel() {
		GroupConfigModel groupConfigModel = new GroupConfigModel();
		groupConfigModel.setId(5);
		groupConfigModel.setParentid(4);
		groupConfigModel.setName("2dadd2de-0715-4872-a46b-85cb10d94ccc");
		groupConfigModel.setType("27fa4568-c385-4488-88cb-1191a8fedb32");
		groupConfigModel.setApp(7);
		return groupConfigModel;
	}


}
