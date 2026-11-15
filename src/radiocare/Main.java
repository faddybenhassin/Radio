package radiocare;

import radiocare.controller.PatientController;
import radiocare.dao.PatientDAO;
import radiocare.service.PatientService;
import radiocare.view.PatientView;

public class Main {
    public static void main(String[] args) {

        // we call all the parts in main and one is passed to the one under it
        PatientDAO dao = new PatientDAO();
        PatientService service = new PatientService(dao);
        PatientController controller = new PatientController(service);
        PatientView view = new PatientView(controller);
    }
}