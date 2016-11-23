package org.summer.common.io;

import org.junit.Test;
import org.summer.common.io.tools.TestUtils;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
public class ThreadMonitorTestCase {


    @Test
    public void testTimeout() {
        Thread thread = ThreadMonitor.start(100L);
        try {
            TestUtils.sleep(200L);
            ThreadMonitor.stop(thread);
            fail("Expected InterruptedException");
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }

    }
}
