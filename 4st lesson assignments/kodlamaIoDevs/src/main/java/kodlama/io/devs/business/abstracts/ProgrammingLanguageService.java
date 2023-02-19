package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.GetByIdProgrammingLanguageResponse;

import java.util.List;

public interface ProgrammingLanguageService {
    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;

    void delete(int id);

    void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;

    List<GetAllProgrammingLanguageResponse> getAll();

    GetByIdProgrammingLanguageResponse findById(int id) throws Exception;
}
