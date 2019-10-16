/*
 * SHANGHAI SUNNY EDUCATION, INC. CONFIDENTIAL
 *
 * Copyright 2006-2016 Shanghai Sunny Education, Inc. All Rights Reserved.
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

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public interface IDateRange {
    Date getStartDate();

    Date getEndDate();

    boolean contains(long time);

    boolean contains(Date date);

    IDateRange previous();

    IDateRange next();

    IDateRange narrow();

    class SimpleDateRange implements Serializable, IDateRange {
        private static final long serialVersionUID = -5529004849781570608L;

        private final long startTime;
        private final long endTime;

        public SimpleDateRange(Date startDate, Date endDate) {
            startTime = Objects.requireNonNull(startDate).getTime();
            endTime = Objects.requireNonNull(endDate).getTime();
            if (startTime > endTime) {
                throw new IllegalArgumentException("start greater than end");
            }
        }

        @Override
        public Date getStartDate() {
            return new Date(startTime);
        }

        @Override
        public Date getEndDate() {
            return new Date(endTime);
        }

        @Override
        public boolean contains(long time) {
            return time >= startTime && time <= endTime;
        }

        @Override
        public boolean contains(Date date) {
            return date != null && contains(date.getTime());
        }

        @Override
        public IDateRange previous() {
            throw new UnsupportedOperationException();
        }

        @Override
        public IDateRange next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public IDateRange narrow() {
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SimpleDateRange that = (SimpleDateRange) o;
            return startTime == that.startTime &&
                    endTime == that.endTime;
        }

        @Override
        public int hashCode() {
            return Objects.hash(startTime, endTime);
        }
    }
}
