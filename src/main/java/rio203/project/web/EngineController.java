package rio203.project.web;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import rio203.project.entities.Engine;
import rio203.project.service.EngineService;

@AllArgsConstructor
@RestController
@RequestMapping("/rio203project")
@CrossOrigin(origins = "*") // Allow requests from any origin
public class EngineController {

    private EngineService engineService;

     @GetMapping("engine/{id}")
        public ResponseEntity<Engine> getEngine(@PathVariable ObjectId id){
            try {
                return new ResponseEntity<>(engineService.getEngine(id), HttpStatus.OK);
            } catch (NotFoundException e) { 
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

    @PostMapping("engine/save")
    public ResponseEntity<String> saveEngine(@RequestBody Engine engine){
        engineService.saveEngine(engine);
        return new ResponseEntity<>(engine.getId(), HttpStatus.CREATED);
    }

    @PutMapping("engine/{id}")
    public ResponseEntity<Engine> updateEngine( @RequestBody Engine engine, @PathVariable ObjectId id) {
        try {
            return new ResponseEntity<>(engineService.updateEngine(id, engine.getTemperature(), engine.getRpm(), engine.getHumidity()), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("engine/{id}")
    public ResponseEntity<HttpStatus> deleteEngine(@PathVariable ObjectId id) {
        engineService.deleteEngine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);    
    }

    @GetMapping("engine/all")
    public ResponseEntity<List<Engine>> getEngines() {
        return new ResponseEntity<>(engineService.getAllEngines(), HttpStatus.OK);
    }


    
}
