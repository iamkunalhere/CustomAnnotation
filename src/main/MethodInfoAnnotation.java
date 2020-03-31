package main;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)

public @interface MethodInfoAnnotation {
    String author() default "Kunal";
    String date();
    int revision() default 1;
    String comments();
}
