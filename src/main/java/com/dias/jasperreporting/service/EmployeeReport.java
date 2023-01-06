package com.dias.jasperreporting.service;

import com.dias.jasperreporting.model.Employee;
import com.dias.jasperreporting.reporting.Report;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
@Builder
public class EmployeeReport implements Report {

    private static final String REPORT_TEMPLATE = "sample/Employee";
    private final List<Employee> employees;

    @Override
    public Map<String, Object> getDataSource() {
        Map<String, Object> datasource = new HashMap<>();
        datasource.put("employeeDataSource", new JRBeanCollectionDataSource(employees, false));
        return datasource;
    }

    @Override
    public String getReportTemplate(){
        return REPORT_TEMPLATE;
    }

}
