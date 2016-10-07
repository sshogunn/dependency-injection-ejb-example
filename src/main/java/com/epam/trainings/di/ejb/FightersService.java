package com.epam.trainings.di.ejb;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;

@Stateless
public class FightersService {

    public List<String> fighterNames() {
        return Arrays.asList("Po", "Tigress", "Oogway");
    }
}
