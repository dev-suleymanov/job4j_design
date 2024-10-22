package ru.job4j.ood.ocp;

public class ReportGenerator {
    public void generateReport(String reportType) {
        if (reportType.equals("PDF")) {
            System.out.println("Логика генерации PDF-отчета");
        } else if (reportType.equals("CSV")) {
            System.out.println("Логика генерации CSV-отчета");
        } else {
            throw new IllegalArgumentException("Unknown report type: " + reportType);
        }
    }
}
