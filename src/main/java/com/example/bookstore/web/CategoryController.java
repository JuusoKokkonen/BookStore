package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository cRepository;
	
	// Category list
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String categoryList(Model model) {
		model.addAttribute("categories", cRepository.findAll());
		model.addAttribute("category", new Category());
		return "categorylist";
	}
	
	// New category
		@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
		public String saveBook(Category category) {
			cRepository.save(category);
			return "redirect:categorylist";
		}
}
