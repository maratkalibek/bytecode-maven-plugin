package com.example;

import java.io.PrintStream;

/**
 * public class com.example.Class1 {
 *   private java.io.PrintStream y;
 *
 *   private static java.io.PrintStream z;
 *
 *   public com.example.Class1();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: aload_0
 *        5: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        8: putfield      #13                 // Field y:Ljava/io/PrintStream;
 *       11: return
 *
 *   public void method1();
 *     Code:
 *        0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: ldc           #18                 // String Method1 println FROM com.example.Class1
 *        5: invokevirtual #20                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        8: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       11: ldc           #26                 // String Method1 print FROM com.example.Class1
 *       13: invokevirtual #28                 // Method java/io/PrintStream.print:(Ljava/lang/String;)V
 *       16: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       19: bipush        123
 *       21: invokevirtual #31                 // Method java/io/PrintStream.print:(I)V
 *       24: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       27: ldc           #34                 // float 123.0f
 *       29: invokevirtual #35                 // Method java/io/PrintStream.println:(F)V
 *       32: return
 *
 *   public void method2();
 *     Code:
 *        0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: astore_1
 *        4: aload_1
 *        5: ldc           #38                 // String Method2 print FROM com.example.Class1
 *        7: invokevirtual #28                 // Method java/io/PrintStream.print:(Ljava/lang/String;)V
 *       10: return
 *
 *   private java.io.PrintStream getDirectSystemOut();
 *     Code:
 *        0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: areturn
 *
 *   private java.io.PrintStream getVariableSystemOut();
 *     Code:
 *        0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: astore_1
 *        4: new           #40                 // class java/lang/Integer
 *        7: dup
 *        8: bipush        7
 *       10: invokespecial #42                 // Method java/lang/Integer."<init>":(I)V
 *       13: astore_2
 *       14: aload_2
 *       15: invokevirtual #44                 // Method java/lang/Integer.intValue:()I
 *       18: pop
 *       19: aload_2
 *       20: invokevirtual #48                 // Method java/lang/Integer.longValue:()J
 *       23: pop2
 *       24: aload_1
 *       25: areturn
 *
 *   public void method3();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #52                 // Method getDirectSystemOut:()Ljava/io/PrintStream;
 *        4: astore_1
 *        5: aload_1
 *        6: ldc           #56                 // String Method3 println FROM com.example.Class1
 *        8: invokevirtual #20                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *       11: return
 *
 *   public void method4();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #58                 // Method getVariableSystemOut:()Ljava/io/PrintStream;
 *        4: astore_1
 *        5: aload_1
 *        6: ldc           #61                 // String Method4 println FROM com.example.Class1
 *        8: invokevirtual #20                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *       11: return
 *
 *   public void method5();
 *     Code:
 *        0: invokestatic  #63                 // Method com/example/Class2.getStaticSystemOut:()Ljava/io/PrintStream;
 *        3: astore_1
 *        4: aload_1
 *        5: ldc           #68                 // String Method5 println FROM com.example.Class1
 *        7: invokevirtual #20                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *       10: return
 *
 *   public void method6();
 *     Code:
 *        0: new           #64                 // class com/example/Class2
 *        3: dup
 *        4: invokespecial #70                 // Method com/example/Class2."<init>":()V
 *        7: invokevirtual #71                 // Method com/example/Class2.getObjectSystemOut:()Ljava/io/PrintStream;
 *       10: astore_1
 *       11: aload_1
 *       12: ldc           #74                 // String Method6 println FROM com.example.Class1
 *       14: invokevirtual #20                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *       17: return
 *
 *   public void method7();
 *     Code:
 *        0: aload_0
 *        1: getfield      #13                 // Field y:Ljava/io/PrintStream;
 *        4: ldc           #76                 // String Method7 println FROM com.example.Class1
 *        6: invokevirtual #20                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        9: return
 *
 *   public void method8();
 *     Code:
 *        0: getstatic     #78                 // Field z:Ljava/io/PrintStream;
 *        3: ldc           #81                 // String Method8 println FROM com.example.Class1
 *        5: invokevirtual #20                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        8: return
 *
 *   static {};
 *     Code:
 *        0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: putstatic     #78                 // Field z:Ljava/io/PrintStream;
 *        6: return
 * }
 */
public class Class1 {

    private PrintStream y = System.out;
    private static PrintStream z = System.out;

    public void method1() {
        System.out.println("Method1 println FROM com.example.Class1");
        System.out.print("Method1 print FROM com.example.Class1");
        System.out.print(123);
        System.out.println(123f);
    }

    public void method2() {
        PrintStream x = System.out;
        x.print("Method2 print FROM com.example.Class1");
    }

    private PrintStream getDirectSystemOut() {
        return System.out;
    }

    private PrintStream getVariableSystemOut() {
        PrintStream x = System.out;
        Integer a = new Integer(7);
        a.intValue();
        a.longValue();
        return x;
    }

    public void method3() {
        PrintStream x = getDirectSystemOut();
        x.println("Method3 println FROM com.example.Class1");
    }

    public void method4() {
        PrintStream x = getVariableSystemOut();
        x.println("Method4 println FROM com.example.Class1");
    }

    public void method5() {
        PrintStream x = Class2.getStaticSystemOut();
        x.println("Method5 println FROM com.example.Class1");
    }

    public void method6() {
        PrintStream x = new Class2().getObjectSystemOut();
        x.println("Method6 println FROM com.example.Class1");
    }

    public void method7() {
        y.println("Method7 println FROM com.example.Class1");
    }

    public void method8() {
        z.println("Method8 println FROM com.example.Class1");
    }
}
