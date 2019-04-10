package com.wjf.dynamic.service.Impl;

import com.wjf.dynamic.mapper.LoveMapper;
import com.wjf.dynamic.model.Love;
import com.wjf.dynamic.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoveServiceImpl implements LoveService {
    @Autowired
    private LoveMapper loveMapper;

    @Override
    public int insertLove(Love love) {
        loveMapper.insertLove(love);
        return love.getId();
    }

    @Override
    public Love getLoveByOpenId(String openId) {
        return loveMapper.getLoveByOpenId(openId);
    }

    @Override
    public int updateLoveByOpenId(Love love) {
        return loveMapper.updateLoveByOpenId(love);
    }
}
