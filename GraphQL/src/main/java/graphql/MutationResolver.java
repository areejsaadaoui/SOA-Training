package graphql;

import business.ModuleBusiness;
import business.UniteEnseignementBusiness;
import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.UniteEnseignement;

public class MutationResolver implements GraphQLRootResolver {

    private final UniteEnseignementBusiness helper;
    private final ModuleBusiness moduleHelper;

    public MutationResolver() {
        helper = new UniteEnseignementBusiness();
        moduleHelper = new ModuleBusiness();
    }

    public boolean addUniteEnseignement(
            int code,
            String domaine,
            String responsable,
            int credits,
            int semestre
    ) {
        UniteEnseignement ue =
                new UniteEnseignement(code, domaine, responsable, credits, semestre);

        return helper.addUniteEnseignement(ue);
    }

    public boolean deleteUniteEnseignement(int code) {
        return helper.deleteUniteEnseignement(code);
    }

    /**
     * Updates the UE identified by {@code code}.
     * The UE's code is kept unchanged.
     */
    public boolean updateUniteEnseignement(
            int code,
            String domaine,
            String responsable,
            int credits,
            int semestre
    ) {
        UniteEnseignement updatedUE =
                new UniteEnseignement(code, domaine, responsable, credits, semestre);

        return helper.updateUniteEnseignement(code, updatedUE);
    }

    public boolean addModule(
            String matricule,
            String nom,
            int coefficient,
            int volumeHoraire,
            entities.Module.TypeModule type
    ) {
        entities.Module module =
                new entities.Module(matricule, nom, coefficient, volumeHoraire, type);

        return moduleHelper.addModule(module);
    }
}
