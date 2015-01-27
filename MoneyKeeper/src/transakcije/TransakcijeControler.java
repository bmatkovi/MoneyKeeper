package transakcije;

import java.util.ArrayList;
import java.util.List;

import com.example.moneykeeper.R;
import com.example.moneykeeper.R.id;
import com.example.moneykeeper.R.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import db.Racun;
import db.Transakcija;

@SuppressLint("NewApi")
public abstract class TransakcijeControler extends Activity {

	public abstract int getLayout();

	public abstract void init();

	public abstract void toastIt(String msg);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayout());
		// init();
		final Context context = this;
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// dohvaæanje transakcija iz baze podataka

		List<Transakcija> kat = Transakcija.getTransakcions();

		List<String> opis = null;
		opis = new ArrayList<String>();

		// pretvaranje liste transakcija u string, ovisno o atributima
		StringBuilder builderTransakcija = new StringBuilder();
		for (Transakcija transakcija : kat) {
			builderTransakcija.append(transakcija.opis).append("\n");
			opis.add(transakcija.opis);
		}

		ArrayAdapter<String> adapterTransakcija = new ArrayAdapter<String>(
				this, R.layout.activity_transaction, R.id.label, opis);

		List<Racun> stanje = Racun.getRacuni();
		// stanje = new Delete().from(Racun.class).execute();

		StringBuilder builder = new StringBuilder();
		for (Racun racun : stanje) {
			builder.append(racun.iznos).append("\n");

		}

		final ListView listview = (ListView) findViewById(R.id.listview);

		final ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < stanje.size(); ++i) {
			list.add(builder.toString());

		}

		final StableArrayAdapter adapter = new StableArrayAdapter(this,
				android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {
				final String item = (String) parent.getItemAtPosition(position);
				view.animate().setDuration(2000).alpha(0)
						.withEndAction(new Runnable() {
							@Override
							public void run() {
								list.remove(item);
								adapter.notifyDataSetChanged();
								view.setAlpha(1);
							}
						});
			}

		});

		// lista priljeva novca
		List<Transakcija> promet = Transakcija.getTransakcions();
		final ArrayList<String> list11 = new ArrayList<String>();

		StringBuilder builder1 = new StringBuilder();
		for (Transakcija tr : promet) {
			if (tr.vrsta == 1) {
				builder1.append("Iznos: ").append(tr.iznos)
				// .append("\n")
						.append(" Opis: ").append(tr.opis)
						// .append("\n")
						.append(" Kategorija: ")
						// .append(tr.Kategorija.naziv)
						.append("\n");

				list11.add("Iznos: " + tr.iznos + "\n" + "Opis: " + tr.opis
						+ "\n" + "Kategorija: " + tr.Kategorija.naziv);
			}

		}

		final ListView listview1 = (ListView) findViewById(R.id.listviewTransI);

		final StableArrayAdapter adapter1 = new StableArrayAdapter(this,
				android.R.layout.simple_list_item_1, list11);
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
								list11.remove(item);
								adapter1.notifyDataSetChanged();
								view.setAlpha(1);
							}
						});
			}
		});

		// lista odljeva novca
		// ArrayList<Integer> iznosi = new ArrayList<Integer>();

		List<Transakcija> promet1 = Transakcija.getTransakcions();
		// stanje = new Delete().from(Racun.class).execute();

		final ArrayList<String> listO = new ArrayList<String>();

		StringBuilder builder11 = new StringBuilder();
		for (Transakcija tr : promet1) {
			if (tr.vrsta == 0) {
				builder11.append("Iznos: ").append(tr.iznos)
				// .append("\n")
						.append(" Opis: ").append(tr.opis)
						// .append("\n")
						.append("Kategorija: ")
						// .append(tr.Kategorija.naziv)
						.append("\n");
				listO.add("Iznos: " + tr.iznos + "\n" + "Opis: " + tr.opis
						+ "\n" + "Kategorija: " + tr.Kategorija.naziv);
			}// +"\n"+"Kategorija: "+tr.Kategorija.naziv.toString()+"\n"

		}

		final ListView listview11 = (ListView) findViewById(R.id.listviewTransO);

		// final ArrayList<String> ispis = new ArrayList<String>();
		// for (int i =0; i < builder11.length(); i++) {

		// ispis.add(builder11.toString());
		// ispis.add("Iznos: "+(iznosi.get(i)).toString());

		// }

		final StableArrayAdapter adapterC = new StableArrayAdapter(this,
				android.R.layout.simple_list_item_1, listO);
		listview11.setAdapter(adapterC);

		listview11
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent,
							final View view, int position, long id) {
						final String item = (String) parent
								.getItemAtPosition(position);
						view.animate().setDuration(2000).alpha(0)
								.withEndAction(new Runnable() {

									@Override
									public void run() {
										listO.remove(item);
										adapterC.notifyDataSetChanged();
										view.setAlpha(1);
									}
								});
					}
				});

	}

	// kreiranje option menija sa definiranim itemima
	public static final int PRIHOD = Menu.FIRST;
	public static final int RASHOD = Menu.FIRST + 1;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		menu.add(Menu.NONE, PRIHOD, Menu.NONE, "Novi prihod");
		menu.add(Menu.NONE, RASHOD, Menu.NONE, "Novi rashod");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case PRIHOD:
			Intent incomeActivity = new Intent(this, Income.class);
			this.startActivity(incomeActivity);
			return true;

		case RASHOD:
			Intent outcomeActivity = new Intent(this, Outcome.class);
			this.startActivity(outcomeActivity);
			return true;

		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	};

}
