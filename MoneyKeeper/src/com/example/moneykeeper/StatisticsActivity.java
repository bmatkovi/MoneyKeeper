package com.example.moneykeeper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StatisticsActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statistics);
		final Context context = this;

		//gumb za otvaranje funkc. statistika
		Button btnCloseStatistics = (Button) findViewById(R.id.btnCloseStatistics);
		btnCloseStatistics.setOnClickListener(

		new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, MainActivity.class);
				startActivity(i);

			}
		});

	}
}