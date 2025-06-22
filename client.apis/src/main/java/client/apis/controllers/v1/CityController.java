package client.apis.controllers.v1;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import apis.contracts.common.GResponse;
import apis.contracts.requests.AddCityRequest;
import apis.contracts.requests.UpdateCityRequest;
import apis.contracts.response.GetCityResponse;
import io.swagger.v3.oas.annotations.Operation;
import logic.layer.services.CityService;

@RestController("CityV1Controller")
@RequestMapping("/api/v1/city")
public class CityController {
	 private final CityService cityService;

	    public CityController(CityService cityService) {
	        this.cityService = cityService;
	    }
	    
	    @Operation(summary = "GetCities", description = "Returns list of cities")
	    @GetMapping
	    public List<GetCityResponse> getAll() {
	        return cityService.getAllCities();
	    }
	    
	    @Operation(summary = "AddCity", description = "Add new City")
	    @PostMapping
	    public GResponse<GetCityResponse> Add(AddCityRequest addCityRequest) {
	        return cityService.Add(addCityRequest);
	    }
	    
	    @Operation(summary = "UpdateCity", description = "Update City")
	    @PutExchange
	    public GResponse<GetCityResponse> Update(UpdateCityRequest updateCityRequest) {
	        return cityService.Update(updateCityRequest);
	    }
	   	   	    
	    @Operation(summary = "DeleteCity", description = "Delete City")
	    @DeleteMapping
	    public GResponse<String> Delete(int id) {
	        return cityService.Delete(id);
	    }

}
