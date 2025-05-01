package scb.reporter2.services;

import org.springframework.stereotype.Service;
import scb.reporter2.model.ReportHeader;
import scb.reporter2.repositories.ReportRepository;

import java.util.List;

@Service
class ReportServiceImpl implements ReportsService {

    private final ReportRepository reportRepository;

    ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<ReportHeader> getAllReportHeaders() {
        return reportRepository.findAll();

    }

    @Override
    public List<ReportHeader> getReportsByGroup(int groupId) {
        return reportRepository.findByGroupId(groupId);
    }
}
