package com.winston.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @ClassName IFileService
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/11/27 10:45
 * @Version：
 */
public interface IFileService {

    Map<String, String> upload(MultipartFile file);

    MultipartFile transport(String path);

}
