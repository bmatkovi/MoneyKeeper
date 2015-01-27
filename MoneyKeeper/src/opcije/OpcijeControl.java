package opcije;

import java.util.ArrayList;
import java.util.List;

import com.activeandroid.query.Select;
import com.example.moneykeeper.R;
import com.example.moneykeeper.R.id;

import db.Kategorija;
import db.Korisnik;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public abstract class OpcijeControl extends Activity {

	public abstract int getLayout();

	public abstract int getButtton();

	public abstract int getDialog();

	public abstract String getNaslov();

	public abstract int getVar1();

	public abstract int getVar2();

	public abstract int getVar3();

	public abstract void Spremi(Dialog dialog);

	public abstract void Prikaz();

	public abstract void Ispis();

	final Context context = this;
	private Button button;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(getLayout());
		getActionBar().setDisplayHomeAsUpEnabled(true);


		Ispis();
		
		 /*
		* gumb za otvaranje dialoga za unos kor. podataka
		* */
		button = (Button) findViewById(getButtton());

		button.setOnClickListener(new OnClickListener() {

			private TextView text1;
			private TextView text2;
			private TextView text3;

			@Override
			public void onClick(View arg0) {

				final Dialog dialog = new Dialog(context);
				dialog.setContentView(getDialog());
				dialog.setTitle(getNaslov());

				text1 = (TextView) dialog.findViewById(getVar1());

				text2 = (TextView) dialog.findViewById(getVar2());

				text3 = (TextView) dialog.findViewById(getVar3());

				Button dialogButton = (Button) dialog
						.findViewById(R.id.btnIzlaz1);
				dialogButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
						Intent i = new Intent(context, SettingsActivity.class);
						startActivity(i);
					}
				});
				
				/*
				* gumb za spremanje unešenih podataka
				*/
				Button spremiButton = (Button) dialog
						.findViewById(R.id.btnSpremi11);
				spremiButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {

						Spremi(dialog);
						
					}
				});

				dialog.show();
			}
		});

	}
	/*
	 * menu, biranje za izlaz
	 */
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
