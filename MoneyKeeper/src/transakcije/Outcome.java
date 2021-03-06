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
	 * metoda za dohvaćanje layouta za klasu Outcomekoji se prosljeđuje
	 * IncomeOutcomeControleru
	 */
	public int getLayout() {
		return R.layout.activity_outcome;
	}

	/*
	 * metoda za dohvaćanje buttona za klasu Outcomekoji se prosljeđuje
	 * IncomeOutcomeControleru
	 */
	@Override
	public int getButon() {
		return R.id.btn_Out;
	}

	/*
	 * metoda za dohvaćanje dialoga za klasu Outcomekoji se prosljeđuje
	 * IncomeOutcomeControleru
	 */
	@Override
	public int getDialog() {
		return R.layout.dialog_unesi_trosak;
	}

	/*
	 * metoda za dohvaćanje naslova za dialog za klasu Incomekoji se prosljeđuje
	 * IncomeOutcomeControleru
	 */
	@Override
	public String getNslov() {
		return "Unos troškova";
	}

	/*
	 * metoda za dohvaćanje oznake vrste transakcije za klasu Outcomekoji se
	 * prosljeđuje IncomeOutcomeControleru
	 */
	@Override
	public int getVrsta() {
		return 0;
	}

	/*
	 * metoda za toastkoji se prosljeđuje IncomeOutcomeControleru
	 */
	@Override
	public void toastIt(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}

}
