package com.chengzi.art.school.oa.dto.response;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
public class MenuTreeDto implements Comparable<MenuTreeDto> {

    private Integer id;

    private String name;

    private String icon;

    private String url;

    private Integer order;

    private List<MenuTreeDto> menuTreeDtos;


    @Override
    public int compareTo(@NotNull MenuTreeDto o) {
        return Integer.compare(order, o.getOrder());
    }
}
