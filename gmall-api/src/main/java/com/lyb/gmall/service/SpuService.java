package com.lyb.gmall.service;

import com.lyb.gmall.bean.PmsProductImage;
import com.lyb.gmall.bean.PmsProductInfo;
import com.lyb.gmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {

    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    String updateSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);


    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId,String skuId);
}
