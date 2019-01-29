package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import library.dao.CategoryDAO;
import library.entity.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	public CategoryDAO categoryDAO;
	
		
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public List<Category> getCategories() {
		return categoryDAO.getCategories();
	}


	@Override
	@Transactional
	public void saveCategory(Category theCategory) {
		
		categoryDAO.saveCategory(theCategory);
		
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public Category getCategory(int theId) {
		
		Category theCategory = categoryDAO.getCategory(theId);
		
		return theCategory;
	}


	@Override
	@Transactional
	public void deleteCategory(int theId) {
		
		categoryDAO.deleteCategory(theId);
	}

}
