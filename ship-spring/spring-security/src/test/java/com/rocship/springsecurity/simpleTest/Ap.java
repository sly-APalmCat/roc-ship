package com.rocship.springsecurity.simpleTest;/**
 * Description: <br/>
 * date: 2020/12/15 11:27<br/>
 *
 * @version
 */

import org.springframework.util.StringUtils;
import sun.net.NetworkServer;

import java.io.IOException;

/**
 * ClassName: Ap <br/>
 * Description: <br/>
 * date: 2020/12/15 11:27<br/>
 * @author 15438<br />
 */
public class Ap  extends NetworkServer {
    public void serviceRequest() throws IOException {

        this.clientOutput.print("Echo server " + this.getClass().getName() + "\n");
        this.clientOutput.flush();
        byte[] var1 = new byte[300];
        int var2;
        while((var2 = this.clientInput.read(var1, 0, var1.length)) >= 0) {
            System.out.println(new String(var1));
            this.clientOutput.write(var1, 0, var2);
            this.clientOutput.flush();
            clear(var1);
        }

    }

    private void clear(byte[] var1) {
        for (int i = 0; i < var1.length; i++) {
            var1[i] = 0x00;
        }
    }


}
