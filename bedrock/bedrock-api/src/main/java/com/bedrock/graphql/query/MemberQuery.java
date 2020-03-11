package com.bedrock.graphql.query;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bedrock.graphql.dao.entity.Member;
import com.bedrock.graphql.exception.CustomException;
import com.bedrock.graphql.service.MemberService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class MemberQuery implements GraphQLQueryResolver{
	
	@Autowired
	public MemberService memberService;
	
    private static final Logger logger = LogManager.getLogger(MemberQuery.class);

	public List<Member> getMembers(final int count) {
        return this.memberService.getAllMembers(count);
    }

    
    public List<Member> getMemberByName( String name) {
    	
    	logger.info("Member by name query resolver ");

    	if(this.memberService.getMemberByName(name).size() == 0)
        {
        	throw new CustomException("no memeber data");
        }else {
        	return this.memberService.getMemberByName(name);
        }
    }
    

    
    public List<Member> searchMember( String name, String skillBucket, Long empId, String pName) {
    	logger.info("search member query resolver ");
    	if(this.memberService.searchMemberByNameAndSkillAndEmpId(name, skillBucket, empId, pName).size() == 0) {
    		throw new CustomException("invalid request");
    	}else {
        return this.memberService.searchMemberByNameAndSkillAndEmpId(name, skillBucket, empId, pName);
    	}
    }
    
	public Optional<Member> getMember(final Long id) {
        return this.memberService.getMember(id);
    }
	
	public List<Member> getAllMembersWithContribution(String skill){
		return this.memberService.getMemberWithContribution(skill);
	}
	
	public List<Member> getAllMembersWithSkill(String skill){
		return this.memberService.getMemberWithSkill(skill);
	}
	
	public List<Member> getAllMembersWithCertfication(String skill){
		return this.memberService.getMemberWithCertification(skill);
	}
	
	public List<Member> getAllMemberWithCreatedAsset(String skill){
		return this.memberService.getMemberWithCreatedAsset(skill);
	}

	public List<Member> getAllMemberWithBillingInProject(String skill){
		return this.memberService.getMemberWithBillingInProject(skill);
	}
	
	public List<Member> getAllMemberReportsToManager(String skill){
		return this.memberService.getAllMemberReportsToManager(skill);
	}
	

}
