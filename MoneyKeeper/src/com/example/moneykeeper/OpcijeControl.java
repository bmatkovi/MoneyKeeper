package com.example.moneykeeper;

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
		 * // dohvaæanje kategorija iz baze i spremanje u listu List<Kategorija>
		 * kat = Kategorija.getKategorije();
		 * 
		 * List<String> naziv = new ArrayList<String>();
		 * 
		 * // prikaz odabranih atributa u obliku stringa StringBuilder builder =
		 * new StringBuilder(); for (Kategorija kategorija : kat) {
		 * builder.append(kategorija.naziv).append("\n");
		 * naziv.add(kategorija.naziv); }
		 * 
		 * ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		 * R.layout.activity_categories, R.id.label, naziv);
		 * setListAdapter(adapter);
		 * 
		 * }
		 * 
		 * @Override protected void onListItemClick(ListView l, View v, int
		 * position, long id) { String item = (String)
		 * getListAdapter().getItem(position); Kategorija kat = new
		 * Kategorija(); //new
		 * Delete().from(Kategorija.class).where("idKategorije= ?",
		 * kat.getIdKategorije()).executeSingle(); Toast.makeText(this, item +
		 * " selected", Toast.LENGTH_LONG).show(); }
		 */
		// gumb za otvaranje dialoga za unos kor. podataka
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

				// gumb za spremanje unešenih podataka
				Button spremiButton = (Button) dialog
						.findViewById(R.id.btnSpremi11);
				spremiButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {

						Spremi(dialog);
						/*
						 * 
						 * 
						 * String ime = ((EditText) dialog
						 * .findViewById(R.id.txt_Unesi_Naziv_Racuna))
						 * .getText().toString(); String prezime = ((EditText)
						 * dialog
						 * .findViewById(R.id.txt_UnesiPrezime)).getText()
						 * .toString(); String lozinka = ((EditText) dialog
						 * .findViewById(R.id.txt_Lozinka)).getText()
						 * .toString();
						 * 
						 * if (ime != null && ime.trim() != "") { Korisnik
						 * korisnik = new Korisnik();
						 * 
						 * korisnik.ime = ime; korisnik.prezime = prezime;
						 * korisnik.lozinka = lozinka; long a = korisnik.save();
						 * 
						 * Toast.makeText( getBaseContext(), a != -1 ?
						 * "Dodani su podaci!" : "Dogodila se greška!",
						 * Toast.LENGTH_LONG).show();
						 * 
						 * } else { Toast.makeText(getBaseContext(),
						 * "Podaci nisu dodani!", Toast.LENGTH_LONG) .show(); }
						 */
					}
				});

				// gumb za prikaz podataka
				/*
				 * Button prikaz = (Button)
				 * dialog.findViewById(R.id.btnPrikaz111);
				 * prikaz.setOnClickListener(new OnClickListener() {
				 * 
				 * @Override public void onClick(View v) {
				 * 
				 * Prikaz(); /*
				 * 
				 * List<Korisnik> kat = null; kat = new
				 * Select().all().from(Korisnik.class).execute();
				 * 
				 * StringBuilder builder = new StringBuilder(); for (Korisnik
				 * kategorija : kat) {
				 * builder.append("ime: ").append(kategorija.ime)
				 * .append(" prezime: ") .append(kategorija.prezime)
				 * .append(" loz: ") .append(kategorija.lozinka).append("\n"); }
				 * 
				 * 
				 * Toast.makeText(getBaseContext(), builder.toString(),
				 * Toast.LENGTH_LONG).show(); // new
				 * Delete().from(Korisnik.class).execute();
				 *//*
					 * }
					 * 
					 * 
					 * });
					 */

				dialog.show();
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
	}

}
