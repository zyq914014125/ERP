package com.hqyj.Dao;

import com.hqyj.entity.Grade;
import com.hqyj.entity.Single;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SingleDao {
    @Select("SELECT * FROM Single ORDER BY RAND() LIMIT 10;")
    List<Single> queryTest();
}
