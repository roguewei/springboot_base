package com.winston.service;

import com.winston.entity.ExcelEnTity;

import java.util.List;

public interface IExcelEntityService {

    List<ExcelEnTity> query();

    void save(ExcelEnTity enTity);

}
