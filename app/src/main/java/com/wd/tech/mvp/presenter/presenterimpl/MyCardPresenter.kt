package com.wd.tech.mvp.presenter.presenterimpl


import com.wd.tech.mvp.model.bean.DeletePostBean

import com.wd.tech.mvp.model.utils.RetrofitUtil
import com.wd.tech.mvp.presenter.base.BasePresenter
import com.wd.tech.mvp.view.activity.MyCardActivity
import com.wd.tech.mvp.model.bean.MyCardActivityBean
import com.wd.tech.mvp.view.contract.Contract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MyCardPresenter(val myCardActivity: MyCardActivity) : BasePresenter<Contract.IMyCardView>(),Contract.IMyCardPre
{
    override fun onIDeleltePost(hashMap: HashMap<String, String>, id: String) {
        val sslRetrofit = RetrofitUtil.instant.SSLRetrofit()
        sslRetrofit.getDeleltPost(hashMap,id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<DeletePostBean>(){
                override fun onNext(t: DeletePostBean) {
                    myCardActivity.onSuccess(t)
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }
            })
    }


    override fun onIMyCardPre(hashMap: HashMap<String, String>, page: Int, count: Int) {
        val sslRetrofit = RetrofitUtil.instant.SSLRetrofit()
        sslRetrofit.getMyCard(hashMap,page,count)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<MyCardActivityBean>(){
                override fun onNext(t: MyCardActivityBean) {
                    myCardActivity.onSuccess(t)
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }
            })
    }
}