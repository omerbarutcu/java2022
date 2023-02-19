package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageSubTechnologyService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageSubTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageSubTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguageSubTechnologyResponse;
import kodlama.io.devs.business.responses.GetByIdProgrammingLanguageSubTechnologyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/languagesubtechnologies")
public class ProgrammingLanguageSubTechnologyController {
    ProgrammingLanguageSubTechnologyService technologyService;

    @Autowired
    public ProgrammingLanguageSubTechnologyController(ProgrammingLanguageSubTechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProgrammingLanguageSubTechnologyRequest createProgrammingLanguageSubTechnologyRequest)
            throws Exception {
        technologyService.add(createProgrammingLanguageSubTechnologyRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateProgrammingLanguageSubTechnologyRequest updateProgrammingLanguageSubTechnologyRequest)
            throws Exception {
        technologyService.update(updateProgrammingLanguageSubTechnologyRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        technologyService.delete(id);
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLanguageSubTechnologyResponse> getAll() {
        return technologyService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdProgrammingLanguageSubTechnologyResponse findById(@PathVariable int id) throws Exception{
        return technologyService.findById(id);
    }
}
