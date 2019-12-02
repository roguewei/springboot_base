package com.winston.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.winston.entity.ExcelEnTity;
import com.winston.service.IExcelEntityService;
import com.winston.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName ExcelController
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/12/2 11:19
 * @Version：
 */
@RestController
@RequestMapping("/web/excel")
public class ExcelController {

    @Autowired
    private IExcelEntityService entityService;

    /**
     * @auther: Winston
     * @Description: 导出
     * @param:
     * @return:
     * @date: 2019/12/2 11:27
     */
    @GetMapping("/myexport")
    public void myexport(HttpServletResponse response){
        System.out.println(1);
        List<ExcelEnTity> query = entityService.query();
        //导出
        ExcelUtil.exportExcel(query, "easypoi导出测试",
                "导出sheet1", ExcelEnTity.class,
                "myTest.xls", response);
    }

    @PostMapping("/myimport")
    public String myimport(MultipartFile file){
        ImportParams params = new ImportParams();
        //数据处理
        params.setHeadRows(1);
        params.setTitleRows(1);
        //需要验证
        params.setNeedVerfiy(false);

        try {
            ExcelImportResult<ExcelEnTity> result = ExcelImportUtil.importExcelMore
                    (file.getInputStream(), ExcelEnTity.class, params);
            List<ExcelEnTity> enTityList = result.getList();
            enTityList.forEach(item -> {
                entityService.save(item);
            });
        }catch (Exception e){
            e.printStackTrace();
        }

        return "导入成功";
    }
}
