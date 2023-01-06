package com.dias.jasperreporting.service;

import com.dias.jasperreporting.model.Employee;
import com.dias.jasperreporting.reporting.Printer;
import com.dias.jasperreporting.reporting.Report;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeReportService {

    private final Printer printer;

    public JasperPrint generateReport() {
        List<Employee> employees = generateData();
        Report roleReport = EmployeeReport.builder()
                .employees(employees)
                .build();
        return printer.getReport(roleReport);
    }

    private List<Employee> generateData() {
        List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder()
                .name("João Victor Dias")
                .role("Software Engineer / Bug Implementor")
                .techSkill("Java")
                .build());
        employees.add(Employee.builder()
                .name("Eugene")
                .role("Software Engineer / Tech Lead")
                .techSkill("Zsh, Java")
                .build());
        employees.add(Employee.builder()
                .name("Ahmet")
                .role("Software Engineer")
                .techSkill("Balloon JS")
                .build());
        employees.add(Employee.builder()
                .name("Lyubomir")
                .role("Software Engineer")
                .techSkill("PHP")
                .build());
        employees.add(Employee.builder()
                .name("Kristoffer")
                .role("Product Owner")
                .techSkill("Project Management / Business")
                .build());
        employees.add(Employee.builder()
                .name("Jelle")
                .role("Product Owner")
                .techSkill("Project Management / Business")
                .build());
        employees.add(Employee.builder()
                .name("Filipe")
                .role("Development Manager")
                .techSkill("Management")
                .build());
        return employees;
    }

}
