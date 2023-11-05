package uz.pdp.dataabsemigration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Job {
  private String title;
  private Long minSalary;
  private Long maxSalary;
}