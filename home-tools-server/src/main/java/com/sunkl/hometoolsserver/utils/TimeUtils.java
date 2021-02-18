package com.sunkl.hometoolsserver.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    final static String defaulDateFormat = "yyyy-MM-dd HH:mm:ss";

    public static String getCurrentDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern(defaulDateFormat));
    }
}
