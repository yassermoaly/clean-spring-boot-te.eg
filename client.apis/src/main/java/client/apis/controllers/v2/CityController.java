package client.apis.controllers.v2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import apis.contracts.response.GetCityResponse;
import io.swagger.v3.oas.annotations.Operation;
import logic.layer.services.CityService;

@RestController("CityV2Controller")
@RequestMapping("/api/v2/city")
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
}
