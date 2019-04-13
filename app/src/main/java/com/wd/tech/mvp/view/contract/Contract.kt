package com.wd.tech.mvp.view.contract

import com.wd.tech.mvp.model.bean.LoginBean
import com.wd.tech.mvp.model.bean.RegBean

class Contract
{
    /**
     * 登录
     */
    interface ILoginView
    {
        fun onSuccess(loginBean: LoginBean)
        fun onFail()
    }
    interface ILoginPre
    {
      fun onILoinPre(phone:String,pwd:String)
    }
    interface ILoginModel
    {
      fun onILoginModel(phone:String,pwd:String,loginCallBack: LoginCallBack)
    }
    interface LoginCallBack{
       fun  loadSuccess(loginBean: LoginBean)
        fun loadFail()
    }
    /**
     * 注册
     */
    interface IRegView
    {
        fun onSuccess(regBean: RegBean)
        fun onFail()
    }
    interface IRegPre
    {
        fun onIRegPre(phone:String,nickName:String,pwd:String)
    }
    interface IRegModel
    {
        fun onIRegModel(phone:String,nickName:String,pwd:String,regCallBack: RegCallBack)
    }
    interface RegCallBack{
        fun  loadSuccess(regBean: RegBean)
        fun loadFail()
    }
}