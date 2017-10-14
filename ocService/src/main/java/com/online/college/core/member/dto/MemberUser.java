package com.online.college.core.member.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class MemberUser {
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String memberName;
	private String memberSchool;
	private String memberPhone;
	private String memberEmail;
	private String memberWechat;
	private String memberGraduationDate;
	private String memberLoginIp;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp memberLoginTime;
	private Integer memberStatu;// 状态为0表示未读，状态为1表示已读，状态为3表示已读未联系
	private Integer memberExamStatu;//考试状态，0代表未通过考试，1代表通过考试
	private Integer memberDelStatu; //删除状态，0表示状态正常，1表示已删除
}
