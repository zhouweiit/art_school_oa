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

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils extends DateUtilsExtend {

  public static final long DAY_TIME_LENGTH_IN_MILLIS = 24 * 60 * 60 * 1000;
  public static final long WEEK_TIME_LENGTH_IN_MILLIS = 7 * DAY_TIME_LENGTH_IN_MILLIS;
  public static final String FORMAT_SQL_DATETIME = "yyyy-MM-dd HH:mm:ss";
  public static final String FORMAT_SQL_DATE = "yyyy-MM-dd";
  public static final String FORMAT_SQL_TIME = "HH:mm:ss";
  public static final String FORMAT_YEAR_MONTH = "yyyy-MM";

  public static String dateToString(Date date) {
    return dateToString(date, FORMAT_SQL_DATETIME);
  }

  public static String dateToString(Date date, String pattern) {
    return dateToString(date, pattern, Locale.CHINA);
  }

  public static String dateToString(Date date, String pattern, Locale locale) {
    return null;
  }

  public static Date stringToDate(String date) {
    return stringToDate(date, FORMAT_SQL_DATETIME);
  }


  public static Date stringToDate(String date, String pattern) {
    return stringToDate(date, pattern, Locale.CHINA);
  }


  public static Date stringToDate(String date, String pattern, Locale locale) {
    return null;
  }

  public static long dayDiff(Date date1, Date date2) {
    return (date1.getTime() - date2.getTime()) / 86400000;
  }

  public static long hourDiff(Date date1, Date date2) {
    return (date1.getTime() - date2.getTime()) / (60 * 60 * 1000);
  }

  public static long minuteDiff(Date date1, Date date2) {
    return (date1.getTime() - date2.getTime()) / (60 * 1000);
  }

  /**
   * 计算日期
   *
   * @param date     date
   * @param deltaDay delta day
   * @return result date
   */
  public static Date calculateDateDay(Date date, int deltaDay) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, deltaDay);
    return cal.getTime();
  }

  public static String calculateDateDayToSqlDate(Date date, int deltaDay) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, deltaDay);
    return dateToString(cal.getTime(), FORMAT_SQL_DATE);
  }

  public static String getDateTimeStrC(Date date) {
    return dateToString(date, "yyyy年MM月dd日");
  }

  @Deprecated
  public static Date getFirstDayOfWeek(Date date) {
    WeekRange weekRange = WeekRange.newInstance(date.getTime());
    return weekRange.getStartDate();
  }

  @Deprecated
  public static Date getLastDayOfWeek(Date date) {
    WeekRange weekRange = WeekRange.newInstance(date.getTime());
    return weekRange.getEndDate();
  }

  @Deprecated
  public static Date getFirstDayOfMonth(Date date) {
    MonthRange monthRange = MonthRange.newInstance(date.getTime());
    return monthRange.getStartDate();
  }

  @Deprecated
  public static Date getLastDayOfMonth(Date date) {
    MonthRange monthRange = MonthRange.newInstance(date.getTime());
    return monthRange.getEndDate();
  }

  @Deprecated
  public static Date getDayStart(Date date) {
    return DayRange.newInstance(date.getTime()).getStartDate();
  }

  @Deprecated
  public static Date getDayEnd(Date date) {
    return DayRange.newInstance(date.getTime()).getEndDate();
  }

  @Deprecated
  public static Date getTodayStart() {
    return DayRange.current().getStartDate();
  }

  public static Date getTodayEnd() {
    return DayRange.current().getEndDate();
  }

  @Deprecated
  public static Date getYesterdayStart() {
    long timestamp = DayRange.current().getStartTime() - 86400 * 1000;
    return new Date(timestamp);
  }

  @Deprecated
  public static Date getYesterdayEnd() {
    long timestamp = DayRange.current().getEndTime() - 86400 * 1000;
    return new Date(timestamp);
  }

  @Deprecated
  public static Date getTomorrowStart() {
    long timestamp = DayRange.current().getStartTime() + 86400 * 1000;
    return new Date(timestamp);
  }

  @Deprecated
  public static DateRange getDayDateRange(Date date) {
    return DayRange.newInstance(date.getTime());
  }

  /**
   * 取得指定日期过 day 天后的日期 (当 day 为负数表示指日期之前);
   *
   * @param date 日期 为null时表示当天
   * @param day  相加(相减)的天数
   * @return result date
   */
  public static Date nextDay(Date date, int day) {
    long timestamp = date.getTime() + ((long) day * 86400L * 1000L);
    return new Date(timestamp);
  }

  public static String getYesterdaySqlDate() {
    return calculateDateDayToSqlDate(new Date(), -1);
  }

  public static String getNowSqlDatetime() {
    return dateToString(new Date(), FORMAT_SQL_DATETIME);
  }

  public static String getTodaySqlDate() {
    return dateToString(new Date(), FORMAT_SQL_DATE);
  }

  public static String nowToString(String format) {
    return dateToString(new Date(), format);
  }

  public static String nowToString() {
    return dateToString(new Date(), FORMAT_SQL_DATETIME);
  }

  public static int getCurrentToDayEndSecond() { // 获取从当前时间到当天截止的秒数，主要用于缓存的过期时间
    long current = System.currentTimeMillis();
    long todayEnd = DayRange.newInstance(current).getEndDate().getTime();
    long start = current / 1000;    // current second
    long end = todayEnd / 1000;     // today last second
    int exp = (int) (end - start + 1);
    return Math.max(1, exp);        // ensure exp greater than 0
  }

  public static int getCurrentToWeekEndSecond() { // 获取从当前时间到本周截止的秒数，主要用于缓存的过期时间
    long current = System.currentTimeMillis();
    long todayEnd = WeekRange.newInstance(current).getEndDate().getTime();
    long start = current / 1000;    // current second
    long end = todayEnd / 1000;     // this week last second
    int exp = (int) (end - start + 1);
    return Math.max(1, exp);        // ensure exp greater than 0
  }

  public static int getCurrentToMonthEndSecond() {
    // 获取从当前时间到本月截止的秒数，主要用于缓存的过期时间
    // 这个时间也许会超过30天，如果是需要再换算一下到unix时间
    long current = System.currentTimeMillis();
    long todayEnd = MonthRange.newInstance(current).getEndDate().getTime();
    long start = current / 1000;    // current second
    long end = todayEnd / 1000;     // this week last second
    int exp = (int) (end - start + 1);
    return Math.max(1, exp);        // ensure exp greater than 0
  }

  public static long getCurrentToDateEndSecond(Date date) {
    Instant current = Instant.now();
    Instant target = date.toInstant();

    return target.getEpochSecond() - current.getEpochSecond();
  }

  public static long roundDateToDay235959InMillis(Date date, int delta) {
    Date endDatetime = DateUtils.nextDay(date, delta);
    Calendar cal = Calendar.getInstance();
    cal.setTime(endDatetime);
    cal.set(Calendar.HOUR_OF_DAY, 23);
    cal.set(Calendar.MINUTE, 59);
    cal.set(Calendar.SECOND, 59);
    cal.set(Calendar.MILLISECOND, 0);
    return cal.getTimeInMillis();
  }
}
