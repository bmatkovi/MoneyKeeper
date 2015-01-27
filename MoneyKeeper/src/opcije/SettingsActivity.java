package opcije;

import alarm.AlarmActivity;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.moneykeeper.MyDialog;
import com.example.moneykeeper.R;

public class SettingsActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitiy_settings);
		final Context context = this;
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// gumb za otvaranje dialoga za unos korisnièkih podataka
		Button btnDodajKorisnika = (Button) findViewById(R.id.btnDodajKorisnika);
		btnDodajKorisnika.setOnClickListener(

		new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent i = new Intent(context, KorisnikActivity.class);
				startActivity(i);

				/*
				 * final MyDialog dialog = new MyDialog(SettingsActivity.this);
				 * dialog.displayDialog(new OnClickListener() {
				 * 
				 * @Override public void onClick(View v) {
				 * 
				 * Toast.makeText(getBaseContext(), "Dodani su podaci",
				 * Toast.LENGTH_SHORT).show(); dialog.getDialog().dismiss(); }
				 * });
				 */

			}
		});

		// gumb za otvaranje dialoga za unos racuna
		Button btnDodajRacun = (Button) findViewById(R.id.btn_dodaj_racun);
		btnDodajRacun.setOnClickListener(

		new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, RacunActivity.class);
				startActivity(i);

			}
		});

		// gumb za otvaranje dialoga za postavljanje alarma TODO!!
		Button btnDodajAlarm = (Button) findViewById(R.id.btn_dodaj_alarm);
		btnDodajAlarm.setOnClickListener(

		new OnClickListener() {
			@Override
			public void onClick(View v) {

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
