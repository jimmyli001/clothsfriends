package com.linktownld.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import com.linktownld.R;
import com.linktownld.adapter.RecyclerCardAdapter;
import com.linktownld.adapter.RecyclerCardHAdapter;
import com.linktownld.adapter.RecyclerHeaderAdapter;
import com.linktownld.bean.RecyclerBean;
import com.linktownld.utils.ScreenUtils;
import com.linktownld.view.CustomerViewPage;
import com.linktownld.view.DividerItemDecoration;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MessageFragment extends BaseFragment {
	private CustomerViewPage pager_act_linktown;
	private List<View> views;
	private View viewpage1, viewpage2, viewpage3;
	private RecyclerView mRecyclerView,mRecyclerView_h;
	private List<String> mDatas = null;
	private RecyclerHeaderAdapter mRecyclerHeaderAdapter;
	private RecyclerCardHAdapter mRecyclerAdapterH;
	private RecyclerCardAdapter mRecyclerAdapter;
	public Context mContext;
	private ArrayList<RecyclerBean> recyclerBeans;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_message, container, false);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		viewpage1 = LayoutInflater.from(getActivity()).inflate(R.layout.main_pager, null);
		viewpage2 = LayoutInflater.from(getActivity()).inflate(R.layout.main_pager, null);
		viewpage3 = LayoutInflater.from(getActivity()).inflate(R.layout.main_pager, null);
		initViewPager();
		pager_act_linktown.setViewPageViews(views);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ScreenUtils.getScreenWidth(mContext)*(440/750));
