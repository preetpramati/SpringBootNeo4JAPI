package com.bedrock.graphql.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class CustomException extends RuntimeException implements GraphQLError{

	private Map<String, Object> extensions = new HashMap<>();
    String message;

    public CustomException(String message) {
    	super(message);
		// TODO Auto-generated constructor stub
    	this.message = message;
	}
    
    public CustomException(String message, Long invalidMemberId) {
    	super(message);
		// TODO Auto-generated constructor stub
        extensions.put("invalidMemberId", invalidMemberId);

	}

	@Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
    	 return null;
    			 }

    @Override
    public ErrorType getErrorType() {
    	 return ErrorType.DataFetchingException;
    }

    @Override 
    public String getMessage() {
        return message;
    }

}

