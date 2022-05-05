package com.github.maratkalibek.maven.plugins.bytecode;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SystemOutFinder {

    public static List<SystemOutPrintCall> findAllCallsInDirectory(File dir) throws IOException {
        List<SystemOutPrintCall> result = new LinkedList<>();
        List<SystemOutMethod> methods = findAllMethods(dir);

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                List<SystemOutPrintCall> subResult = findAllCallsInDirectory(file, methods);
                result.addAll(subResult);
            } else {
                if (!file.getName().endsWith(".class"))
                    continue;
                List<SystemOutPrintCall> classResult = findAllCallsInClass(file, methods);
                result.addAll(classResult);
            }
        }
        return result;
    }

    private static List<SystemOutPrintCall> findAllCallsInDirectory(File dir, List<SystemOutMethod> methods) throws IOException {
        List<SystemOutPrintCall> result = new LinkedList<>();

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                List<SystemOutPrintCall> subResult = findAllCallsInDirectory(file, methods);
                result.addAll(subResult);
            } else {
                List<SystemOutPrintCall> classResult = findAllCallsInClass(file, methods);
                result.addAll(classResult);
            }
        }
        return result;
    }

    private static List<SystemOutPrintCall> findAllCallsInClass(File file, List<SystemOutMethod> methods) throws IOException {
        if (!file.getName().endsWith(".class"))
            return Collections.emptyList();

        InputStream in = new FileInputStream(file);
        ClassReader cr = new ClassReader(in);

        PluginClassVisitor cv = new PluginClassVisitor();
        cr.accept(cv, ClassReader.EXPAND_FRAMES);

        List<SystemOutPrintCall> calls = cv.getCalls();

        return calls;
    }

    private static List<SystemOutMethod> findAllMethods(File dir) {
        return new LinkedList<>();
    }
}
