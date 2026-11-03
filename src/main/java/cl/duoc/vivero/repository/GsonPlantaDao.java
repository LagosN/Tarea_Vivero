package cl.duoc.vivero.repository;

import cl.duoc.vivero.model.Planta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GsonPlantaDao<T extends Planta> implements PlantaDao<T> {

    private Path archivo;
    private Type tipoLista;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public GsonPlantaDao(String nombre, Class<T> tClass){
        this.archivo = Paths.get(nombre);
        this.tipoLista = TypeToken.getParameterized(List.class,tClass).getType();
    }

    @Override
    public List<T> listar() {
        return List.of();
    }

    @Override
    public void cargar(List<T> plantas) {

    }
}
