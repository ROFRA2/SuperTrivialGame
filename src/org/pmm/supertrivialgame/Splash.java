package org.pmm.supertrivialgame;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Intent i= new Intent(this, Main.class);
		startActivity(i);
		/*ImageView azul=(ImageView)findViewById(R.id.imageView12);
		Animation animationT= AnimationUtils.loadAnimation(this, R.anim.anim);
		azul.startAnimation(animationT);*/
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
