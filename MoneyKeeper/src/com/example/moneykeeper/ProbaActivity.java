package com.example.moneykeeper;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import db.Kategorija;

public class ProbaActivity extends ListActivity {
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		
		List<Kategorija> kat = Kategorija.getKategorije();

		List<String> naziv =  new ArrayList<String>();
		/*
		// prikaz odabranih atributa u obliku stringa
				StringBuilder builder = new StringBuilder();
				for (Kategorija kategorija : kat) {
					builder.append(kategorija.naziv).append("\n");
					naziv.add(kategorija.naziv);
				}

				ArrayAdapter<String> adaptera = new ArrayAdapter<String>(this,
						R.layout.activity_categories, R.id.label, naziv);
				setListAdapter(adaptera);
		*/
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2" };
		MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);
		setListAdapter(adapter);
	}
}