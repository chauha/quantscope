package com.ashish.processor;

import com.ashish.exceptions.NoEntryFoundException;
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
    public Result query(QueryParams params) throws NoEntryFoundException {
        List<String> res =  storage.getMostFrequent(params.getDate());
        if ( res.size() == 0 ){
            throw new NoEntryFoundException("No entries exist for "+ params.getDate());
        }
        Result result = new Result(res);
        return result;
    }
}
