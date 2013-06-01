package com.android.ormlite;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.ormlite.database.DatabaseInitializer;

public class AndroidORMLiteTestActivity extends Activity {

	public static final String TAG = "ORMLITE TEST";
	private Button button;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startProcess();
			}
		});
	}

	private void startProcess() {
		boolean deleted = this.deleteDatabase("/data/data/com.android.ormlite/databases/ORMLite_test.db");
		Log.i(AndroidORMLiteTestActivity.TAG, "PREVIOUS DATABASE STATE: " + deleted);
		InputStream jsonFile;
		try {
			jsonFile = getAssets().open("json_response.txt");
			DatabaseInitializer.createAllNptAnswers(getApplicationContext(), jsonFile);
		} catch (IOException e) {
			Log.e(TAG, "Database exception", e);
		}
	}
}