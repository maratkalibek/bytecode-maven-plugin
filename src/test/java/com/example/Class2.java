package com.example;

import java.io.PrintStream;

/**
 * public class com.example.Class2 {
 *   public com.example.Class2();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static java.io.PrintStream getStaticSystemOut();
 *     Code:
 *        0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: areturn
 *
 *   public java.io.PrintStream getObjectSystemOut();
 *     Code:
 *        0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: areturn
 * }
 */

public class Class2 {

    public static PrintStream getStaticSystemOut() {
        return System.out;
    }

    public PrintStream getObjectSystemOut() {
        return System.out;
    }
}
