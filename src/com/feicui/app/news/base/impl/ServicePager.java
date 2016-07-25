package com.feicui.app.news.base.impl;

import com.feicui.app.news.base.BasePager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * �ǻ۷���ҳ��
 */
public class ServicePager extends BasePager {

	public ServicePager(Activity activity) {
		super(activity);
	}

	@Override
	public void initData() {
		tv_title.setText("����");
		TextView text=new TextView(mActivity);
		text.setText("�ǻ۷���");
		text.setTextColor(Color.RED);
		text.setTextSize(30);
		text.setGravity(Gravity.CENTER);
		fl_content.addView(text);
	}
}
