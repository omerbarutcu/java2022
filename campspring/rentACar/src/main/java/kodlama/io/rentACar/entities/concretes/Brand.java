package kodlama.io.rentACar.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brand {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;
}
