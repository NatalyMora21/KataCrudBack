package com.ejercicio.cataCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class TodoController {
    //Servicio : gestionar el acceso al dato

    //Inyectar el repositorio
    @Autowired
    private TodoService service;

    @GetMapping(value="api/todo")
    public Iterable<Todo> list () {
        return service.list();
    }

    @PostMapping(value="api/todo")
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }

    @PutMapping(value="api/todo")
    public Todo update(@RequestBody Todo todo) throws Exception {
        if (todo.getId()!= null){
            return  service.save(todo);
        }
        throw new Exception("No exixste el id para actualizar");

    }

    @DeleteMapping(value="api/{id]/todo")
    public void delete( @PathParam("id") Long id){
        service.delete(id);
    }

    @GetMapping(value="api/{id}/todo")
    public Todo get(@PathParam("id") Long id){
        return service.get(id);
    }
}
