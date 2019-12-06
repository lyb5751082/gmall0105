package com.lyb.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lyb.gmall.bean.PmsSkuAttrValue;
import com.lyb.gmall.bean.PmsSkuImage;
import com.lyb.gmall.bean.PmsSkuInfo;
import com.lyb.gmall.bean.PmsSkuSaleAttrValue;
import com.lyb.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.lyb.gmall.manage.mapper.PmsSkuImageMapper;
import com.lyb.gmall.manage.mapper.PmsSkuInfoMapper;
import com.lyb.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.lyb.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;


    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {

        // 插入skuInfo
        int i = pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();

        // 插入平台属性关联
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }

        // 插入销售属性关联
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuId);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }

        // 插入图片信息
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(skuId);
            pmsSkuImageMapper.insertSelective(pmsSkuImage);
        }

    }

    @Override
    public PmsSkuInfo getSkuById(String skuId) {
        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        pmsSkuInfo.setId(skuId);
        PmsSkuInfo skuInfo = pmsSkuInfoMapper.selectOne(pmsSkuInfo);
        PmsSkuImage pmsSkuImage=new PmsSkuImage();
        pmsSkuImage.setSkuId(skuId);
        List<PmsSkuImage> pmsSkuImages=pmsSkuImageMapper.select(pmsSkuImage);
        pmsSkuInfo.setSkuImageList(pmsSkuImages);
        return skuInfo;
    }


}
