package com.android.ormlite.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "categories")
public class Category {

	@DatabaseField(id = true)
	private int id;
	@DatabaseField(columnName = "type", canBeNull = false)
	private int type;
	@DatabaseField(columnName = "name", canBeNull = false)
	private String name;
	
	
	public Category() {
		super();
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	

	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}
