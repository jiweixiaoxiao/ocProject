package com.online.college.core.member.dao;


import com.online.college.common.page.TailPage;
import com.online.college.core.member.dto.MemberUser;

import java.util.List;

public interface MemberUserDao {
	int deleteByPrimaryKey(Integer id);

	int insert(MemberUser record);

	int insertSelective(MemberUser record);

	int getTotalItemsCount();

	MemberUser selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(MemberUser record);

	int updateByPrimaryKey(MemberUser record);

	/*
	 * 查找所有用户
	 */
	public List<MemberUser> queryAll(MemberUser entity);

	/*
	 * 分页查找用户列表
	 */
	public List<MemberUser> queryPage(MemberUser entity, TailPage<MemberUser> page);

}
