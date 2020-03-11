package com.bedrock.graphql.dao.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.bedrock.graphql.dao.entity.Contributions;

@Repository
public interface ContributionsRepository extends Neo4jRepository<Contributions, Integer> {

	@Query("MATCH (c:Contributions)-[b:PART_OF]-(p:Skill) where c.technology = $technology RETURN c")
	List<Contributions> findAllContributionsWithSkill(String technology);
}
