package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.ModuleMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.ModuleOutput;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ModuleOutputService {
    private final ModuleMapper moduleMapper;
    private final UserMapper userMapper;

    public ModuleOutputService(ModuleMapper moduleMapper, UserMapper userMapper) {
        this.moduleMapper = moduleMapper;
        this.userMapper = userMapper;
    }

//    public String isFileValid(MultipartFile webfile, String username) {
//        for (File file : fileMapper.getFiles(userMapper.getUser(username).getUserid())) {
//            if (webfile.isEmpty()) {return "No file was selected for upload.";}
//            else if (file.getFilename().equals(webfile.getOriginalFilename())) {return "Uploaded file name is in use.";}
//        }
//        return null;
//    }

//    public int createFile(MultipartFile fileData, Integer userid) {
//        File file = new File();
//        file.setFilename(fileData.getOriginalFilename());
//        file.setContenttype(fileData.getContentType());
//        try {
//            file.setFileData(fileData.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        file.setFilesize(fileData.getSize());
//        file.setUserid(userid);
//        return fileMapper.insert(file);
//    }

    public List<ModuleOutput> getModuleOutputs() {
        System.out.println(moduleMapper.getModuleOutputs());
        return moduleMapper.getModuleOutputs();
    }

    public ModuleOutput getModuleOutput(Integer moduleId) { return moduleMapper.getModuleOutput(moduleId); }

//    public void deleteFile(Integer fileId) {fileMapper.deleteFile(fileId);}
}
