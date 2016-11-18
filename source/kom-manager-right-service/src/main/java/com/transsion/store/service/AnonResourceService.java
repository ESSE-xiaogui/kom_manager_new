package com.transsion.store.service;

import java.util.List;

/**
 */
public class AnonResourceService {
    private List<String> anonList;

    public void setAnonList(List<String> anonList) {
        this.anonList = anonList;
    }

    public List<String> getResources(){
        return anonList;
    }
}
