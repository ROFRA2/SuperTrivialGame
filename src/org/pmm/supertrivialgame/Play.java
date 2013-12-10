package org.pmm.supertrivialgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Play extends Activity {
	
	protected void onStop() {
		hiloTiempo.cancel(true);//Esto evita un error al volver atras
		super.onStop();
	}

	private ArrayList <Question> preguntas;
	private int numPregunta=0;
	TextView pregunta;
	TextView score;
	Button respuesta1;
	Button respuesta2;
	Button respuesta3;
	Button respuesta4;
	Question question;
	ProgressBar barraTiempo;
	Tiempo hiloTiempo;
	private int puntuacion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		pregunta=(TextView)findViewById(R.id.pregunta);
		respuesta1=(Button)findViewById(R.id.respuesta1);
		respuesta2=(Button)findViewById(R.id.respuesta2);
		respuesta3=(Button)findViewById(R.id.respuesta3);
		respuesta4=(Button)findViewById(R.id.respuesta4);
		score=(TextView)findViewById(R.id.score);
		barraTiempo=(ProgressBar)findViewById(R.id.progressBar1);
		puntuacion=0;
		
		inicializarPreguntas();
		Collections.shuffle(preguntas);//ordena aleatoriamente el arraylist
		realizarPregunta();
		
		respuesta1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				hiloTiempo.cancel(true);
				if(question.getRightAnswer()==0){
					puntuacion+=(100-barraTiempo.getProgress())*10;
					score.setText("Score: "+puntuacion);
					respuesta1Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Correcta. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta", "Respuesta Correcta. Siguiente pregunta");
					}
				}else if(question.getRightAnswer()==1){
					respuesta2Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Erronea. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta","Respuesta Erronea. Siguiente pregunta");
					}
				}else if(question.getRightAnswer()==2){
					respuesta3Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Erronea. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta","Respuesta Erronea. Siguiente pregunta");
					}
				}else if(question.getRightAnswer()==3){
					respuesta4Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Erronea. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta","Respuesta Erronea. Siguiente pregunta");
					}
				}
			}
		});
		
		
		respuesta2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				hiloTiempo.cancel(true);
				if(question.getRightAnswer()==1){
					puntuacion+=(100-barraTiempo.getProgress())*10;
					score.setText("Score: "+puntuacion);
					respuesta2Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Correcta. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta", "Respuesta Correcta. Siguiente pregunta");
					}
				}else if(question.getRightAnswer()==0){
					respuesta1Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Erronea. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta","Respuesta Erronea. Siguiente pregunta");
					}
				}else if(question.getRightAnswer()==2){
					respuesta3Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Erronea. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta","Respuesta Erronea. Siguiente pregunta");
					}
				}else if(question.getRightAnswer()==3){
					respuesta4Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Erronea. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta","Respuesta Erronea. Siguiente pregunta");
					}
				}
			}
		});

		respuesta3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				hiloTiempo.cancel(true);
				if(question.getRightAnswer()==2){
					puntuacion+=(100-barraTiempo.getProgress())*10;
					score.setText("Score: "+puntuacion);
					respuesta3Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Correcta. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta", "Respuesta Correcta. Siguiente pregunta");
					}
				}else if(question.getRightAnswer()==1){
					respuesta2Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Erronea. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta","Respuesta Erronea. Siguiente pregunta");
					}
				}else if(question.getRightAnswer()==0){
					respuesta1Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Erronea. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta","Respuesta Erronea. Siguiente pregunta");
					}
				}else if(question.getRightAnswer()==3){
					respuesta4Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Erronea. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta","Respuesta Erronea. Siguiente pregunta");
					}
				}
			}
		});
		
		respuesta4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				hiloTiempo.cancel(true);
				if(question.getRightAnswer()==3){
					puntuacion+=(100-barraTiempo.getProgress())*10;
					score.setText("Score: "+puntuacion);
					respuesta4Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Correcta. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta", "Respuesta Correcta. Siguiente pregunta");
					}
				}else if(question.getRightAnswer()==1){
					respuesta2Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Erronea. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta","Respuesta Erronea. Siguiente pregunta");
					}
				}else if(question.getRightAnswer()==2){
					respuesta3Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Erronea. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta","Respuesta Erronea. Siguiente pregunta");
					}
				}else if(question.getRightAnswer()==0){
					respuesta1Correcta();
					if(preguntas.size()==numPregunta){
						dialogRespuesta("Resuesta","Respuesta Erronea. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
					}else{
						dialogRespuesta("Resuesta","Respuesta Erronea. Siguiente pregunta");
					}
				}
			}
		});
	}

	private void realizarPregunta() {
		botonesVisible();
		respuesta1.setTextColor(Color.BLACK);
		respuesta2.setTextColor(Color.BLACK);
		respuesta3.setTextColor(Color.BLACK);
		respuesta4.setTextColor(Color.BLACK);
		question=preguntas.get(numPregunta);
		pregunta.setText(question.getQuestionText());
		String[]aswers=question.getAnswers();
		inicializarRespuesta(aswers);
		hiloTiempo=new Tiempo();
		hiloTiempo.execute();
		numPregunta++;
}

