package uz.pdp.dataabsemigration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dataabsemigration.dto.StudentDto;
import uz.pdp.dataabsemigration.entity.Student;
import uz.pdp.dataabsemigration.service.StudentService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody StudentDto dto){
        return studentService.createStudent(dto);
    }

    @GetMapping("/getWithMap/{id}")
    public Student getWithMap(@PathVariable Integer id){
        return studentService.getWithMap(id);
    }

    @GetMapping("/getWithJavaChashir/{id}")
    public Student getWithJavaChashir(@PathVariable Integer id){
        return studentService.getWithJavaCasher(id);
    }

    @GetMapping("/getWithRedis/{id}")
    public Student getWithRedis(@PathVariable Integer id){
        return studentService.getWithRedis(id);
    }
}
