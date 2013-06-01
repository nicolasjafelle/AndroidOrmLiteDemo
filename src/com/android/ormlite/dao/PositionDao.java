package com.android.ormlite.dao;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.android.ormlite.AndroidORMLiteTestActivity;
import com.android.ormlite.domain.Position;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class PositionDao extends AbstractDao<Position> {

	public PositionDao(Context context) {
		super(context);
	}

	public Position findPositionByShortPosition(String shortPosition) {
		Position pos = null;
		try {
			super.open();
			QueryBuilder<Position, ?> qb = dbHelper.getDao(Position.class).queryBuilder();
			String textWildcard = "%" + shortPosition + "%";
		    qb.where().like("short_position", textWildcard);
		    PreparedQuery<Position> pq = qb.prepare();
		    pos = dbHelper.getDao(Position.class).queryForFirst(pq);
		    
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN QUESTIONDAO", e);
		}finally {
			dbHelper.close();
		}
		return pos;
	}
	
	
	public long getPositionsSelectedCount() {
		long totalPositionsSelected = 0;
		try {
			super.open();
			QueryBuilder<Position, ?> qb = dbHelper.getDao(Position.class).queryBuilder();
			qb.setCountOf(true);
		    qb.where().eq("is_selected", true);
		    PreparedQuery<Position> pq = qb.prepare();
		    totalPositionsSelected = dbHelper.getDao(Position.class).countOf(pq);
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN QUESTIONDAO", e);
		}finally {
			dbHelper.close();
		}
		return totalPositionsSelected;
	
	}
	
	public List<Position> findSelectedPositions() {
		List<Position> positions = null;
		try {
			super.open();
			QueryBuilder<Position, ?> qb = dbHelper.getDao(Position.class).queryBuilder();
		    qb.where().eq("is_selected", true);
		    PreparedQuery<Position> pq = qb.prepare();
		    positions = dbHelper.getDao(Position.class).query(pq);
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN QUESTIONDAO", e);
		}finally {
			dbHelper.close();
		}
		return positions;
	}
	
	
	
}
