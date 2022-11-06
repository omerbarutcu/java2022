package kodlama.io.devs.business.concretes;


import kodlama.io.devs.business.abstracts.ProgrammingLanguageSubTechnologyService;
import kodlama.io.devs.common.utility.ProgrammingLanguageSubTechnologyControl;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageSubTechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.entities.concretes.ProgrammingLanguageSubTechnology;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageSubTechnologyManager implements ProgrammingLanguageSubTechnologyService {
    private ProgrammingLanguageSubTechnologyRepository languageSubTechnologyRepository;
    private ProgrammingLanguageRepository languageRepository;
    private List<ProgrammingLanguageSubTechnology> languageSubTechnologies;
    private ProgrammingLanguageManager programmingLanguageManager;

    public ProgrammingLanguageSubTechnologyManager(ProgrammingLanguageSubTechnologyRepository languageSubTechnologyRepository,
                                                   ProgrammingLanguageRepository languageRepository, List<ProgrammingLanguageSubTechnology> languageSubTechnologies,
                                                   ProgrammingLanguageManager programmingLanguageManager) {
        this.languageSubTechnologyRepository = languageSubTechnologyRepository;
        this.languageRepository = languageRepository;
        this.languageSubTechnologies = languageSubTechnologies;
        this.programmingLanguageManager = programmingLanguageManager;
    }

    @Override
    public void add(ProgrammingLanguageSubTechnology languageSubTechnology, int id) throws Exception {
        if (!ProgrammingLanguageSubTechnologyControl.programmingLanguageSubTechnologyNameControl(languageSubTechnology, languageSubTechnologies)) {
            throw new Exception("This Language Technology is not valid !");
        }
        ProgrammingLanguage byId = programmingLanguageManager.findById(id);
        languageSubTechnology.setProgrammingLanguage(byId);
        languageSubTechnologyRepository.save(languageSubTechnology);
    }

    @Override
    public void delete(int id) {
        languageSubTechnologyRepository.deleteById(id);
    }

    @Override
    public void update(ProgrammingLanguageSubTechnology languageSubTechnology) throws Exception {
        if (!ProgrammingLanguageSubTechnologyControl.programmingLanguageSubTechnologyNameControl(languageSubTechnology, languageSubTechnologies)) {
            throw new Exception("This Language Technology is not valid !");
        }
        ProgrammingLanguageSubTechnology technologyTemp = languageSubTechnologyRepository.getReferenceById(languageSubTechnology.getId());
        technologyTemp.setName(languageSubTechnology.getName());
        languageSubTechnologyRepository.save(technologyTemp);
    }

    @Override
    public List<ProgrammingLanguageSubTechnology> getAll() {
        return languageSubTechnologyRepository.findAll();
    }

    @Override
    public ProgrammingLanguageSubTechnology findById(int id) {
        return languageSubTechnologyRepository.findById(id).get();
    }
}
