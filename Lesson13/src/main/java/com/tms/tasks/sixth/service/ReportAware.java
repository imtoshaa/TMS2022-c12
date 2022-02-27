package com.tms.tasks.sixth.service;

import com.tms.tasks.sixth.model.Employee;

import java.util.List;

public interface ReportAware {

    void generateReport(List<Employee> employees);
}
