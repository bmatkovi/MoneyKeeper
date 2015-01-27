package kategorije;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.query.Delete;
import com.activeandroid.query.From;
import com.activeandroid.query.Select;
import com.example.moneykeeper.R;
import com.example.moneykeeper.R.id;
import com.example.moneykeeper.R.layout;

import db.Kategorija;
import db.VrstaKategorije;

public class CategoryActivity extends Activity {

	/*
	 * Kreiranje aktivnosti category, koja omogućuje kreiranje nove kategorije
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		final Context context = this;
		/*
		 * kreiranje actionbara za navigaciju back, prema CategoriesActivity i
		 */
		getActionBar().setDisplayHomeAsUpEnabled(true);

		/*
		 * gumb za spremanje unešenih podataka o novoj kategoriji
		 */
		Button btnSpremiKategoriju = (Button) findViewById(R.id.btnSpremiKategoriju);
		btnSpremiKategoriju.setOnClickListener(

		/*
		 * Kreiranje onClick listenera, koji prepoznaje odgovarajuće elemente na
		 * activity_category
		 */
		new OnClickListener() {
			@Override
			public void onClick(View v) {

				String nazivKategorije = ((EditText) findViewById(R.id.editTextUnesi_Kategoriju))
						.getText().toString();

				String opisKategorije = ((EditText) findViewById(R.id.editTextOpisKategorije))
						.getText().toString();

				/*
				 * Spremanje nove kategorije u bazu s odgovarajućom toast
				 * porukom
				 */
				if (nazivKategorije != null && nazivKategorije.trim() != "") {
					Kategorija kategorija = new Kategorija();

					kategorija.naziv = nazivKategorije;
					kategorija.opis = opisKategorije;
					kategorija.VrstaKategorije = null;
					kategorija.favorit = null;
					long a = kategorija.save();

					Toast.makeText(
							getBaseContext(),
							a != -1 ? "Dodana je kategorija!"
									: "Dogodila se greška!", Toast.LENGTH_LONG)
							.show();

				} else {
					Toast.makeText(getBaseContext(), "Kategorije nije dodana!",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	/*
	 * Kreiranje back gumba na action navigation tabu
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		// Respond to the action bar's Up/Home button
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
