package com.online.college.core.member.service;



import com.online.college.common.page.TailPage;
import com.online.college.core.member.dto.MemberUser;
import com.online.college.core.member.vo.ResultVo;

import java.io.IOException;

public interface IMemberUserService {
	/*
	 * 增加一个会员用户
	 */
	public String createMemberUserInfo(MemberUser entity) throws IOException;
	/*
	 * 根据id更新一个会员用户信息
	 */
	public ResultVo updateMemberUserInfo(MemberUser entity);
	/*
	 * 根据id查找一个用户
	 */
	public String getById(Long id);
	/*
	 * 查找所有用户
	 */
	public String queryAll(MemberUser entity) throws IOException;
	/*
	 * 分页查找用户列表
	 */
	public TailPage<MemberUser> queryPage(MemberUser entity, TailPage<MemberUser> page) throws IOException;
	/*
	 * 逻辑删除用户
	 */
	public String deleteLogic(Integer id) throws IOException;
	
}
