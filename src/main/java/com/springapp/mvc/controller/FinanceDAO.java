package com.springapp.mvc.controller;

import com.springapp.mvc.utils.HibernateUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class FinanceDAO {
    @Autowired
    public FinanceDAO(String filePath) {
        HibernateUtils.loadFromExcel(filePath);
    }
}
