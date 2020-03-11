package com.bedrock.graphql.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bedrock.graphql.dao.entity.Project;
import com.bedrock.graphql.dao.impl.ProjectDAO;
import com.bedrock.graphql.dao.repository.ProjectRepository;

@Service
public class ProjectService {
	
	private static final Logger logger = LogManager.getLogger(ProjectService.class);

	@Autowired
	private ProjectDAO projectDAO;
	
	private final ProjectRepository projectRepository;
	
	public ProjectService(final ProjectRepository projectRepository) {
        this.projectRepository = projectRepository ;
    }
	
	public List<Project> getAllProjectWithCreatedAsset(String skillBucket){
		return this.projectRepository.findAllProjectWithCreatedAsset(skillBucket);
	}
	
	public List<Project> getAllProjectWithNeedOfSkill(String skillBucket){
		return this.projectRepository.findAllProjectWithNeedOfSkill(skillBucket);
	}
	
	public List<Project> searchProject(String name, String skillBucket, String location){
		return this.projectDAO.searchProject(name, skillBucket, location);
	}
	
	}

