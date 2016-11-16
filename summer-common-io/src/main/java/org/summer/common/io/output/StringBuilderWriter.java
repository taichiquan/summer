package org.summer.common.io.output;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public class StringBuilderWriter extends Writer implements Serializable {

    private final StringBuilder stringBuilder;

    public StringBuilderWriter() {
        this.stringBuilder = new StringBuilder();
    }

    public StringBuilderWriter(final int capacity) {
        this.stringBuilder = new StringBuilder(capacity);
    }

    public StringBuilderWriter(final StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder != null ? stringBuilder : new StringBuilder();
    }


    @Override
    public Writer append(final CharSequence csq) throws IOException {
        stringBuilder.append(csq);
        return this;
    }

    @Override
    public Writer append(final CharSequence csq, final int start, final int end) throws IOException {
        stringBuilder.append(csq, start, end);
        return this;
    }

    @Override
    public Writer append(final char c) throws IOException {
        stringBuilder.append(c);
        return this;
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        if (cbuf != null) {
            stringBuilder.append(cbuf, off, len);
        }
    }

    public void flush() throws IOException {

    }

    public void close() throws IOException {

    }

    @Override
    public void write(final String str) throws IOException {
        if (str != null) {
            stringBuilder.append(str);
        }
    }

    public StringBuilder getBuilder() {
        return stringBuilder;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
