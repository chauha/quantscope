package com.ashish.processor;

import com.ashish.models.QueryParams;
import com.ashish.models.Result;
import com.ashish.storage.Storage;

import java.util.List;

public class BasicQueryProcessor implements QueryProcessor {

    private Storage storage;

    public BasicQueryProcessor(Storage storage){
        this.storage = storage;
    }

    @Override
    public Result query(QueryParams params) {
        List<String> res =  storage.getMostFrequent(params.getDate());
        Result result = new Result(res);
        return result;
    }
}
