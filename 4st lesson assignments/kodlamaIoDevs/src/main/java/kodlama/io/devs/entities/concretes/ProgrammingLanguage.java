package kodlama.io.devs.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "programming_language")
@Setter
@Getter
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<ProgrammingLanguageSubTechnology> subTechnologies;
}
