package com.jr;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.jasperreports.engine.JasperReport;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class Dto {
    private String telNum;
    private String someString;
    public Date date;

    public Dto(String telNum, String someString, Date testDto) {
        this.telNum = telNum;
        this.someString = someString;
        this.date = testDto;
    }

    public Dto() {
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public Date getDate() {
        return date;
    }

    public Dto setDate(Date date) {
        this.date = date;
        return this;
    }
}
