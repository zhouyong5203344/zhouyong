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
 * ��ҳ��
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
		//���ò��������
		setBehindContentView(R.layout.left_menu);
		//��ȡ��������� 
		SlidingMenu menu = getSlidingMenu();
		//menu=new SlidingMenu(this);
		//�����������
		menu.setMode(SlidingMenu.LEFT);
		//����ȫ������ 
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		//����Ԥ����Ļ��� 
		menu.setBehindOffset(200);
		//���������Ĳ���
		//menu.setMenu(R.layout.left_menu);
		initFragment();
	}

	/**
	 * ��ʼ��Fragment ��fragment�������������ļ�
	 */
	private void initFragment() {
		FragmentManager fm = getSupportFragmentManager();
		/** �������� */
		FragmentTransaction transaction = fm.beginTransaction();
		/** ��fragment�滻FragmentLayout */
		transaction.replace(R.id.fl_left_menu, new LeftMenuFragment(),
				FRAGMENT_LEFT_MENU);
		transaction.replace(R.id.fl_content, new ContentFragment(),
				FRAGMENT_CONTENT);
		/** �ύ���� */
		transaction.commit();
	}
}
