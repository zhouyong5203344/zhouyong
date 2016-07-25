package com.feicui.app.news.fragment;

import java.util.ArrayList;

import com.feicui.app.news.R;
import com.feicui.app.news.base.BasePager;
import com.feicui.app.news.base.impl.GovernmentPager;
import com.feicui.app.news.base.impl.HomePager;
import com.feicui.app.news.base.impl.NewsPager;
import com.feicui.app.news.base.impl.ServicePager;
import com.feicui.app.news.base.impl.SettingPager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * 主页内容
 */
public class ContentFragment extends BaseFragment {
	/**页签*/
	private RadioGroup rg_fragment;
	/**子页面集合*/
	private ArrayList<BasePager> pagerList;
	private ViewPager vp_content;

	@Override
	public View initView() {
		View view=View.inflate(mActivity, R.layout.fragment_content, null);
		rg_fragment=(RadioGroup) view.findViewById(R.id.rg_fragment);
		vp_content=(ViewPager) view.findViewById(R.id.vp_content);
		return view;
	}
	
	public void initData(){
		rg_fragment.check(R.id.rg_fragment);
		pagerList=new ArrayList<BasePager>();
		//初始化5个子页面
		pagerList.add(new HomePager(mActivity));
		pagerList.add(new NewsPager(mActivity));
		pagerList.add(new ServicePager(mActivity));
		pagerList.add(new GovernmentPager(mActivity));
		pagerList.add(new SettingPager(mActivity));
		
		vp_content.setAdapter(new ContentAdapter());
	}
	
	class ContentAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return pagerList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			BasePager pager=pagerList.get(position);
			container.addView(pager.rootView);
			pager.initData();
			return pager.rootView;
		}
	}

}
