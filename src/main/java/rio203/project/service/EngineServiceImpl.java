package rio203.project.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;
import rio203.project.entities.Engine;
import rio203.project.repositories.EngineRepository;

@AllArgsConstructor
@Service
public class EngineServiceImpl implements EngineService {

    private EngineRepository engineRepository;
    

    @Override
    public Engine saveEngine(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public void deleteEngine(ObjectId id) {
       engineRepository.deleteById(id);    
    }

    @Override
    public Engine getEngine(ObjectId id) throws NotFoundException  {
        Optional<Engine> engine = engineRepository.findById(id); 
        if (engine.isPresent()){ 
            return engine.get(); 
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public Engine updateEngine(ObjectId id, float temp, float rpm, float humidity) throws NotFoundException {
        Optional<Engine> oldEngine = engineRepository.findById(id); 
        if(oldEngine.isPresent()){ 
            Engine engine= oldEngine.get();
            engine.setTemperature(temp);
            engine.setRpm(rpm);
            engine.setHumidity(humidity);
            return engineRepository.save(engine);
        }else {
            throw new NotFoundException();
        }
    }

    @Override
    public List<Engine> getAllEngines() {
        return (List<Engine>)engineRepository.findAll() ;
    }
    
}
