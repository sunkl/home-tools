package com.sunkl.hometoolsserver.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    final static String defaulDateTimeFormat = "yyyy-MM-dd HH:mm:ss";
    final static String defaulDateFormat = "yyyy-MM-dd";

    public static String getCurrentDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern(defaulDateTimeFormat));
    }

    public static String getYesterdayDate() {
        LocalDate today = LocalDate.now();
        return today.plusDays(-1).format(DateTimeFormatter.ofPattern(defaulDateFormat));
    }
}
