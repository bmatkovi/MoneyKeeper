package com.example.moneykeeper;

import java.util.ArrayList;
import java.util.List;

import com.example.moneykeeper.R;
import com.example.moneykeeper.R.id;
import com.example.moneykeeper.R.layout;

import db.Racun;
import db.Transakcija;
import android.app.Dialog;
import android.widget.Toast;

public class Outcome extends IncomeOutcomeControler{


	public int getLayout() {
		return R.layout.activity_outcome;
	}
	
	
	@Override
	public int getButon() {
		return R.id.btn_Out;
	}


	@Override
	public int getDialog() {
		//final Dialog dialog = new Dialog(context);
		//dialog.setContentView(R.layout.dialog_unesi_trosak);
		//dialog.setTitle("Unos troškova");
		return R.layout.dialog_unesi_trosak;
	}





	@Override
	public String getNslov() {
		// TODO Auto-generated method stub
		return "Unos troškova";
	}


	@Override
	public int getVrsta() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void toastIt(String msg) {
		Toast.makeText(getApplicationContext(), msg,Toast.LENGTH_LONG).show();
	}


	
	
}
