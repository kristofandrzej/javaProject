package library.converter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import library.entity.Category;
import library.service.CategoryService;

@Component
public class CategoryConverter implements Converter<String, Category> {

	@Autowired
	private CategoryService categoryService;


	@Override
	public Category convert(String theId) {
		System.out.println("Podejscie coverters pierwsze category");
		if(theId == null || theId.isEmpty()) {
			return null;
		} else {
			return categoryService.getCategory(Integer.valueOf(theId));
		}
		
	}
	
	
	
}
