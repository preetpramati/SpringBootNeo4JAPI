package com.bedrock.graphql.dao.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@NodeEntity
public class Assets {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    
    private String url;
    
    private String technology;
    
    private String topic;
    
    private String desc;
    
    private String skillBucket;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
