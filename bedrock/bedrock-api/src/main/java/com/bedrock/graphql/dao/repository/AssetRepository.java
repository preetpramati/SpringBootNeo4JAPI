package com.bedrock.graphql.dao.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.bedrock.graphql.dao.entity.Assets;

@Repository
public interface AssetRepository extends Neo4jRepository<Assets, Long> {

}
