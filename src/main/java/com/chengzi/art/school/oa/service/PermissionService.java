package com.chengzi.art.school.oa.service;

import com.chengzi.art.school.framework.util.StringUtil;
import com.chengzi.art.school.oa.constant.PermissionType;
import com.chengzi.art.school.oa.dto.response.MenuTreeDto;
import com.chengzi.art.school.oa.persistence.mysql.artoa.dao.PermissionResourceDao;
import com.chengzi.art.school.oa.persistence.mysql.artoa.dao.PermissionResourceRoleDao;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.PermissionResource;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.PermissionResourceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PermissionService {

    @Autowired
    private PermissionResourceDao permissionResourceDao;

    @Autowired
    private PermissionResourceRoleDao permissionResourceRoleDao;

    public List<PermissionResourceRole> loadRolesByIds(Collection<Integer> roleIds) {
        return permissionResourceRoleDao.selectByIds(roleIds);
    }

    public Map<Integer, PermissionResource> loadAllPermissionResource() {
        return permissionResourceDao.selectAll().stream().collect(Collectors.toMap(PermissionResource::getId, Function.identity()));
    }

    /**
     * 根据角色ID与资源ID，获取所有的资源权限列表
     * @param roleIds
     * @param permissionResourceIdsParams
     * @return
     */
    public Set<PermissionResource> loadPermissionResource(Collection<Integer> roleIds, Collection<Integer> permissionResourceIdsParams) {
        List<PermissionResourceRole> roles = loadRolesByIds(roleIds);
        Map<Integer, PermissionResource> permissionResources = loadAllPermissionResource();
        Set<Integer> permissionResourceIds = roles.stream().filter(r -> StringUtil.isNotBlank(r.getPermissionResourceId())).map(PermissionResourceRole::getPermissionResourceId)
                .map(PermissionResourceRole::splitPermissionResourceId).flatMap(Collection::stream).collect(Collectors.toSet());
        permissionResourceIds.addAll(permissionResourceIdsParams);
        return permissionResourceIds.stream().map(permissionResources::get).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    /**
     * 根据传递的权限列表，然后根据权限类型为1级菜单，与2级菜单组成菜单列表
     * @param permissionResources
     * @return
     */
    public List<MenuTreeDto> createMenuTreeDto(Collection<PermissionResource> permissionResources) {
        Set<PermissionResource> first = permissionResources.stream().filter(p -> PermissionType.ofId(p.getType()) == PermissionType.FirstMenu).collect(Collectors.toSet());
        Set<PermissionResource> second = permissionResources.stream().filter(p -> PermissionType.ofId(p.getType()) == PermissionType.SecondMenu).collect(Collectors.toSet());
        List<MenuTreeDto> menuTreeDtos = new ArrayList<>();
        first.forEach(p -> {
            MenuTreeDto dto = new MenuTreeDto();
            dto.setId(p.getId());
            dto.setName(p.getName());
            dto.setOrder(p.getOrder());
            dto.setIcon(p.getIcon());
            dto.setUrl(p.getUrl());
            dto.setMenuTreeDtos(new ArrayList<>());
            menuTreeDtos.add(dto);
        });
        second.forEach(p -> {
            for (MenuTreeDto firstMenu : menuTreeDtos) {
                if (Objects.equals(firstMenu.getId(), p.getParentId())) {
                    MenuTreeDto dto = new MenuTreeDto();
                    dto.setId(p.getId());
                    dto.setName(p.getName());
                    dto.setOrder(p.getOrder());
                    dto.setIcon(p.getIcon());
                    dto.setUrl(p.getUrl());
                    firstMenu.getMenuTreeDtos().add(dto);
                }
            }
        });
        Collections.sort(menuTreeDtos);
        menuTreeDtos.forEach(dto -> Collections.sort(dto.getMenuTreeDtos()));
        return menuTreeDtos;
    }

}
