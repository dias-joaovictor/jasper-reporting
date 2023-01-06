package com.dias.jasperreporting.controller;

import com.dias.jasperreporting.service.EmployeeReportService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
@Validated
@Slf4j
public class ReportController {

    private final EmployeeReportService employeeReportService;

    @GetMapping
    @ResponseBody
    public void getReport(HttpServletResponse response) throws IOException, JRException {
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        JasperExportManager.exportReportToPdfStream(employeeReportService.generateReport(), response.getOutputStream());
    }
}
