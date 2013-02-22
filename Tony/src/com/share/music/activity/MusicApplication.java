package com.share.music.activity;

import java.util.ArrayList;

import android.app.Application;

/**
 * 全局应用类，方便退出应用
 * 
 * @author yexiaoming
 * 
 */
public class MusicApplication extends Application {

	ArrayList<BaseActivity> activities = new ArrayList<BaseActivity>();
	public static MusicApplication app;

	@Override
	public void onCreate() {
		super.onCreate();
		if (null == app) {
			app = this;
		}
	}

	public void addActivity(BaseActivity acitivity) {
		activities.add(acitivity);
	}

	public void removeActivity(BaseActivity acitivity) {
		for (int i = 0; i < activities.size(); i++) {
			if (activities.get(i) == acitivity) {
				activities.remove(i);
				return;
			}
		}

	}

	/**
	 * 退出应用
	 */
	public void exit() {
		for (int i = 0; i < activities.size(); i++) {
			activities.get(i).finish();
		}
		activities.clear();
		System.exit(0);
	}

}
