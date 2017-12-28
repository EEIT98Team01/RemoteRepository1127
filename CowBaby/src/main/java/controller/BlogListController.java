package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import model.service.BlogService;
import model.service.CustomerManagementService;

@Controller
public class BlogListController {

	@Autowired
	BlogService blogService;
	
	@Autowired
	private ServletContext application;
	
/*
	// 會員管理/會員檢視使用
	@RequestMapping(value = ("/pages/backstageAdmit/CustomerManagementView"), method = { RequestMethod.GET,
			RequestMethod.POST })
	public String view(Model model, String id) {
		if (id != null && !"".equals(id.trim())) {
			model.addAttribute("customerData", customerManagementService.findById(Integer.parseInt(id)));
		}

		return "member_managment_view";
	}
*/
	
	
	// Blog編輯使用									//識別字串，與JSP對應
	@RequestMapping(value = ("/pages/backstageAdmit/blogDelete"), method = { RequestMethod.GET,
			RequestMethod.POST })
	public String edit(Model model, String id) {
		if (id != null && !"".equals(id.trim())) {
			model.addAttribute("blogData", blogService.findById(Integer.parseInt(id)));
		}

		return "blog_edit";
	}

	//CKeditor 文字+圖片上傳
	@RequestMapping("/pages/backstageAdmit/upload.image")  //<--路徑跟ckeditor的config.js對應 
	public String imageUpload(MultipartFile upload, String CKEditorFuncNum, HttpServletResponse response)
			throws IOException {
		System.out.println("+++");
		PrintWriter out = response.getWriter();
		String name = upload.getOriginalFilename();
		String mimeType = application.getMimeType(name);

		String expandedName = "";
		if (mimeType.equals("image/jpeg")) {
			expandedName = ".jpg";
		} else if (mimeType.equals("image/png")) {
			expandedName = ".png";
		} else if (mimeType.equals("image/gif")) {
			expandedName = ".gif";
		} else if (mimeType.equals("image/bmp")) {
			expandedName = ".bmp";
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'',"
					+ "'文件格式不正確（必須為.jpg/.gif/.bmp/.png文件）');");
			out.println("</script>");
			return null;
		}

		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		name = df.format(new Date()) + expandedName;
		try {
			File file = new File(application.getRealPath("/images"), name);
			upload.transferTo(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String fileURL = application.getContextPath() + "/images/" + name;

		out.println("<script type=\"text/javascript\">");
		out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + fileURL + "','')");
		out.println("</script>");
		out.close();
		return null;
	}
	
}
