package radiocare.dao;

import radiocare.model.EquipementImagerie;

public class EquipementImagerieDAO extends JsonDAO<EquipementImagerie,String>{
    public EquipementImagerieDAO() {
        super("data/equipements.json", EquipementImagerie.class, EquipementImagerie::getIdEquipement);
    }
}
