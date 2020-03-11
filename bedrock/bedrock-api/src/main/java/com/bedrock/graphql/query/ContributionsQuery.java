package com.bedrock.graphql.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bedrock.graphql.dao.entity.Contributions;
import com.bedrock.graphql.service.ContributionsService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class ContributionsQuery implements GraphQLQueryResolver {
	
	@Autowired
	public ContributionsService contributionService;

	public List<Contributions> getAllContributionsWithSkill(String technology){
		return this.contributionService.getAllContributionsWithSkill(technology);
	}

}
