package com.online.college.core.member.service.impl;


import com.online.college.common.page.TailPage;
import com.online.college.common.util.JsonUtil;
import com.online.college.core.member.dao.MemberUserDao;
import com.online.college.core.member.dto.MemberUser;
import com.online.college.core.member.service.IMemberUserService;
import com.online.college.core.member.vo.ResultVo;
import com.online.college.core.member.vo.ResultVoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MemberUserService implements IMemberUserService {
	@Autowired
	private MemberUserDao memberUserDao;

	@Override
	public String createMemberUserInfo(MemberUser entity) throws IOException {

			this.memberUserDao.insertSelective(entity);
			return ResultVoUtils.success();

	}

	@Override
	public ResultVo updateMemberUserInfo(MemberUser entity) {
		memberUserDao.updateByPrimaryKeySelective(entity);
		return null;
	}

	@Override
	public String getById(Long id) {
		MemberUser memberUser = memberUserDao.selectByPrimaryKey(id);
		try {
			if (memberUser != null){
			return ResultVoUtils.success(memberUser);
			}
			else {
				return ResultVoUtils.error();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String queryAll(MemberUser entity) throws IOException {
		return JsonUtil.toJson(memberUserDao.queryAll(entity));
	}

	@Override
	public TailPage<MemberUser> queryPage(MemberUser entity, TailPage<MemberUser> page) throws IOException {

		List<MemberUser> memberUserList =memberUserDao.queryPage(entity, page);
		int total = memberUserDao.getTotalItemsCount();
		page.setItemsTotalCount(total);
		page.setItems(memberUserList);
		 return page;
	}

	@Override
	public String deleteLogic(Integer id){
		int result = memberUserDao.deleteByPrimaryKey(id);
		try {
			if(result>0) {
				return ResultVoUtils.success("删除成功","1");
			}
			return ResultVoUtils.error();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
