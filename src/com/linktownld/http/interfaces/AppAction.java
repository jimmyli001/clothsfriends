package com.linktownld.http.interfaces;

import com.linktownld.bean.UserBean;
import com.linktownld.http.callback.ActionCallbackListener;

/**
 *  连接 业务 接口
 * @author LBS778
 *
 */
public interface AppAction {

	// 登录
    public void login(String loginName, String password, ActionCallbackListener<UserBean> listener);
    
}
