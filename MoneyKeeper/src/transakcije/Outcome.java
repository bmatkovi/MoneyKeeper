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

public class Outcome extends IncomeOutcomeControler {

	/*
	 * metoda za dohva�anje layouta za klasu Outcomekoji se proslje�uje
	 * IncomeOutcomeControleru
	 */
	public int getLayout() {
		return R.layout.activity_outcome;
	}

	/*
	 * metoda za dohva�anje buttona za klasu Outcomekoji se proslje�uje
	 * IncomeOutcomeControleru
	 */
	@Override
	public int getButon() {
		return R.id.btn_Out;
	}

	/*
	 * metoda za dohva�anje dialoga za klasu Outcomekoji se proslje�uje
	 * IncomeOutcomeControleru
	 */
	@Override
	public int getDialog() {
		return R.layout.dialog_unesi_trosak;
	}

	/*
	 * metoda za dohva�anje naslova za dialog za klasu Incomekoji se proslje�uje
	 * IncomeOutcomeControleru
	 */
	@Override
	public String getNslov() {
		return "Unos tro�kova";
	}

	/*
	 * metoda za dohva�anje oznake vrste transakcije za klasu Outcomekoji se
	 * proslje�uje IncomeOutcomeControleru
	 */
	@Override
	public int getVrsta() {
		return 0;
	}

	/*
	 * metoda za toastkoji se proslje�uje IncomeOutcomeControleru
	 */
	@Override
	public void toastIt(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}

}
