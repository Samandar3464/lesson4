package uz.pdp.databasemigration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto  {
    Integer id;
    String author;
    String message;
    private Integer blogId;
}