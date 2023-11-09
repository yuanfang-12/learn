package com.bocsoft.mapper;

import com.bocsoft.entity.FuncEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface FuncMapper {

    FuncEntity selectByName(FuncEntity funcEntity);
}
