package com.android.ormlite.dto;

import java.util.List;

import android.content.Context;

import com.android.ormlite.dao.QuestionDao;
import com.android.ormlite.dao.SportManDao;
import com.android.ormlite.domain.Answer;
import com.android.ormlite.domain.Question;
import com.android.ormlite.domain.SportMan;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AnswerDto extends AbstractDto {

	@JsonProperty("interviewDate")
	private String interviewDate;
	@JsonProperty("questionId")
	private int questionId;
	@JsonProperty("personId")
	private int personId;
	@JsonProperty("topics")
	private List<String> topics;
	@JsonProperty("answer")
	private String answer;
	@JsonProperty("answerEdited")
	private String answerEdited;
	

	public AnswerDto() {
		super();
	}


	public String getInterviewDate() {
		return interviewDate;
	}


	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}


	public int getQuestionId() {
		return questionId;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}


	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public List<String> getTopics() {
		return topics;
	}


	public void setTopics(List<String> topics) {
		this.topics = topics;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public String getAnswerEdited() {
		return answerEdited;
	}


	public void setAnswerEdited(String answerEdited) {
		this.answerEdited = answerEdited;
	}
	
	public Answer toModelObject(Context context) {
		QuestionDao questionDao = new QuestionDao(context);
		Answer answer = new Answer();
		answer.setId(this.getId());
		answer.setContent(this.getAnswer());
		Question question = questionDao.findById(Question.class, this.questionId);
		answer.setQuestion(question);
		
		SportManDao sportManDao = new SportManDao(context);
		SportMan sportMan = sportManDao.findById(SportMan.class, this.personId);
		answer.setSportMan(sportMan);
		
		return answer;
	}
	
	public Answer toModelObject(Context context, List<Question> questions, List<SportMan> sportMen) {
		Answer answer = new Answer();
		answer.setId(this.getId());
		answer.setContent(this.getAnswer());
		
		for (SportMan sportMan : sportMen) {
			if(sportMan.getId() == personId) {
				answer.setSportMan(sportMan);
			}
		}
		
		for (Question question : questions) {
			if(question.getId() == questionId) {
				answer.setQuestion(question);
			}
		}
		return answer;
	}
	
	
	
	
}
