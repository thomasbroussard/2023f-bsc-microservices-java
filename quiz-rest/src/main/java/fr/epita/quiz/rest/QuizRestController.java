package fr.epita.quiz.rest;

import fr.epita.quiz.rest.dto.QuestionChoiceDTO;
import fr.epita.quiz.services.DataAccessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/quiz/v1")
public class QuizRestController {

    DataAccessService dataAccessService;

    @PostMapping(path = "/question", consumes = "application/json")
    public void saveQuestionAndChoices(QuestionChoiceDTO questionChoiceDTO) {
        //validate that we have all the required information

        //map to Question and Choices datamodel
        //use a mapper service
        dataAccessService.saveQuestion();

    }


}
