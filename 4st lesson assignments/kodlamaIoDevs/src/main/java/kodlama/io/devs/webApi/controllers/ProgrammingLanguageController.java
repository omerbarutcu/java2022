package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.GetByIdProgrammingLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/programminglanguages")
public class ProgrammingLanguageController {
    private final ProgrammingLanguageService programmingLanguageService;

    public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
        programmingLanguageService.add(createProgrammingLanguageRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
        programmingLanguageService.update(updateProgrammingLanguageRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        programmingLanguageService.delete(id);
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLanguageResponse> getAll() {
        return programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdProgrammingLanguageResponse findById(@PathVariable int id) throws Exception{
        return programmingLanguageService.findById(id);
    }
}