private void inicializarRespuesta(String[] aswers) {
	respuesta1.setText(aswers[0]);
	respuesta2.setText(aswers[1]);
	respuesta3.setText(aswers[2]);
	respuesta4.setText(aswers[3]);
}

private void botonesVisible() {
	respuesta1.setEnabled(true);
	respuesta2.setEnabled(true);
	respuesta3.setEnabled(true);
	respuesta4.setEnabled(true);
}

private void inicializarPreguntas() {
	preguntas=new ArrayList <Question>();
	preguntas.add(new Question("Geograf�a","�Qu� l�nea imaginaria de la tierra est� marcada por el monolito Jujuy?",new String[]{"El Tr�pico de Sagitario","El Tr�pico de Aries","El Tr�pico de Virgo","El Tr�pico de Capricornio"},3,1));
	preguntas.add(new Question("Espect�culos","�En qu� pel�cula aparec�an The Beatles en dibujos animados?",new String[]{"Yellow submarine","A Hard Day�s Night","Magical Mystery Tour","Help!"},0,3));
	preguntas.add(new Question("Historia","�Por qu� cruz pas� a la historia Henri Dunant?",new String[]{"Cruz de Occitania","Cruz Roja","Cruz de Borgo�a","Cruz del calvario"},1,0));
	preguntas.add(new Question("Geograf�a","�C�mo se llama el mar que separa Argentina de las islas Malvinas?",new String[]{"Mar Argentino","Mar de la Plata","Mar Malvino","Mar del Tucum�n"},0,3));
	preguntas.add(new Question("Arte y Literatura","�A qu� poeta debemos el Llanto por Ignacio S�nchez Mej�as?",new String[]{"Miguel Hern�ndez","Garc�a Lorca","Pablo Neruda","Rafael Alberti"},1,2));
	preguntas.add(new Question("Ciencias y Naturaleza","�Qu� miembros de una colmena se alimentan con jalea real?",new String[]{"Las larvas","Los z�nganos","La reina","Las obreras"},0,2));
	preguntas.add(new Question("Historia","�Qui�n fue el legislador ateniense m�s famoso por la severidad de sus penas?",new String[]{"Plat�n","Salaminia","Drac�n","Arist�teles"},2,1));
	preguntas.add(new Question("Arte y Literatura","�En qu� caf� dirigi� una famosa tertulia literaria Ram�n G�mez de la Serna?",new String[]{"Caf� Madrid","Caf� Pombo","Caf� Gij�n","Caf� Cibeles"},1,3));
	preguntas.add(new Question("Ocio y Deportes","�Qu� equipo de f�tbol espa�ol fue el primero en llevarse a sus vitrinas la Supercopa de Europa?",new String[]{"Real Madrid","Valencia","Fc Barcelona","Atl�tico de Madrid"},1,2));
	preguntas.add(new Question("Historia","�En qu� pa�s 100.000 personas protagonizaron La Larga Marcha?",new String[]{"India","Rusia","China","Indonesia"},2,0));
	preguntas.add(new Question("Espect�culos","�Qui�n dirigi� primero Tesis y despu�s Abre los ojos?",new String[]{"�lex de la Iglesia","Alejandro Amen�bar","Eduardo Noriega","Mateo Gil"},1,0));
	preguntas.add(new Question("Arte y Literatura","�Qui�n escribi� un Viaje a la Luna y la Historia c�mica de los estados e imperios del Sol?",new String[]{"Cyrano de Bergerac","Julio Verne","Victor Hugo","H. G. Wells"},0,1));
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.action_help:
				int ayuda= question.help;
				switch(ayuda){
				case 0:
					respuesta1.setEnabled(false);
					break;
				case 1:
					respuesta2.setEnabled(false);
					break;
				case 2:
					respuesta3.setEnabled(false);
					break;
				case 3:
					respuesta4.setEnabled(false);
					break;
				}
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
		
	}
	
	public class Tiempo extends AsyncTask<Void,Integer,Void>{
		private int progress;
		
		@Override
		protected void onPreExecute() {
			progress=0;		
		}
		
		@Override
		protected Void doInBackground(Void... params) {
			System.out.println(isCancelled());
			while(!isCancelled()&&progress<100){
				progress++;
				System.out.println(progress);
				try{
					Thread.sleep(100);
				}catch(Exception e){
					System.out.println("Error "+e);
				}
				publishProgress(progress);
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			barraTiempo.setProgress(progress);
			if(progress==100){
				this.cancel(true);
				System.out.println(progress+"hola "+this.toString()+" "+this.isCancelled());
				if(preguntas.size()==numPregunta){
					dialogRespuesta("Tiempo", "Se acabo el tiempo. Era la utlima pregunta. Tu puntuaci�n es: "+puntuacion);
				}else{
					dialogRespuesta("Tiempo", "Se acabo el tiempo");
				}
			}
		}	
	}
	
	private void respuesta4Correcta() {
		respuesta1.setTextColor(Color.RED);
		respuesta2.setTextColor(Color.RED);
		respuesta3.setTextColor(Color.RED);
		respuesta4.setTextColor(Color.GREEN);
	}

	private void respuesta3Correcta() {
		respuesta1.setTextColor(Color.RED);
		respuesta2.setTextColor(Color.RED);
		respuesta3.setTextColor(Color.GREEN);
		respuesta4.setTextColor(Color.RED);
	}

	private void respuesta2Correcta() {
		respuesta1.setTextColor(Color.RED);
		respuesta2.setTextColor(Color.GREEN);
		respuesta3.setTextColor(Color.RED);
		respuesta4.setTextColor(Color.RED);
	}

	private void respuesta1Correcta() {
		respuesta1.setTextColor(Color.GREEN);
		respuesta2.setTextColor(Color.RED);
		respuesta3.setTextColor(Color.RED);
		respuesta4.setTextColor(Color.RED);
	}
	
	
	private void dialogRespuesta(String titulo, String mensaje){
		hiloTiempo.cancel(true);
		AlertDialog alerta=null;
		AlertDialog.Builder ventana=new AlertDialog.Builder(this);
		ventana.setTitle(titulo);
		ventana.setMessage(mensaje);
		ventana.setPositiveButton("OK",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				 final Handler handler = new Handler(); 
			        Timer t = new Timer(); 
			        t.schedule(new TimerTask() { //Prepara la ejecuci�n de una tarea despu�s de un tiempo determinado (ms). 
			            //Es una clase que representa una tarea a ejecutar en un tiempo especificado.
			            public void run() { //Dentro de este m�todo definimos las operaciones de la tarea a realizar.
			                handler.post(new Runnable() { //Gracias al m�todo post, podemos acceder desde el hilo secundario al hilo principal.
			                    public void run() { //Realizo la tarea que quiero realizar al acabar el tiempo del schedule (1000ms).
			                        //Aqu� paso a la siguiente pregunta
			                    	if(preguntas.size()==numPregunta){
			                    		Intent i= new Intent(Play.this, Main.class);
			            				startActivity(i);
			    					}else{
			    						realizarPregunta();
			    					}
			                    	
			                    } 
			                }); 
			            } 
			        }, 1500); 
			}
		});
		alerta=ventana.create();
		alerta.show();
	}

}
