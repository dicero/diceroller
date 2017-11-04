package com.dicero.diceroller.admin.controller.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
* <p></p>
* @author ningzong.zeng
*/
@Controller
@RequestMapping(value="/manager/message")
public class AdminMessageController {
	Logger logger = LoggerFactory.getLogger(AdminMessageController.class);
	int pageSize = 10;
	
//	@Autowired MessageService messageService;
//	@Autowired IFileUpload iFileUpload;
//
//	@AdminAccess({AdminRole.SUPER_ADMIN})
//	@RequestMapping(value="/list", method=RequestMethod.GET)
//	public String list(@RequestParam(value="page",defaultValue="1") int page, Model model) {
//		Page<Message> messages = messageService.findAll(page - 1, pageSize);
//		model.addAttribute("messages", messages);
//		return "message/list";
//	}
//
//	// 创建
//	@AdminAccess({AdminRole.SUPER_ADMIN})
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String message(Model model) {
//		return "message/operate";
//	}
	
//	// 查看
//	@AdminAccess({AdminRole.SUPER_ADMIN})
//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
//	public String operate(@PathVariable String id, Model model) {
//		Message message = messageService.findById(Long.valueOf(id));
//		model.addAttribute("message", message);
//		return "teacher/operate";
//	}
		
//	// 修改或者新增
//	@AdminAccess({AdminRole.SUPER_ADMIN})
//	@RequestMapping(value="/operate", method=RequestMethod.POST)
//	public String operate(@Valid Teacher teacher, @RequestParam("imgUrlFile") MultipartFile imgUrlFile,
//			BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			model.addAttribute("showStatus", ShowStatus.values());
//			return "teacher/operate";
//		}
//		if(teacher.getId() == null) {
//			if(!imgUrlFile.isEmpty()){
//				String upfile = iFileUpload.upload(imgUrlFile);
//				teacher.setImgUrl(upfile);
//			}
//			if(this.messageService.save(teacher) == null){
//				return "error/500";
//			}
//		} else {
//			if(!imgUrlFile.isEmpty()){
//				String upfile = iFileUpload.upload(imgUrlFile);
//				teacher.setImgUrl(upfile);
//			}
//			if(this.teacherService.update(teacher) == null) {
//				return "error/500";
//			}
//		}
//		return "redirect:/manager/iframe/success";
//	}
	
}
