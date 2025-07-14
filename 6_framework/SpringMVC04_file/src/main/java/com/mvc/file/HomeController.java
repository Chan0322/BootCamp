package com.mvc.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mvc.file.common.FileValidator;
import com.mvc.file.common.UploadFile;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping("/form")
	public String getUploadForm() {
		logger.info("UPLOAD FORM");
		return "uploadForm";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(UploadFile uploadFile, BindingResult result, Model model) {
		System.out.println(uploadFile.getDesc());
		System.out.println(uploadFile.getMpfile().getOriginalFilename());
		
		// 유효성 검사
		fileValidator.validate(uploadFile, result);
//		System.out.println(result.hasErrors());
		if(result.hasErrors()) {
			// hasErrors가 true => file의 size가 0 => 업로드 시 file 선택X
			return "uploadForm";
		}
//		if(uploadFile.getMpfile().getSize()==0) {
//			return "uploadform";
//		}
		
		MultipartFile file = uploadFile.getMpfile();
		String filename = file.getOriginalFilename();
		String desc = uploadFile.getDesc();
		
		UploadFile fileobj = new UploadFile();	// 응답페이지에서 출력
		fileobj.setFilename(filename);
		fileobj.setDesc(desc);
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			File storage = new File("C:\\storage");
			if( !storage.exists() ) { // 해당 경로 존재 여부 확인
				storage.mkdir();
				//c드라이브에 storage 폴더가 없으면 만든다.
			}
			
			File newfile = new File("c:\\storage\\"+filename);
			if( !newfile.exists() ) {
				newfile.createNewFile();
			}
			
			inputStream = file.getInputStream();
			outputStream = new FileOutputStream(newfile);
			
			int res = 0;
			byte[] b = new byte[(int)file.getSize()];
			
			while( (res=inputStream.read(b)) != -1 ) {
				outputStream.write(b, 0, res);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("fileobj", fileobj);
		return "uploadRes";
	}
}
