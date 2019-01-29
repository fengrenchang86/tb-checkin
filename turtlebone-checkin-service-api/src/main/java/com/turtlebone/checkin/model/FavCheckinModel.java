package com.turtlebone.checkin.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class FavCheckinModel implements Serializable {
	protected String username;
	protected String name;
	protected String type;
	protected Integer count;
	protected String dateTime;
}
