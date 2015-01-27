package com.example.moneykeeper;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import db.Kategorija;
import db.Korisnik;
import db.Racun;
import db.Transakcija;

public abstract class IncomeOutcomeControler extends Activity {

	public abstract int getLayout();

	public abstract int getButon();

	public abstract int getDialog();

	public abstract String getNslov();

	public abstract int getVrsta();

	public abstract void toastIt(String msg);

	final Context context = this;
	private Button button;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(getLayout());
		
		// gumb za otvaranje dialoga za unos prihoda novca
		button = (Button) findViewById(getButon());
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// dialog za unos podataka

				final Dialog dialog = new Dialog(context);
				dialog.setContentView(getDialog());
				dialog.setTitle(getNslov());

				// padajuæa lista za odabir moguæih kategorija
				final Spinner sp = (Spinner) dialog
						.findViewById(R.id.spin_KategorijaO);

				List<Kategorija> kat = Kategorija.getKategorije();
				List<String> naziv = new ArrayList<String>();

				StringBuilder builder = new StringBuilder();
				for (Kategorija kategorija : kat) {
					builder.append(kategorija.naziv).append("\n");
					naziv.add(kategorija.naziv);
				}

				final ArrayList<String> list22 = new ArrayList<String>();
				for (int i = 0; i < naziv.size(); ++i) {
					list22.add(naziv.get(i));

				}

				final ArrayAdapter<String> adp = new ArrayAdapter<String>(
						IncomeOutcomeControler.this,
						android.R.layout.simple_dropdown_item_1line, list22);

				adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				sp.setAdapter(adp);

				sp.setOnItemSelectedListener(new OnItemSelectedListener() {

					public String val = null;
					int position = 0;

					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int pos, long arg3) {

						position = pos;
						val = sp.getSelectedItem().toString();
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub

					}
				});

				// padajuæa lista za odabir korisnika
				final Spinner sp1 = (Spinner) dialog
						.findViewById(R.id.spin_KorisnikO);

				List<Korisnik> kor = Korisnik.getKorisnici();
				List<String> ime = new ArrayList<String>();

				StringBuilder builder1 = new StringBuilder();
				for (Korisnik korisnik : kor) {
					builder1.append(korisnik.ime).append("\n");
					ime.add(korisnik.ime);
				}

				final ArrayList<String> list_Kor = new ArrayList<String>();
				for (int i = 0; i < ime.size(); ++i) {
					list_Kor.add(ime.get(i));

				}

				final ArrayAdapter<String> adp1 = new ArrayAdapter<String>(
						IncomeOutcomeControler.this,
						android.R.layout.simple_dropdown_item_1line, list_Kor);

				adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				sp1.setAdapter(adp1);

				sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

					public String val = null;
					int position = 0;

					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int pos, long arg3) {

						position = pos;
						val = sp1.getSelectedItem().toString();
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub

					}
				});

				// gumb za izlaz
				Button dialogButton = (Button) dialog
						.findViewById(R.id.btn_Izlaz1);
				dialogButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
						Intent i = new Intent(context, Transactions.class);
						startActivity(i);
					}
				});

				// gumb za prikaz
				/*
				 * Button prikaz = (Button)
				 * dialog.findViewById(R.id.btn_prikaz);
				 * prikaz.setOnClickListener(new OnClickListener() {
				 * 
				 * @Override public void onClick(View v) {
				 * 
				 * // new Delete().from(Racun.class).execute(); // new
				 * Delete().from(Transakcija.class).execute(); List<Transakcija>
				 * trans = Transakcija.getTransakcions(); StringBuilder builder
				 * = new StringBuilder(); for (Transakcija transakcija : trans)
				 * { if (transakcija.vrsta == getVrsta()) {
				 * 
				 * builder.append("Iznos: ")
				 * .append(transakcija.iznos).append("\n") .append("Opis: ")
				 * .append(transakcija.opis).append("\n") .append("Datum: ")
				 * .append(transakcija.datum).append("\n") .append("Vrijeme: ")
				 * .append(transakcija.vrijeme)
				 * .append("\n").append("Kategorija: ")
				 * .append(transakcija.Kategorija.naziv)
				 * .append("\n").append("Korisnik: ")
				 * .append(transakcija.Korisnik.ime) .append("\n");
				 * 
				 * } } //Toast.makeText(getBaseContext(),
				 * builder.toString(),Toast.LENGTH_LONG).show();
				 * toastIt(builder.toString()); } });
				 */
				// gumb za spremanje unešenih podataka u dialog
				Button spremiButton = (Button) dialog
						.findViewById(R.id.btn_Spremi11);
				spremiButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {

						int iznos = Integer.parseInt(((EditText) dialog
								.findViewById(R.id.txt_IznosO)).getText()
								.toString());
						String opis = ((EditText) dialog
								.findViewById(R.id.txt_OpisO)).getText()
								.toString();
						String datum = ((EditText) dialog
								.findViewById(R.id.txt_DatumO)).getText()
								.toString();

						DigitalClock dc = (DigitalClock) dialog
								.findViewById(R.id.vrijemeTroska);

						String vrijeme = dc.getText().toString();

						String varKategorija = sp.getSelectedItem().toString();
						String varKorisnik = sp1.getSelectedItem().toString();

						if (iznos != 0) {
							Transakcija transakcija = new Transakcija();

							Kategorija katt = new Kategorija();
							katt.naziv = varKategorija;

							List<Kategorija> kk = Kategorija.getKategorije();
							for (Kategorija kategorija : kk) {
								if (kategorija.naziv == varKategorija) {
								} else {
									katt.save();
								}
							}

							Korisnik kor = new Korisnik();
							kor.ime = varKorisnik;

							List<Korisnik> ko = Korisnik.getKorisnici();
							for (Korisnik korisnik : ko) {
								if (korisnik.ime == varKorisnik) {
								} else {
									kor.save();
								}
							}

							transakcija.iznos = iznos;
							transakcija.opis = opis;
							transakcija.datum = datum;
							transakcija.vrijeme = vrijeme;
							transakcija.Kategorija = katt;
							transakcija.Korisnik = kor;
							transakcija.vrsta = getVrsta();
							long a = transakcija.save();

							StringBuilder pom = new StringBuilder();
							pom.append("iznos: ").append(transakcija.iznos)
									.append("\n").append(" opis: ")
									.append(transakcija.opis).append("\n")
									.append(" dat: ").append(transakcija.datum)
									.append("\n").append(" vrijeme: ")
									.append(transakcija.vrijeme).append("\n")
									.append(" kategorija: ")
									.append(transakcija.Kategorija.naziv)
									.append("\n").append(" korisnik: ")
									.append(transakcija.Korisnik.ime)
									.append("\n");

							List<Racun> rac = new ArrayList<Racun>();
							rac = Racun.getRacuni();

							if (getVrsta() == 1) {

								for (Racun racun : rac) {
									racun.iznos = racun.iznos
											+ transakcija.iznos;
									racun.save();
								}

							} else {

								for (Racun racun : rac) {
									racun.iznos = racun.iznos
											- transakcija.iznos;
									racun.save();

								}
							}

							Toast.makeText(
									getBaseContext(),
									a != -1 ? "Dodani su podaci!"
											: "Dogodila se greška!",
									Toast.LENGTH_LONG).show();

							Toast.makeText(getBaseContext(), pom.toString(),
									Toast.LENGTH_LONG).show();
						} else {
							Toast.makeText(getBaseContext(),
									"Podaci nisu dodani!", Toast.LENGTH_LONG)
									.show();
						}

					}
				});
				dialog.show();
			}
		});
	}
	
	
}