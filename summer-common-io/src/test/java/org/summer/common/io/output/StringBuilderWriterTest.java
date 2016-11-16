package org.summer.common.io.output;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Writer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public class StringBuilderWriterTest {

    @Test
    public void testAppendConstructCapacity() throws IOException {
        final StringBuilderWriter writer = new StringBuilderWriter(100);
        writer.append("Foo");
        assertEquals("Foo", writer.toString());
        writer.close();
    }

    @Test
    public void testAppendConstructStringBuilder() throws IOException {
        final StringBuilder stringBuilder = new StringBuilder("Foo");
        final StringBuilderWriter stringBuilderWriter = new StringBuilderWriter(stringBuilder);
        assertEquals("Foo", stringBuilderWriter.toString());
        Assert.assertSame(stringBuilder, stringBuilderWriter.getBuilder());

        stringBuilderWriter.close();
    }

    @Test
    public void testAppendConstructNull() throws IOException {
        final Writer writer = new StringBuilderWriter(null);
        writer.append("Foo");
        assertEquals("Foo", writer.toString());
        writer.close();
    }


    @Test
    public void testClose() {
        final Writer writer = new StringBuilderWriter();
        try {
            writer.append("Foo");
            writer.close();
            writer.append("Bar");
        } catch (final Throwable e) {
            fail("Throwable: " + e);
        }

        assertEquals("FooBar", writer.toString());
    }


    @Test
    public void testWriteStringPortion() throws IOException {
        final Writer writer = new StringBuilderWriter();
        writer.write("FooBar", 3, 3);
        assertEquals("Bar", writer.toString());
        writer.close();

        writer.write("FooBar", 0, 3);
        assertEquals("BarFoo", writer.toString());

        writer.close();
    }
}
