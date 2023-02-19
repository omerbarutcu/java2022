package kodlama.io.devs.business.concretes;


import kodlama.io.devs.business.abstracts.ProgrammingLanguageSubTechnologyService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageSubTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageSubTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageSubTechnologyResponse;
import kodlama.io.devs.business.responses.GetByIdProgrammingLanguageSubTechnologyResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageSubTechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.entities.concretes.ProgrammingLanguageSubTechnology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageSubTechnologyManager implements ProgrammingLanguageSubTechnologyService {
    private final ProgrammingLanguageSubTechnologyRepository languageSubTechnologyRepository;
    private final ProgrammingLanguageManager languageManager;

    public ProgrammingLanguageSubTechnologyManager(
            ProgrammingLanguageSubTechnologyRepository languageSubTechnologyRepository,
            ProgrammingLanguageManager languageManager) {
        this.languageSubTechnologyRepository = languageSubTechnologyRepository;
        this.languageManager = languageManager;
    }

    @Override
    public void add(CreateProgrammingLanguageSubTechnologyRequest createProgrammingLanguageSubTechnologyRequest)
            throws Exception {
        ProgrammingLanguageSubTechnology programmingLanguageSubTechnology = new ProgrammingLanguageSubTechnology();
        if (createProgrammingLanguageSubTechnologyRequest.getName() == null)
            throw new Exception("Teknoloji ismi boş olamaz");
        if (createProgrammingLanguageSubTechnologyRequest.getLanguageName() == null)
            throw new Exception("Programlama ismi boş olamaz");
        for (ProgrammingLanguageSubTechnology technology : languageSubTechnologyRepository.findAll()) {
            if (technology.getName().equalsIgnoreCase(createProgrammingLanguageSubTechnologyRequest.getName())) {
                throw new Exception("Bu isimde zaten bir kayıt var");
            }
        }
        programmingLanguageSubTechnology.setName(createProgrammingLanguageSubTechnologyRequest.getName());
        programmingLanguageSubTechnology.setProgrammingLanguage(languageManager.
                findProgramLanguageByName(createProgrammingLanguageSubTechnologyRequest.getLanguageName()));
        languageSubTechnologyRepository.save(programmingLanguageSubTechnology);
    }

    @Override
    public void delete(int id) {
        languageSubTechnologyRepository.deleteById(id);
    }

    @Override
    public void update(UpdateProgrammingLanguageSubTechnologyRequest updateProgrammingLanguageSubTechnologyRequest)
            throws Exception {
        ProgrammingLanguageSubTechnology programmingLanguageSubTechnology = languageSubTechnologyRepository.
                getReferenceById(updateProgrammingLanguageSubTechnologyRequest.getId());
        ProgrammingLanguage programmingLanguage = languageManager.
                findProgramLanguageByName(updateProgrammingLanguageSubTechnologyRequest.getLanguageName());
        if (updateProgrammingLanguageSubTechnologyRequest.getName().isEmpty())
            throw new Exception("Teknoloji ismi boş olamaz");
        if (updateProgrammingLanguageSubTechnologyRequest.getLanguageName() == null)
            throw new Exception("Programlama ismi boş olamaz");
        if (!languageSubTechnologyRepository.existsById(updateProgrammingLanguageSubTechnologyRequest.getId()))
            throw new Exception("Girilen id bulunamadı");
        programmingLanguageSubTechnology.setName(updateProgrammingLanguageSubTechnologyRequest.getName());
        programmingLanguageSubTechnology.setProgrammingLanguage(programmingLanguage);
        languageSubTechnologyRepository.save(programmingLanguageSubTechnology);
    }

    @Override
    public List<GetAllProgrammingLanguageSubTechnologyResponse> getAll() {
        List<GetAllProgrammingLanguageSubTechnologyResponse> subTechnologyResponses = new ArrayList<>();
        for (ProgrammingLanguageSubTechnology technology : languageSubTechnologyRepository.findAll()) {
            GetAllProgrammingLanguageSubTechnologyResponse response = new GetAllProgrammingLanguageSubTechnologyResponse();
            response.setId(technology.getId());
            response.setName(technology.getName());
            response.setLanguageName(technology.getProgrammingLanguage().getName());
            subTechnologyResponses.add(response);
        }
        return subTechnologyResponses;
    }

    @Override
    public GetByIdProgrammingLanguageSubTechnologyResponse findById(int id) throws Exception {
        GetByIdProgrammingLanguageSubTechnologyResponse response = new GetByIdProgrammingLanguageSubTechnologyResponse();
        for (ProgrammingLanguageSubTechnology languageSubTechnology : languageSubTechnologyRepository.findAll()) {
            if (languageSubTechnology.getId() == id) {
                response.setId(languageSubTechnology.getId());
                response.setName(languageSubTechnology.getName());
                response.setLanguageName(languageSubTechnology.getProgrammingLanguage().getName());
            }
            if (response.getName() == null) {
                throw new Exception("Girilen id'ye ait dil bulunamadı");
            }
        }
        return response;
    }
}
