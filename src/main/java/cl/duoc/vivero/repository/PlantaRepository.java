package cl.duoc.vivero.repository;

import cl.duoc.vivero.model.Planta;
import cl.duoc.vivero.model.PlantaExterior;
import cl.duoc.vivero.model.PlantaInterior;

import java.util.ArrayList;
import java.util.List;

public class PlantaRepository {
    public final static String ARCHIVO_INTERIORES = "interores.json";
    public static final String ARCHIVO_EXTERIORES = "exteriores.json";
    private final PlantaDao<PlantaInterior> interiorPlantaDao;
    private final PlantaDao<PlantaExterior> exteriorPlantaDao;
    private final List<PlantaInterior> interiorList = new ArrayList<>();
    private final List<PlantaExterior> exteriorList = new ArrayList<>();

    public PlantaRepository(){
        this(new GsonPlantaDao<>(ARCHIVO_INTERIORES, PlantaInterior.class),new GsonPlantaDao<>(ARCHIVO_EXTERIORES, PlantaExterior.class));
    }

    private PlantaRepository(GsonPlantaDao<PlantaInterior> interiorPlantaDao, GsonPlantaDao<PlantaExterior> exteriorPlantaDao){
        this.exteriorPlantaDao = exteriorPlantaDao;
        this.interiorPlantaDao = interiorPlantaDao;
    }

    public void cargar(){
        List<PlantaInterior> interiorLectura = this.interiorPlantaDao.listar();
        this.interiorList.clear();
        this.interiorList.addAll(interiorLectura);
        //TODO: Implementar exterior
    }

    public List<Planta> getList(){
        List<Planta> plantas = new ArrayList<>(this.interiorList);
        plantas.addAll(this.exteriorList);

        return plantas;
    }

    public boolean guardar(Planta planta){
        return false;
    }
}
