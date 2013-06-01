package com.android.ormlite.database;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.ormlite.AndroidORMLiteTestActivity;
import com.android.ormlite.domain.Answer;
import com.android.ormlite.domain.Category;
import com.android.ormlite.domain.Position;
import com.android.ormlite.domain.Question;
import com.android.ormlite.domain.SportMan;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	// name of the database file for your application -- change to something
	// appropriate for your app
	private static final String DATABASE_NAME = "ORMLite_test.db";
	// any time you make changes to your database objects, you may have to
	// increase the database versionä
	private static final int DATABASE_VERSION = 1;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	
	/**
	 * This is called when the database is first created. Usually you should
	 * call createTable statements here to create the tables that will store
	 * your data.
	 */
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			TableUtils.createTable(connectionSource, Category.class);
			TableUtils.createTable(connectionSource, Question.class);
			TableUtils.createTable(connectionSource, Answer.class);
			TableUtils.createTable(connectionSource, SportMan.class);
			TableUtils.createTable(connectionSource, Position.class);
			
			DaoManager.createDao(connectionSource, Category.class);
			DaoManager.createDao(connectionSource, Question.class);
			DaoManager.createDao(connectionSource, Answer.class);
			DaoManager.createDao(connectionSource, SportMan.class);
			DaoManager.createDao(connectionSource, Position.class);
			
			Log.i(AndroidORMLiteTestActivity.TAG, "DB created.");
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "Error in DatabaseHelper", e);
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * This is called when your application is upgraded and it has a higher
	 * version number. This allows you to adjust the various data to match the
	 * new version number.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			Log.i(AndroidORMLiteTestActivity.TAG, "Upgrading DB.");
			TableUtils.dropTable(connectionSource, Category.class, true);
			TableUtils.dropTable(connectionSource, Question.class, true);
			TableUtils.dropTable(connectionSource, Answer.class, true);
			TableUtils.dropTable(connectionSource, SportMan.class, true);
			TableUtils.dropTable(connectionSource, Position.class, true);
			// after we drop the old databases, we create the new ones
			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "Error in DatabaseHelper", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * Close the database connections and clear any cached DAOs.
	 */
	@Override
	public void close() {
		super.close();
	}
	
	
}