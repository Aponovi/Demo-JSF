package fr.eql.aicap1.managed.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.*;

@ManagedBean(name = "mbCountries")
@ViewScoped
public class CountriesManagedBean {
    private List<String> countries = new ArrayList<>();
    private final Map<String, List<String>> citiesByCountry = new HashMap<>();
    private String selectedCountry;
    private String selectedCity;

    @PostConstruct
    public void init(){
        Collections.addAll(countries, "France", "USA", "Italia");
        List<String> franceCities = new ArrayList<>();
        List<String> usaCities = new ArrayList<>();
        List<String> italyCities = new ArrayList<>();

        Collections.addAll(franceCities, "Paris", "Cachan", "Lille");
        Collections.addAll(usaCities, "New-York", "Boston", "New Orleans");
        Collections.addAll(franceCities, "Roma", "Venezia", "Napoli");

        citiesByCountry.put("Fance", franceCities);
        citiesByCountry.put("USA", usaCities);
        citiesByCountry.put("Italie", italyCities);
    }
    public List<String> fetchCitiesFromCountry(){
        List<String> cities = new ArrayList<>();
        if (selectedCountry != null && !selectedCountry.equals("")){
            cities = citiesByCountry.get(selectedCountry);
        }
        return cities;
    }

    public void resetSelectedCity(){
        selectedCity = null;

    }

    /// Getters ///
    public List<String> getCountries() {return countries; }
    public String getSelectedCountry() {return selectedCountry; }
    public String getSelectedCity() {return selectedCity; }

    /// Stetters///
    public void setCountries(List<String> countries) {this.countries = countries; }
    public void setSelectedCountry(String selectedCountry) {this.selectedCountry = selectedCountry; }
    public void setSelectedCity(String selectedCity) {this.selectedCity = selectedCity; }
}
