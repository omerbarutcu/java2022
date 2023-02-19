package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    private final ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        if (createProgrammingLanguageRequest.getName() == null) {
            throw new Exception("Programlama dili boş olamaz");
        } else {
            if (!createProgrammingLanguageRequest.getName().isBlank()) {
                for (ProgrammingLanguage language : programmingLanguageRepository.findAll()) {
                    if (language.getName().equalsIgnoreCase(createProgrammingLanguageRequest.getName())) {
                        throw new Exception("Bu isimde zaten bir kayıt var");
                    }
                }
            }
            programmingLanguage.setName(createProgrammingLanguageRequest.getName());
            programmingLanguageRepository.save(programmingLanguage);
        }
    }

    @Override
    public void delete(int id) {
        programmingLanguageRepository.deleteById(id);
    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getReferenceById(updateProgrammingLanguageRequest.getId());
        if (updateProgrammingLanguageRequest.getName().isEmpty()) {
            throw new Exception("Programlama dili boş olamaz");
        } else {
            for (ProgrammingLanguage language : programmingLanguageRepository.findAll()) {
                if (language.getName().equalsIgnoreCase(updateProgrammingLanguageRequest.getName())) {
                    throw new Exception("Bu isimde zaten bir kayıt var");
                }
            }
            if (!programmingLanguageRepository.existsById(updateProgrammingLanguageRequest.getId())) {
                throw new Exception("Girilen id bulunamadı");
            }
            programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
            programmingLanguageRepository.save(programmingLanguage);
        }
    }

    @Override
    public List<GetAllProgrammingLanguageResponse> getAll() {
        List<GetAllProgrammingLanguageResponse> programmingLanguageResponses = new ArrayList<>();
        for (ProgrammingLanguage language : programmingLanguageRepository.findAll()) {
            GetAllProgrammingLanguageResponse response = new GetAllProgrammingLanguageResponse();
            response.setName(language.getName());
            response.setId(language.getId());
            programmingLanguageResponses.add(response);
        }
        return programmingLanguageResponses;
    }

    @Override
    public GetByIdProgrammingLanguageResponse findById(int id) throws Exception {
        GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = new GetByIdProgrammingLanguageResponse();
        for (ProgrammingLanguage language : programmingLanguageRepository.findAll()) {
            if (language.getId() == id) {
                getByIdProgrammingLanguageResponse.setId(language.getId());
                getByIdProgrammingLanguageResponse.setName(language.getName());
            }
        }
        if (getByIdProgrammingLanguageResponse.getName() == null) {
            throw new Exception("Girilen id'ye ait dil bulunamadı");
        }
        return getByIdProgrammingLanguageResponse;
    }

    protected ProgrammingLanguage findProgramLanguageByName(String name) throws Exception {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        boolean nameControl = false;
        for (ProgrammingLanguage language : programmingLanguageRepository.findAll()) {
            if (name.equalsIgnoreCase(language.getName())) {
                nameControl = true;
                programmingLanguage.setId(language.getId());
                programmingLanguage.setName(language.getName());
                programmingLanguage.setSubTechnologies(language.getSubTechnologies());
            }
        }
        if (!nameControl) {
            throw new Exception("Girilen ProgrammingLanguage ismi bulunamadı");
        }

        return programmingLanguage;
    }
}
