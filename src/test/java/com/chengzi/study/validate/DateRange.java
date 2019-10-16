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

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Represents an inclusive range of <code>Date</code>s
 *
 * @author Xiaohai Zhang
 * @serial
 * @since 2013-02-04 23:10
 */
public class DateRange implements Serializable, IDateRange {
  private static final long serialVersionUID = -9049432860010905998L;

  @Getter
  private final long startTime;
  @Getter
  private final long endTime;

  private DateRangePrecision precision;

  public synchronized void setPrecision(DateRangePrecision precision) {
    Objects.requireNonNull(precision, "Precision must not be null");
    if (this.precision != null)
      throw new IllegalStateException("Precision already set");
    this.precision = precision;
  }

  public DateRangePrecision getPrecision() {
    return precision == null ? DateRangePrecision.SECOND : precision;
  }

  public DateRange(long startTime, long endTime) {
    if (startTime > endTime) {
      throw new IllegalArgumentException("Start must be less than or equals end");
    }
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public DateRange(Date startDate, Date endDate) {
    Objects.requireNonNull(startDate, "Start must not be null");
    Objects.requireNonNull(endDate, "End must not be null");
    this.startTime = startDate.getTime();
    this.endTime = endDate.getTime();
    if (startTime > endTime) {
      throw new IllegalArgumentException("Start must be less than or equals end");
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
  public DateRange previous() {
    throw new UnsupportedOperationException();
  }

  @Override
  public DateRange next() {
    throw new UnsupportedOperationException();
  }

  @Override
  public IDateRange narrow() {
    return new SimpleDateRange(getStartDate(), getEndDate());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DateRange dateRange = (DateRange) o;

    return endTime == dateRange.endTime && startTime == dateRange.startTime;
  }

  @Override
  public int hashCode() {
    int result = (int) (startTime ^ (startTime >>> 32));
    result = 31 * result + (int) (endTime ^ (endTime >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "[" + startTime + "~" + endTime + "]";
  }

  public static DateRange newInstance(long timestamp, DateRangeUnit unit) {
    return newInstance(timestamp, unit, DateRangePrecision.SECOND);
  }

  public static DateRange newInstance(long timestamp, DateRangeUnit unit, DateRangePrecision precision) {
    if (unit == null) {
      return null;
    }
    precision = precision == null ? DateRangePrecision.SECOND : precision;
    switch (unit) {
      case YEAR: {
        return YearRange.newInstance(timestamp, precision);
      }
      case MONTH: {
        return MonthRange.newInstance(timestamp, precision);
      }
      case WEEK: {
        return WeekRange.newInstance(timestamp, precision);
      }
      case DAY: {
        return DayRange.newInstance(timestamp, precision);
      }
      case HOUR: {
        return HourRange.newInstance(timestamp, precision);
      }
      default: {
        throw new UnsupportedOperationException();
      }
    }
  }
}
