package com.feicui.app.news.base.impl;

import com.feicui.app.news.base.BasePager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
/**
 * ��ҳ
 */
public class HomePager extends BasePager {

	public HomePager(Activity activity) {
		super(activity);
	}

	@Override
	public void initData() {
		tv_title.setText("��ҳ");
		TextView text=new TextView(mActivity);
		text.setText("��ҳ");
		text.setTextColor(Color.RED);
		text.setTextSize(30);
		text.setGravity(Gravity.CENTER);
		fl_content.addView(text);
	}
}
