package uz.pdp.dataabsemigration.servie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserUpdateDTO {
    private Integer id;
    private String password;
    private String oldPassword;
}
