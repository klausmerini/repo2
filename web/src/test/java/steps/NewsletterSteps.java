package steps;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import funcionalidades.NewsletterFuncionalidade;

public class NewsletterSteps
{
    private NewsletterFuncionalidade newsletterFuncionalidade= new NewsletterFuncionalidade();

    @Entao("^preencho o campo 'Sign up for our newsletter'$")
    public void preencho_o_campo_Sign_up_for_our_newsletter() throws Throwable
    {
        newsletterFuncionalidade.preencheCampoSubscribeNewsletter();
    }

    @E("^clico em Subscribe$")
    public void clico_em_Subscribe() throws Throwable {
        newsletterFuncionalidade.clicaSubscribeBtn();
    }

    @Entao("^site exibe mensagem confirmando inscrição$")
    public void site_exibe_mensagem_confirmando_inscrição() throws Throwable {
      newsletterFuncionalidade.verificaRespostaNewsletter();
    }
}
