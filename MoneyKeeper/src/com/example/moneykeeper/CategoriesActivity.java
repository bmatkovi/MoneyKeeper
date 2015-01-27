package com.example.moneykeeper;

import java.util.ArrayList;
import java.util.List;

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

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

	    getActionBar().setDisplayHomeAsUpEnabled(true);

		
		// dohvaæanje kategorija iz baze i spremanje u listu
		List<Kategorija> kat = Kategorija.getKategorije();

		List<String> naziv =  new ArrayList<String>();

		// prikaz odabranih atributa u obliku stringa
		StringBuilder builder = new StringBuilder();
		for (Kategorija kategorija : kat) {
			builder.append(kategorija.naziv).append("\n");
			naziv.add(kategorija.naziv);
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.activity_categories, R.id.label, naziv);
		setListAdapter(adapter);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		Kategorija kat = new Kategorija(); 
		//new Delete().from(Kategorija.class).where("idKategorije= ?", kat.getIdKategorije()).executeSingle();
		Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
	}

	// kreiranje option gumba i njegovih itema
	public static final int KATEGORIJA = Menu.FIRST;
	public static final int ZATVORI = Menu.FIRST+1;

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		menu.add(Menu.NONE, KATEGORIJA, Menu.NONE, "Nova kategorija");
		menu.add(Menu.NONE, ZATVORI, Menu.NONE, "Izlaz");

		return true;
	}

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
