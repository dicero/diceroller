package com.dicero.diceroller.core.email;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

/**   
* <p></p>
* @author ningzong.zeng
*/
@Component
@Configurable
public class Email implements IEmail {
//	Logger logger = LoggerFactory.getLogger(Email.class);
//
//	@Autowired
//	private JavaMailSender javaMailSender;
//	
//	@Value("${spring.mail.username}")
//	private String MAIL_FORM = "keguankuailai@sina.com";
//
	@Override
	public void sendText(String toEmail, String subject, String text) {
//		MimeMessage message = javaMailSender.createMimeMessage();
//		MimeMessageHelper helper;
//		try {
//			helper = new MimeMessageHelper(message, true);
//			helper.setFrom(MAIL_FORM);
//			helper.setTo(toEmail);
//			helper.setSubject(subject);
//			helper.setText(text, true); 
//			javaMailSender.send(message);
//		} catch (MessagingException e) {
//			logger.error("sendText error ", e);
//		}
	}

}
