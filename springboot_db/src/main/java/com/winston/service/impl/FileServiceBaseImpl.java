package com.winston.service.impl;

import com.winston.service.IFileService;
import com.winston.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * @ClassName FileServiceImpl
 * @Author: Winston
 * @Description: TODO
 * @Date:Create：in 2019/11/27 10:46
 * @Version：
 */
@Service("fileServiceBase")
public class FileServiceBaseImpl implements IFileService {

    @Autowired
    private FileUtil fileUtil;

    @Override
    public Map<String, String> upload(MultipartFile file) {
        try {
            return fileUtil.excuteUpload(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MultipartFile transport(String path) {
        return fileUtil.transport(path);
    }
}
