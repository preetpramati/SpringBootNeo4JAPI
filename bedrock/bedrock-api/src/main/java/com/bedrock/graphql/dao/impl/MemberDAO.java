package com.bedrock.graphql.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bedrock.graphql.dao.IMemberDAO;
import com.bedrock.graphql.dao.entity.Member;
import com.bedrock.graphql.service.MemberService;

@Repository
public class MemberDAO implements IMemberDAO {

	private static final Logger logger = LogManager.getLogger(MemberService.class);

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Member> searchMember(String memberName, Long empId, String skillBucket, String projectName) {
		List<Member> members = new ArrayList<Member>();

		  Boolean conditionSet = false;
		 
		  Map<String, Object> params = new HashMap<>();
		  
		  String cypher = "MATCH (m:Member {%bedrockmember%}) %bedrockproject% \n" +
		  " OPTIONAL MATCH(m:Member)-[r2:REPORTS_TO]->(p2:Member)-[r3:REPORTS_TO]-(p3:Member) \n"+	  
		  " OPTIONAL MATCH (m)-[ar:CREATED_ASSET]->(a:Assets) " +
		  " OPTIONAL MATCH (m:Member)-[sr:KNOWS_SKILLS]->(s:Skill)" +
		  " OPTIONAL MATCH (m:Member)-[cr:IS_CERTIFIED_IN]->(c:Certifications)" +
		  " OPTIONAL MATCH (m:Member)-[pr:IS_BILLED_FOR]->(p:Project)\n" +
		  " OPTIONAL MATCH (m:Member)-[hc:HAS_CONTRIBUTION]->(co:Contributions)\n" +  
		  " RETURN m,ar,a,sr,s,cr,c,pr,p,hc,co,r2,p2,p3,r3";
		  
		  StringBuilder buildQuery = new StringBuilder();
		  
		  if(memberName!=null && !memberName.isEmpty()) {
		  buildQuery.append(" name:$name ");
		  params.put ("name", memberName);
		  conditionSet = true; }
		  
		  if(empId != null && empId != 0 ) { if(conditionSet) {
		  buildQuery.append(" , "); } buildQuery.append(" empId:$empId "); params.put
		  ("empId", empId); conditionSet = true; }
		  
		  if( skillBucket!=null && !skillBucket.isEmpty()) { if(conditionSet) {
		  buildQuery.append(" , "); } buildQuery.append(" skillBucket:$skillBucket ");
		  params.put ("skillBucket", skillBucket); conditionSet = true; }
		  
		  cypher = cypher.replace("%bedrockmember%", buildQuery);
		  
		  
		  if(projectName!=null && !projectName.isEmpty()) { StringBuilder projectQuery
		  = new StringBuilder();
		  
		  
		  projectQuery.append(" , ");
		  
		  projectQuery.
		  append(" (m:Member)-[pr:IS_BILLED_FOR]->(p:Project) where p.name=$projectName "
		  ); params.put ("projectName", projectName); conditionSet = true; cypher =
		  cypher.replace("%bedrockproject%", projectQuery); }else { cypher =
		  cypher.replace("%bedrockproject%", ""); }
		  
		  logger.info("query created: "+cypher); 
		  
		 Result memberList = sessionFactory.openSession().query(cypher, params);
		 Iterator<Map<String, Object>> itr = memberList.queryResults().iterator();
		 while (itr.hasNext()) {
			 members.add((Member) itr.next().get("m"));
			  }
		return members;
	}

}
