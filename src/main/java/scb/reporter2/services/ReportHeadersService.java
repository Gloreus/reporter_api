package scb.reporter2.services;

import scb.reporter2.model.ReportHeader;

import java.util.List;


public interface ReportHeadersService {
    List<ReportHeader> getAllReportHeaders();
    List<ReportHeader> getReportsByGroup(int groupId);
}
