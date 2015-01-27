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

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		final Context context = this;

	    getActionBar().setDisplayHomeAsUpEnabled(true);
		

		// gumb za spremanje une�enih podataka o novoj kategoriji
		Button btnSpremiKategoriju = (Button) findViewById(R.id.btnSpremiKategoriju);
		btnSpremiKategoriju.setOnClickListener(

		new OnClickListener() {
			@Override
			public void onClick(View v) {

				String nazivKategorije = ((EditText) findViewById(R.id.editTextUnesi_Kategoriju))
						.getText().toString();

				String opisKategorije = ((EditText) findViewById(R.id.editTextOpisKategorije))
						.getText().toString();

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
									: "Dogodila se gre�ka!", Toast.LENGTH_LONG)
							.show();

				} else {
					Toast.makeText(getBaseContext(), "Kategorije nije dodana!",
							Toast.LENGTH_LONG).show();
				}
			}
		});

		// gumb za prikaz kategorija
		/*
		Button btnPrikazKategorija = (Button) findViewById(R.id.btnPrikazKategorija);
		btnPrikazKategorija.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// new Delete().from(Kategorija.class).execute();

				List<Kategorija> kat = null;
				kat = new Select().all().from(Kategorija.class).execute();
				StringBuilder builder = new StringBuilder();
				for (Kategorija kategorija : kat) {
					builder.append("Naziv: ").append(kategorija.naziv)
							.append("\n").append("Opis: ")
							.append(kategorija.opis).append("\n");
				}
				Toast.makeText(getBaseContext(), builder.toString(),
						Toast.LENGTH_LONG).show();
			}
		});
		*/
	}
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