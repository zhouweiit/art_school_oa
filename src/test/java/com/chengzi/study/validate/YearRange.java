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

public class YearRange extends DateRange {
    private static final long serialVersionUID = -7257407654432430936L;

    @Getter
    private final int year;

    public YearRange(long startTime, long endTime) {
        super(startTime, endTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(endTime);
        this.year = calendar.get(Calendar.YEAR);
    }

    @Override
    public YearRange previous() {
        return newInstance(getStartTime() - getPrecision().getDelta(), getPrecision());
    }

    @Override
    public YearRange next() {
        return newInstance(getEndTime() + getPrecision().getDelta(), getPrecision());
    }

    public static YearRange current() {
        return newInstance(System.currentTimeMillis());
    }

    public static YearRange newInstance(long stamp) {
        return newInstance(stamp, DateRangePrecision.SECOND);
    }

    public static YearRange current(DateRangePrecision precision) {
        return newInstance(System.currentTimeMillis(), precision);
    }

    public static YearRange newInstance(long stamp, DateRangePrecision precision) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(stamp);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long startTime = calendar.getTimeInMillis();
        calendar.add(Calendar.YEAR, 1);
        precision = precision == null ? DateRangePrecision.SECOND : precision;
        long endTime = calendar.getTimeInMillis() - precision.getDelta();
        YearRange inst = new YearRange(startTime, endTime);
        inst.setPrecision(precision);
        return inst;
    }

    @Override
    public String toString() {
        return Integer.toString(year);
    }

    public static List<YearRange> available(DateRange range) {
        if (range == null) {
            return Collections.emptyList();
        }
        List<YearRange> yearRanges = new ArrayList<>();
        YearRange yearRange = newInstance(range.getStartTime());
        yearRanges.add(yearRange);
        while (true) {
            yearRange = yearRange.next();
            if (yearRange.getEndTime() <= range.getEndTime() || yearRange.contains(range.getEndTime())) {
                yearRanges.add(yearRange);
                continue;
            }
            break;
        }
        return yearRanges;
    }

    public static YearRange parse(String s) {
        Objects.requireNonNull(s);
        if (s.length() != 4) throw new IllegalArgumentException();
        int y = Integer.parseInt(s);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.set(Calendar.YEAR, y);

        return newInstance(calendar.getTimeInMillis());
    }
}
