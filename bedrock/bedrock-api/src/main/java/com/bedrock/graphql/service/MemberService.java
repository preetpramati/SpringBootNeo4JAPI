package com.bedrock.graphql.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bedrock.graphql.dao.entity.Member;
import com.bedrock.graphql.dao.impl.MemberDAO;
import com.bedrock.graphql.dao.repository.MemberRepository;

@Service
public class MemberService {
	
	private static final Logger logger = LogManager.getLogger(MemberService.class);
	
	
	@Autowired
	public MemberDAO memberDAO;
	
	private final MemberRepository memberRepository;
	
	public MemberService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository ;
    }
	
	@Transactional
	public Member createMember(final String name, final String location, final String experience, final String title, final String skillBucket, final String status, final String blockedFor, final String degree, final String year, final String field, final String college, final String resumeUrl) {
		Member member = new Member();
		member.setName(name);
		member.setLocation(location);
		member.setExperience(experience);
		member.setTitle(title);
		member.setSkillBucket(skillBucket);
		member.setStatus(status);
		member.setBlockedFor(blockedFor);
		member.setDegree(degree);
		member.setYear(year);
		member.setField(field);
		member.setCollege(college);
		member.setResumeUrl(resumeUrl);
		return this.memberRepository.save(member);
	}
	
	@Transactional(readOnly = true)
    public Optional<Member> getMember(final Long id) {
        return this.memberRepository.findById(id);
    }
	
	@Transactional(readOnly = true)
    public List<Member> getAllMembers(final int count) {
        return ((Collection<Member>) this.memberRepository.findAll()).stream().limit(count).collect(Collectors.toList());
    }
	
	@Transactional(readOnly = true)
    public List<Member> getMemberByName(String name) {
		//throw new MemberException("No such Member", "name", name);
        return this.memberRepository.findByName(name);
    }
	
	
	
	
	  @Transactional(readOnly = true) 
	public List<Member> searchMemberByNameAndSkillAndEmpId(String name,String skillBucket, Long empId, String pName) {
		  // if all null or blank
		 
		return  memberDAO.searchMember(name,empId,skillBucket,pName);
		 
	}
	  
	public List<Member> getMemberWithContribution(String skill){
		return this.memberRepository.findAllMemberWithContribution(skill);
	}
	
	public List<Member> getMemberWithSkill(String skill){
		return this.memberRepository.findAllMemberWithSkill(skill);
	}
	
	public List<Member> getMemberWithCertification(String skill){
		return this.memberRepository.findAllMemberWithCertification(skill);
	}
	
	public List<Member> getMemberWithCreatedAsset(String skill){
		return this.memberRepository.findAllMemberWithCreatedAsset(skill);
	}
	
	public List<Member> getMemberWithBillingInProject(String skill){
		return this.memberRepository.findAllMemberWithBillingInProject(skill);
	}
	
	public List<Member> getAllMemberReportsToManager(String skill){
		return this.memberRepository.findAllMemberReportsToManager(skill);
	}

	
	/*
	 * public List<Member> getAllMember(String name){ return
	 * this.memberRepository.findAllMember(name); }
	 */
	
	/*
	 * public List<Member> getMemberWithNoContribution(final String name){ return
	 * this.memberRepository.findMemberWithNoContribution(name); }
	 */

}
