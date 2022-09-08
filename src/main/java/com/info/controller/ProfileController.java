package com.info.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.info.model.Cmd;
import com.info.model.Item;
import com.info.model.Panier;
import com.info.model.Product;
import com.info.model.User;
import com.info.service.CmdService;
import com.info.service.FileUploadService;
import com.info.service.ItemService;
import com.info.service.PanierService;
import com.info.service.ProductService;
import com.info.service.RegionService;
import com.info.service.UserService;

@Controller
@RequestMapping("profile")
public class ProfileController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PanierService panierService;
	
	@Autowired
	private CmdService cmdService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	
	
	@GetMapping("delete-Product-Panier/{productId}")
	public ModelAndView delPanier(@PathVariable("productId")String productId,Principal principal) {
		ModelAndView mv = new ModelAndView("profile/cart-product");
		
		User user = userService.findByEmail(principal.getName());
		long USERID = user.getUserId();
		
		List<Panier> panierList = new ArrayList<>();
		panierList = panierService.findByUser(USERID);
		List<Product> productList = new ArrayList<Product>();
		for(int i=0;i<panierList.size();i++)
		{
		Product product = panierList.get(i).getProduct();
		long ids = product.getProductId();
		if (ids==Long.parseLong(productId)){
		long Pa= panierList.get(i).getPanierId();
		panierService.deletePanier(Pa);
		}
		}
		List<Panier> panierList2 = new ArrayList<>();
		panierList2 = panierService.findByUser(USERID);
		int sum = 0;
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<panierList2.size();i++)
		{
		Product product = panierList2.get(i).getProduct();
		productList.add(product);
		sum+= (product.getProductPrice())*panierList2.get(i).getNum();
		list.add(panierList2.get(i).getNum());
		}
		mv.addObject("list", list);
		mv.addObject("User", userService.findByEmail(principal.getName()));
		mv.addObject("sum", sum);
		mv.addObject("productList", productList);
		return mv;
		}
	
	
	@GetMapping("cart-product")
	public ModelAndView carroduct(Principal principal) {
		int sum = 0;
		ModelAndView mv = new ModelAndView("profile/cart-product");
		User user = userService.findByEmail(principal.getName());
		long USERID = user.getUserId();
		
		List<Panier> panierList = new ArrayList<>();
		panierList = panierService.findByUser(USERID);
	
		List<Product> productList = new ArrayList<Product>();
		List<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<panierList.size();i++)
		{
		Product product = panierList.get(i).getProduct();
		productList.add(product);
		sum+= (product.getProductPrice())*panierList.get(i).getNum();
		list.add(panierList.get(i).getNum());
		}
		mv.addObject("User", userService.findByEmail(principal.getName()));
		mv.addObject("list", list);
		mv.addObject("sum", sum);
		mv.addObject("productList", productList);
		return mv;
	}
	
	@PostMapping("add-panier")
	public ModelAndView addProduct(Panier panier,Principal principal) {
		ModelAndView mv = new ModelAndView("profile/cart-product");
		
		
		panierService.addPanier(panier);
		
		
		
		User user = userService.findByEmail(principal.getName());
		long USERID = user.getUserId();
		
		List<Panier> panierList = new ArrayList<>();
		panierList = panierService.findByUser(USERID);
	
		List<Product> productList = new ArrayList<Product>();
		
		int sum = 0;
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<panierList.size();i++)
		{
		Product product = panierList.get(i).getProduct();
		productList.add(product);
		sum+= (product.getProductPrice())*panierList.get(i).getNum();
		list.add(panierList.get(i).getNum());
		}
		mv.addObject("User", userService.findByEmail(principal.getName()));
		mv.addObject("list", list);
		mv.addObject("sum", sum);
		mv.addObject("panierList", panierService.listPanier());
		mv.addObject("productList", productList);
		return mv;
	}
	
	@GetMapping("confirmPanier/{productId}")
	@ResponseBody
	public ModelAndView confirmPanier(@PathVariable("productId")String productId,Principal principal) {
		ModelAndView mv = new ModelAndView("profile/cart-confirm-modal");
		ModelAndView vm = new ModelAndView("profile/product-exist");
		User user = userService.findByEmail(principal.getName());
		long USERID = user.getUserId();
		
		List<Panier> panierList = new ArrayList<>();
		panierList = panierService.findByUser(USERID);
	
		for(int i=0;i<panierList.size();i++)
		{
		Product product = panierList.get(i).getProduct();
		long ids = product.getProductId();
		if (ids==Long.parseLong(productId)){
		 return vm;
		 
		}
		}
		
		
		mv.addObject("User", userService.findByEmail(principal.getName()));
		mv.addObject("Product", productService.getProductById(Long.parseLong(productId)).get());
		return mv;
	}
