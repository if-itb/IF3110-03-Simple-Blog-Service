package org.chamerling.heroku.service;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ProductCatalogService {

	@WebMethod
	public List<String> getProductCategories() {
		List<String> categories = new ArrayList<String>();
		categories.add("Books");
		categories.add("Musics");
		categories.add("Movies");
		return categories;
	}
}
