package radiocare.dao;

import radiocare.model.ManipulateurRadio;

public class ManipulateurRadioDAO extends JsonDAO<ManipulateurRadio,String>{
    public ManipulateurRadioDAO() {
        super("data/manipulateurs.json", ManipulateurRadio.class, ManipulateurRadio::getIdManip);
    }
}
