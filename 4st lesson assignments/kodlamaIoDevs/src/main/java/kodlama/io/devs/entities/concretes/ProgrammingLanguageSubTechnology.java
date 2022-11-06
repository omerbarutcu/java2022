package kodlama.io.devs.entities.concretes;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "programminglanguagesubtechnology")
@Setter
@Getter
public class ProgrammingLanguageSubTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    private ProgrammingLanguage programmingLanguage;

}
