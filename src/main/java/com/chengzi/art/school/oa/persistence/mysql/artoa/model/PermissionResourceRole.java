package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import com.chengzi.art.school.framework.util.SafeConverterUtil;
import com.chengzi.art.school.framework.util.StringUtil;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionResourceRole {

    private Integer id;

    private String name;

    private String permissionResourceId;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

    public static String createPermissionResourceId(Set<Integer> permissionResourceIds) {
        List<String> roleIdsString = permissionResourceIds.stream().map(SafeConverterUtil::toString).filter(Objects::nonNull).collect(Collectors.toList());
        return StringUtil.implode(Lists.newArrayList(roleIdsString), ",");
    }

    public static Set<Integer> splitPermissionResourceId(String permissionResourceIdString) {
        List<String> roleIds = StringUtil.splitStringList(permissionResourceIdString, ",");
        return roleIds.stream().map(SafeConverterUtil::toInteger).filter(Objects::nonNull).collect(Collectors.toSet());
    }

}
