package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Result;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ResultMapper {
    @Select("SELECT * FROM results")
    List<Result> getResults();

    @Select("SELECT * FROM results WHERE resultId = #{resultId}")
    Result getModuleOutput(Integer resultId);


//    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) VALUES(#{filename}, " +
//            "#{contenttype}, #{filesize}, #{userid}, #{fileData})")
//    @Options(useGeneratedKeys = true, keyProperty = "fileId")
//    Integer insert(File file);
//
//    @Delete("DELETE FROM FILES WHERE fileId =#{fileId}")
//    void deleteFile(Integer fileId);
}
