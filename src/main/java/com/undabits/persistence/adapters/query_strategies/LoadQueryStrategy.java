package com.undabits.persistence.adapters.query_strategies;

public class LoadQueryStrategy {

    private Query queryStrategy;

    public void setQuery(Query queryStrategy){
        this.queryStrategy = queryStrategy;
    };

    public QueryResult runQuery(){
        return this.queryStrategy.execute();
    }



}
