package com.lyb.gmall.user.mapper;

import com.lyb.gmall.bean.UmsMember;
import com.lyb.gmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UmsMember> {

    List<UmsMember> selectAllUser();

}