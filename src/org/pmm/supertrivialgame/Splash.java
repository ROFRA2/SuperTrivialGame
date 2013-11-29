package org.pmm.supertrivialgame;

import android.R.anim;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		ImageView azul=(ImageView)findViewById(R.id.azul);
		Animation animAzul= AnimationUtils.loadAnimation(this, R.anim.animacionazul);
		azul.setAnimation(animAzul);
		
		ImageView amarillo=(ImageView)findViewById(R.id.amarillo);
		Animation animAmarillo= AnimationUtils.loadAnimation(this, R.anim.animacionamarillo);
		amarillo.setAnimation(animAmarillo);
		
		ImageView morado=(ImageView)findViewById(R.id.morado);
		Animation animMorado= AnimationUtils.loadAnimation(this, R.anim.animacionmorado);
		morado.setAnimation(animMorado);
		
		ImageView naranaja=(ImageView)findViewById(R.id.naranja);
		Animation animNaranja= AnimationUtils.loadAnimation(this, R.anim.animacionnaranja);
		naranaja.setAnimation(animNaranja);
		
		ImageView rojo=(ImageView)findViewById(R.id.rojo);
		Animation animRojo= AnimationUtils.loadAnimation(this, R.anim.animacionrojo);
		rojo.setAnimation(animRojo);
		
		ImageView verde=(ImageView)findViewById(R.id.verde);
		Animation animVerde= AnimationUtils.loadAnimation(this, R.anim.animacionverde);
		verde.setAnimation(animVerde);
		

		ImageView introazul=(ImageView)findViewById(R.id.introazul);
		Animation introanimAzul= AnimationUtils.loadAnimation(this, R.anim.animintroder);
		introazul.setAnimation(introanimAzul);
		
		ImageView introamarillo=(ImageView)findViewById(R.id.introamarillo);
		Animation introanimAmarillo= AnimationUtils.loadAnimation(this, R.anim.animintroizq);
		introamarillo.setAnimation(introanimAmarillo);
		
		ImageView intronaranaja=(ImageView)findViewById(R.id.intronaranja);
		Animation introanimNaranja= AnimationUtils.loadAnimation(this, R.anim.animintroizq);
		intronaranaja.setAnimation(introanimNaranja);

		ImageView introrojo=(ImageView)findViewById(R.id.introrojo);
		Animation introanimRojo= AnimationUtils.loadAnimation(this, R.anim.animintroizq);
		introrojo.setAnimation(introanimRojo);
		
		ImageView introverde=(ImageView)findViewById(R.id.introverde);
		Animation introanimVerde= AnimationUtils.loadAnimation(this, R.anim.animintroder);
		introverde.setAnimation(introanimVerde);
		

		ImageView intromorado=(ImageView)findViewById(R.id.intromorado);
		Animation introanimMorado= AnimationUtils.loadAnimation(this, R.anim.animintroder);
		intromorado.setAnimation(introanimMorado);
	
		TextView texto1=(TextView)findViewById(R.id.textView1);
		Animation animtexto= AnimationUtils.loadAnimation(this, R.anim.animletras);
		texto1.setAnimation(animtexto);
		
		TextView texto2=(TextView)findViewById(R.id.textView2);
		texto2.setAnimation(animtexto);
		
		animtexto.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationEnd(Animation arg0) {
				Intent i= new Intent(Splash.this, Main.class);
				startActivity(i);
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				
			}

			@Override
			public void onAnimationStart(Animation arg0) {
				
			}});
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
