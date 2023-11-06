package uz.pdp.databasemigration.even;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import uz.pdp.databasemigration.entity.Blog;
import uz.pdp.databasemigration.entity.User;

@Data
@RequiredArgsConstructor
public class DeleteBlogEvent {
    private final Blog blog;

}
