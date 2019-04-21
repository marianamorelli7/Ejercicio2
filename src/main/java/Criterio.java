public enum Criterio {

        ADDRESS_LINE ("address_line"),
        AGENCY_CODE ("agency_code"),
        DISTANCE ("distance");

        private String criterio;

        Criterio(String criterio){
            this.criterio = criterio;
        }

        public String getCriterio() {
            return criterio;
        }

        public void setCriterio(String criterio) {
            this.criterio = criterio;
        }

}
