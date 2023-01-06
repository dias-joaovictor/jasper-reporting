package com.dias.jasperreporting.reporting;

import java.util.Map;

public interface Report {

    Map<String, Object> getDataSource();

    String getReportTemplate();
}
