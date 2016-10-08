package com.epam.trainings.di.ejb.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;


@Stateless
@LocalBean
public class FightersServiceBean {

    public List<String> getFightersNames() {
        return Arrays.asList("Po", "Tigress", "Monkey", "Ooogway");
    }
}