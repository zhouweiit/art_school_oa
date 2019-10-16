/*
 * SHANGHAI SUNNY EDUCATION, INC. CONFIDENTIAL
 *
 * Copyright 2011-2016 Shanghai Sunny Education, Inc. All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property of
 * Shanghai Sunny Education, Inc. and its suppliers, if any. The intellectual
 * and technical concepts contained herein are proprietary to Shanghai Sunny
 * Education, Inc. and its suppliers and may be covered by patents, patents
 * in process, and are protected by trade secret or copyright law. Dissemination
 * of this information or reproduction of this material is strictly forbidden
 * unless prior written permission is obtained from Shanghai Sunny Education, Inc.
 */

package com.chengzi.study.validate;

import lombok.Getter;

import java.util.*;

public class HourRange extends DateRange {
    private static final long serialVersionUID = 3012507378617096947L;

    @Getter
    private final int year;
    @Getter
    private final int month;
    @Getter
    private final int day;
    @Getter
    private final int hour;

    public HourRange(long startTime, long endTime) {
        super(startTime, endTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(endTime);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    }

    @Override
    public HourRange previous() {
        return newInstance(getStartTime() - getPrecision().getDelta(), getPrecision());
    }

    @Override
    public HourRange next() {
        return newInstance(getEndTime() + getPrecision().getDelta(), getPrecision());
    }

    public static HourRange current() {
        return newInstance(System.currentTimeMillis());
    }

    public static HourRange newInstance(long timestamp) {
        return newInstance(timestamp, DateRangePrecision.SECOND);
    }

    public static HourRange current(DateRangePrecision precision) {
        return newInstance(System.currentTimeMillis(), precision);
    }

    public static HourRange newInstance(long timestamp, DateRangePrecision precision) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long startTime = calendar.getTimeInMillis();
        precision = precision == null ? DateRangePrecision.SECOND : precision;
        long endTime = startTime + 3600 * 1000 - precision.getDelta();
        HourRange inst = new HourRange(startTime, endTime);
        inst.setPrecision(precision);
        return inst;
    }

    @Override
    public String toString() {
        String y = Integer.toString(year);
        String m = month < 10 ? "0" + month : Integer.toString(month);
        String d = day < 10 ? "0" + day : Integer.toString(day);
        String h = hour < 10 ? "0" + hour : Integer.toString(hour);
        return y + m + d + h;
    }

    public static List<HourRange> available(DateRange range) {
        if (range == null) {
            return Collections.emptyList();
        }
        List<HourRange> hourRanges = new ArrayList<>();
        HourRange hourRange = newInstance(range.getStartTime());
        hourRanges.add(hourRange);
        while (true) {
            hourRange = hourRange.next();
            if (hourRange.getEndTime() <= range.getEndTime() || hourRange.contains(range.getEndTime())) {
                hourRanges.add(hourRange);
                continue;
            }
            break;
        }
        return hourRanges;
    }

    public static HourRange parse(String s) {
        Objects.requireNonNull(s);
        if (s.length() != 10) throw new IllegalArgumentException();
        int y = Integer.parseInt(s.substring(0, 4));
        int m = Integer.parseInt(s.substring(4, 6));
        int d = Integer.parseInt(s.substring(6, 8));
        int h = Integer.parseInt(s.substring(8, 10));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.set(Calendar.YEAR, y);
        calendar.set(Calendar.MONTH, m - 1);
        calendar.set(Calendar.DAY_OF_MONTH, d);
        calendar.set(Calendar.HOUR_OF_DAY, h);

        return newInstance(calendar.getTimeInMillis());
    }
}
