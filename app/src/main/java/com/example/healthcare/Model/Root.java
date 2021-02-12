package com.example.healthcare.Model;

import java.util.List;

public class Root
{
    private Plus_code plus_code;

    private List<Results> results;

    private String status;

    public void setPlus_code(Plus_code plus_code){
        this.plus_code = plus_code;
    }
    public Plus_code getPlus_code(){
        return this.plus_code;
    }
    public void setResults(List<Results> results){
        this.results = results;
    }
    public List<Results> getResults(){
        return this.results;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
}

