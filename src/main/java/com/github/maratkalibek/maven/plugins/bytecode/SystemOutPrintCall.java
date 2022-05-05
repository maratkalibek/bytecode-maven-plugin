package com.github.maratkalibek.maven.plugins.bytecode;

public class SystemOutPrintCall {
    private String clazz;
    private String method;
    private Integer line;
    private boolean isStatic;

    public SystemOutPrintCall(String clazz, String method, boolean isStatic, Integer line) {
        this.clazz = clazz;
        this.method = method;
        this.isStatic = isStatic;
        this.line = line;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public String getClazz() {
        return clazz;
    }

    public String getMethod() {
        return method;
    }

    public Integer getLine() {
        return line;
    }
}
