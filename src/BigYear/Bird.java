package BigYear;

public class Bird {
    private String english;
    private String latin;
    private int observed;

    public Bird(String english, String latin){
        this.english = english;
        this.latin = latin;
        this.observed = 0;
    }

    public String getEnglish(){
        return english;
    }

    public String getLatin(){
        return latin;
    }

    public int getObserved(){
        return observed;
    }

    public void addObservation(){
        observed++;
    }

    @Override
    public String toString(){
        return String.format("%s (%s): %d observations", english, latin, observed);
    }
}
