package com.bean.demo.components;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
public class SessionScopeComponent implements Serializable {

    private static int instanceCount;

    public SessionScopeComponent(){
        instanceCount++;
    }

    public void printInstanceCount(){
        System.out.println("RequestScope instance Count:"+instanceCount+"-hashCode :"+this.hashCode());
    }
}
