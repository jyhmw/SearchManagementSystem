package com.jyhmw.controller;

import com.jyhmw.entity.ResearchAchievement;
import com.jyhmw.mapper.AchievementMapper;
import com.jyhmw.service.AchievementService;
import com.jyhmw.util.RestResponse;
import com.jyhmw.util.RestResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/achievement")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @GetMapping("getAll")
    public RestResponse<List> getAllAchievement() {
        List<ResearchAchievement> list = achievementService.list();
        return RestResponseUtils.success(list, "查询成功");
    }
}
