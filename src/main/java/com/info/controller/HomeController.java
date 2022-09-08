package com.info.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.info.dao.ProductRepository;
import com.info.dao.ProviderRepository;
import com.info.model.Product;
import com.info.model.Provider;
import com.info.model.User;
import com.info.service.CategoryService;
import com.info.service.ItemService;
import com.info.service.PanierService;
import com.info.service.ProductService;
import com.info.service.ProviderService;
import com.info.service.RegionService;
import com.info.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private ProviderRepository providerRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private PanierService panierService;
	
	@Autowired
	private ProviderService providerService;
	
	@GetMapping({"index", "/"})
	public String index(Model model) {
		model.addAttribute("categoryList", categoryService.listCategory());
		model.addAttribute("productList", productService.listProduct());
		return "index";
	}
	
	
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("signup")
	public String signup() {
		return "signup";
	}
	
	
	
	@PostMapping("signup")
	public ModelAndView signUp(User user) {
		ModelAndView mv = new ModelAndView("/index");
		userService.save(user);
		mv.addObject("productList", productService.listProduct());
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}
	
	@GetMapping("modal1")
    public String modal1() {
        return "modal1";
    }
	
	@GetMapping("allProduct")
	public String allProduct(Model model) {
		model.addAttribute("productList", productService.listProduct());
		model.addAttribute("categoryList", categoryService.listCategory());
		return "index";
	}
	
	@GetMapping("getProducts/{categoryId}")
	public ModelAndView getProductFromCategory(@PathVariable("categoryId")String categoryId) {
		ModelAndView mv = new ModelAndView("index");
		long categoryLongId = Long.parseLong(categoryId);
		System.out.println(categoryLongId);
		mv.addObject("productList", productService.findByCategory(categoryLongId));
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}
	
	@GetMapping("error")
	public String error() {
		return "error";
	}
	
	
	//for the items list 
	
	@GetMapping({"itemsList"})
	public String Item(Model model) {
		model.addAttribute("regionList", regionService.listRegion());
		model.addAttribute("itemList", itemService.listItem());
		return "itemsList";
	}
	@GetMapping("allItem")
	public String allItem(Model model) {
		model.addAttribute("itemList", itemService.listItem());
		model.addAttribute("regionList", regionService.listRegion());
		return "itemsList";
	}
	
	@GetMapping("getItems/{regionId}")
	public ModelAndView getItemFromRegion(@PathVariable("regionId")String regionId) {
		ModelAndView mv = new ModelAndView("itemsList");
		long regionLongId = Long.parseLong(regionId);
		System.out.println(regionLongId);
		mv.addObject("itemList", itemService.findByRegion(regionLongId));
		mv.addObject("regionList", regionService.listRegion());
		return mv;
	}
	/*for the provider list
	 	@GetMapping({"providerList"})
		public ModelAndView Provider(Model model,
								@RequestParam(name="page",defaultValue="0") int page,
								@RequestParam(name="size",defaultValue="6") int size) {
			ModelAndView mv = new ModelAndView("providerList");
			Page<Provider> pageProvider=providerRepository.findAll((PageRequest.of(page, size)));
			mv.addObject("providerList", pageProvider.getContent());
			int pageNum=pageProvider.getTotalPages();
			System.out.println(pageNum);
			mv.addObject("pages",pageNum)  ;
			return mv ;
		}
	 */
	
		@GetMapping({"providerList"})
		public String Provider(Model model)
								{
			model.addAttribute("providerList", providerService.listProvider());
			  
			return "providerList" ;
		}
		@GetMapping("consulterFournisseur/{providerId}")
		public ModelAndView consulterFournisseur(@PathVariable("providerId")String providerId) {
			ModelAndView mv = new ModelAndView("consulterFournisseur");
			List<Provider> providerList=new ArrayList<Provider>();
			providerList.add(providerService.getProvider(Long.parseLong(providerId)).get());
			mv.addObject("provider",providerService.getProvider(Long.parseLong(providerId)).get());
			mv.addObject("providerList",providerList);
			return mv;
		}
		
}
