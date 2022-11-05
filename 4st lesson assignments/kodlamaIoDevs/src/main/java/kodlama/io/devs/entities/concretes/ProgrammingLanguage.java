package kodlama.io.devs.entities.concretes;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "programming_language")
@Setter
@Getter
public class ProgrammingLanguage  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;

}
