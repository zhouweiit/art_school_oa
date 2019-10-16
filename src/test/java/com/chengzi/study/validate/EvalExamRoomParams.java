package com.chengzi.study.validate;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zhouwei on 2019/10/15
 **/
@Data
public class EvalExamRoomParams implements Serializable{
    private static final long serialVersionUID = -7657658207561410264L;

    /**
     * 分组ID，也是主键ID
     */
    @NotNull(message = "分组ID不能为空", groups = {Update.class, Delete.class})
    private String id;

    /**
     * 测评ID
     */
    @NotNull(message = "测评ID不能为空")
    private String planId;

    /**
     * 分组名称
     */
    @NotNull(message = "分组名称不能为空")
    @Length(message = "分组名称最大长度不能超过50", min = 1,max = 50)
    private String groupName;

    /**
     * 描述备注信息
     */
    @Length(message = "备注最大长度不能超过500", min = 1,max = 500)
    private String remark;

    /**
     * 学校ID
     */
    @NotNull(message = "学校的ID不能为空")
    @Size(message = "学校的ID不能为空", min = 1)
    private List<Long> schoolIds;

    /**
     * 考场信息
     */
    @NotNull(message = "考场信息不能为空")
    @Size(message = "考场信息不能为空", min = 1)
    @Valid
    private List<ExamRoomParams> examRooms;

    /**
     * 考场信息
     */
    @Data
    public static class ExamRoomParams implements Serializable {

        private static final long serialVersionUID = 6016831026908790691L;

        /**
         * 考场名称
         */
        @NotNull(message = "考场名称不能为空")
        @Length(message = "考场名称最大长度不能超过50", min = 1,max = 50)
        private String name;

        /**
         * 考试开始时间
         */
        @NotNull(message = "考试开始时间不能为空")
        private String startDateTime;

        /**
         * 考试结束时间
         */
        @NotNull(message = "考试结束时间不能为空")
        private String endDatetime;

        /**
         * 考场所用的试卷ID
         */
        @NotNull(message = "试卷ID列表不能为空")
        @Size(message = "试卷ID列表不能为空", min = 1)
        private List<String> paperIds;

        /**
         * 考试提前推送的时间
         */
        @NotNull(message = "提前推送的分钟不能为空")
        @Range(min = 0, max = 60, message = "提前推送的分钟最小值为0，最大值为60")
        private Integer advancePush;

    }

    public MapMessage checkInsert() {
        MapMessage validate = ValidateUtil.validate(this, Default.class);
        if (!validate.isSuccess()) {
            return validate;
        }
        return MapMessage.successMessage();
    }

    public MapMessage checkUpdate() {
        MapMessage validate = ValidateUtil.validate(this, Update.class, Default.class);
        if (!validate.isSuccess()) {
            return validate;
        }
        return MapMessage.successMessage();
    }

    public MapMessage checkDelete() {
        MapMessage validate = ValidateUtil.validate(this, Delete.class);
        if (!validate.isSuccess()) {
            return validate;
        }
        return MapMessage.successMessage();
    }

    public MapMessage checkCommon(EvalPlanEntity evalPlanEntity) {
        if (evalPlanEntity == null) {
            return MapMessage.errorMessage("测评相关信息不存在");
        }
        for (ExamRoomParams examRoomParams : examRooms) {
            MapMessage checkStart = checkStartDateTime(examRoomParams.getStartDateTime());
            if (!checkStart.isSuccess()) {
                return checkStart;
            }
            MapMessage checkEnd = checkEndDateTime(examRoomParams.getEndDatetime(), DateUtils.stringToDate(examRoomParams.getStartDateTime(), DateUtils.FORMAT_SQL_DATETIME));
            if (!checkEnd.isSuccess()) {
                return checkEnd;
            }
            MapMessage checkPaper = checkPaperId(evalPlanEntity, examRoomParams.paperIds);
            if (!checkPaper.isSuccess()) {
                return checkPaper;
            }
        }
        return MapMessage.successMessage();
    }

