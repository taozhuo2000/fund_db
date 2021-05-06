package com.software_project.service;

import com.software_project.dao.RecordDAO;
import com.software_project.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService{
    @Autowired
    RecordDAO recordDAO;

    @Override
    public List<Record> getRecords(String userEmail, String fundCode) {
        return recordDAO.getRecords(userEmail, fundCode);
    }
}
