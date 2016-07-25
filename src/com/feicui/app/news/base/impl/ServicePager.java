package com.feicui.app.news.base.impl;

import com.feicui.app.news.base.BasePager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * 智慧服务页面
 */
public class ServicePager extends BasePager {

	public ServicePager(Activity activity) {
		super(activity);
	}

	@Override
	public void initData() {
		tv_title.setText("生活");
		TextView text=new TextView(mActivity);
		text.setText("智慧服务");
		text.setTextColor(Color.RED);
		text.setTextSize(30);
		text.setGravity(Gravity.CENTER);
		fl_content.addView(text);
	}
}
