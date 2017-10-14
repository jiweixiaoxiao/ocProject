package com.online.college.opt.controller;

import com.online.college.common.page.TailPage;
import com.online.college.common.web.JsonView;
import com.online.college.core.member.dto.MemberUser;
import com.online.college.core.member.service.impl.MemberUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-10
 * Time: 17:29
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberUserService memberUserService;
    /*
    获取分页列表数据
     */
    @RequestMapping("/getMemberList")
    public ModelAndView queryPage(MemberUser memberUser, TailPage<MemberUser> page){
        ModelAndView modelAndView = new ModelAndView("cms/user/memberPageList");
        modelAndView.addObject("curNav","member");
        try {
           page =  memberUserService.queryPage(memberUser,page);
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("page",page);
        modelAndView.addObject("queryEntity",memberUser);
        return  modelAndView;
    }

    @RequestMapping("/getById")
    @ResponseBody
    public String getById(Long id){
        return memberUserService.getById(id);
    }

    @RequestMapping(value = "/doMerge")
    @ResponseBody
    public String doMerge(MemberUser memberUser){
        memberUserService.updateMemberUserInfo(memberUser);
        return new JsonView(0).toString();
    }

    @RequestMapping(value = "/doDel")
    @ResponseBody
    public String doDel(Long id){
        return memberUserService.deleteLogic(new Long(id).intValue());
    }
}
