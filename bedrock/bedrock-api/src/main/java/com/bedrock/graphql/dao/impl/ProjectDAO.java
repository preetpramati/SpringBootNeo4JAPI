package com.bedrock.graphql.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bedrock.graphql.dao.IProjectDAO;
import com.bedrock.graphql.dao.entity.Project;
import com.bedrock.graphql.service.ProjectService;

@Repository
public class ProjectDAO implements IProjectDAO {
	
	private static final Logger logger = LogManager.getLogger(ProjectService.class);
	@Autowired
    private SessionFactory sessionFactory;
	
	public List<Project> searchProject(String name, String skillBucket, String location){
		List<Project> projects = new ArrayList<Project>();
		Boolean conditionSet = false;
		Map<String, Object> params = new HashMap<>();
		String cypher = "MATCH (p:Project {%bedrockproject%}) \n" + 
							"OPTIONAL MATCH (p:Project)-[pr:IS_BILLED_FOR]-(m:Member)\n" + "OPTIONAL MATCH (p:Project)-[b:NEEDS]-(a:Skill)\n" + "OPTIONAL MATCH (p:Project)-[c:HAS_ASSET]-(d:Assets) \n" + "RETURN m,p,a,pr,b,c,d";
		
		StringBuilder buildQuery = new StringBuilder();
		if(name!=null && !name.isEmpty())
		{
			buildQuery.append(" name:$name ");
			params.put ("name", name);
			conditionSet = true;
		}
		if( skillBucket!=null && !skillBucket.isEmpty())
		{
			if(conditionSet)
			{
				buildQuery.append(" , ");
			}
			buildQuery.append(" skillBucket:$skillBucket ");
			params.put ("skillBucket", skillBucket);
			conditionSet = true;
		}
		
		if( location!=null && !location.isEmpty())
		{
			if(conditionSet)
			{
				buildQuery.append(" , ");
			}
			buildQuery.append(" location:$location ");
			params.put ("location", location);
			conditionSet = true;
		}
		cypher = cypher.replace("%bedrockproject%", buildQuery);
		
		logger.info("query created: "+cypher);
		Iterable<Project> projectList = sessionFactory.openSession().query(Project.class, cypher, params);
		Iterator<Project> itr = projectList.iterator();
		while(itr.hasNext())
		{
			projects.add(itr.next());
		}
		
		return projects;
	}
}
