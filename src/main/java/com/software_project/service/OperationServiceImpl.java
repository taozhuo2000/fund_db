package com.software_project.service;

import com.software_project.dao.OperationDAO;
import com.software_project.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService{

    @Autowired
    OperationDAO operationDAO;

    @Override
    public void insertDeal(Record record) {
        operationDAO.insertDeal(record);
    }

    @Override
    public List<Record> getAllUndoRecord() {
        return operationDAO.getAllUndoRecord();
    }

}