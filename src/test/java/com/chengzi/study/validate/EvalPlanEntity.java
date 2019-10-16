/*
 * SHANGHAI SUNNY EDUCATION, INC. CONFIDENTIAL
 *
 * Copyright 2011-2020 Shanghai Sunny Education, Inc. All Rights Reserved.
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

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EvalPlanEntity {
    private static final long serialVersionUID = 6079097817368852563L;

    protected String id;



    private Integer subject;

    private List<String> types;


    private Integer grade;


    private String form;


    private String distributeType;


    private String scene;


    private String pattern;


    private String allowTeacherQuery;


    private String allowTeacherModify;


    private Date teacherMarkDeadline;


    private String allowStudentQuery;


    private Date scorePublishTime;


    private Integer finishExamTime;


    private Integer examTotalTime;

    private Integer totalScore;

    private String spokenScoreType;

    private String spokenAnswerTimes;

    private String scoreRuleType;

    private String regionLevel;


    private Date startTime;

    private Date endTime;


    private Date registrationDeadlineTime;


    private String status;


    private String preStatus;

    private List<String> papers;

}
