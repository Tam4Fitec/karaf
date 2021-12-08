package com.leguide.backoffice.karaf.webservices.wsclient.beans;

import java.util.HashMap;
import java.util.Map;

public class DemandDefinitionBean {

    private Map<Integer, DemandDefinition> mapDemandDefintions;

    private Map<String, CiaoDemandDefinition> mapCiaoDemandDefinitions;

    protected class DemandDefinition {

        private String labelDemande;

        private String caseType;

        private DemandDefinition(String labelDemande, String caseType) {
            this.labelDemande = labelDemande;
            this.caseType = caseType;
        }

        public String getLabelDemande() {
            return labelDemande;
        }

        public String getCaseType() {
            return caseType;
        }
    }

    protected class CiaoDemandDefinition {

        private String labelDemande;

        private String email;

        private CiaoDemandDefinition(String labelDemande, String email) {
            this.labelDemande = labelDemande;
            this.email = email;
        }

        public String getLabelDemande() {
            return labelDemande;
        }

        public String getEmail() {
            return email;
        }
    }

    public void init() {
        // Correspondence table between demand and case type
        mapDemandDefintions = new HashMap<>();
        mapDemandDefintions.put(1, new DemandDefinition("Le référencement prioritaire", null));
        mapDemandDefintions.put(2, new DemandDefinition("Le référencement gratuit", null));
        mapDemandDefintions.put(3, new DemandDefinition("La gestion du compte marchand", null));
        mapDemandDefintions.put(4, new DemandDefinition("La validation d’un site", "Content - Directory Validation"));
        mapDemandDefintions.put(5, new DemandDefinition("L’intégration d’un catalogue", "Content - Feed Integration"));
        mapDemandDefintions.put(6, new DemandDefinition("L’affichage des offres", "Content - Feed"));
        mapDemandDefintions.put(7, new DemandDefinition("La catégorisation de mes offres", "Content - Categorization"));
        mapDemandDefintions.put(8, new DemandDefinition("Les bons plans et newsletters", null));
        mapDemandDefintions.put(9, new DemandDefinition("La facturation ou le budget", null));
        mapDemandDefintions.put(10, new DemandDefinition("Autre", null));
        mapDemandDefintions.put(11, new DemandDefinition("Ciao", null));
        mapDemandDefintions.put(12, new DemandDefinition("Ajout réf. prio", null));

        // Correspondance for Ciao labels
        mapCiaoDemandDefinitions = new HashMap<>();
        mapCiaoDemandDefinitions.put("fr", new CiaoDemandDefinition("Réponse à un avis client sur Ciao", "ciaosufr@ciao.leguide.com"));
        mapCiaoDemandDefinitions.put("dk", new CiaoDemandDefinition("Svar på en kundeanmeldelse på Ciao", "ciaosudk@ciao.leguide.com"));
        mapCiaoDemandDefinitions.put("de", new CiaoDemandDefinition("Beantworten Sie hier einen Erfahrungsbericht auf Ciao!", "ciaosude@ciao.leguide.com"));
        mapCiaoDemandDefinitions.put("gb", new CiaoDemandDefinition("Respond to a comment on Ciao", "ciaosuen@ciao.leguide.com"));
        mapCiaoDemandDefinitions.put("es", new CiaoDemandDefinition("Respuesta a un comentario de un cliente en CIAO", "ciaosues@ciao.leguide.com"));
        mapCiaoDemandDefinitions.put("it", new CiaoDemandDefinition("Rispondi ad una recensione su Ciao", "ciaosuit@ciao.leguide.com"));
        mapCiaoDemandDefinitions.put("nl", new CiaoDemandDefinition("Reageer op een beoordeling op Ciao", "ciaosunl@ciao.leguide.com"));
        mapCiaoDemandDefinitions.put("pl", new CiaoDemandDefinition("Odpowiedź na opinię klienta na Ciao", "ciaosupl@ciao.leguide.com"));
        mapCiaoDemandDefinitions.put("se", new CiaoDemandDefinition("Svar på en kundrecension på Ciao", "ciaosuse@ciao.leguide.com"));
    }

    public DemandDefinition getDemandDefinition(int numDemande) {
        return mapDemandDefintions.get(numDemande);
    }

    public CiaoDemandDefinition getCiaoDemandDefinition(String country) {
        return mapCiaoDemandDefinitions.get(country);
    }
}
