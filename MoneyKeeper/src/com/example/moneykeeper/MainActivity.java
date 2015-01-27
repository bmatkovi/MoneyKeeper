/*
 * 
 */
package com.example.moneykeeper;

import com.example.moneykeeper.R;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Context context = this;
		/*
		 * pokretanje postavki ukoliko je prvi put pokrenuta aplikacija
		 */

		boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
				.getBoolean("firstrun", true);

		/* pokreni SettingsActivity klasu, ali samo prvi put */
		if (firstrun) {

			Intent i = new Intent(context, SettingsActivity.class);
			startActivity(i);
		}

		/*
		 * Spremi podatke o prosljeđenim preferencama
		 */
		getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
				.putBoolean("firstrun", false).commit();

		/*
		 * gumb za ulaz u funkc. transakcije onClick pokrećemo
		 * TransactionActivity klasu, prikaz popisa transakcija
		 */
		ImageButton imgTransaction = (ImageButton) findViewById(R.id.imgTransaction);
		imgTransaction.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, Transactions.class);
				startActivity(i);

			}
		});

		/*
		 * gumb za ulaz u funkc. kategorije onClick pokrećemo CategoriesActivity
		 * klasu, prikaz popisa kategorija
		 */
		ImageButton imgCategory = (ImageButton) findViewById(R.id.imgCategory);
		imgCategory.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, CategoriesActivity.class);
				startActivity(i);

			}
		});

		/*
		 * gumb za ulaz u funkc. opcije onClick pokrećemo SettingsActivity
		 * klasu, prikaz postavki
		 */
		ImageButton imgSettings = (ImageButton) findViewById(R.id.imgSettings);
		imgSettings.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, SettingsActivity.class);
				startActivity(i);

			}
		});

		/*
		 * gumb za ulaz u funkc. statistika onClick pokrećemo Statistics klasu,
		 * prikaz statistike
		 */
		ImageButton imgStatistics = (ImageButton) findViewById(R.id.imgStatistics);
		imgStatistics.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, StatisticsActivity.class);
				startActivity(i);

			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */

	/*
	 * metoda za kreiranje menija u navigation tabu kreiramo gumb Izlaz, za
	 * izlazak iz aplikacije
	 */
	public static final int EXIT = Menu.FIRST;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		menu.add(Menu.NONE, EXIT, Menu.NONE, "Izlaz");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */

	/*
	 * metoda za upravljanje Izlaz gumbom unutar navigation taba
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

