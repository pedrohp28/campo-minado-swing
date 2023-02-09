package br.com.pedrohp28.cm.modelo;

import br.com.pedrohp28.cm.excecao.ExplosaoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTeste {

    private Campo campo;

    @BeforeEach
    void iniciarCampo(){
        campo = new Campo(3, 3);
    }
    @Test
    void testeVizinhoRealDistancia1Esquerda(){
        Campo vizinho = new Campo(3, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        Assertions.assertTrue(resultado);
    }
    @Test
    void testeVizinhoRealDistancia1Direita(){
        Campo vizinho = new Campo(3, 4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        Assertions.assertTrue(resultado);
    }
    @Test
    void testeVizinhoRealDistancia1EmCima(){
        Campo vizinho = new Campo(2, 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        Assertions.assertTrue(resultado);
    }
    @Test
    void testeVizinhoRealDistancia1EmBaixo(){
        Campo vizinho = new Campo(4, 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        Assertions.assertTrue(resultado);
    }
    @Test
    void testeVizinhoRealDistancia2(){
        Campo vizinho = new Campo(2, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        Assertions.assertTrue(resultado);
    }
    @Test
    void testeNaoVizinho(){
        Campo vizinho = new Campo(1, 1);
        boolean resultado = campo.adicionarVizinho(vizinho);
        Assertions.assertFalse(resultado);
    }
    @Test
    void testeValorPadraoAtributoMarcacao(){
        Assertions.assertFalse(campo.isMarcado());
    }
    @Test
    void testeAlternarMarcacao(){
        campo.alternarMarcacao();
        Assertions.assertTrue(campo.isMarcado());
    }
    @Test
    void testeAlternarMarcacaoDuasChamados(){
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        Assertions.assertFalse(campo.isMarcado());
    }
    @Test
    void testeAbrirNaoMinadoeNaoMarcado(){
        Assertions.assertTrue(campo.abrir());
    }
    @Test
    void testeAbrirNaoMinadoeMarcado(){
        campo.alternarMarcacao();
        Assertions.assertFalse(campo.abrir());
    }
    @Test
    void testeAbrirMinadoeMarcado(){
        campo.minar();
        campo.alternarMarcacao();
        Assertions.assertFalse(campo.abrir());
    }
    @Test
    void testeAbrirMinadoeNaoMarcado(){
        campo.minar();

        Assertions.assertThrows(ExplosaoException.class, () -> {
            campo.abrir();
        });
    }
    @Test
    void testeAbrirComVizinhos(){
        Campo campo11 = new Campo(1,1);
        Campo campo12 = new Campo(1,1);
        campo12.minar();

        Campo campo22 = new Campo(2,2);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        Assertions.assertTrue(campo22.isAberto() && campo11.isFechado());
    }
}
