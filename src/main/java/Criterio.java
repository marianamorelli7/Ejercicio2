public enum Criterio {

        ADDRESS ("Address"),
        AGENCY_CODE ("Agency_code"),
        DISTANCE ("Distance");

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
