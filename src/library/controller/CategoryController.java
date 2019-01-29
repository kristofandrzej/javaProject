package library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.entity.Category;
import library.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value= {"/list","/",""})
	public String listCategories(Model theModel) {

		List<Category> theCategories = categoryService.getCategories();

		theModel.addAttribute("categories", theCategories);

		return "list-categories";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Category theCategory = new Category();

		theModel.addAttribute("category", theCategory);

		return "category-form";

	}

	@PostMapping("/saveCategory")
	public String saveCategory(@Valid @ModelAttribute("category") Category theCategory, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "category-form";

		} else {

			categoryService.saveCategory(theCategory);

			return "redirect:/category/list";
		}

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("categoryId") int theId, Model theModel) {

		Category theCategory = categoryService.getCategory(theId);

		theModel.addAttribute("category", theCategory);

		return "category-form";

	}

	@GetMapping("/delete")
	public String deleteCategory(@RequestParam("categoryId") int theId) {

		categoryService.deleteCategory(theId);

		return "redirect:/category/list";

	}

}
