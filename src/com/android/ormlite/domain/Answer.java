package com.android.ormlite.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "answers")
public class Answer {

	@DatabaseField(id = true)
	private int id;
	@DatabaseField(columnName = "content", canBeNull = false)
	private String content;
	@DatabaseField(columnName = "rate", canBeNull = true)
	private double rate;
	@DatabaseField(columnName = "media_url", canBeNull = true)
	private String mediaUrl;
	
	@DatabaseField(foreign = true, columnName = "sportman_id", foreignAutoRefresh = true )
	private SportMan sportMan;
	@DatabaseField(foreign = true, foreignAutoRefresh = true)
	private Question question;
	
	public Answer() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public String getMediaUrl() {
		return mediaUrl;
	}


	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}


	public SportMan getSportMan() {
		return sportMan;
	}


	public void setSportMan(SportMan sportMan) {
		this.sportMan = sportMan;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	
	
	
}
