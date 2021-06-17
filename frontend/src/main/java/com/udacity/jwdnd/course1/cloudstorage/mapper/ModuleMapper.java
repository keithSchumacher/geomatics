package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.GeoModule;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ModuleMapper {
    @Select("SELECT * FROM modules")
    List<GeoModule> getModules();

    @Select("SELECT * FROM modules WHERE moduleId = #{moduleId}")
    GeoModule getModule(Integer moduleId);

    @Insert("INSERT INTO modules (moduleName, gitURL, userid) VALUES(#{moduleName}, #{gitURL}, " +
            "#{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "moduleId")
    Integer insert(GeoModule module);

}