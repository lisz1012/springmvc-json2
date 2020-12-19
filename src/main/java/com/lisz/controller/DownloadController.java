package com.lisz.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;

@Controller
public class DownloadController {

	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(HttpServletRequest req) throws Exception {
		// 获取路径
		ServletContext context = req.getServletContext();
		String realPath = context.getRealPath("/scripts/jquery-3.5.1.min.js");
		//通过io流对文件进行读写
		try(FileInputStream fis = new FileInputStream(realPath);){
			byte[] bytes = new byte[fis.available()];
			fis.read(bytes);
			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Disposition", "attachment;filename=jquery-3.5.1.min.js");
			return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
		}
	}
}
