package apis.contracts.common;

import jakarta.validation.constraints.*;


public class CityBase {	
	public String getNameArabic() {
		return nameArabic;
	}
	public void setNameArabic(String nameArabic) {
		this.nameArabic = nameArabic;
	}
	public String getNameEnglish() {
		return nameEnglish;
	}
	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}
	
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "Name must be 5–20 characters long and contain only letters & numbers")
	private String nameArabic;
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "Name must be 5–20 characters long and contain only letters & numbers")
    private String nameEnglish;
	
}
