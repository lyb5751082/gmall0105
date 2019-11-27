package com.lyb.gmall.service;

import com.lyb.gmall.bean.UmsMember;
import com.lyb.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();


    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
