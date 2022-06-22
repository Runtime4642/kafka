package simple.kafka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import simple.kafka.config.MessageSender;

@RestController
public class KafkaController {
    private final MessageSender messageSender;
    
    @Autowired
    public KafkaController(MessageSender messageSender) {
    	this.messageSender = messageSender;
    }
    
    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
    	//"test-kafka" 이 부분은 저번 실습에서 정한 Topic명으로
    	messageSender.send("test-kafka", message);
        return "success";
    }
    
    @GetMapping("/test")
    public String test() {
    	//"test-kafka" 이 부분은 저번 실습에서 정한 Topic명으로
    	return "hi";
    }
}