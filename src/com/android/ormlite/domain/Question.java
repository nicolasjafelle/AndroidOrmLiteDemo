package com.android.ormlite.domain;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "questions")
public class Question {

	@DatabaseField(id = true)
	private int id;
	@DatabaseField(columnName = "content", canBeNull = false)
	private String content;
	
	@DatabaseField(columnName = "time_viewed", canBeNull = true)
	private int timeViewed;
	@DatabaseField(columnName = "last_seen_date", canBeNull = true)
	private Date lastSeenDate;
	@DatabaseField(columnName = "is_favourite", dataType = DataType.BOOLEAN, canBeNull = true)
	private boolean isFavourite;
	@DatabaseField(columnName = "tags" , canBeNull = true)
	private String tags; // comma separate values. Ej: basketball,rebound,fault
	@DatabaseField(columnName = "positions" , canBeNull = true)
	private String positions; // comma separate values.
	
	
	public Question() {
		super();
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


	public int getTimeViewed() {
		return timeViewed;
	}


	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}


	public Date getLastSeenDate() {
		return lastSeenDate;
	}


	public void setLastSeenDate(Date lastSeenDate) {
		this.lastSeenDate = lastSeenDate;
	}


	public boolean isFavourite() {
		return isFavourite;
	}


	public void setFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPositions() {
		return positions;
	}

	public void setPositions(String positions) {
		this.positions = positions;
	}
	
	
	
	
	
	
	
}
