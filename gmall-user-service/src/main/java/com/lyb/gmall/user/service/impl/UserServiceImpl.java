package com.lyb.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lyb.gmall.bean.UmsMember;
import com.lyb.gmall.bean.UmsMemberReceiveAddress;
import com.lyb.gmall.service.UserService;
import com.lyb.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.lyb.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Example;

import java.util.List;
/*
 这个service是dubbo的注解 能够提供dubbo协议
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> user=userMapper.selectAll();
        return user;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        Example example=new Example(UmsMemberReceiveAddress.class);
        example.createCriteria().andEqualTo("memberId",memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses= umsMemberReceiveAddressMapper.selectByExample(example);
        return umsMemberReceiveAddresses;
    }
}
