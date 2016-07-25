package com.feicui.app.news.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.feicui.app.news.R;
import com.feicui.app.news.util.SharedUtil;

/**
 * 引导页面
 */
public class GuideActivity extends Activity{
	/**左右滑动页面*/
	private ViewPager vp_guide;
	/**开始按钮*/
	private Button btn_start;
	/**引导图片集合*/
	private ArrayList<ImageView> img_list;
	/**引导圆点*/
	private LinearLayout ll_point_group;
	/**圆点之间距离*/
	private int width;
	/**小圆点*/
	private View v_point;
	/**引导图片资源集合*/
	private static final int[] img_id=new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	setContentView(R.layout.activity_guide);
    	initView();
    	initData();
    	setListener();
    }
	private void initView() {
		vp_guide=(ViewPager) findViewById(R.id.vp_guide);
		btn_start=(Button) findViewById(R.id.btn_start);
		ll_point_group=(LinearLayout) findViewById(R.id.ll_point_group);
		v_point=findViewById(R.id.v_point);
	}
	/**准备数据*/
	private void initData() {
		img_list=new ArrayList<ImageView>();
		/**初始化引导页面3个图片*/
		for (int i = 0; i < img_id.length; i++) {
			ImageView image=new ImageView(this);
			image.setBackgroundResource(img_id[i]);
			img_list.add(image);
		}
		/**初始化引导页面3个圆点*/
		for (int i = 0; i < img_id.length; i++) {
			View point=new View(this);
			point.setBackgroundResource(R.drawable.shape_point);
			LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(10, 10);
			if(i>0){
				/**设置圆点间隔*/
				params.leftMargin=10;
			}
			/**设置圆点大小*/
			point.setLayoutParams(params);
			ll_point_group.addView(point);
		}
		/**获取视图树，对Layout结束事件进行监听*/
		ll_point_group.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			

			@Override
			public void onGlobalLayout() {
                 ll_point_group.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                 width=ll_point_group.getChildAt(1).getLeft()-ll_point_group.getChildAt(0).getLeft();
                 System.out.println("圆点距离"+width);
                 Log.e("width", width+"");
			}
		});
		
	}
	private void setListener() {
		vp_guide.setAdapter(new MyPagerAdapter());
		vp_guide.setOnPageChangeListener(new GuideViewPagerListener());
		btn_start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 SharedUtil.setBoolean(GuideActivity.this, "config_user", true);
                 Intent intent=new Intent(GuideActivity.this,MainActivity.class);
                 startActivity(intent);
                 finish();
			}
		});
	}
	
	/**
	 * ViewPager适配器
	 */
	class MyPagerAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return img_id.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}
        
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(img_list.get(position));
			return img_list.get(position);
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}
	
	/**滑动监听事件*/
	class GuideViewPagerListener implements OnPageChangeListener{
        /**滑动状态改变*/
		@Override
		public void onPageScrollStateChanged(int arg0) {
			
		}
        /**滑动事件      position--当前位置，positionOffset--百分比，moveLen--移动距离*/
		@Override
		public void onPageScrolled(int position, float positionOffset, int moveLen) {
			float len=(width*positionOffset)+position*width;
			/**获得当前红点的布局参数*/
			RelativeLayout.LayoutParams params=(RelativeLayout.LayoutParams) v_point.getLayoutParams();
			params.leftMargin=(int) len;
			v_point.setLayoutParams(params);
		}
        /**当前滑动页面*/
		@Override
		public void onPageSelected(int position) {
			if(position==img_id.length-1){
				btn_start.setVisibility(View.VISIBLE);
			}else{
				btn_start.setVisibility(View.INVISIBLE);
			}
		}
	}
}
