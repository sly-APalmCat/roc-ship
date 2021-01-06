package com.rocship.aligenerator.localTest;/**
 * Description: <br/>
 * date: 2021/1/6 16:54<br/>
 *
 * @version
 */

import org.apache.coyote.OutputBuffer;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.StringWriter;

/**
 * ClassName: Writer <br/>
 * Description: <br/>
 * date: 2021/1/6 16:54<br/>
 * @author 15438<br />
 */
public class Writer {

    @Test
    public void one() throws IOException {
        StringWriter stringWriter = new StringWriter();
        StringBuffer buffer = stringWriter.getBuffer();
        buffer.append("lkjlkjlkjlkjlkjlkjk");
        buffer.insert(3,34);

        BufferedWriter writer = new BufferedWriter(new StringWriter());
        String p = "34";
        writer.append("dfd");
        java.io.Writer append = writer.append(p);

        char[] bytes = new char[1024];
        writer.write(bytes);
        writer.flush();
        System.out.println(String.valueOf(bytes));

        append.write(bytes);
        append.close();
        System.out.println(String.valueOf(bytes));
        System.out.println(stringWriter.toString());

        stringWriter.write(bytes);
        stringWriter.close();
        System.out.println(String.valueOf(bytes));



    }



}
