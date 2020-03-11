package com.bedrock.graphql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bedrock.graphql.dao.entity.Contributions;
import com.bedrock.graphql.dao.repository.ContributionsRepository;

@Service
public class ContributionsService {
	
private final ContributionsRepository contributionsRepository;
	
	public ContributionsService(final ContributionsRepository contributionsRepository) {
        this.contributionsRepository = contributionsRepository ;
    }
	
	public List<Contributions> getAllContributionsWithSkill(String technology){
		return this.contributionsRepository.findAllContributionsWithSkill(technology);
	}

}
