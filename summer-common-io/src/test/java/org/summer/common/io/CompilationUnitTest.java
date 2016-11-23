package org.summer.common.io;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/22 0022.
 */
public class CompilationUnitTest {

    @Test
    public void issue578TheFirstCommentIsWithinTheCompilationUnit() throws ParseException, IOException {
        final File file = new File("F:\\source-code\\summer\\summer-common-io\\src\\test\\java\\org\\summer\\common\\io\\CompilationUnitTest.java");
        FileInputStream in = new FileInputStream(file);

        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        // prints the resulting compilation unit to default system outputz
        System.out.println(cu.toString());
    }

}
