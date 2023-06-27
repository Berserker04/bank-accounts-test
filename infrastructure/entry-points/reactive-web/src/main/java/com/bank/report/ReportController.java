package com.bank.report;

import com.bank.http.ResponseHandler;
import com.bank.movement.MovementController;
import com.bank.report.enpointbody.ReportByDate;
import com.bank.report.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
    private final ReportMapper mapper;
    private final ReportService reportService;
    private static final Logger logger = LoggerFactory.getLogger(MovementController.class);

    @GetMapping()
    public ResponseEntity<?> getReports(@RequestParam("date") String date, @RequestBody ReportByDate reportByDate) {
        logger.info("Report: consulting the client's movements {}", reportByDate.getIdClient());
        try {
            SecurityContextHolder.getContext().getAuthentication();

            List<ReportData> result = reportService.getReportByDate(date, reportByDate)
                    .flatMap(movement -> mapper.toEntityData(movement))
                    .collect(Collectors.toList()).block();

            if(result.size() == 0) return ResponseHandler.success("Movements not found");
            return ResponseHandler.success("Success", result);
        }catch (Exception e){
            logger.info(e.getMessage());
            return ResponseHandler.error("Internal server error");
        }
    }
}
