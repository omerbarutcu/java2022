package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMappersService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMappersService modelMappersService;

    @Override
    public List<GetAllModelsResponse> getAll() {

        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponses = models.stream().map(model -> this.modelMappersService.forResponse()
                .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMappersService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}
