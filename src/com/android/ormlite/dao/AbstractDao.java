package com.android.ormlite.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

import android.content.Context;
import android.util.Log;

import com.android.ormlite.AndroidORMLiteTestActivity;
import com.android.ormlite.database.DatabaseHelper;
import com.j256.ormlite.dao.Dao;

public abstract class AbstractDao<T> {

	protected DatabaseHelper dbHelper;
	private Context context;
	
	public AbstractDao(Context context) {
		this.context = context;
//		open();
		
	}
	
	public void open() {
		if(dbHelper == null || !dbHelper.isOpen() ) {
			dbHelper = new DatabaseHelper(context);
		}
	}
	
	
	public void insert(Class<T> clazz, T t) {
		try {
			open();
			dbHelper.getDao(clazz).create(t);
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN ABSTRACTDAO", e);
		}finally {
			dbHelper.close();
		}
	}
	
	public void insertAll(Class<T> clazz, List<T> t) {
		try {
			open();
			for (T t2 : t) {
				dbHelper.getDao(clazz).create(t2);
			}
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN ABSTRACTDAO", e);
		}finally {
			dbHelper.close();
		}
	}
	
	public void insertAllinBatchOperation(final Class<T> clazz, final List<T> t) throws Exception {
		try {
			open();
			final Dao<T, ?> dao = dbHelper.getDao(clazz);
			dao.callBatchTasks(new Callable<Boolean>() {
			    public Boolean call() throws Exception {
			    	for (T t2 : t) {
			    		dao.create(t2);
					}
					return true;
			    }
			});
			
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN ABSTRACTDAO", e);
		}finally {
			dbHelper.close();
		}
	}
	
	
	public void update(Class<T> clazz, T t) {
		try {
			open();
			dbHelper.getDao(clazz).createOrUpdate(t);
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN ABSTRACTDAO", e);
		}finally {
			dbHelper.close();
		}
	}
	
	public void updateAllinBatchOperation(final Class<T> clazz, final List<T> t) throws Exception {
		try {
			open();
			final Dao<T, ?> dao = dbHelper.getDao(clazz);
			dao.callBatchTasks(new Callable<Boolean>() {
			    public Boolean call() throws Exception {
			    	for (T t2 : t) {
			    		dao.update(t2);
					}
					return true;
			    }
			});
			
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN ABSTRACTDAO", e);
		}finally {
			dbHelper.close();
		}
	}
	
	
	
	public List<T> findAll(Class<T> clazz) {
		List<T> list = null;
		try {
			open();
			list = dbHelper.getDao(clazz).queryForAll();
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN ABSTRACTDAO", e);
		}finally {
			dbHelper.close();
		}
		return list;
	}
	
	public void delete(Class<T> clazz, T t) {
		try {
			open();
			dbHelper.getDao(clazz).delete(t);
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN ABSTRACTDAO", e);
		}finally {
			dbHelper.close();
		}
	}
	
	public T findById(Class<T> clazz, Integer id) {
		T t = null;
		try {
			open();
			Dao<T, Integer> dao = dbHelper.getDao(clazz);
			t = dao.queryForId(id);
		} catch (SQLException e) {
			Log.e(AndroidORMLiteTestActivity.TAG, "ERROR IN ABSTRACTDAO", e);
		}
		return t;
	}
	
}
