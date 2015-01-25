package com.example.moneykeeper;

import com.example.moneykeeper.R;
import com.example.moneykeeper.R.id;
import com.example.moneykeeper.R.layout;

import alarm.AlarmActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SettingsActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitiy_settings);
		final Context context = this;

		//gumb za izlazak iz opcija/settings
		Button btnCloseSettings = (Button) findViewById(R.id.btnCloseSettings);
		btnCloseSettings.setOnClickListener(

		new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, MainActivity.class);
				startActivity(i);

			}
		});
		
		//gumb za otvaranje dialoga za unos korisniŠkih podataka
		Button btnDodajKorisnika = (Button) findViewById(R.id.btnDodajKorisnika);
		btnDodajKorisnika.setOnClickListener(

		new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, KorisnikActivity.class);
				startActivity(i);

			}
		});

		//gumb za otvaranje dialoga za unos racuna
		Button btnDodajRacun = (Button) findViewById(R.id.btn_dodaj_racun);
		btnDodajRacun.setOnClickListener(

		new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, RacunActivity.class);
				startActivity(i);

			}
		});

		//gumb za otvaranje dialoga za postavljanje alarma TODO!!
		Button btnDodajAlarm = (Button) findViewById(R.id.btn_dodaj_alarm);
		btnDodajAlarm.setOnClickListener(

		new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, AlarmActivity.class);
				startActivity(i);

			}
		});
	}
}
