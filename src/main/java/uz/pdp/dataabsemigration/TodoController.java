package uz.pdp.dataabsemigration;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/graphql")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @MutationMapping
    public Todo createTodo(@Argument Todo todo){
       return todoService.createTodo(todo);
    }
    @MutationMapping
    public Todo updateTodo(@Argument Todo todo){
       return todoService.updateTodo(todo);
    }
    @QueryMapping
    public List<Todo> getTodosByLevel(@Argument String level){
     return   todoService.getTodosByLevel(level);
    }
    @MutationMapping
    public boolean deleteTodo(@Argument Integer id){
       return todoService.deleteTodo(id);
    }
    @QueryMapping
    public List<Todo> getTodosByCategory(@Argument String category){
      return  todoService.getTodosByCategory(category);
    }

}
