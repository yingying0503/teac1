package com.wd.tech.mvp.view.contract

import com.wd.tech.mvp.model.bean.*

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
    /**
     * 社区类表
     */
    interface ICommunityListView{
        fun onSuccess(communityListBean: CommunityListBean)
        fun onFail()
    }
    interface ICommunityListPre{
        fun onICommunityListPre(hashMap: HashMap<String,String>,page:Int,count:Int)
    }
    /**
     * 咨询展示
     */
    interface  IInformationView
    {
        fun onSuccessBanner(any: Any)
        fun onSuccessInfoRecommendList(any: Any)
        fun onFail()
    }
    interface IInformationPre{
        //轮播图
        fun onIBannerPre()
        //资讯推荐展示列表(包含单独板块列表展示)
        fun onInfoRecommendList(plateId:Int,page:Int,count:Int)
        //广告
        fun onInfoAdvertising()
    }
    /**
     * 咨询详情页面
     */
    interface  IInfoDetailView
    {
        fun onSuccess(any: Any)
        fun onDetailCommentSuccess(any: Any)
        fun onFail()
    }
    interface IInfoDetailPre{
        //详情
        fun onInfoDetailPre(id:Int)
        //详情评论
        fun onDetailCommentPre(infoId:Int,page: Int,count: Int)
    }
    /**
     * 主页查询用户
     */
    interface IUserInfoView {
        fun onSuccess(userInfoBean: UserInfoBean)
        fun onSignSuccess(userSignBean: UserSignBean)
        fun onFail()
    }
    interface IUserInfoPre {
        fun onIUserInfoPre(hashMap: HashMap<String,String>)
        fun onIUserSignPre(hashMap: HashMap<String,String>)
    }
    /**
     *关注列表
     */
    interface IInfoCollectionView {
        fun onInfoCollectionSuccess(infoCollectionBean: InfoCollectionBean)
        fun onFail()
    }
    interface IInfoCollectionPre {
        fun onIInfoCollectionPre(hashMap: HashMap<String,String>,page:Int,count:Int)
    }
    /**
     * 微信登录
     */
    interface IWechatLoginView{
        fun onIWechatLoginSuccess(any: Any)
        fun onIWechatLoginFail()
    }
    interface IWechatLoginPre{
        fun onIWechatLoginPre(code:String)
    }
}