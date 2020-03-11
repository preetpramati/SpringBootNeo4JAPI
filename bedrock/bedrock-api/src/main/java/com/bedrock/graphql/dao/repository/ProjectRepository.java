package com.bedrock.graphql.dao.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.bedrock.graphql.dao.entity.Project;

@Repository
public interface ProjectRepository extends Neo4jRepository<Project, Long> {
	
	List<Project> findByName(String name);
	


	@Query("MATCH (p:Project)-[b:HAS_ASSET]-(a:Assets) where p.skillBucket = $skillBucket RETURN p")
	List<Project> findAllProjectWithCreatedAsset(String skillBucket);
	
	@Query("MATCH (p:Project)-[b:NEEDS]-(a:Skill) where p.skillBucket = $skillBucket RETURN p")
	List<Project> findAllProjectWithNeedOfSkill(String skillBucket);
	
}
