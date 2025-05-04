package scb.reporter2.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.*;

@Slf4j
@Service
public class ReportExecService {
    private final DataSource dataSource;

    ReportExecService( DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean Exec(String query) throws SQLException {
        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        boolean result = stmt.execute(query);
        int rsCount = 0;

        do {
            if (result) {
                ResultSet rs = stmt.getResultSet();
                rsCount++;

                // Show data from the result set.
                log.info("RESULT SET #{}", rsCount);
                while (rs.next()) {
                    log.info(rs.getString(1));
                }
            }

            result = stmt.getMoreResults();
        } while (result);
        return  rsCount > 0;
    }
}
