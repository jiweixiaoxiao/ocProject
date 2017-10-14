package com.online.college.core.member.vo;

import com.alibaba.fastjson.JSON;
import com.online.college.common.util.JsonUtil;
import com.online.college.core.member.enums.ResultEnum;
import lombok.Data;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-10
 * Time: 13:20
 */
@Data
public class ResultVoUtils {
    private String code;
    private String msg;

    public static String success() throws IOException {
        return success(null);
    }
    @Deprecated
    public  static String success(String msgp,String codep) throws  IOException{
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(codep);
        resultVo.setMsg(msgp);
        return  JSON.toJSONString(resultVo);
    }

    public static String success(Object object) throws IOException {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setMsg(ResultEnum.SUCCESS.getMsg());
        resultVo.setObject(object);
        String result = JSON.toJSONString(resultVo);
        return result;
    }

    public  static String message (String msgp,String codep) throws  IOException{
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(codep);
        resultVo.setMsg(msgp);
        return  JSON.toJSONString(resultVo);
    }


    public static String error() throws IOException {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.ERROR.getCode());
        resultVo.setMsg(ResultEnum.ERROR.getMsg());
        return JSON.toJSONString(resultVo);
    }
}
