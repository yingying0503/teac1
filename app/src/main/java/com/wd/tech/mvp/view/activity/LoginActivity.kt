package com.wd.tech.mvp.view.activity


import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.api.BasicCallback

import com.wd.tech.base.RsaCoder
import com.wd.tech.mvp.model.bean.LoginBean
import com.wd.tech.mvp.model.utils.AccountValidatorUtil
import com.wd.tech.mvp.presenter.presenterimpl.LoginPresenter
import com.wd.tech.mvp.view.base.BaseActivity
import com.wd.tech.mvp.view.contract.Contract
import kotlinx.android.synthetic.main.activity_login.*


import com.tencent.mm.opensdk.modelmsg.SendAuth
import com.wd.tech.R
import com.wd.tech.mvp.model.app.MyApp
import com.wd.tech.mvp.model.utils.WeiXinUtil


class LoginActivity : BaseActivity<Contract.ILoginView, LoginPresenter>(),Contract.ILoginView, View.OnClickListener {
    var loginPresenter : LoginPresenter?=null
    var accountValidatorUtil:AccountValidatorUtil?=null
    private var sp: SharedPreferences? = null
    var b : Boolean = false
    var phone : String ?= null
    var pwd : String ?= null

    override fun createPresenter(): LoginPresenter? {
         loginPresenter = LoginPresenter(this);
        return loginPresenter
    }
    override fun initActivityView(savedInstanceState: Bundle?){
        setContentView(R.layout.activity_login)
    }
    override fun initData() {
        b = sp!!.getBoolean("记住", false)
        if (b) {
            login_phone!!.setText(sp!!.getString("name", ""))
            login_pwd.setText(sp!!.getString("pass", ""))
            login_remember_pwd.setChecked(b)
        }
    }
    override fun initView() {
        login_btn.setOnClickListener(this)
        login_reg.setOnClickListener(this)
        login_pwd_eye.setOnClickListener(this)
        login_wechat.setOnClickListener(this)
        login_faceCheck.setOnClickListener(this)
        accountValidatorUtil = AccountValidatorUtil()
        sp = getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
//        PermissonUtil.checkPermission(this, object : PermissionListener {
//            override fun havePermission() {
//
//                //激活活体检测
//                LivenessService.activeEngine(object : LivenessActiveListener {
//                    override fun activeSucceed() {
//                        toast("激活成功")
//                    }
//
//                    override fun activeFail(massage: String) {
//                        Log.d("激活活体检测失败", massage)
//                        toast("激活失败：$massage")
//                    }
//                })
//            }
//
//            override fun requestPermissionFail() {
//                toast("活体检测激活失败")
//                finish()
//            }
//        }, Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE)

    }

    override fun onSuccess(loginBean: LoginBean){
        if(loginBean.status.equals("0000")) { val sp = getSharedPreferences("User", Context.MODE_PRIVATE)
            sp.edit().putString("userId", loginBean.result.userId).putString("sessionId", loginBean.result.sessionId).putString("phone", phone).putString("pwd", pwd).putInt("vip",loginBean.result.whetherVip).commit()

            if(login_remember_pwd.isChecked){
                sp.edit().putString("type","1").commit()
            }else{
                sp.edit().putString("type","2").commit()
            }
            JMessageClient.register(phone,pwd,object : BasicCallback(){
                override fun gotResult(p0: Int, p1: String?) {
                    JMessageClient.login(phone,pwd,object : BasicCallback(){
                        override fun gotResult(p0: Int, p1: String?) {
                            Log.i("极光",p1)
                        }
                    })
                }
            })
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            intent.putExtra("first","1")
            startActivity(intent)
            Toast.makeText(this,loginBean.message,Toast.LENGTH_LONG).show()
            finish()
        }
    }

    override fun onFail() {

    }
    override fun onClick(v: View?) {
        when(v!!.id)
        {
            //登录按钮点击事件
            R.id.login_btn ->{
                pwd =  login_pwd.text.toString().trim()
                //加密后的密码
                var passWord = RsaCoder.encryptByPublicKey(pwd)
                //验证密码
                val password = accountValidatorUtil!!.isPassword(pwd!!)
                if (!password) {
                    Toast.makeText(this, "输入密码不合法", Toast.LENGTH_LONG).show()
                }
                phone = login_phone.text.toString().trim()
                //判断手机号是否合法
                val mobile = accountValidatorUtil!!.isMobile(phone!!)
                if(!mobile)
                {
                    Toast.makeText(this,"输入数据不合法，请检查",Toast.LENGTH_LONG).show()
                    return
                }else{
                    loginPresenter!!.onILoinPre(phone!!,passWord)
                }
                //记住密码
                val edit = sp!!.edit()
                edit.putString("name", phone!!)
                edit.putString("pass", pwd!!)
                edit.putBoolean("记住", login_remember_pwd.isChecked())
                edit.commit()
            }
            R.id.login_reg->{
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
            R.id.login_wechat->{
                if (!WeiXinUtil.success(this)) {
                    Toast.makeText(this, "请先安装应用", Toast.LENGTH_SHORT).show()
                } else {
                    //  验证
                    val req = SendAuth.Req()
                    req.scope = "snsapi_userinfo"
                    req.state = "wechat_sdk_demo_test_neng"
                    WeiXinUtil.reg(this@LoginActivity)!!.sendReq(req)
                    finish()
                }

            }
            //人脸识别
            R.id.login_faceCheck->
            {
                // 人脸登录
                if ((application as MyApp).mFaceDB!!.mRegister.isEmpty()) {
                    Toast.makeText(this, "没有注册人脸，请先注册！", Toast.LENGTH_SHORT).show()
                } else {
                    AlertDialog.Builder(this)
                        .setTitle("请选择相机")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setItems(
                            arrayOf("后置相机", "前置相机")
                        ) { dialog, which -> startDetector(which) }
                        .show()
                }
            }
        }
    }

    fun toast(test: String) {
        runOnUiThread { Toast.makeText(this@LoginActivity, test, Toast.LENGTH_SHORT).show() }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(loginPresenter!=null)
        {
            loginPresenter!!.detachView()
        }
    }
    fun startDetector(camera: Int) {
        val it = Intent(this@LoginActivity, DetecterActivity::class.java)
        it.putExtra("Camera", camera)
        startActivity(it)
        finish()
    }
}
