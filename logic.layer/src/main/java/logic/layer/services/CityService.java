package logic.layer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.contracts.common.GResponse;
import apis.contracts.requests.AddCityRequest;
import apis.contracts.requests.UpdateCityRequest;
import apis.contracts.response.GetCityResponse;
import data.layer.repositories.CityRepository;
import logic.layer.mappers.CityMapper;

import java.util.List;

@Service
public class CityService {

	@Autowired
    private  CityRepository cityRepository;
	
	@Autowired
	private CityMapper cityMapper;


    public List<GetCityResponse> getAllCities() {
        return cityMapper.toDtoList(cityRepository.findAll());
    }
    
    public GResponse<GetCityResponse> Add(AddCityRequest addCityRequest) {    	
    	var city = cityRepository.save(cityMapper.AddToEntity(addCityRequest));    	
        return GResponse.ok(cityMapper.toDto(city));
    }
    
    public GResponse<GetCityResponse> Update(UpdateCityRequest updateCityRequest) {    	
    	var city = cityRepository.save(cityMapper.UpdateToEntity(updateCityRequest));    	
        return GResponse.ok(cityMapper.toDto(city));
    }    
    
    public GResponse<String> Delete(int id) {    		
    	cityRepository.deleteById(id);
    	return GResponse.ok(String.format("Delete action completed successully for the id %s", id));
    }
}