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


public class MonthRange extends DateRange {
    private static final long serialVersionUID = -6876153686625723986L;

    @Getter
    private final int year;
    @Getter
    private final int month;

    public MonthRange(long startTime, long endTime) {
        super(startTime, endTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(endTime);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
    }

    @Override
    public MonthRange previous() {
        return newInstance(getStartTime() - getPrecision().getDelta(), getPrecision());
    }

    @Override
    public MonthRange next() {
        return newInstance(getEndTime() + getPrecision().getDelta(), getPrecision());
    }

    public static MonthRange current() {
        return newInstance(System.currentTimeMillis());
    }

    public static MonthRange newInstance(long stamp) {
        return newInstance(stamp, DateRangePrecision.SECOND);
    }

    public static MonthRange current(DateRangePrecision precision) {
        return newInstance(System.currentTimeMillis(), precision);
    }

    public static MonthRange newInstance(long stamp, DateRangePrecision precision) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(stamp);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long startTime = calendar.getTimeInMillis();
        calendar.add(Calendar.MONTH, 1);
        precision = precision == null ? DateRangePrecision.SECOND : precision;
        long endTime = calendar.getTimeInMillis() - precision.getDelta();
        MonthRange inst = new MonthRange(startTime, endTime);
        inst.setPrecision(precision);
        return inst;
    }

    @Override
    public String toString() {
        return Integer.toString(year) + (month < 10 ? "0" + month : Integer.toString(month));
    }

    public static List<MonthRange> available(DateRange range) {
        if (range == null) {
            return Collections.emptyList();
        }
        List<MonthRange> monthRanges = new ArrayList<>();
        MonthRange monthRange = newInstance(range.getStartTime());
        monthRanges.add(monthRange);
        while (true) {
            monthRange = monthRange.next();
            if (monthRange.getEndTime() <= range.getEndTime() || monthRange.contains(range.getEndTime())) {
                monthRanges.add(monthRange);
                continue;
            }
            break;
        }
        return monthRanges;
    }

    public static MonthRange parse(String s) {
        Objects.requireNonNull(s);
        if (s.length() != 6) throw new IllegalArgumentException();
        int y = Integer.parseInt(s.substring(0, 4));
        int m = Integer.parseInt(s.substring(4, 6));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.set(Calendar.YEAR, y);
        calendar.set(Calendar.MONTH, m - 1);

        return newInstance(calendar.getTimeInMillis());
    }
}
