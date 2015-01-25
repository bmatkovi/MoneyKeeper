package com.example.moneykeeper;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.activeandroid.query.Select;
import db.Korisnik;

@SuppressLint("NewApi")
public class KorisnikActivity  extends OpcijeControl{

	@Override
	public int getLayout() {
		// TODO Auto-generated method stub
		return R.layout.activity_korisnik;
	}

	@Override
	public int getButtton() {
		// TODO Auto-generated method stub
		return R.id.btnUnesiKorisnika;
	}

	@Override
	public int getDialog() {
		// TODO Auto-generated method stub
		return R.layout.dialog_dodaj_korisnika;
	}

	@Override
	public String getNaslov() {
		// TODO Auto-generated method stub
		return "Korisniæki podaci";
	}


	@Override
	public int getVar1() {
		// TODO Auto-generated method stub
		return R.id.txt_Unesi_Naziv_Racuna;
	}

	@Override
	public int getVar2() {
		// TODO Auto-generated method stub
		return R.id.txt_UnesiPrezime;
	}

	@Override
	public int getVar3() {
		// TODO Auto-generated method stub
		return R.id.txt_Lozinka;
	}



	@Override
	public void Spremi(Dialog dialog) {
	
		String ime = ((EditText) dialog
				.findViewById(R.id.txt_Unesi_Naziv_Racuna))
				.getText().toString();
		String prezime = ((EditText) dialog
				.findViewById(R.id.txt_UnesiPrezime)).getText()
				.toString();
		String lozinka = ((EditText) dialog
				.findViewById(R.id.txt_Lozinka)).getText()
				.toString();

		if (ime != null && ime.trim() != "") {
			Korisnik korisnik = new Korisnik();

			korisnik.ime = ime;
			korisnik.prezime = prezime;
			korisnik.lozinka = lozinka;
			long a = korisnik.save();

			Toast.makeText(
					getBaseContext(),
					a != -1 ? "Dodani su podaci!"
							: "Dogodila se greška!",
					Toast.LENGTH_LONG).show();

		} else {
			Toast.makeText(getBaseContext(),
					"Podaci nisu dodani!", Toast.LENGTH_LONG)
					.show();
		}

		
	}

	public void Prikaz() {
		
		List<Korisnik> kat = null;
		kat = new Select().all().from(Korisnik.class).execute();

		StringBuilder builder = new StringBuilder();
		for (Korisnik kategorija : kat) {
			builder.append("ime: ").append(kategorija.ime)
					.append(" prezime: ")
					.append(kategorija.prezime)
					.append(" loz: ")
					.append(kategorija.lozinka).append("\n");
		}

		
		Toast.makeText(getBaseContext(), builder.toString(),
				Toast.LENGTH_LONG).show();
		// new Delete().from(Korisnik.class).execute();
	}

	@Override
	public void Ispis() {
	
		
		List<Korisnik> kor = Korisnik.getKorisnici();
		final List<String> naziv =  new ArrayList<String>();

		// prikaz korisnika		
		StringBuilder builder = new StringBuilder();
		for (Korisnik korisnik : kor) {
			builder.append(korisnik.ime).append("\n");
			naziv.add(korisnik.ime+" "+korisnik.prezime);
		}

		final ListView listview1 = (ListView) findViewById(R.id.listviewKor);
		final StableArrayAdapter adapter1 = new StableArrayAdapter(this,android.R.layout.simple_list_item_1, naziv);
		listview1.setAdapter(adapter1);
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> parent, final View view,
								int position, long id) {
							final String item = (String) parent.getItemAtPosition(position);
							view.animate().setDuration(2000).alpha(0)
									.withEndAction(new Runnable() {
										@Override
										public void run() {
											naziv.remove(item);
											adapter1.notifyDataSetChanged();
											view.setAlpha(1);
										}
									});
						}
					});
	
	}
	
	
	}

	
	

	


