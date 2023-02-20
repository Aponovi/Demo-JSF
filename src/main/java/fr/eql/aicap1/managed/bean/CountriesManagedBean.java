package fr.eql.aicap1.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "mbCountries")
@ViewScoped
public class CountriesManagedBean {
    private List<String> countries = new ArrayList<>();
    private final Map<String, List<String>> citiesByCountry = new HashMap<>();
    private String selectedCountry;
    private String selectedCity;

    /// Getters ///
    public List<String> getCountries() {return countries; }
    public String getSelectedCountry() {return selectedCountry; }
    public String getSelectedCity() {return selectedCity; }

    /// Stetters///
    public void setCountries(List<String> countries) {this.countries = countries; }
    public void setSelectedCountry(String selectedCountry) {this.selectedCountry = selectedCountry; }
    public void setSelectedCity(String selectedCity) {this.selectedCity = selectedCity; }
}
