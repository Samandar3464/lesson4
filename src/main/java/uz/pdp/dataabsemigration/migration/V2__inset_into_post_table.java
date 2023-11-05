package uz.pdp.dataabsemigration.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component
public class V2__inset_into_post_table extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        Connection connection = context.getConnection();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(connection);
        var query = "insert into Post(title , description , author) values (?,?,?)";
        jdbcTemplate.update(query , "Java" , "About java " , " MY_book");

    }
}
