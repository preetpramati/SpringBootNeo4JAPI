package com.bedrock.graphql.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bedrock.graphql.dao.entity.Member;
import com.bedrock.graphql.service.MemberService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
@Component
public class MemberMutation implements GraphQLMutationResolver{
	
	@Autowired
	public MemberService memberService;
	
	public Member createMember(final String name, final String location, final String experience, final String title, final String skillBucket, final String status, final String blockedFor, final String degree, final String year, final String field, final String college, final String resumeUrl) {
        return this.memberService.createMember(name, location, experience, title, skillBucket, status, blockedFor, degree, year, field, college, resumeUrl);
    }

}
