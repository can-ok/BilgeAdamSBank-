package com.bean.demo.components;

import org.springframework.stereotype.Component;

@Component
public class SingletonScopeComponent {
    private static int instanceCount;

    public SingletonScopeComponent(){
        instanceCount++;
    }

    public void printInstanceCount(){
        System.out.println("SingletonScope instanceCount:"+instanceCount+"hash code-"+this.hashCode());
    }
}
