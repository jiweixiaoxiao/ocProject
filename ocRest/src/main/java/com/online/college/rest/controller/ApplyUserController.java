package com.online.college.rest.controller;


import com.online.college.common.page.TailPage;
import com.online.college.core.member.dto.MemberUser;
import com.online.college.core.member.service.impl.MemberUserService;
import com.online.college.core.member.vo.ResultVoUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// TODO 异常处理重新写
@Controller
@RequestMapping("/applyUserManager")
public class ApplyUserController {

    @Autowired
    private MemberUserService memberUserService;



    /*
     * 会员申请接口
     */
    @RequestMapping(value = "/applyUserManagerAdd",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String addMemberUser(MemberUser entity, HttpServletRequest request,HttpServletResponse response){
        if(StringUtils.isEmpty(entity.getMemberName()) ||
                StringUtils.isEmpty(entity.getMemberSchool()) ||
                StringUtils.isEmpty(entity.getMemberGraduationDate()) ||
                StringUtils.isEmpty(entity.getMemberPhone()) ||
                StringUtils.isEmpty(entity.getMemberEmail())){
            try {
                return request.getParameter("callback")+"("+ResultVoUtils.message("存在空值","104")+")";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
             String resultMsg = memberUserService.createMemberUserInfo(entity);
            return request.getParameter("callback")+"("+resultMsg+")";
        } catch (IOException e) {
            e.printStackTrace();
            String resultErr = null;
            try {
                resultErr = ResultVoUtils.message("服务器异常，请稍后再试","106");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            return request.getParameter("callback")+"("+resultErr+")";
        }
    }

    /*
     * 逻辑删除学员信息
     */
    @RequestMapping(value = "/applyUserManagerDel")
    @ResponseBody
    public String deleteMember(Integer id) throws IOException {
        return memberUserService.deleteLogic(id);
    }


}