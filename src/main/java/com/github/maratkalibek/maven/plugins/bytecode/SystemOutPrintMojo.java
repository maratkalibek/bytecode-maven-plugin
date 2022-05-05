package com.github.maratkalibek.maven.plugins.bytecode;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Mojo(name = "system-out-print-check")
public class SystemOutPrintMojo extends AbstractMojo {

    @Parameter(property = "classesDir", defaultValue = "target/classes")
    private String classesDir;

    public void execute() {
        try {
            File dir = new File(classesDir);
            List<SystemOutPrintCall> calls = SystemOutFinder.findAllCallsInDirectory(dir);

            for (SystemOutPrintCall call : calls) {
                getLog().info(String.format("FOUND System.out.print call in %s on line %s for method", call.getClazz(), call.getLine(), call.getMethod()));
            }

            if (calls.size()==0) {
                getLog().info("No System.out.print calls found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}