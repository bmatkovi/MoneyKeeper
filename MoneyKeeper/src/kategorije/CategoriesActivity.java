package kategorije;

import java.util.ArrayList;
import java.util.List;

import com.example.moneykeeper.MainActivity;
import com.example.moneykeeper.R;
import com.example.moneykeeper.R.id;
import com.example.moneykeeper.R.layout;

import android.R.string;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import db.Kategorija;

public class CategoriesActivity extends ListActivity {

	/*
	 * Kreiranje aktivnosti kategorija, koja prikazuje u listViewu sve
	 * katergorije, omogućuje dodavanje novih u optionMenu
	 */
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		/*
		 * kreiranje actionbara za navigaciju back, prema MainActivity i
		 */
		getActionBar().setDisplayHomeAsUpEnabled(true);

		/*
		 * dohvaćanje kategorija iz baze i spremanje u listu
		 */
		List<Kategorija> kat = Kategorija.getKategorije();
		List<String> naziv = new ArrayList<String>();
		List<String> vrstaKategorije = new ArrayList<String>();

		/*
		 * prikaz odabranih atributa u obliku stringa
		 */
		StringBuilder builder = new StringBuilder();
		for (Kategorija kategorija : kat) {
			builder.append(kategorija.naziv).append("\n");
			naziv.add(kategorija.naziv);
		}

		/*
		 * Kreiranje array adaptera, koji se prosljeđuje za prikaz u listViewu
		 */
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.activity_categories, R.id.label, naziv);
		setListAdapter(adapter);

	}

	/*
	 * onClick listener za listView, koji u toastu vraća označenu vrijednost
	 * TODO
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		Kategorija kat = new Kategorija();

		Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();

	}

	/*
	 * kreiranje option gumba i njegovih itema
	 */

	public static final int KATEGORIJA = Menu.FIRST;
	public static final int ZATVORI = Menu.FIRST + 1;

	/*
	 * kreiranje menija, prikaz gumbova za dodavanje nove kategorije i izlaza
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		menu.add(Menu.NONE, KATEGORIJA, Menu.NONE, "Nova kategorija");
		menu.add(Menu.NONE, ZATVORI, Menu.NONE, "Izlaz");

		return true;
	}

	/*
	 * prikaz gumbova u action navigation tabu
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case KATEGORIJA:
			Intent categoryActivity = new Intent(this, CategoryActivity.class);
			this.startActivity(categoryActivity);
			return true;
		case ZATVORI:
			Intent mainActivity = new Intent(this, MainActivity.class);
			this.startActivity(mainActivity);
			return true;

		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
