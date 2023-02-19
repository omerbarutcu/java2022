package kodlama.io.devs.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "programminglanguages")
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "programmingLanguage", fetch = FetchType.EAGER)
    private List<ProgrammingLanguageSubTechnology> subTechnologies;
}
