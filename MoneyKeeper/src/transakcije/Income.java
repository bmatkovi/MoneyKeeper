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
	 * metoda za dohva�anje layouta za klasu Incomekoji se proslje�uje
	 * IncomeOutcomeControleru
	 */
	public int getLayout() {
		return R.layout.activity_income;
	}

	/*
	 * metoda za dohva�anje buttona za klasu Incomekoji se proslje�uje
	 * IncomeOutcomeControleru
	 */
	public int getButon() {
		return R.id.btn_Inc;
	}

	/*
	 * metoda za dohva�anje dialoga za klasu Incomekoji se proslje�uje
	 * IncomeOutcomeControleru
	 */
	@Override
	public int getDialog() {
		return R.layout.dialog_unesi_dohodak;
	}

	/*
	 * metoda za dohva�anje naslova za dialog za klasu Incomekoji se proslje�uje
	 * IncomeOutcomeControleru
	 */
	@Override
	public String getNslov() {
		return "Unos prihoda";
	}

	/*
	 * metoda za dohva�anje oznake vrste transakcije za klasu Incomekoji se
	 * proslje�uje IncomeOutcomeControleru
	 */
	@Override
	public int getVrsta() {
		return 1;
	}

	/*
	 * metoda za toastkoji se proslje�uje IncomeOutcomeControleru
	 */
	public void toastIt(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}

}