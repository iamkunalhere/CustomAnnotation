package main;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @MethodInfoAnnotation(author = "Kunal", comments = "Main Method", date = "31 March 2020", revision = 1)
    public String toString() {
        return "Overridden toString Method";
    }

    @Deprecated
    @MethodInfoAnnotation(comments = "Deprecated method", date = "31th March 2020")
    public static void oldMethod() {
        System.out.println("This Is Old Method Don't Use It");
    }

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationExample.class.getMethods()) {
                // Check Annotation present for method or not
                if (method.isAnnotationPresent(MethodInfoAnnotation.class)) {
                    try {
                        // iterates all available annotations
                        for (Annotation annoObj : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method " + method + " : " + annoObj);
                        }
                        MethodInfoAnnotation methodAnnotation = method.getAnnotation(MethodInfoAnnotation.class);
                        if (methodAnnotation.revision() == 1)
                            System.out.println("Method With Revision No 1 = " + method);
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}