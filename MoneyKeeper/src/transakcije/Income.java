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

	public int getLayout() {

		return R.layout.activity_income;
	}
	

	public int getButon() {
		return R.id.btn_Inc;
	}


	@Override
	public int getDialog() {
	//	final Dialog dialog = new Dialog(context);
    //  dialog.setContentView(R.layout.dialog_unesi_dohodak);
	//	dialog.setTitle("Unos prihoda");
		return R.layout.dialog_unesi_dohodak;
	}



	@Override
	public String getNslov() {
		// TODO Auto-generated method stub
		return "Unos prihoda";
	}


	@Override
	public int getVrsta() {
		// TODO Auto-generated method stub
		return 1;
	}

	public void toastIt(String msg){
		Toast.makeText(getApplicationContext(), msg,Toast.LENGTH_LONG).show();
	}
	
	
	
}