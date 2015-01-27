package com.example.moneykeeper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.R.layout;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.activeandroid.query.Select;

import db.Racun;
import db.Transakcija;

@SuppressLint("NewApi")
public class TransactionActivity extends TransakcijeControler {

	//public int getLayout() {
	//	return R.layout.activity_transaction;
	

		private void MakeAdapter(String tipe, String name, layout lay, String var) {
		/*	
			ArrayAdapter<tipe> name = new ArrayAdapter<tipe>(
					this, R.layout.lay, R.id.label, var);
			return name;
		}
		*/
		Racun rac = new Racun();
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
		ArrayList<Integer> list1 = new ArrayList<Integer>();

		List<Transakcija> promet = new Select().all().from(Transakcija.class)
				.execute();
		// stanje = new Delete().from(Racun.class).execute();

		StringBuilder builder1 = new StringBuilder();
		for (Transakcija tr : promet) {
			 if (tr.vrsta==1){
			builder1.append("Iznos").append(tr.iznos).append("\n");
			list1.add(tr.iznos);
			 }
		}

		final ListView listview1 = (ListView) findViewById(R.id.listviewTransI);

		final ArrayList<String> list11 = new ArrayList<String>();
		for (int i = 0; i < list1.size(); i++) {
			list11.add("Iznos: " + (list1.get(i)).toString());

		}

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
		
		//lista odljeva novca 
		  ArrayList<Integer> iznosi = new  ArrayList<Integer>();
		  
		  List<Transakcija> promet1 = new
		  Select().all().from(Transakcija.class).execute(); 
		  // stanje = new Delete().from(Racun.class).execute();
		  
		  StringBuilder builder11 = new StringBuilder(); for (Transakcija tr :
		  promet1) { if (tr.vrsta==0){
		  builder11.append("Iznos").append(tr.iznos).append("\n");
		  iznosi.add(tr.iznos); } }
		  
		  final ListView listview11 = (ListView)
		  findViewById(R.id.listviewTransO);
		  
		  final ArrayList<String> ispis = new ArrayList<String>(); for (int i =
		  0; i < iznosi.size(); i++) {
		  ispis.add("Iznos: "+(iznosi.get(i)).toString());
		  
		  }
		 
		  final StableArrayAdapter adapterC = new StableArrayAdapter(this,
		  android.R.layout.simple_list_item_1, ispis);
		  listview11.setAdapter(adapterC);
		 
		  listview11.setOnItemClickListener(new
		  AdapterView.OnItemClickListener() {
		  
		  @Override public void onItemClick(AdapterView<?> parent, final View
		  view, int position, long id) { final String item = (String)
		  parent.getItemAtPosition(position);
		  view.animate().setDuration(2000).alpha(0) .withEndAction(new
		  Runnable() {
		  
		  @Override public void run() { ispis.remove(item);
		  adapterC.notifyDataSetChanged(); view.setAlpha(1); } }); } });
		 

		

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
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public int getLayout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void toastIt(String msg) {
		// TODO Auto-generated method stub
		
	};

}

class StableArrayAdapter extends ArrayAdapter<String> {

	HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	public StableArrayAdapter(Context context, int textViewResourceId,
			List<String> objects) {
		super(context, textViewResourceId, objects);
		for (int i = 0; i < objects.size(); ++i) {
			mIdMap.put(objects.get(i), i);
		}
	}

	@Override
	public long getItemId(int position) {
		String item = getItem(position);
		return mIdMap.get(item);
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

}