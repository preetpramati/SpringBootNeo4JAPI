package com.bedrock.graphql.dao.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.bedrock.graphql.dao.entity.Member;

@Repository
public interface MemberRepository extends Neo4jRepository<Member, Long>{
	
	List<Member> findByName(String name);

	
	@Query("MATCH (m:Member)-[b:HAS_CONTRIBUTION]-(p:Contributions) where m.skillBucket = $skill RETURN m")
	List<Member> findAllMemberWithContribution(String skill);
		
	@Query("MATCH (m:Member)-[b:KNOWS_SKILLS]-(p:Skill) where m.skillBucket = $skill RETURN m")
	List<Member> findAllMemberWithSkill(String skill);
	
	@Query("MATCH (m:Member)-[b:IS_CERTIFIED_IN]-(p:Certifications) where m.skillBucket = $skill RETURN m")
	List<Member> findAllMemberWithCertification(String skill);
	
	@Query("MATCH (m:Member)-[b:CREATED_ASSET]-(p:Assets) where m.skillBucket = $skill RETURN m")
	List<Member> findAllMemberWithCreatedAsset(String skill);
	
	@Query("MATCH (m:Member)-[b:IS_BILLED_FOR]-(p:Project) where m.skillBucket = $skill RETURN m,p")
	List<Member> findAllMemberWithBillingInProject(String skill);
	
	@Query("MATCH (m:Member)-[b:REPORTS_TO]-(p:Member) where m.skillBucket = $skill RETURN m")
	List<Member> findAllMemberReportsToManager(String skill);
	
	
	
	
	
	
	
	
	//List<Member> findMemberWithContribution(String name);
}
