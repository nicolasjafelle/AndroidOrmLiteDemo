package com.android.ormlite.dto;

import com.android.ormlite.domain.Athlete;
import com.android.ormlite.domain.Coach;
import com.android.ormlite.domain.SportMan;
import com.android.ormlite.domain.Trainer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SportManDto extends AbstractDto {

	@JsonProperty("name")
	private String name;
	@JsonProperty("team")
	private String team;
	@JsonProperty("type")
	private String type;
	
	public SportManDto() {
		super();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	public SportMan toModelObject() {
		
		SportMan man = null; 
		
		if(this.type.equalsIgnoreCase("Athlete")) {
			man = new Athlete();
			man.setType(1);
		}else if(this.type.equalsIgnoreCase("Coach")) {
			man = new Coach();
			man.setType(2);
		}else { // is Trainer
			man = new Trainer();
			man.setType(3);
		}
		man.setId(this.getId());
		man.setName(this.name);
		man.setTeam(this.team);
		
		return man;
	}
	
	
	
}
