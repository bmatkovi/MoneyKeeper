package com.example.moneykeeper;

import opcije.KorisnikActivity;
import opcije.RacunActivity;
import opcije.SettingsActivity;

import com.example.moneykeeper.R;
import com.example.moneykeeper.R.id;
import com.example.moneykeeper.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class GuideActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		final Context context = this;

		// gumb za otvaranje dialoga za unos korisniækih podataka
		Button btnDodajKorisnika = (Button) findViewById(R.id.btnDodajKorisnika);
		btnDodajKorisnika.setOnClickListener(

		new OnClickListener() {
			@Override
			public void onClick(View v) {

				/*
				 * Intent i = new Intent(context, KorisnikActivity.class);
				 * startActivity(i);
				 */
				final MyDialog dialog = new MyDialog(GuideActivity.this);
				dialog.displayDialog(new OnClickListener() {
					@Override
					public void onClick(View v) {

						Toast.makeText(getBaseContext(), "Dodani su podaci",
								Toast.LENGTH_SHORT).show();
						dialog.getDialog().dismiss();
					}
				});

			}
		});

		// gumb za otvaranje dialoga za unos racuna
		Button btnDodajRacun = (Button) findViewById(R.id.btn_dodaj_racun);
		btnDodajRacun.setOnClickListener(

		new OnClickListener() {
			@Override
			public void onClick(View v) {
				final MyDialog dialog = new MyDialog(GuideActivity.this);
				dialog.displayRacun(new OnClickListener() {
					@Override
					public void onClick(View v) {

						Toast.makeText(getBaseContext(), "Dodani su podaci",
								Toast.LENGTH_SHORT).show();
						dialog.getDialog().dismiss();
					}
				});

			}
		});

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	};
}