//	For Command--------------------------------------------------
	@PostMapping("addToCmd")
	public ModelAndView addToCmd(Cmd cmd,Principal principal) {
		ModelAndView mv = new ModelAndView("profile/cmd-list");
		User user = userService.findByEmail(principal.getName());
		long USERID = user.getUserId();
		
		cmdService.addCmd(cmd);
		List<Integer> list=new ArrayList<Integer>();
		List<Product> productList = new ArrayList<Product>();
		List<Panier> panierList = new ArrayList<>();
		panierList = panierService.findByUser(USERID);
	
		for(int i=0;i<panierList.size();i++)
			{
			Product product = panierList.get(i).getProduct();
			productList.add(product);
			list.add(panierList.get(i).getNum());
		}
		
		
		cmd.setProductList(productList);
		cmd.setQuantity(list);
		cmdService.updateCmd(cmd);
		
		
		List<Cmd> cmdList = new ArrayList<>();
		cmdList=cmdService.findByUser(USERID);
		
		for(int i=0;i<panierList.size();i++)
		{
		panierService.delPanier(panierList.get(i));
		}
		mv.addObject("User", userService.findByEmail(principal.getName()));
		mv.addObject("cmd", cmd);
		mv.addObject("cmdList", cmdList);
		
		return mv;
	}
	
	@GetMapping("cmdproduct/{cmdId}")
	public ModelAndView cmdproduct(@PathVariable("cmdId")String cmdId, Principal principal) {
		
		ModelAndView mv = new ModelAndView("profile/cmd-product");
		
		
		long CMD = Long.parseLong(cmdId);
		List<Integer> list=new ArrayList<Integer>();
		Cmd cmd = cmdService.getCmdById(CMD).get();
		cmd.getQuantity().size();
		list =cmd.getQuantity();
		List<Product> productList = cmd.getProductList();
		
		
		
		
		mv.addObject("User", userService.findByEmail(principal.getName()));
		mv.addObject("productList", productList);
		mv.addObject("cmd", cmd);
		mv.addObject("list", list);
		return mv;
	}
	
	
	@GetMapping("cmd-list")
	public ModelAndView cmdlist( Principal principal) {
		
		ModelAndView mv = new ModelAndView("profile/cmd-list");
		User user = userService.findByEmail(principal.getName());
		long USERID = user.getUserId();
		
		
		List<Cmd> cmdList = new ArrayList<>();
		cmdList=cmdService.findByUser(USERID);
		
		
		
		
		mv.addObject("User", userService.findByEmail(principal.getName()));
		
		mv.addObject("cmdList", cmdList);
		return mv;
	}
//	For Items/User Post /view--------------------------------------------------
	@GetMapping("item-form")
	public ModelAndView listItem() {
		ModelAndView mv = new ModelAndView("profile/item-form");
		mv.addObject("regionList", regionService.listRegion());
		mv.addObject("itemList", itemService.listItem());
		return mv;
	}

	@PostMapping("add-item")
	public ModelAndView addItem(Item item, @RequestParam("file") MultipartFile file) {
		ModelAndView mv = new ModelAndView("itemsList");
		System.out.println("file: " + file.getOriginalFilename());
		String filePath = fileUploadService.upload(file);
		item.setImage(filePath);
		
		System.out.println(item.getImage());
		
		itemService.addItem(item);
		mv.addObject("itemList", itemService.listItem());
		mv.addObject("regionList", regionService.listRegion());
		return mv;
	}

	
}
