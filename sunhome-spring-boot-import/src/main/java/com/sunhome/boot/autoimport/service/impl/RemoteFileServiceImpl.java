package com.sunhome.boot.autoimport.service.impl;


import com.sunhome.boot.autoimport.service.FileService;

public class RemoteFileServiceImpl implements FileService {

    @Override
    public void read() {
        System.out.println("远程文件读");
    }

    @Override
    public void write() {
        System.out.println("远程文件写");

    }
}
