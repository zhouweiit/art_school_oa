package com.chengzi.study.validate;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Params {

    @NotNull(message = "主键ID不能为空")
    @Range(message = "id最小值是10，最大值是100", max = 100, min = 10)
    private Integer id;

    @NotNull(message = "名称不能为空")
    @Length(message = "名称长度最长为10", max = 10)
    private String name;

    public static void main(String[] args) {
        Params params = new Params(55, "");
        System.out.println(ValidateUtil.validate(params));
    }

}
