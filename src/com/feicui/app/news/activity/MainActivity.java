package com.feicui.app.news.activity;

import com.feicui.app.news.R;
import com.feicui.app.news.fragment.ContentFragment;
import com.feicui.app.news.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
/**
 * 主页面
 */
public class MainActivity extends SlidingFragmentActivity {
	private static final String FRAGMENT_LEFT_MENU = "fragment_left_menu";
	private static final String FRAGMENT_CONTENT = "fragment_content";
	private SlidingMenu menu;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		//设置侧边栏布局
		setBehindContentView(R.layout.left_menu);
		//获取侧边栏对象 
		SlidingMenu menu = getSlidingMenu();
		//menu=new SlidingMenu(this);
		//设置左侧拉框
		menu.setMode(SlidingMenu.LEFT);
		//设置全屏触摸 
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		//设置预留屏幕宽度 
		menu.setBehindOffset(200);
		//添加左侧栏的布局
		//menu.setMenu(R.layout.left_menu);
		initFragment();
	}

	/**
	 * 初始化Fragment 将fragment数据填充给布局文件
	 */
	private void initFragment() {
		FragmentManager fm = getSupportFragmentManager();
		/** 开启事务 */
		FragmentTransaction transaction = fm.beginTransaction();
		/** 用fragment替换FragmentLayout */
		transaction.replace(R.id.fl_left_menu, new LeftMenuFragment(),
				FRAGMENT_LEFT_MENU);
		transaction.replace(R.id.fl_content, new ContentFragment(),
				FRAGMENT_CONTENT);
		/** 提交事务 */
		transaction.commit();
	}
}
