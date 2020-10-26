package distributedsystems.deityService.api.restControllers;

import distributedsystems.deityService.api.payload.DeityPayload;
import distributedsystems.deityService.services.models.Deity;
import distributedsystems.deityService.services.IService.DeityIService;
import distributedsystems.deityService.DeityApplication;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/deity")
@RequiredArgsConstructor
public final class DeityController {
    static final Logger log = LoggerFactory.getLogger(DeityApplication.class);

    @Autowired
    private DeityIService DeityService;

    @GetMapping
    public ResponseEntity<List<Deity>> index() {
        return ResponseEntity.ok(DeityService.findAll());
    }

    @PostMapping
    public ResponseEntity<Deity> create(@RequestBody DeityPayload payload) {
        Deity newDeity = new Deity(payload.getName(),
                payload.getAge());
        return ResponseEntity.ok(DeityService.save(newDeity));
    }

    @GetMapping("{DeityId}")
    public ResponseEntity<Deity> show(@PathVariable UUID DeityId) throws NotFoundException {
        return ResponseEntity.ok(DeityService.getById(DeityId));
    }

    @DeleteMapping("{DeityId}")
    public ResponseEntity<Void> delete(@PathVariable UUID DeityId) throws NotFoundException {
        DeityService.deleteById(DeityId);
        return ResponseEntity.noContent().build();
    }
}