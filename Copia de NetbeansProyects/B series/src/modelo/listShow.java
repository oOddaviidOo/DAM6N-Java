package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class listShow implements Serializable {
    private ArrayList<show> seriesList;

    public listShow() {
        seriesList = new ArrayList<>();
    }
public show getShow(int p){
    return seriesList.get(p);
}
public void setShow(show s){
    seriesList.add(s);
}      
public int longitud(){
    return seriesList.size();
}
public void eliminar(int p){
        seriesList.remove(p);
    }
public void actualizar(show s, int p){
    //actualizo en la posicion que recibo con el objeto que recibo
    seriesList.get(p).setTitle(s.getTitle());
    seriesList.get(p).setScriptwriter(s.getScriptwriter());
    seriesList.get(p).setSeasons(s.getSeasons());;
    seriesList.get(p).setGenre(s.getGenre());
    seriesList.get(p).setViews(s.getViews());
    
}
}
