package utils;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Date;

public class TestRateLimiter {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(10);

        for (int i = 0; i <3; i++) {
            rateLimiter.acquire();
            System.out.println(new Date());
        }
        try {
            Thread.sleep(5000);
            System.out.println("============"+new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <50; i++) {
            rateLimiter.acquire();
            System.out.println(new Date());
        }

    }
}
