package uz.pdp.dataabsemigration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;


    public Todo createTodo(Todo todo) {
       return todoRepository.save(todo);
    }

    public boolean deleteTodo(Integer id) {
        todoRepository.deleteById(id);
        return true;
    }

    public Todo updateTodo(Todo todo) {
        Todo todo1 = todoRepository.findById(todo.getId()).get();
        todo1.setTitle(todo.getTitle());
        todo1.setDescription(todo.getDescription());
        return todoRepository.save(todo1);
    }

    public List<Todo> getTodosByLevel(String level) {
        return todoRepository.findAllByLevel(Level.valueOf(level));
    }

    public List<Todo> getTodosByCategory(String category) {
        return todoRepository.findAllByCategory(Category.valueOf(category));

    }

}
