package com.chengzi.study.validate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class EvalExamRoomEntity {

    private static final long serialVersionUID = -1881463183531282857L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 测评ID
     */
    private String evalPlanId;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 描述备注信息
     */
    private String remark;

    /**
     * 学校ID
     */
    private List<Long> schoolIds;

    /**
     * 考场信息
     */
    private List<ExamRoomEntity> examRooms;

    /**
     * 创建时间
     */
    private Date createDatetime;

    /**
     * 更新时间
     */
    private Date updateDatetime;


    /**
     * 考场信息
     */
    @Data
    public static class ExamRoomEntity implements Serializable {

        private static final long serialVersionUID = 6016831026908790691L;

        private String name;

        /**
         * 考试考试时间
         */
        @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = Constants.TIME_ZONE)
        private Date startDateTime;

        /**
         * 考试结束时间
         */
        @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = Constants.TIME_ZONE)
        private Date endDatetime;

        /**
         * 考试使用的试卷ID列表
         */
        private List<String> paperIds;

        /**
         * 试卷信息提前推送的时间，单位分钟
         */
        private Integer advancePush;

    }

}
