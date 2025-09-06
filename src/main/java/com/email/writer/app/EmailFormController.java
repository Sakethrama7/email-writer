package com.email.writer.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class EmailFormController {

    private final EmailGeneratorService emailGeneratorService;

    @GetMapping("/generate")
    public String showForm(Model model) {
        // This method shows the form initially with no generated reply.
        return "index";
    }

    @PostMapping("/generate-form")
    public String generateEmailFromForm(
            @RequestParam("emailContent") String emailContent,
            @RequestParam(value = "tone", required = false) String tone,
            Model model
    ) {
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setEmailContent(emailContent);
        emailRequest.setTone(tone);

        String generatedReply = emailGeneratorService.generateEmailReply(emailRequest);
        model.addAttribute("generatedReply", generatedReply);

        // This returns the same page but now with the 'generatedReply' variable populated.
        return "index";
    }

    @GetMapping("/home")
    public String homePage(){
        return "home";
    }
}


