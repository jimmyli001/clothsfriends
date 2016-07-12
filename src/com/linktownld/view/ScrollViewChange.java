package com.linktownld.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ScrollView;

/**
 * 滑动时标题变色view
 * Created by george.yang on 16/2/21.
 */
public class ScrollViewChange extends ScrollView {
    private View mByWhichView;
    private View mTitleView;
    private boolean shouldSlowlyChange = true;
	private OnScrollListener mListener;
	

    public ScrollViewChange(Context context) {
        super(context);
    }

    public ScrollViewChange(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewChange(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    public ScrollViewChange(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }


    @Override
    public void scrollTo(int x, int y) {
        //这是为了修复noScrllListView嵌套在srcollview时就自动滑动到noscrolllistview的顶部的bug，不影响使用
        if (x == 0 && y == 0 || y <= 0) {
            super.scrollTo(x, y);
        }
    }

    public void setListener(OnScrollListener listener){
        this.mListener = listener;
    }

    public void setShouldSlowlyChange(boolean slowlyChange) {
        this.shouldSlowlyChange = slowlyChange;
    }

    /**
     * 设置透明度渐变的标题view
     * @param view
     */
    public void setupTitleView (View view) {
        this.mTitleView = view;
    }

    /**
     * 跟随的view
     * @param view
     */
    public void setupByWhichView(View view) {
        mByWhichView = view;
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
                                  boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);

        if (scrollY >= mByWhichView.getTop() + mByWhichView.getMeasuredHeight()) {
            mTitleView.setBackgroundColor(Color.BLACK);
        } else if (scrollY>=0) {
            if (!shouldSlowlyChange) {
                mTitleView.setBackgroundColor(Color.TRANSPARENT);
            } else {
                float persent = scrollY * 1f / (mByWhichView.getTop() + mByWhichView.getMeasuredHeight());
                int alpha = (int) (255 * persent);
                int color = Color.argb(alpha,0,0,0);
                mTitleView.setBackgroundColor(color);
            }
        }

        if (mListener!=null) {
            mListener.onScroll(null, scrollX, scrollY, scrollY);
        }
    }
}