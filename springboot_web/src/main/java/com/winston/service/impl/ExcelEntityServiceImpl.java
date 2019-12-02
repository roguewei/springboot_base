package com.winston.service.impl;

import com.winston.entity.ExcelEnTity;
import com.winston.entity.ExcelEnTityExample;
import com.winston.mapper.ExcelEnTityMapper;
import com.winston.service.IExcelEntityService;
import com.winston.utils.TimeUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ExcelEntityServiceImpl
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/12/2 11:22
 * @Version：
 */
@Service
public class ExcelEntityServiceImpl implements IExcelEntityService {

    @Autowired
    private ExcelEnTityMapper mapper;

    @Override
    public List<ExcelEnTity> query() {
        return mapper.selectByExample(new ExcelEnTityExample());
    }

    @Override
    public void save(ExcelEnTity enTity) {
        Long formatMill = TimeUtile.getTimeFormatMill(enTity.getBirthday());
        enTity.setBirthday(String.valueOf(formatMill));
        mapper.insertSelective(enTity);
    }
}
