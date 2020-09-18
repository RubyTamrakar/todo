package com.todo.todo.Controllers;
import com.todo.todo.Models.ToDoDAO;
import com.todo.todo.Models.ToDoDTO;
import com.todo.todo.Repository.ToDoRepository;
import com.todo.todo.Services.ToDoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ToDoController {
    private ToDoRepository repository;

    @Autowired
    public ToDoController(ToDoRepository repository){
        this.repository = repository;
    }

    @Autowired
    ToDoService toDoService;

    @PostMapping("/todo")
    public ResponseEntity<?> addTodo(@RequestBody ToDoDTO toDoDTO) {
        toDoService.saveToDo(toDoDTO);
        return ResponseEntity.ok(toDoDTO);
    }

    @GetMapping("/todo")
    public ResponseEntity<?> getToDos(@RequestParam(value = "email") String email){
        return ResponseEntity.ok(toDoService.getToDOs(email));
    }

    @PatchMapping("/todo/{id}")
    public ResponseEntity<?> setCompleted(@PathVariable ObjectId id) {
        ToDoDAO toDoDAO = toDoService.markAsCompleted(id);
        toDoDAO.setCompleted(true);
        return ResponseEntity.ok("Updated");

    }

    @DeleteMapping("/todo")
    public ResponseEntity<?> deleteToDo(@PathVariable ObjectId id){
        toDoService.deleteToDO(id);
        return ResponseEntity.ok(toDoService);
    }


}
