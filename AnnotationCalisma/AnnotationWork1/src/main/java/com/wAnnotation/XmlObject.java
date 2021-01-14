package com.wAnnotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//RUNTIME: These will be retained at runtime.
//TYPE	Class, Interface, or enumeration
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlObject {
}
