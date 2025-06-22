package apis.contracts.response;

import apis.contracts.common.CityBase;

public class GetCityResponse extends CityBase{
	private Integer id;
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
