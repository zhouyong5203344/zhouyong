package com.feicui.app.news.activity;

import com.feicui.app.news.R;
import com.feicui.app.news.R.id;
import com.feicui.app.news.R.layout;
import com.feicui.app.news.util.SharedUtil;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

/**
 * ����ҳ��
 */
public class SplashActivity extends Activity {
	/** ����ҳ��ͼƬ */
	private RelativeLayout rl_img_splash;
	/** �������� */
	private AnimationSet set;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		initUI();
		initData();
		setListener();
	}

	private void initUI() {
		rl_img_splash = (RelativeLayout) findViewById(R.id.rl_img_splash);
	}

	/** ����Ч�� */
	private void initData() {
		set = new AnimationSet(false);
		/** ��ת���� */
		RotateAnimation rotate = new RotateAnimation(0, 360,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		rotate.setDuration(1000);// ����ʱ��
		/** ���Ŷ��� */
		ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		scale.setDuration(1000);// ����ʱ��
		/** ���䶯�� */
		AlphaAnimation alpha = new AlphaAnimation(0, 1);
		alpha.setDuration(2000);// ����ʱ��
		/** ��Ӷ���Ч�������������У�����ʼ */
		set.addAnimation(rotate);
		set.addAnimation(scale);
		set.addAnimation(alpha);
		/** ��������״̬ */
		set.setFillAfter(true);

	}

	private void setListener() {
		/** ���������¼� */
		set.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				jumpNextView();
			}
		});
		rl_img_splash.startAnimation(set);
	}

	private void jumpNextView() {

		boolean isChecked = SharedUtil.getBoolean(this, "config_user", false);
		if (!isChecked) {
			startActivity(new Intent(SplashActivity.this, GuideActivity.class));
		} else {
			startActivity(new Intent(SplashActivity.this, MainActivity.class));
		}
		finish();
	}
}
