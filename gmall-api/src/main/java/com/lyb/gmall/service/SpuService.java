package com.lyb.gmall.service;

import com.lyb.gmall.bean.PmsProductInfo;

import java.util.List;

public interface SpuService {

    List<PmsProductInfo> spuList(String catalog3Id);
}
