package com.github.maratkalibek.maven.plugins.bytecode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.ClassReader;

import java.io.FileInputStream;
import java.util.List;

public class MethodVisitorTests {

    @Test
    public void testDirectSystemOutCallsFound() throws Exception {
        ClassReader reader = new ClassReader(new FileInputStream("src/test/files/Test1.class"));

        PluginClassVisitor visitor = new PluginClassVisitor();
        reader.accept(visitor, ClassReader.EXPAND_FRAMES);

        List<SystemOutPrintCall> calls = visitor.getCalls();

        Assertions.assertEquals(3, calls.size());

        SystemOutPrintCall call = calls.get(0);
        Assertions.assertEquals("com/example/Test1", call.getClazz());
        Assertions.assertEquals("method1", call.getMethod());
        Assertions.assertEquals(6, call.getLine());

        call = calls.get(1);
        Assertions.assertEquals("com/example/Test1", call.getClazz());
        Assertions.assertEquals("method2", call.getMethod());
        Assertions.assertEquals(11, call.getLine());

        call = calls.get(2);
        Assertions.assertEquals("com/example/Test1", call.getClazz());
        Assertions.assertEquals("method3", call.getMethod());
        Assertions.assertEquals(16, call.getLine());
    }
}
