package com.info.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.info.model.Category;
import com.info.model.Cmd;
import com.info.model.Region;
import com.info.model.Item;
import com.info.model.Product;
import com.info.model.Provider;
import com.info.service.CategoryService;
import com.info.service.CmdService;
import com.info.service.FileUploadService;
import com.info.service.ItemService;
import com.info.service.ProductService;
import com.info.service.ProviderService;
import com.info.service.RegionService;

@Controller
@RequestMapping("manager")
public class ManagerController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CmdService cmdService;
	
	@Autowired
	private ProviderService providerService;
	
	
	@Autowired
	private FileUploadService fileUploadService;

	@GetMapping("index")
	public String index() {
		return "manager/index";
	}

//	For Category--------------------------------------------------
	@GetMapping("category-form")
	public ModelAndView listCategory() {
		ModelAndView mv = new ModelAndView("manager/category-form");
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}

	@PostMapping("add-category")
	public ModelAndView addCategory(Category category) {
		ModelAndView mv = new ModelAndView("manager/category-form");
		categoryService.addCategory(category);
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}
	
	@GetMapping("delete-Category/{categoryId}")
	public ModelAndView deleteCategory(@PathVariable("categoryId")String categoryId) {
		ModelAndView mv = new ModelAndView("manager/category-form");
		categoryService.deleteCategory(Long.parseLong(categoryId));
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}
	
	@GetMapping("updateCategory/{categoryId}")
	public ModelAndView updateCategory(@PathVariable("categoryId")String categoryId) {
		ModelAndView mv = new ModelAndView("manager/updateCategory");
		mv.addObject("Category", categoryService.getCategory(Long.parseLong(categoryId)).get());
		return mv;
	}
//	For Provider--------------------------------------------------
	@GetMapping("provider-form")
	public ModelAndView listProvider() {
		ModelAndView mv = new ModelAndView("manager/provider-form");
		mv.addObject("providerList", providerService.listProvider());
		return mv;
	}

	@PostMapping("add-provider")
	public ModelAndView addProvider(Provider provider, @RequestParam("file") MultipartFile file) {
		ModelAndView mv = new ModelAndView("manager/provider-form");
		System.out.println("file: " + file.getOriginalFilename());
		String filePath = fileUploadService.upload(file);
		provider.setImage(filePath);
		
		System.out.println(provider.getImage());
		
		providerService.addProvider(provider);
		mv.addObject("providerList", providerService.listProvider());
		return mv;
	}
	
	@GetMapping("delete-Provider/{providerId}")
	public ModelAndView deleteProvider(@PathVariable("providerId")String providerId) {
		ModelAndView mv = new ModelAndView("manager/provider-form");
		providerService.deleteProvider(Long.parseLong(providerId));
		mv.addObject("providerList", providerService.listProvider());
		return mv;
	}
	
	@GetMapping("updateProvider/{providerId}")
	public ModelAndView updateProvider(@PathVariable("providerId")String providerId) {
		ModelAndView mv = new ModelAndView("manager/updateProvider");
		mv.addObject("Provider", providerService.getProvider(Long.parseLong(providerId)).get());
		return mv;
	}
	
//	For Product--------------------------------------------------
	@GetMapping("product-form")
	public ModelAndView listProduct() {
		ModelAndView mv = new ModelAndView("manager/product-form");
		mv.addObject("categoryList", categoryService.listCategory());
		mv.addObject("providerList", providerService.listProvider());
		mv.addObject("productList", productService.listProduct());
		return mv;
	}

	@PostMapping("add-product")
	public ModelAndView addProduct(Product product, @RequestParam("file") MultipartFile file) {
		ModelAndView mv = new ModelAndView("manager/product-form");
		System.out.println("file: " + file.getOriginalFilename());
		String filePath = fileUploadService.upload(file);
		product.setImage(filePath);
		
		System.out.println(product.getImage());
		
		productService.addProduct(product);
		mv.addObject("categoryList", categoryService.listCategory());
		mv.addObject("providerList", providerService.listProvider());
		mv.addObject("productList", productService.listProduct());
		return mv;
	}
	
	@GetMapping("delete-Product/{productId}")
	public ModelAndView deleteProduct(@PathVariable("productId")String productId) {
		ModelAndView mv = new ModelAndView("manager/product-form");
		productService.deleteProduct(Long.parseLong(productId));
		mv.addObject("categoryList", categoryService.listCategory());
		mv.addObject("providerList", providerService.listProvider());
		mv.addObject("productList", productService.listProduct());
		return mv;
	}
	
	@GetMapping("updateProduct/{productId}")
	public ModelAndView updateProduct(@PathVariable("productId")String productId) {
		ModelAndView mv = new ModelAndView("manager/updateProduct");
		mv.addObject("categoryList", categoryService.listCategory());
		mv.addObject("providerList", providerService.listProvider());
		mv.addObject("Product", productService.getProductById(Long.parseLong(productId)).get());
		return mv;
	}
	
