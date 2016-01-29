package com.lym;

import java.util.HashMap;

import com.lym.utils.ActivityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity1 extends Activity {
	private ActivityUtils au;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		au = ActivityUtils.getInstance();
		Button btnNext = (Button) findViewById(R.id.btn_next);
		btnNext.setText("ตฺถþาณ");
	}

	public void click(View view) {
		au.startActivity(this, Activity2.class);
		HashMap<String, Object> param = new HashMap<String, Object>();

		byte b = 1;
		param.put("int", 5);
		param.put("string", "string");
		param.put("float", 3.85f);
		param.put("double", 3.5);
		param.put("byte", b);
		au.startActivity(this, Activity2.class, param);
	}
}
