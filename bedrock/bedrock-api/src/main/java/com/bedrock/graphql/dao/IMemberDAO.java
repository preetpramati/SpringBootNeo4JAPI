package com.bedrock.graphql.dao;

import java.util.List;

import com.bedrock.graphql.dao.entity.Member;


public interface IMemberDAO {
	
	public List<Member> searchMember(String memberName, Long empId, String skillBucket, String projectName);

}
