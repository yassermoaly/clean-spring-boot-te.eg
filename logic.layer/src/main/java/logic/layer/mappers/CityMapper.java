package logic.layer.mappers;

import java.util.List;
import org.mapstruct.Mapper;

import apis.contracts.requests.AddCityRequest;
import apis.contracts.requests.UpdateCityRequest;
import apis.contracts.response.GetCityResponse;
import data.layer.entities.City;

@Mapper(componentModel = "spring")
public interface CityMapper {
    
	City AddToEntity(AddCityRequest addCityRequest);
	City UpdateToEntity(UpdateCityRequest updateCityRequest);
    GetCityResponse toDto(City city);	
    List<GetCityResponse> toDtoList(List<City> cities);
}