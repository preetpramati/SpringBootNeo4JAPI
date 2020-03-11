package com.bedrock.graphql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bedrock.graphql.dao.entity.Certifications;
import com.bedrock.graphql.dao.repository.CertificationsRepository;

@Service
public class CertificationsService {
	
private final CertificationsRepository certificationsRepository;
	
	public CertificationsService(final CertificationsRepository certificationsRepository) {
        this.certificationsRepository = certificationsRepository ;
    }
	
	public List<Certifications> getAllContributionsWithSkill(String skillBucket){
		return this.certificationsRepository.findAllCertifiedInSkill(skillBucket);
	}

}
