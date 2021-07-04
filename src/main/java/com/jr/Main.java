package com.jr;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws JRException {
        String blankReport = "src/main/resources/js_1.jrxml";
//        String blankReport = "src/main/resources/Blank_Letter_1.jrxml";
        Collection<Dto> dtoCollection = Gett.getEnt();
        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(dtoCollection);

        JasperReport report = JasperCompileManager.compileReport(blankReport);
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, null, source);
//        getPDF(jasperPrint, "reportSource");

        getHtml(jasperPrint);
    }

    private static void getHtml(JasperPrint jasperPrint) throws JRException {
        HtmlExporter exporter = new HtmlExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
// Set input ...
        exporter.setExporterOutput(
                new SimpleHtmlExporterOutput("employeeReport.html"));

        exporter.exportReport();
    }

    private static JRPdfExporter getPDF(JasperPrint jasperPrint, String namePdf) throws JRException {
        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(
                new SimpleOutputStreamExporterOutput(String.format("%s.pdf", namePdf)));

        SimplePdfReportConfiguration reportConfig
                = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig
                = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataAuthor("baeldung");
        exportConfig.setEncrypted(true);
        exportConfig.setAllowedPermissionsHint("PRINTING");

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();

        return exporter;
    }
}