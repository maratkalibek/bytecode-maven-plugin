package com.github.maratkalibek.maven.plugins.bytecode;

/**
 * Method, that returns System.out
 */

public class SystemOutMethod {
    private String clazz;
    private String method;
    private Boolean isStatic;

    public SystemOutMethod(String clazz, String method, Boolean isStatic) {
        this.clazz = clazz;
        this.method = method;
        this.isStatic = isStatic;
    }

    public String getClazz() {
        return clazz;
    }

    public String getMethod() {
        return method;
    }

    public Boolean getStatic() {
        return isStatic;
    }
}
