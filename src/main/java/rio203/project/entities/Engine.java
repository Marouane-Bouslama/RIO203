package rio203.project.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Document( collection = "engines")
public class Engine {
    
    @Id
    @Field("_id")
    private ObjectId id;

    private float temperature;
    private float rpm;
    private float humidity;

    public String getId() {
        return id != null ? id.toHexString() : null;
    }
}
