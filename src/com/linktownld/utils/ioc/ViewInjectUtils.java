package com.linktownld.utils.ioc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.Activity;

public class ViewInjectUtils {
	
	private static String METHOD_SET_CONTENTVIEW="setContentView";
	private static final String METHOD_FIND_VIEW_BY_ID = "findViewById";  
	
	
	public static void inject(Activity activity)  
    {  
          
        injectContentView(activity);  
        injectViews(activity);  
          
    }  
	/** 
     * 注入主布局文件 
     *  
     * @param activity 
     */  
    private static void injectContentView(Activity activity)  
    {  
        Class<? extends Activity> clazz = activity.getClass();  
        // 查询类上是否存在ContentView注解  
        ContentView contentView = clazz.getAnnotation(ContentView.class);  
        if (contentView != null)// 存在  
        {  
            int contentViewLayoutId = contentView.value();  
            try  
            {  
//                Method method = clazz.getMethod(METHOD_SET_CONTENTVIEW,  
//                        int.class);  
//                method.setAccessible(true);  
//                method.invoke(activity, contentViewLayoutId);  
                activity.setContentView(contentViewLayoutId);
            } catch (Exception e)  
            {  
                e.printStackTrace();  
            }  
        }  
    }  
    /** 
     * 注入所有的控件 
     *  
     * @param activity 
     */  
    private static void injectViews(Activity activity)  
    {  
        Class<? extends Activity> clazz = activity.getClass();  
        Field[] fields = clazz.getDeclaredFields();  
        // 遍历所有成员变量  
        for (Field field : fields)  
        {  
              
            ViewInject viewInjectAnnotation = field  
                    .getAnnotation(ViewInject.class);  
            if (viewInjectAnnotation != null)  
            {  
                int viewId = viewInjectAnnotation.value();  
                if (viewId != -1)  
                {  
                    // 初始化View  
                    try  
                    {  
                        Method method = clazz.getMethod(METHOD_FIND_VIEW_BY_ID,  
                                int.class);  
                        Object resView = method.invoke(activity, viewId);  
                        field.setAccessible(true);  
                        field.set(activity, resView);  
                    } catch (Exception e)  
                    {  
                        e.printStackTrace();  
                    }  
  
                }  
            }  
  
        }  
  
    }  

}
