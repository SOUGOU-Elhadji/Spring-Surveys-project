package com.sarayaspringboot.springbootsurvey.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sarayaspringboot.springbootsurvey.model.Questions;
import com.sarayaspringboot.springbootsurvey.model.Survey;

@Service
public class SurveyService {
	private static List<Survey> surveys = new ArrayList<>();
	private SecureRandom secureRandom = new SecureRandom();
	
	static {
		Questions question1 = new Questions("Question1",
				"Largest country in the world", "Russia",
				Arrays.asList("India","USA","Russia","China"));
		
		Questions question2 = new Questions("Question2",
				"Most populus Country", "China",
				Arrays.asList("India","USA","Russia","China"));
		
		Questions question3 = new Questions("Question3",
				"Highest GOP in the world", "USA",
				Arrays.asList("India","USA","Russia","China"));
		
		Questions question4 = new Questions("Question4",
				"Second largest english speaking", "India",
				Arrays.asList("India","USA","Russia","China"));
		
		
		List<Questions> questions = new ArrayList<>(Arrays
				.asList(question1, question2, question3, question4));
		
		Survey survey = new Survey("Survey1", "The World survey",
				"Survey about the world", questions);
		
		surveys.add(survey);
	}
	
	public List<Survey> retrieveAllSurvey(){
		return surveys;
	}
	
	public Survey retrieveSurveyById(String surveyId) {
		for(Survey survey : surveys) {
			if(survey.getId().equals(surveyId)) {
				return survey;
			}
		}
		return null;
	}
	
	public List<Questions> retrieveQuestions(String surveyId){
		return retrieveSurveyById(surveyId).getQuestions();
	}
	
	public Questions retrieveASingleQuestion(String surveyId, String questionId) {
		for(Questions question : retrieveQuestions(surveyId)) {
			if(question.getId().equals(questionId)) {
				return question;
			}
		}
		return null;
	}
	
	public Questions addQuestion(String surveyId, Questions question) {
		Survey survey = retrieveSurveyById(surveyId);

		if (survey == null) {
			return null;
		}

		String randomId = new BigInteger(130, secureRandom).toString(32);
		question.setId(randomId);

		survey.getQuestions().add(question);

		return question;
	}
}
