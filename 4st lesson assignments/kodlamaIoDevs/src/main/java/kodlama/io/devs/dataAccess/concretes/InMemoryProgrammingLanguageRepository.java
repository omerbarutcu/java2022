package kodlama.io.devs.dataAccess.concretes;

import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

    List<ProgrammingLanguage> programmingLanguages;

    public InMemoryProgrammingLanguageRepository() {
        programmingLanguages = new ArrayList<ProgrammingLanguage>();
        programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
        programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
        programmingLanguages.add(new ProgrammingLanguage(3, "Python"));
        programmingLanguages.add(new ProgrammingLanguage(4, "Go"));
        programmingLanguages.add(new ProgrammingLanguage(5, "Kotlin"));
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        programmingLanguages.add(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        ProgrammingLanguage programmingLanguage = getById(id);
        programmingLanguages.remove(programmingLanguage);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        for (ProgrammingLanguage language : programmingLanguages) {
            if (language.getId() == programmingLanguage.getId()) {
                language.setName(programmingLanguage.getName());
            }
        }
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        for (ProgrammingLanguage language : programmingLanguages) {
            if (language.getId() == id) {
                return language;
            }
        }
        return null;
    }
}
