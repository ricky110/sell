package com.huawei.utils;

import com.huawei.VO.ResultVO;

/**
 * @Author: Ricky
 * @Date: 2019-09-24 12:04
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
