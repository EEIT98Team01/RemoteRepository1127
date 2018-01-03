package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import model.bean.BlogBean;
import model.service.BlogService;
import model.service.CustomerManagementService;

@Controller
public class BlogListController {

	@Autowired
	BlogService blogService;
	
	@Autowired
	private ServletContext application;
	

	// 後台Blog檢視使用
	@RequestMapping(value = ("/pages/backstageAdmit/blogView"), method = { RequestMethod.GET,
			RequestMethod.POST })
	public String view(Model model, String id) {
		if (id != null && !"".equals(id.trim())) {
			
			//以下為顯示小圖編輯
			BlogBean bean2 = blogService.findById(Integer.parseInt(id));
			// 如果大頭貼為空
			if(bean2.getArticlePhoto()!=null){			
				// 從資料庫抓取LOGO圖片編碼(二進制)
				 java.sql.Blob logingPhoto = bean2.getArticlePhoto();
				 try {
					 // LOGO圖片編碼(二進制)->轉base64
					 byte[] img = Base64.getEncoder().encode(logingPhoto.getBytes(1, (int)logingPhoto.length())); 
					 // base64 -> 轉字串顯示於畫面上
					 String logingPhotoImg = new String(img);				 
					 model.addAttribute("logingPhotoImg", logingPhotoImg);
				 } catch (Exception e) {				 
					 e.printStackTrace();
				 }
			}			
			model.addAttribute("blogData", blogService.findById(Integer.parseInt(id)));
		}						//↑識別字串
		return "blog_view"; //← 要放view用
	}			
	
	
	// 後台Blog編輯使用									//識別字串，與JSP對應
	@RequestMapping(value = ("/pages/backstageAdmit/blogDelete"), method = { RequestMethod.GET,
			RequestMethod.POST })
	public String edit(Model model, String id) {
		if (id != null && !"".equals(id.trim())) {
			
			//以下為顯示小圖編輯
			BlogBean bean = blogService.findById(Integer.parseInt(id));
			// 如果大頭貼為空
			if(bean.getArticlePhoto()!=null){
				
				// 從資料庫抓取LOGO圖片編碼(二進制)
				 java.sql.Blob logingPhoto = bean.getArticlePhoto();
				 try {
					 // LOGO圖片編碼(二進制)->轉base64
					 byte[] img = Base64.getEncoder().encode(logingPhoto.getBytes(1, (int)logingPhoto.length())); 
					 // base64 -> 轉字串顯示於畫面上
					 String logingPhotoImg = new String(img);
					 
					 model.addAttribute("logingPhotoImg", logingPhotoImg);
				 } catch (Exception e) {
					 
					 e.printStackTrace();
				 }
			}
			//以上為小圖編輯
			
			model.addAttribute("blogData", blogService.findById(Integer.parseInt(id)));
		}
		
		
		

		return "blog_edit";
	}
		
	
	// 前台Blog頁面			   ↓JSP對應AllProductController
	@RequestMapping(value = ("AllBlogController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String allBlog(Model model) {
		System.out.println("AA");
		
		List<Object[]> list = blogService.findObject();
		model.addAttribute("blogList", list);
		                  //↑JSP對productList
		return "all_blog_list";  // view對應all_blog_list
	}
	
	// 前台Blog資訊
	@RequestMapping(     //↓跟JSP ProductItemOfShop對應
			value=("BlogItemOfArticle"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String blogItem(Model model, String articleID) {
		//查詢該商品的全部資訊
		model.addAttribute("blogData", blogService.findById(Integer.parseInt(articleID)));
		return "blog_item";
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
