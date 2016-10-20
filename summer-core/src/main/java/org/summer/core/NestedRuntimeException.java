package org.summer.core;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author yc
 * @date 2016/10/20
 * @description
 */
public class NestedRuntimeException extends RuntimeException implements HasRootCause {

    private Throwable rootCause;


    public NestedRuntimeException(String message) {
        super(message);
    }

    public NestedRuntimeException(String message, Throwable rootCause) {
        super(message);
        this.rootCause = rootCause;
    }


    @Override
    public String getMessage() {
        if (rootCause == null) {
            return super.getMessage();
        }
        return super.getMessage() + ";nested exception is: \n\t" + rootCause.toString();
    }


    @Override
    public void printStackTrace(PrintStream s) {
        if (rootCause == null) {
            super.printStackTrace(s);
        }else{
            rootCause.printStackTrace(s);
        }

    }

    @Override
    public void printStackTrace(PrintWriter s) {
        if (rootCause == null) {
            super.printStackTrace(s);
        }else{
            rootCause.printStackTrace(s);
        }
    }


    public Throwable getRootCause() {
        return rootCause;
    }


}
