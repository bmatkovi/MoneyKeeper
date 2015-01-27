/*
 * 
 */
package com.example.moneykeeper;

import kategorije.CategoriesActivity;
import opcije.SettingsActivity;
import transakcije.Transactions;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

// TODO: Auto-generated Javadoc
/**
 * The Class MainActivity.
 */
public class MainActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Context context = this;

		boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
				.getBoolean("firstrun", true);

		// dialog prilikom prvog pokretanja
		if (firstrun) {

			Intent i = new Intent(context, SettingsActivity.class);
			startActivity(i);
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

	}


	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */

	public static final int EXIT = Menu.FIRST;


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		menu.add(Menu.NONE, EXIT, Menu.NONE, "Izlaz");
		return true;
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case EXIT:
			this.finish();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
