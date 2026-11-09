package radiocare.model.enums;

public enum LibelleExamen {
    IRM_CEREBRALE("IRM Cérébrale"),
    SCANNER_THORACIQUE("Scanner Thoracique"),
    ECHO_ABDOMINALE("Echo Abdominale"),
    RX_POUMON("RX Poumon");

    private final String label;

    LibelleExamen(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}