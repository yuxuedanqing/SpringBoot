package com.snails.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
@Controller
@RequestMapping("/send")
public class SendMailController {

    @Autowired
    JavaMailSender mailSender;//注入QQ发送邮件的bean

    @PostMapping("/mail")
    @ResponseBody
    public String sendEmail(@RequestParam String qq,String content,String title) throws Exception{
        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        message.setFrom("2062771709@qq.com");//设置发件qq邮箱
        qq+="@qq.com";					//补全地址
        message.setTo(qq);				//设置收件人
        message.setSubject(title);	//设置标题
        message.setText(content,true);  	//第二个参数true表示使用HTML语言来编写邮件
//            FileSystemResource file = new FileSystemResource(
//            File file = new File("图片路径");
//            helper.addAttachment("图片.jpg", file);//添加带附件的邮件
//            helper.addInline("picture",file);//添加带静态资源的邮件
        this.mailSender.send(mimeMessage);
        return "发送成功";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
