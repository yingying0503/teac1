package com.wd.tech.mvp.view.activity;

import java.io.Serializable;

public class Face implements Serializable{
    String name;
    byte[] data;


    public Face(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
