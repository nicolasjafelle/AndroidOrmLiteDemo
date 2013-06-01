package com.android.ormlite.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "positions")
public class Position {

	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(columnName = "short_position", canBeNull = false)
	private String shortPosition;
	@DatabaseField(columnName = "position", canBeNull = true)
	private String position;
	@DatabaseField(columnName = "is_selected", canBeNull = true)
	private boolean isSelected;
	
	
	public Position() {
		super();
	}

	
	

	public Position(String shortPosition, String position, boolean isSelected) {
		super();
		this.shortPosition = shortPosition;
		this.position = position;
		this.isSelected = isSelected;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getShortPosition() {
		return shortPosition;
	}


	public void setShortPosition(String shortPosition) {
		this.shortPosition = shortPosition;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public boolean isSelected() {
		return isSelected;
	}


	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	
	
	
	
}
