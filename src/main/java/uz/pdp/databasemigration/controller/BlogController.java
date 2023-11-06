package uz.pdp.databasemigration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.databasemigration.entity.Blog;
import uz.pdp.databasemigration.model.BlogDto;
import uz.pdp.databasemigration.service.BlogService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/post")
public class BlogController {

    private final BlogService postService;

    @PostMapping
    public Blog create(BlogDto dto) {
        return postService.create(dto);
    }

    @GetMapping("/{id}")
    public Blog getById(@PathVariable Integer id) {
        return postService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
         postService.delete(id);
    }
}
