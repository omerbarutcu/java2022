package kodlama.io.devs.entities.concretes;

import lombok.*;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "programminglanguagesubtechnologies")
public class ProgrammingLanguageSubTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programminglanguage_id",nullable = false)
    private ProgrammingLanguage programmingLanguage;

}
