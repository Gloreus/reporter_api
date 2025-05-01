package scb.reporter2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import scb.reporter2.model.ReportHeader;
import scb.reporter2.services.ReportsService;


import java.util.List;

@RestController
class MainController {


    private final ReportsService reportService;

    public MainController(ReportsService reportsService) {
        this.reportService = reportsService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ReportHeader>> readAll(){

        List<ReportHeader> headers = reportService.getAllReportHeaders();
        return ResponseEntity.ok(headers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ReportHeader>> readByGroup(@PathVariable(name = "id") int id) {

        List<ReportHeader> headers = reportService.getReportsByGroup(id);
        return ResponseEntity.ok(headers);
    }
}
