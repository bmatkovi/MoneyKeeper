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
	 * metoda za dohvaæanje layouta za klasu Incomekoji se prosljeðuje
	 * IncomeOutcomeControleru
	 */
	public int getLayout() {
		return R.layout.activity_income;
	}

	/*
	 * metoda za dohvaæanje buttona za klasu Incomekoji se prosljeðuje
	 * IncomeOutcomeControleru
	 */
	public int getButon() {
		return R.id.btn_Inc;
	}

	/*
	 * metoda za dohvaæanje dialoga za klasu Incomekoji se prosljeðuje
	 * IncomeOutcomeControleru
	 */
	@Override
	public int getDialog() {
		return R.layout.dialog_unesi_dohodak;
	}

	/*
	 * metoda za dohvaæanje naslova za dialog za klasu Incomekoji se prosljeðuje
	 * IncomeOutcomeControleru
	 */
	@Override
	public String getNslov() {
		return "Unos prihoda";
	}

	/*
	 * metoda za dohvaæanje oznake vrste transakcije za klasu Incomekoji se
	 * prosljeðuje IncomeOutcomeControleru
	 */
	@Override
	public int getVrsta() {
		return 1;
	}

	/*
	 * metoda za toastkoji se prosljeðuje IncomeOutcomeControleru
	 */
	public void toastIt(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}

}