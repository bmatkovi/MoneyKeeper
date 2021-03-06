package transakcije;

import java.util.ArrayList;
import java.util.List;
import com.example.moneykeeper.R;
import com.example.moneykeeper.R.id;
import com.example.moneykeeper.R.layout;
import db.Racun;
import db.Transakcija;
import android.app.Dialog;
import android.widget.Toast;

public class Income extends IncomeOutcomeControler {

	/*
	 * metoda za dohvaćanje layouta za klasu Incomekoji se prosljeđuje
	 * IncomeOutcomeControleru
	 */
	public int getLayout() {
		return R.layout.activity_income;
	}

	/*
	 * metoda za dohvaćanje buttona za klasu Incomekoji se prosljeđuje
	 * IncomeOutcomeControleru
	 */
	public int getButon() {
		return R.id.btn_Inc;
	}

	/*
	 * metoda za dohvaćanje dialoga za klasu Incomekoji se prosljeđuje
	 * IncomeOutcomeControleru
	 */
	@Override
	public int getDialog() {
		return R.layout.dialog_unesi_dohodak;
	}

	/*
	 * metoda za dohvaćanje naslova za dialog za klasu Incomekoji se prosljeđuje
	 * IncomeOutcomeControleru
	 */
	@Override
	public String getNslov() {
		return "Unos prihoda";
	}

	/*
	 * metoda za dohvaćanje oznake vrste transakcije za klasu Incomekoji se
	 * prosljeđuje IncomeOutcomeControleru
	 */
	@Override
	public int getVrsta() {
		return 1;
	}

	/*
	 * metoda za toastkoji se prosljeđuje IncomeOutcomeControleru
	 */
	public void toastIt(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}

}