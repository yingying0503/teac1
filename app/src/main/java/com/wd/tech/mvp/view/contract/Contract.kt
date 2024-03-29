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
        fun onIPushSuccess(communityListBean: CommunityListBean)
        fun onFail()
    }
    interface ICommunityListPre{
        fun onICommunityListPre(hashMap: HashMap<String,String>,page:Int,count:Int)
        fun onIPushCommunityListPre(hashMap: HashMap<String,String>,page:Int,count:Int)
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
        fun onInfoRecommendList(hashMap: HashMap<String, String>,page:Int,count:Int)
        //广告
        fun onInfoAdvertising()
        //咨询收藏
        fun onIAddCollectionPre(hashMap: HashMap<String, String>,infoId:Int)
        //取消收藏
        fun onICancelCollectionPre(hashMap: HashMap<String, String>,infoId:Int)
    }
    /**
     * 咨询详情页面
     */
    interface  IInfoDetailView
    {
        fun onSuccess(any: Any)
        fun onDetailCommentSuccess(any: Any)
        fun onWxShare(any: Any)
        fun onFail()
    }
    interface IInfoDetailPre{
        //详情
        fun onInfoDetailPre(map: HashMap<String, String>,id:Int)
        //详情评论
        fun onDetailCommentPre(infoId:Int,page: Int,count: Int)
        //详情咨询点赞
        fun onIAddGreatRecordPre(hashMap: HashMap<String, String>,map: HashMap<String, String>)
        //详情取消点赞
        fun onICancelGreaPre(hashMap: HashMap<String, String>,map: HashMap<String, String>)
        //咨询收藏
        fun onIAddCollectionPre(hashMap: HashMap<String, String>,infoId:Int)
        //取消收藏
        fun onICancelCollectionPre(hashMap: HashMap<String, String>,infoId:Int)
        //添加评论
        fun onIAddInfoCommentPre(hashMap: HashMap<String, String>,infoId:Int,content: String)
        //分享
        fun onIWxShare(hashMap:HashMap<String, String>?)
    }
    /**
     * 咨询搜索item展示
     */
    interface  IInfoSelectView
    {
        fun onSuccess(any: Any)
        fun onFail()
    }
    interface oInfoSelectPre
    {
        fun onfindAllInfoPlate(hashMap: HashMap<String, String>)

    }
    /**
     * 搜索的item点击展示列表
     */
    interface  IInfoSelectPlateView
    {
        fun onSuccess(any: Any)
        fun onFail()
    }
    interface oInfoSelectPlatePre
    {
        fun onByTitle(title:String,page:Int,count:Int)
        fun onBySource(source:String,page:Int,count:Int)
        fun onfindAllInfoPlateByID(hashMap: HashMap<String, String>,plateId:Int,page:Int,count:Int)

    }
    /**
     * 所有版块查询
     */
    interface  IfindAllInfoPlateView
    {
        fun onSuccess(any: Any)
        fun onFail()
    }
    interface ofindAllInfoPlatePre
    {
        fun onfindAllInfoPlate(hashMap: HashMap<String,String>)
    }
    /**
     * 根据版块id进行查询
     */
    interface  IfindAllInfoPlateByIDView
    {
        fun onSuccess(any: Any)
        fun onFail()
    }
    interface ofindAllInfoPlateByIDPre
    {
        fun onfindAllInfoPlateByID( hashMap: HashMap<String,String>,plateId:Int,page:Int,count:Int)
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
        fun onUntiedFaceIdSuccess(any: Any)
        fun onFail()
    }
    interface ISettingUserInfoPre {
        fun onSettingIUserInfoPre(hashMap: HashMap<String,String>)
        fun onModifyHeadPicPre(hashMap: HashMap<String,String>,file: File)
        fun onUntiedFaceId(hashMap: HashMap<String,String>)
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
    /**
     * 好友分组
     */
    interface IMessageView {
        fun onSuccess(initFriendListBean: InitFriendListBean)
        fun onFail()
    }
    interface IMessagePre{
        fun onIMessagePre(hashMap: HashMap<String,String>)
    }
    /**
     * 积分兑换
     */
    interface IInfoPayByIntegralView{
        fun onSuccess(any: Any)
        fun onFail()
    }
    interface IInfoPayByIntegralPre{
        fun onIInfoPayByIntegralPre(hashMap: HashMap<String,String>,infoId: Int,integralCost:Int)
    }
    /**
     * 购买会员所有接口
     */
    interface IVipView{
        fun onSuccess(any: Any)
        fun onFail()
    }
    interface IVipPre{
        fun onIFindVipCommodityListPre()
        fun onIByVip(hashMap: HashMap<String, String>,commodityId: Int,sign:String)
    }
    /**
     * 我的积分
     */
    interface IMyCardView{
        fun onSuccess(any: Any)
        fun onFail()
    }
    interface IMyCardPre{
        fun onIMyCardPre(hashMap: HashMap<String, String>, page: Int, count: Int)
        fun onIDeleltePost(hashMap: HashMap<String, String>, id: String)
    }
    /**
     * 我的通知
     */
    interface IMyNoticeView{
        fun onSuccess(any: Any)
        fun onFail()
    }
    interface IMyNoticePre{
        fun onIMyNoticePre(hashMap: HashMap<String, String>, page: Int, count: Int)

    }
    /**
     * 我的积分
     */
    interface IMyScoreView{
        fun onSuccess(any: Any)
        fun onFail()
    }
    interface IMyScorePre{
        fun onIMyScorePre(hashMap: HashMap<String, String>)

    }
    /**
     * 好友详情界面
     */
    interface IFriendShowView{
        fun onPhoneSuccess(findUserByPhoneBean: FindUserByPhoneBean)
        fun onIdSuccess(friendInfoMationBean: FriendInfoMationBean)
        fun onAddSuccess(addFriendBean: AddFriendBean)
        fun onFail()
    }
    interface IFriendShowPre{
        fun onIFriendPhoneShowPre(hashMap: HashMap<String, String>,phone: String)
        fun onIFriendIdShowPre(hashMap: HashMap<String, String>,id: String)
        fun onIFriendAddShowPre(hashMap: HashMap<String, String>,friendUid: String,remark: String)
    }
    /**
     * 新的好友列表
     */
    interface INewFriendListView{
        fun onINewFriendListSuccess(findFriendNoticePageListBean: FindFriendNoticePageListBean)
        fun onIReviewFriend(reviewFriendApplyBean: ReviewFriendApplyBean)
        fun onFail()
    }
    interface INewFriendListPre{
        fun onINewFriendListPre(hashMap: HashMap<String, String>, page: Int, count: Int)
        fun onIReviewFriend(hashMap: HashMap<String, String>, noticeId: Int, flag: Int)
    }
    /**
     * 注册刷脸
     */
    interface IMyFaceRegView{
        fun onSuccess(any: Any)
        fun onFail()
    }
    interface IMyFaceRegPre{
        fun onIMyFacePre(hashMap: HashMap<String, String>,featureInfo:String)

    }
    /**
     *刷脸登录
     */
    interface IMyFaceLoginView{
        fun onSuccess(any: Any)
        fun onFail()
    }
    interface IMyFaceLoginPre{
        fun onIMyFaceLoginPre(faceId:String)

    }
}