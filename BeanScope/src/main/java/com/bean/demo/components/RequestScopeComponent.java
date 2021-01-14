package com.bean.demo.components;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestScopeComponent {

    private static int instanceCount;

    public RequestScopeComponent(){
        instanceCount++;
    }

    public void printInstanceCount(){
        System.out.println("RequestScope instance Count:"+instanceCount+"-hashCode :"+this.hashCode());
    }
}
