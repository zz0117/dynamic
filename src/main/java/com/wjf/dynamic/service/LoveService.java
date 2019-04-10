package com.wjf.dynamic.service;

import com.wjf.dynamic.model.Love;

public interface LoveService {
    int insertLove(Love love);

    Love getLoveByOpenId(String openId);

    int updateLoveByOpenId(Love love);
}
