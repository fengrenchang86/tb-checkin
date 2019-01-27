package com.turtlebone.checkin.common;

public enum GroupType {
	STUDY(0x10000000, "学习"),
	LIULI(0x10000001, "流利英语"),
	GAOSHU(0x10000002, "高数"),
	DUBBO(0x10000003, "DUBBO"),
	
	
	LIFE(0x20000000, "生活"),
	FEED(0x20000001, "喂奶"),
	HUANPIAN(0x20000002, "换片"),
	JINAI(0x20000002, "挤奶"),
	;
	
	private int id;
	private String description;
	
	GroupType(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}	
	public static GroupType findGroupType(String name) {
		if (name == null) {
			return null;
		}
		for (GroupType gt : GroupType.values()) {
			if (name.equals(gt.name())) {
				return gt;
			}
		}
		return null;
	}
	@Override
	public String toString() {
		return this.description;
	}
}
