package com.example.controller;

import com.example.bean.Record;
import com.example.bean.RecordView;
import com.example.bean.Result;
import com.example.bean.User;
import com.example.service.AdminService;
import com.example.service.RecordService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

//业务层
@CrossOrigin
@Controller
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;
    /**
     * 个人查询
     */
    @RequestMapping(value = "/searchByNumberId")
    @ResponseBody
    public List<RecordView> searchByNumberId(User user){
        return recordService.searchByNumberId(user.getNumberId());
    }
    /**
     * 管理员全部查询
     */
    @RequestMapping(value = "/search")
    @ResponseBody
    public List<RecordView> search(){
        return recordService.getRecordView();
    }

    /**
     * 时间查询
     */
    @RequestMapping(value = "/searchByNumberIdAndDate")
    @ResponseBody
    public List<RecordView> searchByNumberIdAndDate(String numberId, Date date){
        return recordService.searchByNumberIdAndDate(numberId,date);
    }

    /**
     * 增加
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public void add(Record record){
         recordService.add(record);
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public void delete(long recordId){
        recordService.delete(recordId);
    }
}
