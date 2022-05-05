package com.github.maratkalibek.maven.plugins.bytecode;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.LinkedList;
import java.util.List;

public class PluginClassVisitor extends ClassVisitor {

    private String clazz;

    private List<SystemOutPrintCall> calls = new LinkedList<>();

    public PluginClassVisitor() {
        super(Opcodes.ASM8);
    }

    public List<SystemOutPrintCall> getCalls() {
        return calls;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.clazz = name;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        return new PluginMethodVisitor(this.clazz, name, this.calls);
    }
}
