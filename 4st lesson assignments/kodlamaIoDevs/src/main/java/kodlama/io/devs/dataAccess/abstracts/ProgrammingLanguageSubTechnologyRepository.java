package kodlama.io.devs.dataAccess.abstracts;

import kodlama.io.devs.entities.concretes.ProgrammingLanguageSubTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageSubTechnologyRepository
        extends JpaRepository<ProgrammingLanguageSubTechnology, Integer> {
}
