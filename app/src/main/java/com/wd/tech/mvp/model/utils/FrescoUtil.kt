package com.wd.tech.mvp.model.utils

import android.net.Uri
import com.facebook.drawee.view.SimpleDraweeView

class FrescoUtil {
    public fun setPic(url : String, simpleDraweeView : SimpleDraweeView){
        var url : Uri = Uri.parse(url)
        simpleDraweeView.setImageURI(url,this)
    }
}