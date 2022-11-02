package kodlama.io.devs.dataAccess.abstracts;


import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {

    void add(ProgrammingLanguage programmingLanguage);

    void delete(int id);

    void update(ProgrammingLanguage programmingLanguage);

    List<ProgrammingLanguage> getAll();

    ProgrammingLanguage getById(int id);

}
