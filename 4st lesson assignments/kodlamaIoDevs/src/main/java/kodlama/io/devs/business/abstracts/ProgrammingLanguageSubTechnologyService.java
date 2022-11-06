package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.entities.concretes.ProgrammingLanguageSubTechnology;

import java.util.List;

public interface ProgrammingLanguageSubTechnologyService {

    void add(ProgrammingLanguageSubTechnology languageSubTechnology, int id) throws Exception;
    void delete(int id);
    void update(ProgrammingLanguageSubTechnology languageSubTechnology)throws Exception;
    List<ProgrammingLanguageSubTechnology> getAll();
    ProgrammingLanguageSubTechnology findById(int id);
}
