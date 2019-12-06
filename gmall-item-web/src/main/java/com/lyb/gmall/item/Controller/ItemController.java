package com.lyb.gmall.item.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lyb.gmall.bean.PmsProductSaleAttr;
import com.lyb.gmall.bean.PmsSkuInfo;
import com.lyb.gmall.service.SkuService;
import com.lyb.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@CrossOrigin
public class ItemController {
    @Reference
    SpuService spuService;
    @Reference
    SkuService skuService;

    @RequestMapping("{skuId}.html")
    public String item(@PathVariable String skuId,ModelMap map){
        //先要显示出所有销售属性,然后再将当前的sku选中的属性和属性值返回给页面PmsSkuInfo pmsSkuInfo=skuService.getSkuById(skuId);
        //拿到sku对象
        PmsSkuInfo pmsSkuInfo=skuService.getSkuById(skuId);
        map.put("skuInfo",pmsSkuInfo);
        //销售属性对象,这里仔细看这个sql,他是把当前商品的属性值上 set了一个ischecked
        // 直接在页面上会显示被选中的状态
        //SELECT
        //	sa.id as sa_id,sav.id as sav_id,sa.*,sav.*,if(ssav.sku_id,1,0)<等于1true 0 false>as isChecked
        //FROM
        //	pms_product_sale_attr sa
        //INNER JOIN pms_product_sale_attr_value sav ON sa.product_id = sav.product_id
        //AND sa.sale_attr_id = sav.sale_attr_id
        //AND sa.product_id = #{productId}
        //LEFT JOIN pms_sku_sale_attr_value ssav ON sav.id = ssav.sale_attr_value_id
        //AND ssav.sku_id = #{skuId}
       List<PmsProductSaleAttr>pmsProductSaleAttrs=spuService.spuSaleAttrListCheckBySku(pmsSkuInfo.getProductId(),skuId);
        map.put("spuSaleAttrListCheckBySku",pmsProductSaleAttrs);
        return "item";
    }


    @RequestMapping("index")
    public String index(ModelMap modelMap){
        List<String>list=new ArrayList<>();
        for (int i=0;i<5;i++){
           list.add("循环数据为"+i);
        }
        modelMap.put("list",list);
        modelMap.put("hello","hello thymeleaf");
        modelMap.put("check","1");
        return "index";
    }
}
