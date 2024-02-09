package assignment2;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

//output the previous guesses
//compare current guess with history and prevents them from entering the same guess

public class History {

    SortedMap<String, String> Hist;

    public History(){
        Hist = new TreeMap<>();
    }

    public void addToHistory(String guessWord, String GYArray){
        Hist.put(guessWord, GYArray);

    }
    public boolean inMap(String guessCheck) {
       // Iterator i = Hist.keySet().iterator();
        if (Hist.containsKey(guessCheck)){
            return true;
        }
        else return false;

    }
}


