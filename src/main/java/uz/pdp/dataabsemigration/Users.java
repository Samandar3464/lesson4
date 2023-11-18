package uz.pdp.dataabsemigration;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Todo> todos;

    public Users(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
}