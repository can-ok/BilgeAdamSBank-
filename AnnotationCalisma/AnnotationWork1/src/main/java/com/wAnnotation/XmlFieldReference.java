package com.wAnnotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(value=RUNTIME)
@Target(value={ElementType.TYPE,ElementType.FIELD})
public @interface XmlFieldReference {
    String tag() default "";
    String type() default "";
    //Object generic() default ?;
}
