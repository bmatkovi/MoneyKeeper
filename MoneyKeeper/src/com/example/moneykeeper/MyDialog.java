package com.example.moneykeeper;

import java.util.List;

import com.activeandroid.query.Select;
import com.activeandroid.util.Log;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import db.Korisnik;
import db.Racun;

public class MyDialog {

	private Dialog dialog;
	private Activity activity;

	public MyDialog(Activity activity) {
		this.activity = activity;
	}

	public void displayDialog(OnClickListener onClickListener) {
		dialog = new Dialog(activity);
		dialog.setContentView(View.inflate(activity,
				R.layout.dialog_dodaj_korisnika, null));
		Button btnSpremi = (Button) dialog.findViewById(R.id.btnSpremi11);

		String ime = ((EditText) dialog
				.findViewById(R.id.txt_Unesi_Naziv_Racuna)).getText()
				.toString();
		String prezime = ((EditText) dialog.findViewById(R.id.txt_UnesiPrezime))
				.getText().toString();
		String lozinka = ((EditText) dialog.findViewById(R.id.txt_Lozinka))
				.getText().toString();

		if (ime != null && ime.trim() != "") {
			Korisnik korisnik = new Korisnik();

			korisnik.ime = ime;
			korisnik.prezime = prezime;
			korisnik.lozinka = lozinka;
			long a = korisnik.save();
			Log.d("MYTAG", "a = " + a);
		}

		btnSpremi.setOnClickListener(onClickListener);

		dialog.show();
	}

	public void displayRacun(OnClickListener onClickListener) {
		dialog = new Dialog(activity);
		dialog.setContentView(View.inflate(activity,
				R.layout.dialog_dodaj_racun, null));
		Button btnSpremi = (Button) dialog.findViewById(R.id.btnSpremi11);

		String naziv = ((EditText) dialog
				.findViewById(R.id.txt_Unesi_Naziv_Racuna)).getText()
				.toString();
		String opis = ((EditText) dialog.findViewById(R.id.txt_Opis_Racuna))
				.getText().toString();
		int iznos = Integer.parseInt(((EditText) dialog
				.findViewById(R.id.txt_Iznos_Racuna)).getText().toString());

		if (naziv != null && naziv.trim() != "") {
			Racun racun = new Racun();

			racun.naziv = naziv;
			racun.opis = opis;
			racun.iznos = iznos;
			long a = racun.save();

			List<Racun> kat = null;
			kat = new Select().all().from(Racun.class)
					.execute();
			StringBuilder builder = new StringBuilder();
			for (Racun racun1 : kat) {
				builder.append("Naziv: ").append(racun1.naziv)
						.append("\n").append("Opis: ")
						.append(racun1.opis).append("\n")
						.append("Iznos: ").append(racun1.iznos)
						.append("\n");

			}
		}
		btnSpremi.setOnClickListener(onClickListener);

		dialog.show();
	}

	public Dialog getDialog() {
		return dialog;
	}

}
