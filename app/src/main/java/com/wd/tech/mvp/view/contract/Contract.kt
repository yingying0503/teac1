package com.wd.tech.mvp.view.contract

import com.wd.tech.mvp.model.bean.*
import java.io.File

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
        //轮播图
        fun onSuccessBanner(any: Any)
        //资讯推荐展示列表(包含单独板块列表展示)
        fun onSuccessInfoRecommendList(any: Any)
        //咨询点赞
        fun onIAddGreatRecordSucccess(any: Any)
        //取消点赞
        fun onICancelGreaSucccess(any: Any)
        fun onFail()
    }
    interface IInformationPre{
        //轮播图
        fun onIBannerPre()
        //资讯推荐展示列表(包含单独板块列表展示)
        fun onInfoRecommendList(plateId:Int,page:Int,count:Int)
        //广告
        fun onInfoAdvertising()
        //咨询点赞
        fun onIAddGreatRecordPre(hashMap: HashMap<String, String>,infoId:Int)
        //取消点赞
        fun onICancelGreaPre(hashMap: HashMap<String, String>,infoId:Int)
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
        fun onIWechatLoginPre(ak:String,code:String)
    }
    /**
     * 设置主页查询用户
     */
    interface ISettingUserInfoView {
        fun onSuccess(userInfoBean: UserInfoBean)
        fun onModifyHeadPicSuccess(modifyHeadPicBean: ModifyHeadPicBean)
        fun onFail()
    }
    interface ISettingUserInfoPre {
        fun onSettingIUserInfoPre(hashMap: HashMap<String,String>)
        fun onModifyHeadPicPre(hashMap: HashMap<String,String>,file: File)
    }
    /**
     * 用户发布帖子
     */
    interface IUserPushCommentView {
        fun onSuccess(releasePostBean: ReleasePostBean)
        fun onFail()
    }
    interface IUserPushCommentPre{
        fun onIUserPushCommentPre(hashMap: HashMap<String,String>,content: String,list : ArrayList<File>)
    }
}