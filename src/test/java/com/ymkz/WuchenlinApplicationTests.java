package com.ymkz;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//@SpringBootTest
class WuchenlinApplicationTests {


    @Test
    public void testShutdownHook() {
        // register shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Do something in Shutdown Hook");
        }));

        // sleep for some time
        try {
            for (int i=0; i<3; i++) {
                System.out.println("Count: " + i + "...");
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            List nullList = new ArrayList<>();
            System.out.println("Trying to print null list's first element: " + nullList.get(0).toString());

            TimeUnit.MILLISECONDS.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("Ready to exit.");
        System.exit(0);
    }

}
