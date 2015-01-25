package com.example.moneykeeper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Context context = this;

		boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
				.getBoolean("firstrun", true);
		
		//dialog prilikom prvog pokretanja
		if (firstrun) {

			new AlertDialog.Builder(this)
					.setTitle("Welcome!")
					// set the Title text
					.setIcon(R.drawable.ic_launcher)
					// Set the picture in the top left of the popup
					.setMessage(
							"This dialog will only appear once."
									+ " In order to see it again you must either clear the app data (settings->apps->ManageAps) or uninstall then reinstall the app.")
					.setNeutralButton("OK", null).show(); // Sets the button
															// type

		}
		// Save the state with shared preferences
		getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
				.putBoolean("firstrun", false).commit();

		// gumb za ulaz u funkc. transakcije
		ImageButton imgTransaction = (ImageButton) findViewById(R.id.imgTransaction);
		imgTransaction.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, Transactions.class);
				startActivity(i);

			}
		});

		// gumb za ulaz u funkc. kategorije
		ImageButton imgCategory = (ImageButton) findViewById(R.id.imgCategory);
		imgCategory.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, CategoriesActivity.class);
				startActivity(i);

			}
		});

		// gumb za ulaz u funkc. opcije
		ImageButton imgSettings = (ImageButton) findViewById(R.id.imgSettings);
		imgSettings.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, SettingsActivity.class);
				startActivity(i);

			}
		});

		// gumb za ulaz u funkc. statistika
		ImageButton imgStatistics = (ImageButton) findViewById(R.id.imgStatistics);
		imgStatistics.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, StatisticsActivity.class);
				startActivity(i);

			}
		});

		// gumb za izlaz iz aplikacije
		Button exit = (Button) findViewById(R.id.btn_Exit);
		exit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent homeIntent = new Intent(Intent.ACTION_MAIN);
				homeIntent.addCategory(Intent.CATEGORY_HOME);
				homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(homeIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
