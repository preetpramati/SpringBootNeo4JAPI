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
public class Project {
	
	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue
	    private Long id;
	    
	    @Relationship(type = "HAS_ASSET", direction = Relationship.OUTGOING)
		private Assets asset;
	    
	    @Relationship(type = "NEEDS", direction = Relationship.OUTGOING)
		private Skill skill;
	   
	   @Relationship(type = "IS_BILLED_FOR")
	   private ProjectMemberRelation projectMemberRelation;


		private String name;
		
		private String desc;
	    
	    private String teamSize;
	    
	    private String skillBucket;
	    
	    private String location;


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}


		public ProjectMemberRelation getProjectMemberRelation() {
			return projectMemberRelation;
		}

		public void setProjectMemberRelation(ProjectMemberRelation projectMemberRelation) {
			this.projectMemberRelation = projectMemberRelation;
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

		public Assets getAsset() {
			return asset;
		}

		public void setAsset(Assets asset) {
			this.asset = asset;
		}

		public Skill getSkill() {
			return skill;
		}

		public void setSkill(Skill skill) {
			this.skill = skill;
		}

		public String getTeamSize() {
			return teamSize;
		}

		public void setTeamSize(String teamSize) {
			this.teamSize = teamSize;
		}

		public String getSkillBucket() {
			return skillBucket;
		}

		public void setSkillBucket(String skillBucket) {
			this.skillBucket = skillBucket;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    

}
