package com.jyhmw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyhmw.entity.ResearchAchievement;
import com.jyhmw.mapper.AchievementMapper;
import com.jyhmw.service.AchievementService;
import org.springframework.stereotype.Service;

@Service
public class AchievementServiceImpl extends ServiceImpl<AchievementMapper, ResearchAchievement> implements AchievementService {
}
