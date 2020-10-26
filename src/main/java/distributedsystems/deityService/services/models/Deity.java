package distributedsystems.deityService.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deity {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    private String name;
    private Date age;

    public Deity(String name, Date age) {
        this.name = name;
        this.age = age;
        this.id = UUID.randomUUID();
    }

    public void showInformationAboutAuthor() {
        System.out.println("Автор:" + name + ". Дата рождения:" + age + ".\n");
    }

}
