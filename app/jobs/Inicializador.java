package jobs;

import models.Produto;
import models.Produto;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {
    
    @Override
    public void doJob() throws Exception {
        if (Usuario.count() == 0) {
            Usuario adm = new Usuario();
		    adm.email = "adm@adm.com";
		    adm.senha = "adm";
		    adm.nome = "adm";
		    adm.save();
        }
        if (Produto.count() == 0) {
            Produto agua = new Produto();
		    agua.nome = "Garrafão de água 20L";
		    agua.preco = 7;
			agua.estoqueAgua = 200;

		    agua.save();
		
		    Produto gas = new Produto();
		    gas.nome = "Botijão de gás 13kg";
		    gas.preco = 100;
			gas.estoqueGas = 100;

		    gas.save();
        }
    }
}
