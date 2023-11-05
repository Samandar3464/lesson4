package uz.pdp.dataabsemigration.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component
public class V1__Create_post_table extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        Connection connection = context.getConnection();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(connection);
        var query = "create table if not exist Post(id serial  primary key ,title varchar , description varchar , author varchar)";
        jdbcTemplate.update(query);

    }
}
