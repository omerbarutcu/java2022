package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) throws Exception {
        if (programmingLanguage.getName() != null) {
            for (ProgrammingLanguage language : programmingLanguageRepository.getAll()) {
                if (language.getName().equalsIgnoreCase(programmingLanguage.getName())) {
                    throw new Exception(programmingLanguage.getName() + ": isimde bir dil mevcuttur. Lütfen başka bir isim giriniz.");
                }
            }
            programmingLanguageRepository.add(programmingLanguage);
        } else {
            throw new Exception("Programlama dili boş olamaz.");
        }
    }

    @Override
    public void delete(int id) {
        programmingLanguageRepository.delete(id);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        programmingLanguageRepository.update(programmingLanguage);
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return programmingLanguageRepository.getById(id);
    }

}