//	For Items--------------------------------------------------
	@GetMapping("item-form")
	public ModelAndView listItem() {
		ModelAndView mv = new ModelAndView("manager/item-form");
		mv.addObject("regionList", regionService.listRegion());
		mv.addObject("itemList", itemService.listItem());
		return mv;
	}

	@PostMapping("add-item")
	public ModelAndView addItem(Item item, @RequestParam("file") MultipartFile file) {
		ModelAndView mv = new ModelAndView("manager/item-form");
		System.out.println("file: " + file.getOriginalFilename());
		String filePath = fileUploadService.upload(file);
		item.setImage(filePath);
		
		System.out.println(item.getImage());
		
		itemService.addItem(item);
		mv.addObject("regionList", regionService.listRegion());
		mv.addObject("itemList", itemService.listItem());
		return mv;
	}
	
	
	@GetMapping("delete-Item/{itemId}")
	public ModelAndView deleteItem(@PathVariable("itemId")String itemId) {
		ModelAndView mv = new ModelAndView("manager/item-form");
		itemService.deleteItem(Long.parseLong(itemId));
		mv.addObject("regionList", regionService.listRegion());
		mv.addObject("itemList", itemService.listItem());
		return mv;
	}
	
	@GetMapping("updateItem/{itemId}")
	public ModelAndView updateItem(@PathVariable("itemId")String itemId) {
		ModelAndView mv = new ModelAndView("manager/updateItem");
		mv.addObject("regionList", regionService.listRegion());
		mv.addObject("Item", itemService.getItemById(Long.parseLong(itemId)).get());
		return mv;
	}
//	For Commandes--------------------------------------------------
	@GetMapping("Cmd-List")
	public ModelAndView listCmd() {
		ModelAndView mv = new ModelAndView("manager/Cmd-List");
		mv.addObject("cmdList", cmdService.listCmd());
		return mv;
	}
	@PostMapping("add-cmd")
	public ModelAndView addCmd(String cmdId,String cmdEtat) {
		ModelAndView mv = new ModelAndView("manager/Cmd-List");
		
		Cmd cmd = cmdService.getCmdById(Long.parseLong(cmdId)).get();
		cmd.setCmdEtat(cmdEtat);
		cmdService.addCmd(cmd);
	
		mv.addObject("cmdList", cmdService.listCmd());
		return mv;
	}
	@GetMapping("delete-Cmd/{cmdId}")
	public ModelAndView deleteCmd(@PathVariable("cmdId")String cmdId) {
		ModelAndView mv = new ModelAndView("manager/Cmd-List");
		cmdService.deleteCmd(Long.parseLong(cmdId));
		mv.addObject("cmdList", cmdService.listCmd());
		return mv;
	}
	
	@GetMapping("updateCmd/{cmdId}")
	public ModelAndView updateCmd(@PathVariable("cmdId")String cmdId) {
		ModelAndView mv = new ModelAndView("manager/updateCmdModal");
		
		mv.addObject("Cmd", cmdService.getCmdById(Long.parseLong(cmdId)).get());
		
		return mv;
	}
	
	@GetMapping("afficheCmd/{cmdId}")
	public ModelAndView afficheCmd(@PathVariable("cmdId")String cmdId) {
		ModelAndView mv = new ModelAndView("manager/afficheCmdModal");
		List<Integer> list=new ArrayList<Integer>();
		Cmd cmd=cmdService.getCmdById(Long.parseLong(cmdId)).get();
		cmd.getQuantity().size();
		list =cmd.getQuantity();
		List<Product> productList = cmd.getProductList();
		mv.addObject("cmd", cmd);
		mv.addObject("productList", productList);
		mv.addObject("list", list);
		return mv;
	}
	
	
//	For Region--------------------------------------------------
	@GetMapping("region-form")
	public ModelAndView listRegion() {
		ModelAndView mv = new ModelAndView("manager/region-form");
		mv.addObject("regionList", regionService.listRegion());
		return mv;
	}

	@PostMapping("add-region")
	public ModelAndView addRegion(Region region) {
		ModelAndView mv = new ModelAndView("manager/region-form");
		regionService.addRegion(region);
		mv.addObject("regionList", regionService.listRegion());
		return mv;
	}
	
	@GetMapping("delete-Region/{regionId}")
	public ModelAndView deleteRegion(@PathVariable("regionId")String regionId) {
		ModelAndView mv = new ModelAndView("manager/region-form");
		regionService.deleteRegion(Long.parseLong(regionId));
		mv.addObject("regionList", regionService.listRegion());
		return mv;
	}
	
	@GetMapping("updateRegion/{regionId}")
	public ModelAndView updateRegion(@PathVariable("regionId")String regionId) {
		ModelAndView mv = new ModelAndView("manager/updateRegion");
		mv.addObject("Region", regionService.getRegion(Long.parseLong(regionId)).get());
		return mv;
	}


}
