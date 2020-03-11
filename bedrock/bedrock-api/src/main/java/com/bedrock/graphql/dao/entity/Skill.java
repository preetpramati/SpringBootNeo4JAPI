package com.bedrock.graphql.dao.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@NodeEntity
public class Skill {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    
    private String skillName;
    
    private String skillBucket;
    
    private String desc;
    
    private String provider;
    
    private String type;
    
    //Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillBucket() {
		return skillBucket;
	}

	public void setSkillBucket(String skillBucket) {
		this.skillBucket = skillBucket;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
