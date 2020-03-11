package com.bedrock.graphql.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bedrock.graphql.dao.entity.Certifications;
import com.bedrock.graphql.service.CertificationsService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class CertificationsQuery implements GraphQLQueryResolver{
	
	@Autowired
	public CertificationsService certificationsService;
	
	public List<Certifications> getAllCertifiedInSkill(String skillBucket){
		return this.certificationsService.getAllContributionsWithSkill(skillBucket);
	}

}
