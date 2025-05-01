package scb.reporter2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import scb.reporter2.model.ReportHeader;

import java.util.List;

public interface ReportRepository extends JpaRepository<ReportHeader, Integer> {
    @NativeQuery ("select id, name, description from reports where group_id = ?1")
    List<ReportHeader> findByGroupId(int groupId);

}
