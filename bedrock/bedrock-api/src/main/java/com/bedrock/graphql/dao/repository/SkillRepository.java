package com.bedrock.graphql.dao.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.bedrock.graphql.dao.entity.Skill;

@Repository
public interface SkillRepository extends Neo4jRepository<Skill, Long>{

}
