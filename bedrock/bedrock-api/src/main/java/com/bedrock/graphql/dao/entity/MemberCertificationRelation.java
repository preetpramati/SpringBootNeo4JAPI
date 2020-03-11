package com.bedrock.graphql.dao.entity;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "IS_CERTIFIED_IN")
public class MemberCertificationRelation {
	
	public String date;
	
	@StartNode
	Member member;
	
	@EndNode
	Certifications certification;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Certifications getCertification() {
		return certification;
	}

	public void setCertification(Certifications certification) {
		this.certification = certification;
	}
	

}
