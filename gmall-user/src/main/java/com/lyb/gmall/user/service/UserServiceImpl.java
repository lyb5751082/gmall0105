package com.lyb.gmall.user.service;

import com.lyb.gmall.service.UserService;//api的userservice
import com.lyb.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.lyb.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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
