package uz.pdp.databasemigration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private Integer id;
  private String name;

  private Integer age;

}