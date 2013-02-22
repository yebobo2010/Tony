package com.share.music.player;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnCompletionListener;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.telephony.TelephonyManager;

/**
 * 用服务播放音乐
 * 
 * @author Administrator
 * 
 */
public class PlayerService extends Service {
	private MediaPlayer mediaPlayer;

	@Override
	public void onCreate() {
		super.onCreate();

		try {
			if (mediaPlayer != null) {
				mediaPlayer.reset();
				mediaPlayer.release();
				mediaPlayer = null;
			}
			mediaPlayer = new MediaPlayer(this);

			// 设置下一首播放监听
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

				@Override
				public void onCompletion(MediaPlayer arg0) {
					playNext();
				}
			});

			// 播放时监听来电状态
			IntentFilter filter = new IntentFilter();
			filter.addAction(Intent.ACTION_ANSWER);
			registerReceiver(PhoneListener, filter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*** 来电时监听播放状态 */
	protected BroadcastReceiver PhoneListener = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals(Intent.ACTION_ANSWER)) {
				TelephonyManager telephonymanager = (TelephonyManager) context
						.getSystemService(Context.TELEPHONY_SERVICE);
				switch (telephonymanager.getCallState()) {
				case TelephonyManager.CALL_STATE_RINGING:// 当有来电时候，暂停音乐，可我试了试，只是把声音降低而已
					pause();
					break;
				case TelephonyManager.CALL_STATE_OFFHOOK:
					play();
					break;
				default:
					break;
				}
			}
		}
	};

	/**
	 * 播放音乐
	 */
	public void play() {

	}

	/**
	 * 暂停播放
	 */
	public void pause() {

	}

	/**
	 * 播放下一首
	 */
	public void playNext() {

	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);

		intent.getExtras().getString("");
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		if (mediaPlayer != null) {
			mediaPlayer.pause();
			mediaPlayer.release();
			mediaPlayer = null;
		}
	}
}
