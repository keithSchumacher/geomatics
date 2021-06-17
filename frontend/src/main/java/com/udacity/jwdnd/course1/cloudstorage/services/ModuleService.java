package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.ModuleMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.ResultMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.GeoModule;
import com.udacity.jwdnd.course1.cloudstorage.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ModuleService {
    @Autowired
    ModuleMapper moduleMapper;
    @Autowired
    UserMapper userMapper;

    public List<GeoModule> getModules() {
        return moduleMapper.getModules();
    }

    public GeoModule getModule(Integer moduleId) {
        return moduleMapper.getModule(moduleId);
    }

    public int createModule(String moduleName, String gitURL, Integer userid) {
        GeoModule module = new GeoModule();
        module.setModuleName(moduleName);
        module.setGitURL(gitURL);
        module.setUserid(userid);
        return moduleMapper.insert(module);
    }

//    public void deleteFile(Integer fileId) {fileMapper.deleteFile(fileId);}
}
