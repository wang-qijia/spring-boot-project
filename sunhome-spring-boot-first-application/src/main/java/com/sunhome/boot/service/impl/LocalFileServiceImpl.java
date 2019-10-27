package com.sunhome.boot.service.impl;

import com.sunhome.boot.service.FileService;

public class LocalFileServiceImpl implements FileService {

    @Override
    public void read() {
        System.out.println("本地读");
    }

    @Override
    public void write() {
        System.out.println("本地写");

    }
}