//		params.height = ScreenUtils.getScreenWidth(mContext)*(440/750);
//		params.width = ScreenUtils.getScreenWidth(mContext);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 1);
//		pager_act_linktown.
		initDataAndView();
	}

	private void initDataAndView() {
		// TODO Auto-generated method stub
		mDatas = new ArrayList<String>();
		for (int i = '0'; i <= '9'; i++) {
			mDatas.add(String.valueOf((char) i));
		}
		recyclerBeans = new ArrayList<RecyclerBean>();
//		mRecyclerHeaderAdapter = new RecyclerHeaderAdapter(recyclerBeans);
		mRecyclerAdapterH = new RecyclerCardHAdapter(mContext, mDatas);
		mRecyclerAdapter = new RecyclerCardAdapter(mContext, mDatas);
		mRecyclerView.setAdapter(mRecyclerAdapter);
		mRecyclerView_h.setAdapter(mRecyclerAdapterH);
//		mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
		// 设置网格布局管理器
		final ExStaggeredGridLayoutManager gridLayoutManager =new ExStaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
		mRecyclerView.setLayoutManager(gridLayoutManager);
		
	    mRecyclerView_h.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
//	    gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//	    	@Override
//	    	public int getSpanSize(int position) {
//	    	return (mRecyclerHeaderAdapter.isHeaderView(position) || mRecyclerHeaderAdapter.isBottomView(position)) ? gridLayoutManager.getSpanCount() : 1;
//	    	}
//	    	});
	}

	private void initViewPager() {
		int[] images = new int[] { R.drawable.main_viewpage_1, R.drawable.main_viewpage_2, R.drawable.main_viewpage_3};
		views = new ArrayList<View>();
		// for (int i = 0; i < images.length; i++) {
		ImageView imageView1 = (ImageView) viewpage1.findViewById(R.id.turn_img);
		imageView1.setBackgroundResource(images[0]);
		views.add(viewpage1);
		// }
		ImageView imageView2 = (ImageView) viewpage2.findViewById(R.id.turn_img);
		imageView2.setBackgroundResource(images[1]);
		views.add(viewpage2);
		ImageView imageView3 = (ImageView) viewpage3.findViewById(R.id.turn_img);
		imageView3.setBackgroundResource(images[2]);
		views.add(viewpage3);

	}

	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mContext = getActivity();
	}
	/**
	 *  不规则排列（类似于瀑布流）的布局管理器
	 */
	public class ExStaggeredGridLayoutManager extends StaggeredGridLayoutManager {

	    public ExStaggeredGridLayoutManager(int spanCount, int orientation) {
	        super(spanCount, orientation);
	    }

	    // 尺寸的数组，[0]是宽，[1]是高
	    private int[] measuredDimension = new int[2];

	    // 用来比较同行/列那个item罪宽/高
	    private int[] dimension;


	    @Override

	    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
	        // 宽的mode+size
	        final int widthMode = View.MeasureSpec.getMode(widthSpec);
	        final int widthSize = View.MeasureSpec.getSize(widthSpec);
	        // 高的mode + size
	        final int heightMode = View.MeasureSpec.getMode(heightSpec);
	        final int heightSize = View.MeasureSpec.getSize(heightSpec);

	        // 自身宽高的初始值
	        int width = 0;
	        int height = 0;
	        // item的数目
	        int count = getItemCount();
	        // item的列数
	        int span = getSpanCount();
	        // 根据行数或列数来创建数组
	        dimension = new int[span];

	        for (int i = 0; i < count; i++) {
	            measureScrapChild(recycler, i,
	                    View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED),
	                    View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED), measuredDimension);

	           // 如果是竖直的列表，计算item的高，否则计算宽度
	            //Log.d("LISTENER", "position " + i + " height = " + measuredDimension[1]);
	            if (getOrientation() == VERTICAL) {
	                dimension[findMinIndex(dimension)] += measuredDimension[1];
	            } else {
	                dimension[findMinIndex(dimension)] += measuredDimension[0];
	            }
	        }
	        if (getOrientation() == VERTICAL) {
	            height = findMax(dimension);
	        } else {
	            width = findMax(dimension);
	        }
	        

	        switch (widthMode) {
	            // 当控件宽是match_parent时，宽度就是父控件的宽度
	            case View.MeasureSpec.EXACTLY:
	                width = widthSize;
	                break;
	            case View.MeasureSpec.AT_MOST:
	                break;
	            case View.MeasureSpec.UNSPECIFIED:
	                break;
	        }
	        switch (heightMode) {
	            // 当控件高是match_parent时，高度就是父控件的高度
	            case View.MeasureSpec.EXACTLY:
	                height = heightSize;
	                break;
	            case View.MeasureSpec.AT_MOST:
	                break;
	            case View.MeasureSpec.UNSPECIFIED:
	                break;
	        }
	        // 设置测量尺寸  
	        setMeasuredDimension(width, height);
	    }

	    private void measureScrapChild(RecyclerView.Recycler recycler, int position, int widthSpec,
	            int heightSpec, int[] measuredDimension) {

	        // 挨个遍历所有item
	        if (position < getItemCount()) {
	            try {
	                View view = recycler.getViewForPosition(position);//fix 动态添加时报IndexOutOfBoundsException

	                if (view != null) {
	                    RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) view.getLayoutParams();
	                    int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec, getPaddingLeft() + getPaddingRight(), lp.width);
	                    int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec, getPaddingTop() + getPaddingBottom(), lp.height);
	                    // 子view进行测量，然后可以通过getMeasuredWidth()获得测量的宽，高类似
	                    view.measure(childWidthSpec, childHeightSpec);
	                    // 将item的宽高放入数组中
	                    measuredDimension[0] = view.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
	                    measuredDimension[1] = view.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
	                    recycler.recycleView(view);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private int findMax(int[] array) {
	        int max = array[0];
	        for (int value : array) {
	            if (value > max) {
	                max = value;
	            }
	        }
	        return max;
	    }

	    /**
	     * 得到最数组中最小元素的下标
	     *
	     * @param array
	     * @return
	     */
	    private int findMinIndex(int[] array) {
	        int index = 0;
	        int min = array[0];
	        for (int i = 0; i < array.length; i++) {
	            if (array[i] < min) {
	                min = array[i];
	                index = i;
	            }
	        }
	        return index;
	    }
	   
	}
	

}
