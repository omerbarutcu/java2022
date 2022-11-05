package kodlama.io.devs.dataAccess.abstracts;


import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageRepository  extends JpaRepository<ProgrammingLanguage,Integer> {

}
