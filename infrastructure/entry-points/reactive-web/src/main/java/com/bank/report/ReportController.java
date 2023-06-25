package com.bank.report;

import com.bank.report.enpointbody.ReportByDate;
import com.bank.report.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
    private final ReportService reportService;

    @GetMapping()
    public Flux<Report> getReports(@RequestParam("date") String date, @RequestBody ReportByDate reportByDate) {
        return reportService.getReportByDate(date, reportByDate);
    }
}
