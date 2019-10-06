package com.huawei.controller;

import com.huawei.VO.ProductInfoVO;
import com.huawei.VO.ProductVO;
import com.huawei.VO.ResultVO;
import com.huawei.dataobject.ProductCategory;
import com.huawei.dataobject.ProductInfo;
import com.huawei.service.CategoryService;
import com.huawei.service.ProductService;
import com.huawei.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Ricky
 * @Date: 2019-09-23 15:01
 */

/**
 *
 *  @RestController  返回的是JSON格式，所以用此注解
 *
 *  @RequestMapping 请求路径
 *
 */

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        //1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 查询类目（一次性查询）
//        List<Integer> categoryTpyeList = new ArrayList<>();
//        //传统方法
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTpyeList.add(productInfo.getCategoryType());
//        }
        //精简方法（Java8，lambda）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e->e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
                //类目循环
        for (ProductCategory productCategory : productCategoryList) {
            // 类目列表
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            // 商品循环
            for (ProductInfo productInfo : productInfoList) {
                // 类目相等时 将该商品添加到类目列表中
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    // copy属性
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    // 该循环类型下  有多少的对应类目的商品添加进来
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            // 类目列表 list 最后将其添加到 结果视图 resultVO 中
            productVOList.add(productVO);
        }

//        ResultVO resultVO = new ResultVO();

        //测试用
//        ProductVO productVO = new ProductVO();
//        ProductInfoVO productInfoVO = new ProductInfoVO();
//
//        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
//
//        resultVO.setData(Arrays.asList(productVO));

//        resultVO.setData(productVOList);
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        return resultVO;

        return ResultVOUtil.success(productVOList);
    }
}
