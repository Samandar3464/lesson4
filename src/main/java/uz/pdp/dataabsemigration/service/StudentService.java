package uz.pdp.dataabsemigration.service;

import org.springframework.stereotype.Service;
import uz.pdp.dataabsemigration.dto.StudentDto;
import uz.pdp.dataabsemigration.entity.Student;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class StudentService {

    private ConcurrentHashMap<Integer, Student> mapCash = new ConcurrentHashMap<>();
    public Student createStudent(StudentDto dto) {
        return null;
    }

    public Student getWithMap(Integer id) {
    }

    public Student getWithJavaChashir(Integer id) {
    }

    public Student getWithRedis(Integer id) {
    }

    private void saveToMapCash(Student student){
        mapCash.put(student.getId() ,student);
    }

    private Student getFromMapCash(Integer id){
        return  mapCash.get(id);
    }
}
