package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.CreateProgrammingLanguageSubTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageSubTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageSubTechnologyResponse;
import kodlama.io.devs.business.responses.GetByIdProgrammingLanguageSubTechnologyResponse;

import java.util.List;

public interface ProgrammingLanguageSubTechnologyService {

    void add(CreateProgrammingLanguageSubTechnologyRequest createProgrammingLanguageSubTechnologyRequest) throws Exception;

    void delete(int id);

    void update(UpdateProgrammingLanguageSubTechnologyRequest updateProgrammingLanguageSubTechnologyRequest) throws Exception;

    List<GetAllProgrammingLanguageSubTechnologyResponse> getAll();

    GetByIdProgrammingLanguageSubTechnologyResponse findById(int id) throws Exception;
}
