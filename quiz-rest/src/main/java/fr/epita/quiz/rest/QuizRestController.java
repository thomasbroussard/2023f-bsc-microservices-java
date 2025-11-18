package fr.epita.quiz.rest;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.rest.dto.ChoiceDTO;
import fr.epita.quiz.rest.dto.QuestionChoiceDTO;
import fr.epita.quiz.services.DataAccessService;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping("/quiz/v1")
public class QuizRestController {

    DataAccessService dataAccessService;

    @PostMapping(path = "/question", consumes = "application/json")
    public void saveQuestionAndChoices(QuestionChoiceDTO questionChoiceDTO) {
        //validate that we have all the required information

        //map to Question and Choices datamodel
        String questionTitle = questionChoiceDTO.getQuestion();
        Question question = new Question();
        question.setTitle(questionTitle);
        question.setId(questionChoiceDTO.getQuestionId());

        Set<MCQChoice> choices = new LinkedHashSet<>();
        for (ChoiceDTO choiceDTO : questionChoiceDTO.getChoices()) {
            MCQChoice choice = new MCQChoice();
            choice.setId(choiceDTO.getId());
            choice.setOption(choiceDTO.getChoiceTitle());
            choice.setQuestion(question);
            choices.add(choice);
        }



        //use a mapper service
        dataAccessService.saveQuestion(question, choices);

    }

    @GetMapping("/question/{id}")
    public QuestionChoiceDTO getQuestionAndChoices(@PathVariable Integer id) {

        Question question = new Question();
        question.setId(id);
        Set<MCQChoice> choices = dataAccessService.getChoices(question);

        return new QuestionChoiceDTO();
    }






}
