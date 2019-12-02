package com.winston.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @ClassName ExcelEntityExample
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/12/2 10:41
 * @Version：
 */
@Data
@ExcelTarget("20")
public class ExcelEntityTest implements Serializable {

    @Excel(name = "id", width = 15)
    @NotBlank(message = "该字段不能为空")
    private Integer id;

    @Excel(name = "姓名", orderNum = "0", width = 30)
    private String name;

    @Excel(name = "性别", replace = {"男_1", "女_2"},orderNum = "1", width = 30)
    private String sex;

    @Excel(name = "生日", exportFormat = "yyyy-MM-dd", orderNum = "2", width = 30)
    private String birthday;

}
