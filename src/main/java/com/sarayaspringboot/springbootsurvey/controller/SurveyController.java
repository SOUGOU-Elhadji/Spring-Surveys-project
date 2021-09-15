package com.sarayaspringboot.springbootsurvey.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sarayaspringboot.springbootsurvey.model.Questions;
import com.sarayaspringboot.springbootsurvey.service.SurveyService;

@RestController
public class SurveyController {
	
	@Autowired
	SurveyService surveyService;
	
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Questions> questionBySurvey(@PathVariable String surveyId){
		return surveyService.retrieveQuestions(surveyId);
	}
	
	@PostMapping("/surveys/{surveyId}/questions")
    ResponseEntity<?> add(@PathVariable String surveyId, @RequestBody Questions question) {

        Questions created = surveyService.addQuestion(surveyId, question);

        if (created == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
