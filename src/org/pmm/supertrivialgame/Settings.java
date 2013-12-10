package org.pmm.supertrivialgame;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Settings extends Activity {

	boolean itemSelected[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_settings);
		
		//Radio button de Question Server
		String[] data = new String[]{"None","dakkon.isca.upv.es","Test server (not working!)"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
		Spinner lista = (Spinner)findViewById(R.id.spinner1);
		////Indicamos el tipo de Spinner 
		adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
		// Establecemos el adaptador en el Spinner
		lista.setAdapter(adapter);
		
		//CheckBox de Question Preferences
		final AlertDialog.Builder ventanaPreferences =new AlertDialog.Builder(this);
		String[] datosQuestionPreferences = new String[]{"Sports", "Literature", "Science", "Movies", "History"};
		
		
		this.itemSelected = new boolean[datosQuestionPreferences.length];
		ventanaPreferences.setTitle("Question Preferences");
		ventanaPreferences.setMultiChoiceItems(datosQuestionPreferences, itemSelected, new DialogInterface.OnMultiChoiceClickListener() {
						
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				if(isChecked){
					itemSelected[which]=true;
				}else {
					itemSelected[which]=false;
				}				
			}
		});

		ventanaPreferences.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), "Saved preferences...", Toast.LENGTH_SHORT).show();				
			}
		});	
		
		Button botonSelectPreferences = (Button)findViewById(R.id.button1);				
		
		botonSelectPreferences.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ventanaPreferences.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}
		
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.action_help:
				AlertDialog.Builder ventana =new AlertDialog.Builder(this);
				ventana.setTitle("Ayuda");
				ventana.setMessage("La ayuda esta disponible en www.noexiste.com.");
				ventana.setIcon(android.R.drawable.ic_dialog_info);
				ventana.setPositiveButton("OK", null);
				ventana.show();
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
