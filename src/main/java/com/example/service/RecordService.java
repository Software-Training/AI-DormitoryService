package com.example.service;


import com.example.bean.Record;
import com.example.bean.RecordView;
import com.example.bean.Result;
import com.example.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

//实现层，增删查
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class RecordService {
    @Autowired
    private RecordMapper recordMapper;

    public void add(Record record) {
        recordMapper.AddRecord(record);
    }

    public void delete(long recordId) {
        recordMapper.delRecordByRecordId(recordId);
    }

    public List<RecordView> getRecordView() {
        return  recordMapper.getRecordView();
    }

    public List<RecordView> searchByNumberId(String numberId) {
        return recordMapper.getRecordViewByNumberId(numberId);
    }

    public List<RecordView> searchByNumberIdAndDate(String numberId, String date) {
        return recordMapper.getRecordViewByNumberIdAndDate(numberId,date);
    }
    public List<RecordView> searchByDate(String date) {
        return recordMapper.getRecordViewByDate(date);
    }
}
