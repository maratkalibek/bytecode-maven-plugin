package com.github.maratkalibek.maven.plugins.bytecode;

public class SystemOutPrintCall {
    private String clazz;
    private String method;
    private Integer line;

    public SystemOutPrintCall(String clazz, String method, Integer line) {
        this.clazz = clazz;
        this.method = method;
        this.line = line;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }
}
