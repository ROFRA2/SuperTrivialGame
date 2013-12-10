package org.pmm.supertrivialgame;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Menu;
import android.view.MenuItem;

public class Credits extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_credits);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.credits, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.action_help:
				Builder ventana =new AlertDialog.Builder(this);
				ventana.setTitle("Ayuda");
				ventana.setMessage("La ayuda esta disponible en www.noexiste.com.");
				ventana.setIcon(android.R.drawable.ic_dialog_info);
				ventana.setPositiveButton("OK", null);
				ventana.show();
				return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}

}
