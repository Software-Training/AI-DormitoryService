package com.example.mapper;

import com.example.bean.Record;
import com.example.bean.RecordView;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface RecordMapper {
    //新增记录record
    @Insert({"insert into record(inTime,outTime,date,userId) values(#{inTime},#{outTime},#{date},#{userId})"})
    void AddRecord(Record recordInfo);
    //删除记录record
    @Delete("delete from record where recordId=#{recordId}")
    void delRecordByRecordId(@Param("recordId") long recordId);

    //查询所有进出记录视图表详细信息
    @Select("select * from recordview")
    List<RecordView> getRecordView();

    //更新
    @Update("update record set outTime=#{outTime} where date = #{date} and userId=#{userId}")
    void updateOutTimeByDateAndUserId( @Param("outTime") String outTime,@Param("date") String date,@Param("userId") long userId);

    //查询对应学号学生的进出记录信息
    @Select("select * from recordview where numberId=#{numberId}")
    List<RecordView> getRecordViewByNumberId(@Param("numberId") String numberId);

    //查询某一天的该学生进出记录信息
    @Select("select * from recordview where numberId=#{numberId} and date=#{date}")
    List<RecordView> getRecordViewByNumberIdAndDate(@Param("numberId") String numberId,@Param("date") Date date);
}

