package com.czl.test;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class InstantTest {

    // 일자
    public static void main(String[] args) {
        System.out.println("Hello");
        defaultTest();
        beetweenTest();
        dateConvert();
    }

    public static void defaultTest(){
        Instant now = Instant.now();
        System.out.println(now);
        // Duration
        System.out.println(now.plus(Duration.ofMillis(1)));
        System.out.println(now.plus(Duration.ofSeconds(1)));
        System.out.println(now.plus(Duration.ofMinutes(1)));
        System.out.println(now.plus(Duration.ofHours(1)));
        System.out.println(now.plus(Duration.ofDays(1)));

        System.out.println("=====================================");
        // ChronoUnit
        System.out.println(now.plus(1, ChronoUnit.MILLIS));
        System.out.println(now.plus(1, ChronoUnit.SECONDS));
        System.out.println(now.plus(1, ChronoUnit.MINUTES));
        System.out.println(now.plus(1, ChronoUnit.HOURS));
        System.out.println(now.plus(1, ChronoUnit.DAYS));

        System.out.println("=====================================");
        // instant는 최대 day로만 증가가 가능한다.
        ZonedDateTime znow = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println(znow.toInstant());
        System.out.println(znow.plusDays(1).toInstant());
        System.out.println(znow.plusMonths(1).toInstant());
        System.out.println(znow.plusYears(1).toInstant());

        System.out.println("=====================================");
        System.out.println(znow);
        System.out.println(znow.plusDays(1));
        System.out.println(znow.plusMonths(1));
        System.out.println(znow.plusYears(1));
    }

    public static void beetweenTest(){
        System.out.println("=====================================");
        Instant now = Instant.now();
        Instant nowPlusOneDay = now.plus(Duration.ofDays(1));
        System.out.println(now);
        System.out.println(nowPlusOneDay);
        System.out.println("isAfter : " + now.isAfter(nowPlusOneDay));
        System.out.println("isBefore : " + now.isBefore(nowPlusOneDay));
        System.out.println("equals : " + now.equals(nowPlusOneDay));
        System.out.println("compareTo : " + now.compareTo(nowPlusOneDay));
        System.out.println("=====================================");
    }

    public static void dateConvert(){
        System.out.println("=====================================");
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.atZone(ZoneId.systemDefault()));
        System.out.println(now.atZone(ZoneId.of("Asia/Seoul")));
        System.out.println(now.atZone(ZoneId.of("UTC")));
        System.out.println(now.atZone(ZoneId.of("UTC")).toInstant());
        System.out.println("=====================================");
    }
}
