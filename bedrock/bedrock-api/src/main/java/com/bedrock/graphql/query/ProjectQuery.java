package com.bedrock.graphql.query;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bedrock.graphql.dao.entity.Project;
import com.bedrock.graphql.exception.CustomException;
import com.bedrock.graphql.service.ProjectService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
@Component
public class ProjectQuery implements GraphQLQueryResolver{
	
	@Autowired
	public ProjectService projectService;
	
	private static final Logger logger = LogManager.getLogger(ProjectQuery.class);
	                        
	public List<Project> getAllProjectWithCreatedAsset(String skillBucket){
		return this.projectService.getAllProjectWithCreatedAsset(skillBucket);
	}
	
	public List<Project> getAllProjectWithNeedOfSkill(String skillBucket){
		return this.projectService.getAllProjectWithNeedOfSkill(skillBucket);
	}
	
	public List<Project> searchProject(String name, String skillBucket, String location){
		logger.info("search project query resolver ");
		if(this.projectService.searchProject(name, skillBucket, location).size() == 0) {
			throw new CustomException("invalid request");
		} else {
		return this.projectService.searchProject(name, skillBucket, location);
		}
	}

}
