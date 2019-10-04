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

    private List<Order> order;

    private Map<String, Object> search;

    @Data
    public static class Column {

        private String data;

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

    @Data static class Order {

    }

}
