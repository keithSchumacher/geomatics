package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.ModuleOutput;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ModuleMapper {
    @Select("SELECT * FROM moduleOutput")
    List<ModuleOutput> getModuleOutputs();

    @Select("SELECT * FROM moduleOutput WHERE moduleId = #{moduleId}")
    ModuleOutput getModuleOutput(Integer moduleId);


//    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) VALUES(#{filename}, " +
//            "#{contenttype}, #{filesize}, #{userid}, #{fileData})")
//    @Options(useGeneratedKeys = true, keyProperty = "fileId")
//    Integer insert(File file);
//
//    @Delete("DELETE FROM FILES WHERE fileId =#{fileId}")
//    void deleteFile(Integer fileId);
}
