package br.alura.refatoracao.cap1;


public class GeradorDeNotaFiscal {

    public NotaFiscal gera(Fatura fatura) {

        NotaFiscal nf = geraNf(fatura);

        new EnviadorDeEmail().enviaEmail(nf);
        new NFDao().salvaNoBanco(nf);

        return nf;
    }

    private NotaFiscal geraNf(Fatura fatura) {
        double valor = fatura.getValorMensal();
        double imposto = 0;
        if(valor < 200) {
            imposto = valor * 0.03;
        }
        else if(valor > 200 && valor <= 1000) {
            imposto = valor * 0.06;
        }
        else {
            imposto = valor * 0.07;
        }

        NotaFiscal nf = new NotaFiscal(valor, imposto);
        return nf;
    }
}

/* CLASSE REFATORADA UTILIZANDO QUEBRA EM M�TODOS PRIVADOS
public class GeradorDeNotaFiscal {

	public NotaFiscal gera(Fatura fatura) {

		// calcula valor do imposto
		NotaFiscal nf = calculaImposto(fatura);

		// envia email
		enviarEmail(nf);
		
		// salva no banco
		salvarNoBancoDeDados(nf);

		return nf;
	}

	private NotaFiscal calculaImposto(Fatura fatura) {
		double valor = fatura.getValorMensal();
		double imposto = 0;
		if(valor < 200) {
			imposto = valor * 0.03;
		}
		else if(valor > 200 && valor <= 1000) {
			imposto = valor * 0.06;
		}
		else {
			imposto = valor * 0.07;
		}
		
		NotaFiscal nf = new NotaFiscal(valor, imposto);
		return nf;
	}

	private void salvarNoBancoDeDados(NotaFiscal nf) {
		String sql = "insert into notafiscal (cliente, valor)"+
					 "values (?," + nf.getValorLiquido() + ")";
		
		System.out.println("Salvando no banco" + sql);
	}

	private void enviarEmail(NotaFiscal nf) {
		String msgDoEmail = "Caro cliente,<br/>";
		msgDoEmail += "É com prazer que lhe avisamos que sua nota fiscal foi "
				+ "gerada no valor de " + nf.getValorLiquido() + ".<br/>";
		msgDoEmail += "Acesse o site da prefeitura e faça o download.<br/><br/>";
		msgDoEmail += "Obrigado!";
		
		System.out.println(msgDoEmail);
	}
}
*/