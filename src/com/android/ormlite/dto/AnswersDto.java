package com.android.ormlite.dto;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.android.ormlite.domain.Answer;
import com.android.ormlite.domain.Question;
import com.android.ormlite.domain.SportMan;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AnswersDto {

	@JsonProperty("questions")
	private List<QuestionDto> questions;
	@JsonProperty("answers")
	private List<AnswerDto> answers;
	@JsonProperty("people")
	private List<SportManDto> sportMen;
	
	
	public AnswersDto() {
		super();
	}


	public List<QuestionDto> getQuestions() {
		return questions;
	}


	public void setQuestions(List<QuestionDto> questions) {
		this.questions = questions;
	}


	public List<AnswerDto> getAnswers() {
		return answers;
	}


	public void setAnswers(List<AnswerDto> answers) {
		this.answers = answers;
	}


	public List<SportManDto> getSportMen() {
		return sportMen;
	}


	public void setSportMen(List<SportManDto> sportMen) {
		this.sportMen = sportMen;
	}
	
	
	public List<Question> getAllQuestions() {
		List<Question> completeQuestions = new ArrayList<Question>();
		
		for (QuestionDto questionDto : this.questions) {
			completeQuestions.add(questionDto.toModelObject());
		}
		
		return completeQuestions;
	}
	
	public List<SportMan> getAllSportMen() {
		List<SportMan> completeSportMen = new ArrayList<SportMan>();
		
		for (SportManDto sportManDto : this.sportMen) {
			completeSportMen.add(sportManDto.toModelObject());
		}
		
		return completeSportMen;
	}
	
	
	public List<Answer> getAllAnswers(Context context) {
		List<Answer> completeAnswers = new ArrayList<Answer>();
		
		for (AnswerDto answerDto : this.answers) {
			completeAnswers.add(answerDto.toModelObject(context));
		}
		
		return completeAnswers;
	}
	
	public List<Answer> getAllAnswers(Context context, List<Question> questions, List<SportMan> sportMen) {
		List<Answer> completeAnswers = new ArrayList<Answer>();
		
		for (AnswerDto answerDto : this.answers) {
			completeAnswers.add(answerDto.toModelObject(context, questions, sportMen));
		}
		
		return completeAnswers;
	}
	
	
	
	
}
