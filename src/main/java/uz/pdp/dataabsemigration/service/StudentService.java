package uz.pdp.dataabsemigration.service;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import uz.pdp.dataabsemigration.dto.StudentDto;
import uz.pdp.dataabsemigration.entity.Student;
import uz.pdp.dataabsemigration.repository.PostRepository;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class StudentService {
    private final PostRepository postRepository;
    private final CacheManager cacheManager;
    private final Cache cache;

    public StudentService(PostRepository postRepository, CacheManager cacheManager, Cache cache) {
        this.postRepository = postRepository;
        this.cacheManager = cacheManager;
        this.cache = cacheManager.getCache("student");
    }

    private ConcurrentHashMap<Integer, Student> mapCash = new ConcurrentHashMap<>();

    public Student createStudent(StudentDto dto) {

    }

    public Student getWithMap(Integer id) {
    }
    public Student getWithJavaCasher(Integer id) {
    }

    public Student getWithRedis(Integer id) {
    }

    private void saveToMapCash(Student student) {
        mapCash.put(student.getId(), student);
    }

    private Student getFromMapCash(Integer id) {
        return mapCash.get(id);
    }
}