    public MapMessage checkSchoolIds(List<EvalExamRoomEntity> evalExamRoomEntities, String groupId) {
        //在其他组已经分配好的学校ID
        Set<Long> schoolIds = evalExamRoomEntities.stream().filter(e -> !Objects.equals(e.getId(), groupId)).map(EvalExamRoomEntity::getSchoolIds).flatMap(List::stream).collect(Collectors.toSet());
        for (Long id : this.schoolIds) {
            if (schoolIds.contains(id)) {
                return MapMessage.errorMessage("本次分配的学校ID已经在其他组存在了，不能重复安排考场，学校ID：" + id);
            }
        }
        return MapMessage.successMessage();
    }

    public MapMessage checkStartDateTime(String datetime) {
        Date date = DateUtils.stringToDate(datetime, DateUtils.FORMAT_SQL_DATETIME);
        if (date == null) {
            return MapMessage.errorMessage("考试开始时间的格式不对");
        }
        return MapMessage.successMessage();
    }

    public MapMessage checkEndDateTime(String datetime, Date startDateTime) {
        Date endDateTime = DateUtils.stringToDate(datetime, DateUtils.FORMAT_SQL_DATETIME);
        if (endDateTime == null) {
            return MapMessage.errorMessage("考试结束时间的格式不对");
        }
        Date dayStart = DateUtils.getDayStart(endDateTime);
        Date dayEnd = DateUtils.getDayEnd(endDateTime);
        if (endDateTime.getTime() <= startDateTime.getTime()) {
            return MapMessage.errorMessage("考试开始时间不能大于结束时间");
        }
        if (startDateTime.getTime() < dayStart.getTime() || startDateTime.getTime() > dayEnd.getTime()) {
            return MapMessage.errorMessage("考试的开始时间与结束时间必须在当天[00:00:01 - 23:59:59]之内");
        }
        return MapMessage.successMessage();
    }

    public MapMessage checkPaperId(EvalPlanEntity evalPlanEntity, List<String> paperIds) {
        for (String paperId : paperIds) {
            if (!evalPlanEntity.getPapers().contains(paperId)) {
                return MapMessage.errorMessage("试卷ID在测评里面不存在");
            }
        }
        return MapMessage.successMessage();
    }

    public EvalExamRoomEntity buildEvalExamRoomEntity(boolean insert) {
        EvalExamRoomEntity examRoomEntity = new EvalExamRoomEntity();
        if (insert) {
            examRoomEntity.setCreateDatetime(new Date());
        } else {
            examRoomEntity.setId(id);
        }
        examRoomEntity.setEvalPlanId(planId);
        examRoomEntity.setGroupName(groupName);
        examRoomEntity.setSchoolIds(schoolIds);
        examRoomEntity.setRemark(remark);
        examRoomEntity.setUpdateDatetime(new Date());
        examRoomEntity.setExamRooms(new ArrayList<>());
        for (ExamRoomParams examRoom : examRooms) {
            EvalExamRoomEntity.ExamRoomEntity examRoomInfo = new EvalExamRoomEntity.ExamRoomEntity();
            examRoomInfo.setName(examRoom.getName());
            examRoomInfo.setPaperIds(examRoom.getPaperIds());
            examRoomInfo.setAdvancePush(examRoom.getAdvancePush());
            examRoomInfo.setStartDateTime(DateUtils.stringToDate(examRoom.getStartDateTime(), DateUtils.FORMAT_SQL_DATETIME));
            examRoomInfo.setEndDatetime(DateUtils.stringToDate(examRoom.getEndDatetime(), DateUtils.FORMAT_SQL_DATETIME));
            examRoomEntity.getExamRooms().add(examRoomInfo);
        }
        return examRoomEntity;
    }

    public interface Update{}

    public interface Delete{}
}
