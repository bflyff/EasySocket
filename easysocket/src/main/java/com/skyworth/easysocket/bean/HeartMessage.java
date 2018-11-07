package com.skyworth.easysocket.bean;


import android.support.annotation.NonNull;

import com.skyworth.easysocket.Protocol;

/**
 * 作者：Ice Nation
 * 日期：2018/5/10 18:00
 * 邮箱：tangjie@skyworth.com
 */

public class HeartMessage extends EasyMessage {

    private String tag = null;

    public HeartMessage(EasyMessage message) {
        super(message.bytes, message.length);
        init();
    }

    private void init() {
        tag = readString(START_DATA,length - START_DATA);
    }

    public String getTag() {
        return tag;
    }

    public static EasyMessage create(@NonNull String tag, int code){
        return new Builder()
                .setType(Protocol.HEART)
                .setCode(code)
                .addData(tag)
                .build();
    }
}
