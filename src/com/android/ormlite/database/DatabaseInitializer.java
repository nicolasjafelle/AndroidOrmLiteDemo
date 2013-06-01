package com.android.ormlite.database;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.android.ormlite.AndroidORMLiteTestActivity;
import com.android.ormlite.dao.AnswerDao;
import com.android.ormlite.dao.PositionDao;
import com.android.ormlite.dao.QuestionDao;
import com.android.ormlite.dao.SportManDao;
import com.android.ormlite.domain.Answer;
import com.android.ormlite.domain.Position;
import com.android.ormlite.domain.Question;
import com.android.ormlite.domain.SportMan;
import com.android.ormlite.dto.AnswersDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DatabaseInitializer {

	public static void createAllNptAnswers(final Context context, final InputStream jsonFile) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Log.i(AndroidORMLiteTestActivity.TAG, "INIT NPT ANSWERS STORAGE");
					ObjectMapper mapper = new ObjectMapper();
					AnswersDto dto = mapper.readValue(jsonFile, AnswersDto.class);
					
					QuestionDao questionDao = new QuestionDao(context);
					AnswerDao answerDao = new AnswerDao(context);
					SportManDao sportManDao = new SportManDao(context);
					PositionDao positionDao = new PositionDao(context);

					Position pos1 = new Position("OL", null, false);
					Position pos2 = new Position("QB", null, false);
					Position pos3 = new Position("RB", null, false);
					Position pos4 = new Position("TE", null, false);
					Position pos5 = new Position("WR", null, false);
					Position pos6 = new Position("DL", null, false);
					Position pos7 = new Position("LB", null, false);
					Position pos8 = new Position("S", null, false);
					Position pos9 = new Position("CB", null, false);
					Position pos10 = new Position("KR", null, false);
					Position pos11 = new Position("K/P", null, false);
					Position pos12 = new Position("SP", null, false);

					positionDao.insert(Position.class, pos1);
					positionDao.insert(Position.class, pos2);
					positionDao.insert(Position.class, pos3);
					positionDao.insert(Position.class, pos4);
					positionDao.insert(Position.class, pos5);
					positionDao.insert(Position.class, pos6);
					positionDao.insert(Position.class, pos7);
					positionDao.insert(Position.class, pos8);
					positionDao.insert(Position.class, pos9);
					positionDao.insert(Position.class, pos10);
					positionDao.insert(Position.class, pos11);
					positionDao.insert(Position.class, pos12);

					List<SportMan> sportMen = dto.getAllSportMen();
					sportManDao.insertAllinBatchOperation(SportMan.class, sportMen);

					List<Question> questions = dto.getAllQuestions();
					questionDao.insertAllinBatchOperation(Question.class, questions);

					List<Answer> answers = dto.getAllAnswers(context, questions, sportMen);
					answerDao.insertAllinBatchOperation(Answer.class, answers);

					Log.i(AndroidORMLiteTestActivity.TAG, "ALL DATA DUMPED INTO DB");
					checkData(context);
				} catch (Exception e) {
					Log.e(AndroidORMLiteTestActivity.TAG, "CAUSE", e);
				}
			}
		});
		t.start();
	}

	public static void checkData(Context context) {
		List<Question> questions;
		List<Question> questions2;
		List<Question> questions3;
		QuestionDao dao = new QuestionDao(context);
		questions = dao.findQuestionsByString("HOW");
		
		Log.i(AndroidORMLiteTestActivity.TAG, "==============================================================");
		Log.i(AndroidORMLiteTestActivity.TAG, "==================== FIRST QUESTIONS SET =====================");
		Log.i(AndroidORMLiteTestActivity.TAG, "==============================================================");
		for (Question question : questions) {
			Log.i(AndroidORMLiteTestActivity.TAG, question.getContent());
		}
		
		List<String> words = new ArrayList<String>();
		words.add("how");
		words.add("better");
		questions2 = dao.findQuestionsByStrings(words);
		Log.i(AndroidORMLiteTestActivity.TAG, "==============================================================");
		Log.i(AndroidORMLiteTestActivity.TAG, "==================== SECOND QUESTIONS SET ====================");
		Log.i(AndroidORMLiteTestActivity.TAG, "==============================================================");
		for (Question question : questions2) {
			Log.i(AndroidORMLiteTestActivity.TAG, question.getContent());
		}

		questions3 = dao.findQuestionsByPosition("OL");		
		
		Log.i(AndroidORMLiteTestActivity.TAG, "==============================================================");
		Log.i(AndroidORMLiteTestActivity.TAG, "==================== THIRD QUESTIONS SET =====================");
		Log.i(AndroidORMLiteTestActivity.TAG, "==============================================================");
		for (Question question : questions3) {
			Log.i(AndroidORMLiteTestActivity.TAG, question.getPositions());
		}

		PositionDao positionDao = new PositionDao(context);
		Position position = new Position();
		position = positionDao.findPositionByShortPosition("OL");
		position.setSelected(true);
		positionDao.update(Position.class, position);
		long pos = positionDao.getPositionsSelectedCount();
		
		Log.i(AndroidORMLiteTestActivity.TAG, "TOTAL POSITIONS SELECTED BY USER: " + pos);
		List<Position> positions = positionDao.findSelectedPositions();
		
		Log.i(AndroidORMLiteTestActivity.TAG, "SELECTED POSITIONS COUNT: " + positions.size());
	}

}
