package apis.contracts.requests;

import apis.contracts.common.CityBase;
import lombok.Data;


@Data

public class UpdateCityRequest extends CityBase {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
