package com.feicui.app.news.base;

import com.feicui.app.news.R;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BasePager {
	public Activity mActivity;
	/**主页标题*/
	public TextView tv_title;
	/**首页内容*/
	public FrameLayout fl_content;
	public View rootView;
     
	public BasePager(Activity activity){
		mActivity=activity;
		initView();
	}
	
	/**
	 * 初始化布局
	 */
	public void initView(){
		rootView=View.inflate(mActivity, R.layout.base_pager, null);
		tv_title=(TextView) rootView.findViewById(R.id.tv_title);
		fl_content=(FrameLayout) rootView.findViewById(R.id.fl_content);
	}
	
	/**
	 * 初始化数据
	 */
	public void initData(){
		
	}
}
