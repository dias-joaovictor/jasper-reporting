package com.dias.jasperreporting.reporting;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class Printer {

    private final ApplicationContext context;

    public JasperPrint getReport(Report report) {
        Resource resource = context.getResource("classpath:jasperreports/%s.jrxml".formatted(report.getReportTemplate()));

        try {
            //Compile to jasperReport
            InputStream inputStream = resource.getInputStream();
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            JRMapArrayDataSource dataSource = new JRMapArrayDataSource(new Object[]{report.getDataSource()});
            JasperPrint print = JasperFillManager.fillReport(jasperReport, null, dataSource);

            return print;
        } catch (Exception exception){
            throw new RuntimeException(exception);
        }
    }
}
