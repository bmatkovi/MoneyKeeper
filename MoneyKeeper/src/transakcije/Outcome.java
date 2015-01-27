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
	 * metoda za dohvaæanje layouta za klasu Outcomekoji se prosljeðuje
	 * IncomeOutcomeControleru
	 */
	public int getLayout() {
		return R.layout.activity_outcome;
	}

	/*
	 * metoda za dohvaæanje buttona za klasu Outcomekoji se prosljeðuje
	 * IncomeOutcomeControleru
	 */
	@Override
	public int getButon() {
		return R.id.btn_Out;
	}

	/*
	 * metoda za dohvaæanje dialoga za klasu Outcomekoji se prosljeðuje
	 * IncomeOutcomeControleru
	 */
	@Override
	public int getDialog() {
		return R.layout.dialog_unesi_trosak;
	}

	/*
	 * metoda za dohvaæanje naslova za dialog za klasu Incomekoji se prosljeðuje
	 * IncomeOutcomeControleru
	 */
	@Override
	public String getNslov() {
		return "Unos troškova";
	}

	/*
	 * metoda za dohvaæanje oznake vrste transakcije za klasu Outcomekoji se
	 * prosljeðuje IncomeOutcomeControleru
	 */
	@Override
	public int getVrsta() {
		return 0;
	}

	/*
	 * metoda za toastkoji se prosljeðuje IncomeOutcomeControleru
	 */
	@Override
	public void toastIt(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}

}
