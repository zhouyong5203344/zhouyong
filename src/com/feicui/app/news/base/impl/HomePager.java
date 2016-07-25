package com.feicui.app.news.base.impl;

import com.feicui.app.news.base.BasePager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
/**
 * Ê×Ò³
 */
public class HomePager extends BasePager {

	public HomePager(Activity activity) {
		super(activity);
	}

	@Override
	public void initData() {
		tv_title.setText("Ê×Ò³");
		TextView text=new TextView(mActivity);
		text.setText("Ê×Ò³");
		text.setTextColor(Color.RED);
		text.setTextSize(30);
		text.setGravity(Gravity.CENTER);
		fl_content.addView(text);
	}
}
