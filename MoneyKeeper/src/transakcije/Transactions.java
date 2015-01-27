package transakcije;

import com.example.moneykeeper.R;
import com.example.moneykeeper.R.id;
import com.example.moneykeeper.R.layout;

import android.widget.Toast;

public class Transactions extends TransakcijeControler{

	/*
	 * metoda za dohvaæanje layouta za Tansakcije i prosljeðuej 
	 * se TransactionControleru
	*/
	@Override
	public int getLayout() {
		return R.layout.activity_transaction;
	}

	/*
	 * metoda za ispis toast-a
	 */
	public void toastIt(String msg){
		Toast.makeText(getApplicationContext(), msg,Toast.LENGTH_LONG).show();
	}

	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
