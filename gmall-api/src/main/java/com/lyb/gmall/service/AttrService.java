package com.lyb.gmall.service;

import com.lyb.gmall.bean.PmsBaseAttrInfo;
import com.lyb.gmall.bean.PmsBaseAttrValue;
import com.lyb.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
