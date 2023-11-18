package uz.pdp.dataabsemigration.servie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthUserService {

    private final PasswordRep rep;

    public void create(Password dto) {
        rep.save(dto);
    }

    public void update(AuthUserUpdateDTO dto) {
        Password password = rep.findById(dto.getId()).get();
        if (dto.getOldPassword().equals(password.getPassword())){
            password.setPassword(dto.getPassword());
        }
        rep.save(password);
    }

    public void delete(Integer id) {
         if (!rep.findById(id).isEmpty()){
             rep.deleteById(id);
         }

    }

    public Password get(Integer id) {
        Password password = rep.findById(id).get();
        return password;
    }

}
