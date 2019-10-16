package com.chengzi.art.school.framework.util.date;


import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期工具类：
 * 1. LocalDate
 * 2. LocalTime
 * 3. LocalDateTime
 * 4. DateTimeFormatter
 * 5. Instant
 * 6. Date
 * 7. ZoneOffset
 */
@Slf4j
public class DateUtil {

    public static final ZoneId ZONE_BEIJING = ZoneId.of("+08:00");

    public static LocalDateTime localDateTimeByDate(Date date) {
        try {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.of("+08:00"));
        } catch (Exception e) {
            log.error(date + "", e);
            return null;
        }
    }

    public static String dateToString(Date date, DateFormat dateFormat) {
        try {
            return localDateTimeByDate(date).format(DateTimeFormatter.ofPattern(dateFormat.getPattern()));
        } catch (Exception e) {
            log.error(date + " : " + dateFormat, e);
            return null;
        }
    }

    public static Date stringToDate(String datetime, DateFormat dateFormat) {
        try {
            LocalDateTime localDateTime = stringToLocalDateTime(datetime, dateFormat);
            return new Date(localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli());
        } catch (Exception e) {
            log.error(datetime + " : " + dateFormat, e);
            return null;
        }
    }

    public static String localDateTimeToString(LocalDateTime localDateTime, DateFormat dateFormat) {
        try {
            localDateTime.atZone(ZONE_BEIJING);
            return localDateTime.format(DateTimeFormatter.ofPattern(dateFormat.getPattern()));
        } catch (Exception e) {
            log.error(localDateTime + " : " + dateFormat, e);
            return null;
        }
    }

    public static LocalDateTime stringToLocalDateTime(String datetime, DateFormat dateFormat) {
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(dateFormat.getPattern()));
            localDateTime.atZone(ZONE_BEIJING);
            return localDateTime;
        } catch (Exception e) {
            log.error(datetime + " : " + dateFormat, e);
            return null;
        }
    }

}

