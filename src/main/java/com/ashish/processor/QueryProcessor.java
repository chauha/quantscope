package com.ashish.processor;

import com.ashish.exceptions.NoEntryFoundException;
import com.ashish.models.QueryParams;
import com.ashish.models.Result;

public interface QueryProcessor {

    public Result query(QueryParams params) throws NoEntryFoundException;
}
