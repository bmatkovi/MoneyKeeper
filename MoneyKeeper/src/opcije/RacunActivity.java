package opcije;

import java.util.ArrayList;
import java.util.List;

import transakcije.StableArrayAdapter;

import com.activeandroid.query.Select;
import com.example.moneykeeper.OpcijeControl;
import com.example.moneykeeper.R;
import com.example.moneykeeper.R.id;
import com.example.moneykeeper.R.layout;

import db.Korisnik;
import db.Racun;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class RacunActivity extends OpcijeControl {

	@Override
	public int getLayout() {
		return R.layout.activity_racun;
	}

	@Override
	public int getButtton() {
		return R.id.btnUnesiRacun1;
	}

	@Override
	public int getDialog() {
		// TODO Auto-generated method stub
		return R.layout.dialog_dodaj_racun;
	}

	@Override
	public String getNaslov() {
		// TODO Auto-generated method stub
		return "Podaci o raèunu";
	}



	@Override
	public int getVar1() {
		// TODO Auto-generated method stub
		return R.id.txt_Unesi_Naziv_Racuna;
	}

	@Override
	public int getVar2() {
		// TODO Auto-generated method stub
		return R.id.txt_Opis_Racuna;
	}

	@Override
	public int getVar3() {
		// TODO Auto-generated method stub
		return R.id.txt_Iznos_Racuna;
	}

	

	public void Spremi(Dialog dialog) {
		
		String naziv = ((EditText) dialog
				.findViewById(R.id.txt_Unesi_Naziv_Racuna))
				.getText().toString();
		String opis = ((EditText) dialog
				.findViewById(R.id.txt_Opis_Racuna)).getText()
				.toString();
		int iznos = Integer.parseInt(((EditText) dialog
				.findViewById(R.id.txt_Iznos_Racuna)).getText()
				.toString());

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

			Toast.makeText(
					getBaseContext(),
					a != -1 ? "Dodani su podaci!"
							: "Dogodila se greška!",
					Toast.LENGTH_LONG).show();

			Toast.makeText(getBaseContext(),
					builder.toString(), Toast.LENGTH_LONG)
					.show();

		} else {
			Toast.makeText(getBaseContext(),
					"Podaci nisu dodani!", Toast.LENGTH_LONG)
					.show();
		}
		
	}

	public void Prikaz() {
		
		
		 // Delete().from(Kategorija.class).execute();
		// Racun rac = new Racun();
		
		List<Racun> rac =Racun.getRacuni();
	 
		StringBuilder builder = new StringBuilder(); 
		for (Racun racun : rac) {
		  builder.append("Naziv: ").append(racun.naziv)
		  .append("\n").append("Opis: ")
		  .append(racun.opis).append("\n")
		  .append("Iznos")
		  .append(racun.iznos).append("\n")
		  ;
		  }
		  Toast.makeText(getBaseContext(), builder.toString(),
		  Toast.LENGTH_LONG).show();
		  
		
	}

	@Override
	public void Ispis() {
		
		List<Racun> rac = Racun.getRacuni();
		final List<String> naziv =  new ArrayList<String>();

		// prikaz racuna	
		StringBuilder builder = new StringBuilder();
		for (Racun racun : rac) {
			//builder.append(racun.naziv).append("\n");
			naziv.add("Naziv raèuna: "+ racun.naziv+"\n"+"Opis: "+racun.opis + "\n"+"Iznos: "+ racun.iznos);
		}

		final ListView listview1 = (ListView) findViewById(R.id.listviewRac);
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
	
	


