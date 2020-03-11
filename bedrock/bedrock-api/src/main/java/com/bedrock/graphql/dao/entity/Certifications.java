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
public class Certifications {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    
    @Relationship(type = "PART_OF", direction = Relationship.OUTGOING)
	private Skill skills;
    
    @Relationship(type = "IS_CERTIFIED_IN")
	private MemberCertificationRelation memberCertificationRelation;
    
    public MemberCertificationRelation getMemberCertificationRelation() {
		return memberCertificationRelation;
	}

	public void setMemberCertificationRelation(MemberCertificationRelation memberCertificationRelation) {
		this.memberCertificationRelation = memberCertificationRelation;
	}

	private String name;
    
    private String desc;
    
    private String skillBucket;
    
    private String skill;
    
    private String provider;
    
    private String certUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSkillBucket() {
		return skillBucket;
	}

	public void setSkillBucket(String skillBucket) {
		this.skillBucket = skillBucket;
	}

	public String getSkill() {
		return skill;
	}
	
	

	public Skill getSkills() {
		return skills;
	}

	public void setSkills(Skill skills) {
		this.skills = skills;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getCertUrl() {
		return certUrl;
	}

	public void setCertUrl(String certUrl) {
		this.certUrl = certUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
