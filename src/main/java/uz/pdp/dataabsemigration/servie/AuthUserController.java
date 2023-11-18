package uz.pdp.dataabsemigration.servie;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authuser")
@RequiredArgsConstructor
public class AuthUserController {
  
  private final AuthUserService authUserService;


  @PostMapping
  public ResponseEntity<String> create(@Valid @RequestBody Password dto) {
      authUserService.create(dto);
      return new ResponseEntity<>("Created", HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<String> update(@Valid @RequestBody AuthUserUpdateDTO dto) {
      authUserService.update(dto);
      return new ResponseEntity<>("Updated", HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Integer id) {
      authUserService.delete(id);
      return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Password> get(@PathVariable Integer id) {
      return new ResponseEntity<>(authUserService.get(id), HttpStatus.OK);
  }

}