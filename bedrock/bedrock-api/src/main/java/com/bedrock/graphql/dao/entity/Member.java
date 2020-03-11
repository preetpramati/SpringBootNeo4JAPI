package com.bedrock.graphql.dao.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@NodeEntity
public class Member {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    private Long id;
	@Relationship(type = "HAS_CONTRIBUTION", direction = Relationship.OUTGOING)
	private Contributions contribution;
	
	@Relationship(type = "KNOWS_SKILLS", direction = Relationship.OUTGOING)
	private Skill skill;

	@Relationship(type = "CREATED_ASSET", direction = Relationship.OUTGOING)
	private Assets asset;

	/*
	 * @Relationship(type = "REPORTS_TO") private MemberMemberRelation
	 * memberMemberRelation;
	 */
	@Relationship(type = "REPORTS_TO" ,direction = Relationship.OUTGOING )
	private Member member;
	
	@Relationship(type = "IS_BILLED_FOR")
	private MemberProjectRelation memberProjectRelation;

	@Relationship(type = "IS_CERTIFIED_IN")
	private MemberCertificationRelation memberCertificationRelation;
	

	private Long empId;
	
	private String name;
	
	private String location;
	
	private String experience;
	
	private String title;
	
	private String skillBucket;
	
	private String status;
	
	private String blockedFor;
	
	private String degree;
	
	private String year;
	
	private String field;
	
	private String college;
	
	private String resumeUrl;
	
	//Getters and setters

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}


	public Member getMember() {
		return member;
	}




	public void setMember(Member member) {
		this.member = member;
	}




	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Contributions getContribution() {
		return contribution;
	}

	public void setContribution(Contributions contribution) {
		this.contribution = contribution;
	}
	
	
	
	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}


	public MemberCertificationRelation getMemberCertificationRelation() {
		return memberCertificationRelation;
	}

	public void setMemberCertificationRelation(MemberCertificationRelation memberCertificationRelation) {
		this.memberCertificationRelation = memberCertificationRelation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSkillBucket() {
		return skillBucket;
	}

	public void setSkillBucket(String skillBucket) {
		this.skillBucket = skillBucket;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBlockedFor() {
		return blockedFor;
	}

	public void setBlockedFor(String blockedFor) {
		this.blockedFor = blockedFor;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getResumeUrl() {
		return resumeUrl;
	}

	public void setResumeUrl(String resumeUrl) {
		this.resumeUrl = resumeUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public MemberProjectRelation getMemberProjectRelation() {
		return memberProjectRelation;
	}

	public void setMemberProjectRelation(MemberProjectRelation memberProjectRelation) {
		this.memberProjectRelation = memberProjectRelation;
	}
	
	public Assets getAsset() {
		return asset;
	}

	public void setAsset(Assets asset) {
		this.asset = asset;
	}
	/*
	 * 
	 * 
	 * 
	 * public MemberMemberRelation getMemberMemberRelation() { return
	 * memberMemberRelation; }
	 * 
	 * 
	 * 
	 * 
	 * public void setMemberMemberRelation(MemberMemberRelation
	 * memberMemberRelation) { this.memberMemberRelation = memberMemberRelation; }
	 * 
	 * 
	 * 
	 * 
	 */
}
