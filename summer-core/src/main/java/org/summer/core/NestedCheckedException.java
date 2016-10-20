package org.summer.core;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author yc
 * @date 2016/10/20
 * @description
 */
public class NestedCheckedException extends Exception implements HasRootCause {

    private Throwable rootCause;

    public NestedCheckedException(String message) {
        super(message);
    }

    public NestedCheckedException(String message, Throwable rootCause) {
        super(message);
        this.rootCause = rootCause;
    }


    @Override
    public String getMessage() {
        if (rootCause == null) {
            return super.getMessage();
        }
        return super.getMessage() + "; nested exception \n\t" + rootCause.toString();
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
