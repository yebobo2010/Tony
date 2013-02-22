package com.share.music.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Activity的基类
 * 
 * @author yexiaoming
 * 
 */

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MusicApplication.app.addActivity(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		MusicApplication.app.removeActivity(this);
	}

}
