package com.bedrock.graphql.dao.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.bedrock.graphql.dao.entity.Certifications;

@Repository
public interface CertificationsRepository extends Neo4jRepository<Certifications, Long> {

	@Query("MATCH (c:Certifications)-[b:PART_OF]-(p:Skill) where c.skillBucket = $skillBucket RETURN c")
	List<Certifications> findAllCertifiedInSkill(String skillBucket);
}
