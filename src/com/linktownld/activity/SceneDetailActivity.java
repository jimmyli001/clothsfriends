package com.linktownld.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.linktownld.R;
import com.linktownld.activity.palceorder.PaceOrderByAdressActivity;
import com.linktownld.view.MyScrollView;

/**
 * 场景详情(加入场景，使用场景)界面
 * @author yang.zhou
 *
 */

public class SceneDetailActivity extends BaseActivity implements
		OnClickListener,com.linktownld.view.MyScrollView.OnScrollListener {

	  /** 
     * 手机屏幕宽度 
     */  
    private int screenWidth;  
    /** 
     * 场景内容布局的高度 
     */  
    private int sceneLayoutHeight;  
    /** 
     * myScrollView与其父类布局的顶部距离 
     */  
    private int myScrollViewTop;  
  
    /** 
     * 场景内容布局与其父类布局的顶部距离 
     */  
    private int sceneLayoutTop; 
	
	private RelativeLayout rl_scene_detail_bg_img;
	private TextView tv_commnet_more;
	private TextView tv_join_scene;
	private TextView tv_scence_describe;
	private TextView tv_use_scene;
	private TextView tv_scene_content;
	private WebView wv_scene_describe;
	private ImageView img_own_like;
	private MyScrollView scroll_view;
	private RelativeLayout rl_title;
	private RelativeLayout rl_remove_title;
	private boolean isSpread;
	private boolean isLike;
	private WindowManager mWindowManager;
	

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_scene_detail);
		initView();
	}

	private void initView() {
		rl_scene_detail_bg_img = (RelativeLayout) findViewById(R.id.rl_scene_detail_bg_img);
		tv_commnet_more = (TextView) findViewById(R.id.tv_commnet_more);
		tv_join_scene = (TextView) findViewById(R.id.tv_join_scene);
		tv_scence_describe = (TextView) findViewById(R.id.tv_scence_describe);
		tv_use_scene = (TextView) findViewById(R.id.tv_use_scene);
		tv_scene_content = (TextView) findViewById(R.id.tv_scene_content);
		wv_scene_describe = (WebView) findViewById(R.id.wv_scene_describe);
		img_own_like = (ImageView) findViewById(R.id.img_own_like);
		scroll_view = (MyScrollView) findViewById(R.id.scroll_view);
		rl_title = (RelativeLayout) findViewById(R.id.rl_title);
		rl_remove_title = (RelativeLayout) findViewById(R.id.rl_remove_title);
		tv_commnet_more.setOnClickListener(this);
		tv_join_scene.setOnClickListener(this);
		tv_scence_describe.setOnClickListener(this);
		tv_use_scene.setOnClickListener(this);
		wv_scene_describe.setOnClickListener(this);
		img_own_like.setOnClickListener(this);
		//设置背景图片的高度
		changeImageHeight(); 
		
		scroll_view.setOnScrollListener(this);  
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);  
        screenWidth = mWindowManager.getDefaultDisplay().getWidth();  
	}

	private void changeImageHeight() {
		//取控件RelativeLayout当前的布局参数
		LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) rl_scene_detail_bg_img.getLayoutParams(); 
		WindowManager wm = this.getWindowManager();
	     int width = wm.getDefaultDisplay().getWidth();
		//控件的高度与宽度比例为1:1.3 
		linearParams.height = (int) (width/1.3);
		System.out.println("========================"+width+"");
		System.out.println("========================"+(width/1.3)+"");
		//使设置好的布局参数应用到控件
		rl_scene_detail_bg_img.setLayoutParams(linearParams);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.tv_commnet_more:
			startActivity(new Intent(mContext, CommentListActivity.class));
			break;
		case R.id.tv_join_scene:
			startActivity(new Intent(mContext, MyServiceListAvtivity.class));
			break;
		case R.id.tv_use_scene:
			startActivity(new Intent(mContext, PaceOrderByAdressActivity.class));
			break;
		case R.id.tv_scence_describe:
			if(isSpread){
				isSpread = false;
			}else{
				isSpread = true;
			}
			changeWebViewHeight();
			break;
		case R.id.img_own_like:
			if(isLike){
				img_own_like.setImageResource(R.drawable.scene_heart_choose);
				isLike = false;
			}else{
				img_own_like.setImageResource(R.drawable.scene_heart);
				isLike = true;
			}
			
			break;
		default:
			break;
		}
	}

	private void changeWebViewHeight() {
		LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) wv_scene_describe.getLayoutParams();
		if(isSpread){
			linearParams.height = 365; // 当控件的高强制设成365象素
		}else{
			linearParams.height = 200; // 当控件的高强制设成200象素
		}
		wv_scene_describe.setLayoutParams(linearParams);
	}
	
	 /** 
     * 窗口有焦点的时候，即所有的布局绘制完毕的时候，我们来获取购买布局的高度和myScrollView距离父类布局的顶部位置 
     */  
    @Override    
    public void onWindowFocusChanged(boolean hasFocus) {    
        super.onWindowFocusChanged(hasFocus);    
        if(hasFocus){  
        	sceneLayoutHeight = tv_scene_content.getHeight();  
            sceneLayoutTop = tv_scene_content.getTop();  
              
            myScrollViewTop = scroll_view.getTop();  
        }  
    }   
  
    /** 
     * 滚动的回调方法，当滚动的Y距离大于或者等于 内容布局距离父类布局顶部的位置，就显示有内容的标题 
     * 当滚动的Y的距离小于 内容布局距离父类布局顶部的位置加上内容布局的高度就显示无内容的标题 
     *  
     */  
	@Override
	public void onScroll(int scrollY) {
		if(scrollY >= sceneLayoutTop + sceneLayoutHeight+rl_scene_detail_bg_img.getHeight()){  
			rl_title.setVisibility(View.GONE);
			rl_remove_title.setVisibility(View.VISIBLE);
      }else{  
    	  rl_title.setVisibility(View.VISIBLE);
			rl_remove_title.setVisibility(View.GONE);  
      }  
	}  
}
