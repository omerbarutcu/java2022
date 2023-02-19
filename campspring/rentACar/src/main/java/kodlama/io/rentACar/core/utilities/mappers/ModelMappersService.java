package kodlama.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMappersService {
    ModelMapper forResponse();

    ModelMapper forRequest();
}
