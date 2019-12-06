package com.lyb.gmall.service;

import com.lyb.gmall.bean.PmsSkuInfo;

public interface SkuService {
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getSkuById(String skuId);
}
