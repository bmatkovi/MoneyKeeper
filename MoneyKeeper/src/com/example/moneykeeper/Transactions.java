package com.example.moneykeeper;

import com.example.moneykeeper.R;
import com.example.moneykeeper.R.id;
import com.example.moneykeeper.R.layout;

import android.widget.Toast;

public class Transactions extends TransakcijeControler{

	@Override
	public int getLayout() {

		return R.layout.activity_transaction;
	}
/*
	@Override
	public void init() {
		toastIt("tostaj ovaj tekst");
	}
	*/
	public void toastIt(String msg){
		Toast.makeText(getApplicationContext(), msg,Toast.LENGTH_LONG).show();
	}

	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
