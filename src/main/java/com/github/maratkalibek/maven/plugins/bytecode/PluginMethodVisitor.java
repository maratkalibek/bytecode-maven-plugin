package com.github.maratkalibek.maven.plugins.bytecode;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

public class PluginMethodVisitor extends MethodVisitor {

    private List<SystemOutPrintCall> calls;

    private String clazz;
    private String method;
    private Integer line;
    private boolean isStatic;

    private Boolean systemOutInUse = false;

    protected PluginMethodVisitor(String clazz, String method, boolean isStatic, List<SystemOutPrintCall> calls) {
        super(Opcodes.ASM8);

        this.calls = calls;

        this.clazz = clazz;
        this.method = method;
        this.isStatic = isStatic;
    }

    @Override
    public void visitLineNumber(int line, Label start) {
        this.line = line;
        super.visitLineNumber(line, start);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        if (opcode==Opcodes.INVOKEVIRTUAL) {
            if (systemOutInUse && name.equals("print") || name.equals("println")) {
                SystemOutPrintCall call = new SystemOutPrintCall(clazz, method, isStatic, line);
                calls.add(call);
            }
            systemOutInUse = false;
        }
        super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
    }

    @Override
    public void visitInsn(int opcode) {
        super.visitInsn(opcode);
    }

    @Override
    public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        super.visitInvokeDynamicInsn(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments);
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        super.visitIntInsn(opcode, operand);
    }

    @Override
    public void visitIincInsn(int varIndex, int increment) {
        super.visitIincInsn(varIndex, increment);
    }

    @Override
    public void visitFrame(int type, int numLocal, Object[] local, int numStack, Object[] stack) {
        super.visitFrame(type, numLocal, local, numStack, stack);
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        if (opcode==Opcodes.GETSTATIC && owner.equals("java/lang/System") && name.equals("out")) {
            systemOutInUse = true;
        } else {
            systemOutInUse = false;
        }
        super.visitFieldInsn(opcode, owner, name, descriptor);
    }
}
