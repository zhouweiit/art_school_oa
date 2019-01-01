package com.chengzi.art.school.oa.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TableParamDto {

    private Integer draw;

    private List<Column> columns;

    private Integer start;

    private Integer length;

    private Map<String, Object> search;

    @Data
    public static class Column {

        private Integer data;

        private String name;

        private Boolean searchable;

        private Boolean orderable;

        private Search search;

    }

    @Data
    public static class Search {

        private String value;

        private Boolean regex;

    }

}
