package rio203.project.service;


import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import rio203.project.entities.Engine;

public interface EngineService {
    Engine getEngine(ObjectId id) throws NotFoundException ;
    Engine saveEngine(Engine engine);
    void deleteEngine(ObjectId id);
    Engine updateEngine(ObjectId id,float temp, float rpm,float current) throws NotFoundException;
    List<Engine> getAllEngines();
}
