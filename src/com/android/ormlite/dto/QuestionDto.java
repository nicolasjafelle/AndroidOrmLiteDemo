package com.android.ormlite.dto;

import java.util.List;

import com.android.ormlite.domain.Question;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class QuestionDto extends AbstractDto {

	@JsonProperty("question")
	private String content;
	@JsonProperty("positions")
	private List<String> positions;
	@JsonProperty("topics")
	private List<String> topics;
	
	public QuestionDto() {
		super();
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getPositions() {
		return positions;
	}

	public void setPositions(List<String> positions) {
		this.positions = positions;
	}

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}
	
	public Question toModelObject() {
		Question question = new Question();
		question.setId(this.getId());
		question.setContent(this.content);
		
		for (String tag : topics) {
			String total;
			if(question.getTags() == null) {
				total = tag;
			}else {
				total = question.getTags() + "," + tag;
			}
			question.setTags(total);
		}
		
		for (String position : positions) {
			String total;
			if(question.getPositions() == null) {
				total = position;
			}else {
				total = question.getPositions() + "," + position;
			}
			question.setPositions(total);
		}
		
		return question;
	}
	
	
	
	
}
