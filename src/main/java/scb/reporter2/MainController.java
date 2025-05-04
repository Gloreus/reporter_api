package scb.reporter2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import scb.reporter2.model.ReportHeader;
import scb.reporter2.services.ReportExecService;
import scb.reporter2.services.ReportHeadersService;


import java.sql.SQLException;
import java.util.List;

@RestController
class MainController {


    private final ReportHeadersService reportService;
    private final ReportExecService reportExecService;

    public MainController(ReportHeadersService reportsService, ReportExecService reportExecService) {
        this.reportService = reportsService;
        this.reportExecService = reportExecService;
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
    @GetMapping("/exec")
    public String ExecuteReport() {
        try {
            reportExecService.Exec("select 1 as n; select 2 as id;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Ok";

    }
}
