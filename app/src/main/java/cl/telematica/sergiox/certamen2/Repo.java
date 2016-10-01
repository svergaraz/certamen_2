package cl.telematica.sergiox.certamen2;

import java.net.URL;

/**
 * Created by Sergiox on 30-09-2016.
 */

public class Repo
{
    private String name;
    private String descripcion;
    private String actualizacion;
    private String url;

    public Repo(String nam, String des, String act, String link){
        name = nam;
        descripcion = des;
        actualizacion = act;
        url = link;
    }

    public String getName(){
        return name;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getActualizacion(){
        return actualizacion;
    }

    public String getUrl(){
        return url;
    }
}
