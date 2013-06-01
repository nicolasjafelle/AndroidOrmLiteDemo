package com.android.ormlite.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "sportmen")
public class SportMan {

	@DatabaseField(id = true)
	private int id;
	@DatabaseField(columnName = "name", canBeNull = false)
	private String name;
	@DatabaseField(columnName = "team", canBeNull = true)
	private String team;
	@DatabaseField(columnName = "type", canBeNull = true)
	private int type;
	// 1 = Athlete, 2 = Coach, 3 = Trainer
	
	public SportMan() {
		super();
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public SportMan getClassByType(int type) {
		
		switch (type) {
		case 1:
			Athlete athlete = new Athlete();
			athlete.setName(this.name);
			athlete.setTeam(this.team);
			athlete.setType(type);
			return athlete;
		case 2:
			Coach coach = new Coach();
			coach.setName(this.name);
			coach.setTeam(this.team);
			coach.setType(type);
			return coach;
		case 3:
			Trainer trainer = new Trainer();
			trainer.setName(this.name);
			trainer.setTeam(this.team);
			trainer.setType(type);
			return trainer;
		default:
			throw new IllegalStateException("No Such type with value: " + type);
		}

	}
	
	
	
	
}
