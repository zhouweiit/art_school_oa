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


public class WeekRange extends DateRange {
    private static final long serialVersionUID = 5545993879264293350L;

    @Getter
    private final int year;
    @Getter
    private final int weekOfYear;

    private WeekRange(long startTime, long endTime) {
        super(startTime, endTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTimeInMillis(endTime);
        this.year = calendar.get(Calendar.YEAR);
        this.weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
    }

    @Override
    public WeekRange previous() {
        long start = getStartTime() - 86400 * 7 * 1000;
        long end = getEndTime() - 86400 * 7 * 1000;
        WeekRange inst = new WeekRange(start, end);
        inst.setPrecision(getPrecision());
        return inst;
    }

    @Override
    public WeekRange next() {
        long start = getStartTime() + 86400 * 7 * 1000;
        long end = getEndTime() + 86400 * 7 * 1000;
        WeekRange inst = new WeekRange(start, end);
        inst.setPrecision(getPrecision());
        return inst;
    }

    public static WeekRange current() {
        return newInstance(System.currentTimeMillis());
    }

    public static WeekRange newInstance(long time) {
        return newInstance(time, DateRangePrecision.SECOND);
    }

    public static WeekRange current(DateRangePrecision precision) {
        return newInstance(System.currentTimeMillis(), precision);
    }

    public static WeekRange newInstance(long time, DateRangePrecision precision) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long start = calendar.getTimeInMillis();
        precision = precision == null ? DateRangePrecision.SECOND : precision;
        long end = start + 86400 * 7 * 1000 - precision.getDelta();
        WeekRange inst = new WeekRange(start, end);
        inst.setPrecision(precision);
        return inst;
    }

    @Override
    public String toString() {
        return Integer.toString(year) + (weekOfYear < 10 ? "0" + weekOfYear : Integer.toString(weekOfYear));
    }

    public static List<WeekRange> available(DateRange range) {
        if (range == null) {
            return Collections.emptyList();
        }
        List<WeekRange> weekRanges = new ArrayList<>();
        WeekRange weekRange = newInstance(range.getStartTime());
        weekRanges.add(weekRange);
        while (true) {
            weekRange = weekRange.next();
            if (weekRange.getEndTime() <= range.getEndTime() || weekRange.contains(range.getEndTime())) {
                weekRanges.add(weekRange);
                continue;
            }
            break;
        }
        return weekRanges;
    }

    public static WeekRange parse(String s) {
        Objects.requireNonNull(s);
        if (s.length() != 6) throw new IllegalArgumentException();
        int y = Integer.parseInt(s.substring(0, 4));
        int w = Integer.parseInt(s.substring(4, 6));

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.set(Calendar.YEAR, y);
        calendar.set(Calendar.WEEK_OF_YEAR, w);

        return newInstance(calendar.getTimeInMillis());
    }
}
