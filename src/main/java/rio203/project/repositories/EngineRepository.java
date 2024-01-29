package rio203.project.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import rio203.project.entities.Engine;

@Repository
public interface EngineRepository extends MongoRepository<Engine, ObjectId>{
    
}
