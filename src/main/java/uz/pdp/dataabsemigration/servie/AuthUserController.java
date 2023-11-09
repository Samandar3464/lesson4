package uz.pdp.dataabsemigration.servie;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authuser")
public class AuthUserController {
  
  private final AuthUserService authUserService;

  public AuthUserController(AuthUserService service) {
      this.authUserService = service;
  }

  @PostMapping
  public ResponseEntity<String> create(@Valid @RequestBody AuthUserCreateDTO dto) {
      authUserService.create(dto);
      return new ResponseEntity<>("Successfully Created - User", HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<String> update(@Valid @RequestBody AuthUserUpdateDTO dto) {
      authUserService.update(dto);
      return new ResponseEntity<>("Successfully Updated - User", HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable String id) {
      authUserService.delete(id);
      return new ResponseEntity<>("Successfully Deleted - User", HttpStatus.NO_CONTENT);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AuthUserGetDTO> get(@PathVariable String id) {
      return new ResponseEntity<>(authUserService.get(id), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<AuthUserGetDTO>> list(@Valid AuthUserCriteria criteria) {
      return new ResponseEntity<>(authUserService.list(criteria), HttpStatus.OK);
  }

}