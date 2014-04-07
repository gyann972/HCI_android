package com.map.tracer;

import com.map.route.LoginActivity;
import com.map.route.ViewActivity;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class PathInfoActivity extends Activity {
	
	public final static String CLASS_DEST = "com.map.route.CLASSDEST";

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_path_info);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setTitle("MapTracer");
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.path_info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()){
			case R.id.log_out:
				Intent intent = new Intent(PathInfoActivity.this, LoginActivity.class);
				startActivity(intent);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	public void submitDestination(View view){
    	Intent intent = new Intent(this, ViewActivity.class);
    	EditText editTxt = (EditText)findViewById(R.id.target_point);
    	String message = editTxt.getText().toString();
    	intent.putExtra(CLASS_DEST, message);
    	
    	//Call another activity
    	startActivity(intent);
    }
}
