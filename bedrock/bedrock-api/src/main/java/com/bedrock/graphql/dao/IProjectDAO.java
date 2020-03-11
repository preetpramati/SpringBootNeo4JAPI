package com.bedrock.graphql.dao;

import java.util.List;

import com.bedrock.graphql.dao.entity.Project;

public interface IProjectDAO {
	public List<Project> searchProject(String name, String skillBucket, String location);
}
