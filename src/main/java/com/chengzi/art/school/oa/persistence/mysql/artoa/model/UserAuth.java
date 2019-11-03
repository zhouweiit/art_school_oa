package com.chengzi.art.school.oa.persistence.mysql.artoa.model;

import com.chengzi.art.school.framework.util.SafeConverterUtil;
import com.chengzi.art.school.framework.util.StringUtil;
import com.chengzi.art.school.framework.util.encryption.MD5Util;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuth {

    private static final String saltString = "1234567890abcdefghijklmnopqrstuvwxyz";

    private Integer userBaseId;

    private String loginName;

    private String salt;

    private String loginPassword;

    private String roleId;

    private String permissionResourceId;

    private Date lastLoginDatetime;

    private Integer schoolGroupId;

    private Integer isDelete;

    private Date createDatetime;

    private Date updateDatetime;

    public Set<Integer> getRoIdSet() {
        return splitRoleId(this.roleId);
    }

    public Set<Integer> getPermissionResourceIdSet() {
        return splitPermissionResourceId(this.permissionResourceId);
    }

    public static String createRoleId(Set<Integer> roleIds) {
        List<String> roleIdsString = roleIds.stream().map(SafeConverterUtil::toString).filter(Objects::nonNull).collect(Collectors.toList());
        return StringUtil.implode(Lists.newArrayList(roleIdsString), ",");
    }

    public static Set<Integer> splitRoleId(String roleIdString) {
        List<String> roleIds = StringUtil.splitStringList(roleIdString, ",");
        return roleIds.stream().map(SafeConverterUtil::toInteger).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    public static String createPermissionResourceId(Set<Integer> permissionResourceIds) {
        List<String> roleIdsString = permissionResourceIds.stream().map(SafeConverterUtil::toString).filter(Objects::nonNull).collect(Collectors.toList());
        return StringUtil.implode(Lists.newArrayList(roleIdsString), ",");
    }

    public static Set<Integer> splitPermissionResourceId(String permissionResourceIdString) {
        List<String> roleIds = StringUtil.splitStringList(permissionResourceIdString, ",");
        return roleIds.stream().map(SafeConverterUtil::toInteger).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    public static String createPasswordSalt() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        while (true) {
            int i = random.nextInt(saltString.length() - 1);
            sb.append(saltString.charAt(i));
            if (sb.length() >= 5) {
                break;
            }
        }
        return sb.toString();
    }

    public static String createPassword(String password) {
        String salt = createPasswordSalt();
        return createPassword(salt, password);
    }

    public static String createPassword(String salt, String password) {
        return MD5Util.getInstance().md5(salt + "." + password);
    }

}
