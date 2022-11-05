package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.common.utility.ProgrammingLanguageControl;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;
    private List<ProgrammingLanguage> programmingLanguages;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.programmingLanguages = programmingLanguageRepository.findAll();
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) throws Exception {
        if (!ProgrammingLanguageControl.nameControl(programmingLanguage, programmingLanguages)) {
            throw new Exception("This Programming language is not valid !");
        }
        programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        programmingLanguageRepository.deleteById(id);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) throws Exception {
        if (!ProgrammingLanguageControl.nameControl(programmingLanguage, programmingLanguages)) {
            throw new Exception("This Programming language is not valid");
        }
        ProgrammingLanguage programmingLanguageTemp = programmingLanguageRepository.getReferenceById(programmingLanguage.getId());
        programmingLanguageTemp.setName(programmingLanguage.getName());
        programmingLanguageRepository.save(programmingLanguageTemp);
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.findAll();
    }

    @Override
    public ProgrammingLanguage findById(int id) {
        return programmingLanguageRepository.findById(id).get();
    }

}
