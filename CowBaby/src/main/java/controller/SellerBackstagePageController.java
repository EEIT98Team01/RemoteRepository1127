package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

import model.bean.SellerBackstageManageBean;
import model.bean.ShoppingCart;
import model.service.SellerBackstageManageService;

@Controller
@RequestMapping("/pages/backstageSeller/SellerBackstagePageController.controller")
public class SellerBackstagePageController {

	@Autowired
	SellerBackstageManageService sellerBackstageManageService;
	@Autowired
	private ServletContext application;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String method(Model model, HttpSession session){
		
		
		return "account_overview";
	}

}
