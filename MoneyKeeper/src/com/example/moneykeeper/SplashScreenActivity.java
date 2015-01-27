package com.example.moneykeeper;

import com.example.moneykeeper.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreenActivity extends Activity {

	/*
	 * početni parametri
	 */
	private static String TAG = SplashScreenActivity.class.getName();
	private static long SLEEP_TIME = 5;

	/*
	 * kreiranje splash screena, prikazuje se prilikom pokretanja aplikacije
	 * zahtjeva prozor bez title bara i notification bara
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_splash_screen);

		/*
		 * Pokretanje timera i pokretanje main activity nakon
		 */
		IntentLauncher launcher = new IntentLauncher();
		launcher.start();
	}

	private class IntentLauncher extends Thread {

		@Override
		/*
		 * čekanje neko vrijeme, duljina prikaza splash screena nakon kojeg se
		 * pokreže main activity
		 */
		public void run() {
			try {
				Thread.sleep(SLEEP_TIME * 1000);
			} catch (Exception e) {
				Log.e(TAG, e.getMessage());
			}

			Intent intent = new Intent(SplashScreenActivity.this,
					MainActivity.class);
			SplashScreenActivity.this.startActivity(intent);
			SplashScreenActivity.this.finish();
		}
	}

}

