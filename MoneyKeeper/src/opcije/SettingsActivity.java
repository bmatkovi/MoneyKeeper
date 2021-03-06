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

import com.example.moneykeeper.DialogControler;
import com.example.moneykeeper.R;

public class SettingsActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitiy_settings);
		final Context context = this;
		getActionBar().setDisplayHomeAsUpEnabled(true);

		/*
		 * gumb za otvaranje dialoga za unos korisničkih podataka
		 */
		Button btnDodajKorisnika = (Button) findViewById(R.id.btnDodajKorisnika);
		btnDodajKorisnika.setOnClickListener(

		new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent i = new Intent(context, KorisnikActivity.class);
				startActivity(i);
			}
		});

		/*
		 * gumb za otvaranje dialoga za unos racuna
		 */
		Button btnDodajRacun = (Button) findViewById(R.id.btn_dodaj_racun);
		btnDodajRacun.setOnClickListener(

		new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, RacunActivity.class);
				startActivity(i);

			}
		});
		/*
		 * gumb za otvaranje dialoga za postavljanje alarma TODO!!
		 */
		Button btnDodajAlarm = (Button) findViewById(R.id.btn_dodaj_alarm);
		btnDodajAlarm.setOnClickListener(

		new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
	}

	/*
	 * menu, odabir za izlaz iz funkcionalnosti
	 */
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
