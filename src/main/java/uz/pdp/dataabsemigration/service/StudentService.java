package uz.pdp.dataabsemigration.service;

import lombok.SneakyThrows;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import uz.pdp.dataabsemigration.dto.StudentDto;
import uz.pdp.dataabsemigration.entity.Student;
import uz.pdp.dataabsemigration.mapper.StudentMapper;
import uz.pdp.dataabsemigration.repository.StudentRepository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CacheManager cacheManager;
    private final Cache cache;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository,
                          CacheManager cacheManager,
                          Cache cache,
                          StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.cacheManager = cacheManager;
        this.cache = cacheManager.getCache("student");
        this.studentMapper = studentMapper;
    }

    private ConcurrentHashMap<Integer, Student> mapCash = new ConcurrentHashMap<>();

    public Student createStudent(StudentDto dto) {
        Student entity = studentMapper.toEntity(dto);
        return studentRepository.save(entity);
    }

    @SneakyThrows
    public Student getWithMap(Integer id) {
        Student fromMapCash = getFromMapCash(id);
        if (fromMapCash != null) {
            return fromMapCash;
        } else {
            Student student = studentRepository.findById(id).orElseThrow();
            saveToMapCash(student);
            TimeUnit.SECONDS.sleep(2);
            return student;
        }
    }
    @SneakyThrows
    public Student getWithJavaCasher(Integer id) {
        Student fromCash = cache.get(id, Student.class);
        if (fromCash != null) {
            return fromCash;
        } else {
            Student student = studentRepository.findById(id).orElseThrow();
            cache.put(student.getId(),student);
            TimeUnit.SECONDS.sleep(2);
            return student;
        }
    }
    @SneakyThrows
    public Student getWithRedis(Integer id) {
        if (fromCash != null) {
            return fromCash;
        } else {
            Student student = studentRepository.findById(id).orElseThrow();
            saveToMapCash(student);
            TimeUnit.SECONDS.sleep(2);
            return student;
        }
    }

    private void saveToMapCash(Student student) {
        mapCash.put(student.getId(), student);
    }

    private Student getFromMapCash(Integer id) {
        return mapCash.get(id);
    }
}
