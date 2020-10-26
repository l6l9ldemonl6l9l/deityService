package distributedsystems.deityService.services.IService;

import distributedsystems.deityService.services.models.Deity;
import javassist.NotFoundException;
import java.util.List;
import java.util.UUID;

public interface DeityIService{
    List<Deity> findAll();

    Deity save(Deity deityForSave);

    Deity getById(UUID id) throws NotFoundException;

    void deleteById(UUID id) throws NotFoundException;
}
