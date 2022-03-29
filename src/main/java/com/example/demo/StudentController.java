package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.plaf.basic.BasicTreeUI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private  NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @PostMapping("/students")
    public  String insert(@RequestBody Student student){

        String sql ="INSERT INTO student(name) VALUE(:studentName)";
        Map<String ,Object> map = new HashMap<>();
        map.put("studentName",student.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);
        int id = keyHolder.getKey().intValue();

        System.out.println("my sql id: "+id);
        return  "執行 insert sql";
    }

    @PostMapping("/students/batch")
    public String insertList(@RequestBody List<Student> studentList){

        String sql = "insert into student(name) value(:studentName)";
        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[studentList.size()];
        for (int i=0; i< studentList.size();i++) {

            Student student = studentList.get(i);
            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("studentName",student.getName());
        }

        namedParameterJdbcTemplate.batchUpdate(sql,parameterSources);

        return "執行一批 Insert sql";

    }


    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId)
    {
        String sql = "delete from student where id=:studentId";
        Map<String, Object>map = new HashMap<>();
        map.put("studentId",studentId);
        namedParameterJdbcTemplate.update(sql,map);
        return "執行 delete";
    }
}
