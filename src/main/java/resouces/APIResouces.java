package resouces;

public enum APIResouces {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource;

	APIResouces(String resouce) {
		// TODO Auto-generated constructor stub
		this.resource=resouce;
	}
	
	public String getResource() {
		
		return resource;
		
	}

}

