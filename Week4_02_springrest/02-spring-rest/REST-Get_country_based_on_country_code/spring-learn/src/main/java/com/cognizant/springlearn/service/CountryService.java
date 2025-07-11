package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Service
public class CountryService {

  public Country getCountry(String code) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    List<Country> countries = context.getBean("countryList", List.class);

    return countries.stream()
        .filter(c -> c.getCode().equalsIgnoreCase(code))
        .findFirst()
        .orElse(null);
  }
}
