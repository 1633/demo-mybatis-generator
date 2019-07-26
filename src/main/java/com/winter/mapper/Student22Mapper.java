package com.winter.mapper;

import com.winter.model.Student22;
import com.winter.model.Student22Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Student22Mapper {
    int countByExample(Student22Example example);

    int deleteByExample(Student22Example example);

    int deleteByPrimaryKey(Integer userId);

    int insert(Student22 record);

    int insertSelective(Student22 record);

    List<Student22> selectByExample(Student22Example example);

    Student22 selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") Student22 record, @Param("example") Student22Example example);

    int updateByExample(@Param("record") Student22 record, @Param("example") Student22Example example);

    int updateByPrimaryKeySelective(Student22 record);

    int updateByPrimaryKey(Student22 record);
}