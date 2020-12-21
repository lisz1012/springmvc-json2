package com.lisz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class UploadController {

	// 要确保 commons-fileupload 和 commons-io 这两个依赖在pom文件中:
	/* <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	        <property name="defaultEncoding" value="UTF-8" />
	        <property name="maxUploadSize" value="1024000" />
	   </bean>
	*/
	// 并且这两个要加入 Project Structure -> Artifact -> output Layout 的lib：
	// add Copy of -> Library Files
	// 用户上传大文件中间关闭浏览器，可能直接受到文件的一部分
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile multipartFile, @RequestParam(value = "note", required = false) String note) throws Exception{ //前端提交上来的会封装到
		if (!multipartFile.isEmpty()) { // 防止下面的NPE
			System.out.println(note);
			System.out.println(multipartFile.getName());
			multipartFile.transferTo(new File("/Users/shuzheng/IdeaProjects/springmvc-json2/web/uploads/" + multipartFile.getOriginalFilename()));
		}
		return "success";
	}

	@RequestMapping("/uploadMultipleFiles")
	public String upload(@RequestParam("file") MultipartFile[] multipartFiles, @RequestParam(value = "note", required = false) String note) throws Exception{ //前端提交上来的会封装到
		for (MultipartFile multipartFile : multipartFiles) {
			if (!multipartFile.isEmpty()) { // 防止下面的NPE
				System.out.println(note);
				System.out.println(multipartFile.getName());
				multipartFile.transferTo(new File("/Users/shuzheng/IdeaProjects/springmvc-json2/web/uploads/" + multipartFile.getOriginalFilename()));
			}
		}
		return "success";
	}
}
