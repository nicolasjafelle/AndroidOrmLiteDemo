package com.android.ormlite.dao;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.android.ormlite.AndroidORMLiteTestActivity;
import com.android.ormlite.domain.Question;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

public class QuestionDao extends AbstractDao<Question> {

	public QuestionDao(Context context) {
		super(context);
	}
	
	public List<Question> findQuestionsByString(String text) {
		List<Question> questions = null;
		try {
			super.open();
			QueryBuilder<Question, ?> qb = dbHelper.getDao(Question.class).queryBuilder();
			String textWildcard = "%" + text + "%";
		    qb.where().like("content", textWildcard);
		    PreparedQuery<Question> pq = qb.prepare();
		    questions = dbHelper.getDao(Question.class).query(pq);
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN QUESTIONDAO", e);
		}finally {
			dbHelper.close();
		}
		return questions;
	
	}
	
	public List<Question> findQuestionsByStrings(List<String> words) {
		List<Question> questions = null;
		try {
			super.open();
			dbHelper.getDao(Question.class);
			QueryBuilder<Question, ?> qb = dbHelper.getDao(Question.class).queryBuilder();
			Where<Question,?> where = qb.where();
			for (String word : words) {
				where.like("content", "%" + word + "%");
				where.or();
			}
		    PreparedQuery<Question> pq = qb.prepare();
		    questions = dbHelper.getDao(Question.class).query(pq);
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN QUESTIONDAO", e);
		}finally {
			dbHelper.close();
		}
		return questions;
	
	}
	
	public List<Question> findQuestionsByPosition(String position) {
		List<Question> questions = null;
		try {
			super.open();
			QueryBuilder<Question, ?> qb = dbHelper.getDao(Question.class).queryBuilder();
			String textWildcard = "%" + position + "%";
		    qb.where().like("positions", textWildcard);
		    PreparedQuery<Question> pq = qb.prepare();
		    questions = dbHelper.getDao(Question.class).query(pq);
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN QUESTIONDAO", e);
		}finally {
			dbHelper.close();
		}
		return questions;
	
	}
	

}
