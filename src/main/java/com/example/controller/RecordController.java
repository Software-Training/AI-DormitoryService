package com.example.controller;

import com.example.bean.Record;
import com.example.bean.RecordView;
import com.example.bean.User;
import com.example.service.AdminService;
import com.example.service.RecordService;
import com.example.util.ResultUtil;
import com.sun.org.apache.xpath.internal.objects.XObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

//业务层
@CrossOrigin
@Controller
@RequestMapping("/records")
public class RecordController {
    @Autowired
    private RecordService recordService;
    /**
     * 个人查询
     */
    @RequestMapping(value = "/{numberId}")
    @ResponseBody
    public Object searchByNumberId(User user){
        List<RecordView> list= recordService.searchByNumberId(user.getNumberId());
        return ResultUtil.success(list);
    }
    /**
     * 管理员全部查询
     */
    @RequestMapping(value = "/search")
    @ResponseBody
    public Object search(){
        List<RecordView> list= recordService.getRecordView();
        return ResultUtil.success(list);
    }
    /**
     * 时间查询
     */
    @RequestMapping(value = "/searchByDate/{date}")
    @ResponseBody
    public Object searchByDate(@PathVariable("date") String date){
        List<RecordView> list= recordService.searchByDate(date);
        return ResultUtil.success(list);
    }
    /**
     * 时间查询
     */
    @RequestMapping(value = "/searchByNumberIdAndDate")
    @ResponseBody
    public  Object searchByNumberIdAndDate(String numberId, String date){
        List<RecordView> list=recordService.searchByNumberIdAndDate(numberId,date);
        return ResultUtil.success(list);
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
