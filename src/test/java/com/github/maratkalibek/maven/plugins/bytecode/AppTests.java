package com.github.maratkalibek.maven.plugins.bytecode;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class AppTests {

    @Test
    public void testDirectCalls() throws Exception {
        List<SystemOutPrintCall> calls = SystemOutFinder.findAllCallsInDirectory(new File("src/test/files"));

        for (SystemOutPrintCall call : calls) {
            System.out.println(String.format("%s %s %s", call.getClazz(), call.getMethod(), call.getLine()));
        }
    }
}
