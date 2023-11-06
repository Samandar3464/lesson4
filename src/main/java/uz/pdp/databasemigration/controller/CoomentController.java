package uz.pdp.databasemigration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.databasemigration.entity.Comment;
import uz.pdp.databasemigration.model.CommentDto;
import uz.pdp.databasemigration.service.CommentService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comment")
public class CoomentController {

    private final CommentService commentService;

    @PostMapping
    public Comment create(CommentDto dto) {
        return commentService.create(dto);
    }

}
