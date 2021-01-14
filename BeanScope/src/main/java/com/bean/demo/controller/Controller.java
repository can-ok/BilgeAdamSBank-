package com.bean.demo.controller;

import com.bean.demo.components.PrototypeScopeComponent;
import com.bean.demo.components.RequestScopeComponent;
import com.bean.demo.components.SessionScopeComponent;
import com.bean.demo.components.SingletonScopeComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private PrototypeScopeComponent prototypeScopeComponent;

    @Autowired
    private RequestScopeComponent requestScopeComponent;

    @Autowired
    private SessionScopeComponent sessionScopeComponent;

    @Autowired
    private SingletonScopeComponent singletonScopeComponent;

    @GetMapping("/prototype")
    public long getPrototypeScopeData(){
        prototypeScopeComponent.printInstanceCount();
        return System.identityHashCode(prototypeScopeComponent);
    }

    @GetMapping("/request")
    public long getRequestScopeData(){
        requestScopeComponent.printInstanceCount();
        return System.identityHashCode(requestScopeComponent);
    }

    @GetMapping("/session")
    public long getSessionScopeData(){
        sessionScopeComponent.printInstanceCount();
        return System.identityHashCode(sessionScopeComponent);
    }

    //dont need the implementation of Singletion

    @GetMapping("/singletion")
    public long getSingletionScope(){
        singletonScopeComponent.printInstanceCount();
        return System.identityHashCode(singletonScopeComponent);
    }
}
