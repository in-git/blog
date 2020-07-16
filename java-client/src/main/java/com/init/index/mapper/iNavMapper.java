package com.init.index.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.init.index.bean.Weblist;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface iNavMapper extends BaseMapper< Weblist > { }
