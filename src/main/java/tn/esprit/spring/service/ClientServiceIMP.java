package tn.esprit.spring.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Admin;
import tn.esprit.spring.entity.CategorieStat;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Product.Produit;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.Product.ProduitRepository;


@Service
public class ClientServiceIMP {
	@Autowired
	ClientRepository clientrepository;
	@Autowired
	ProduitRepository produitrepository;
	private JavaMailSender javaMailSender;

	@Autowired
	public ClientServiceIMP(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public List<CategorieStat>  NumCategorie2(){
		return clientrepository.NumCategorie2();
	}

	public Client authenticateClient(String login, String password,Boolean enabled) {
		 enabled=true;
		return clientrepository.getClientByUser_nameAndPassword(login, password,enabled);
	}

	public List<Client> findOne() {
		return clientrepository.findAll();
	}
	@Transactional
	public void actif(long id){
	Client c=clientrepository.findById(id).get();
	c.setEnabled(true);
	clientrepository.save(c);
	}
	@Transactional
	public void block(long id){
		Client c=clientrepository.findById(id).get();
		c.setEnabled(false);
		clientrepository.save(c);
		}

	public Client save(Client u) {
		u.setEnabled(true);
		u.setInteret("informatique");
		return clientrepository.save(u);
	}
	public Client getPassword(String email)throws MailException, MessagingException{
		Client c=clientrepository.getPassword(email);
		c.getEncrytedPassword();
		SimpleMailMessage mail = new SimpleMailMessage();
        
		////*******************************/////
		StringBuilder buf = new StringBuilder();
		buf.append("\"<html>\n" + "  <head>\n" + "    <meta name=\"viewport\" content=\"width=device-width\" />\n"
				+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
				+ "    <title>Simple Transactional Email</title>\n" + "    <style>\n"
				+ "      /* -------------------------------------\n" + "          GLOBAL RESETS\n"
				+ "      ------------------------------------- */\n" + "      \n"
				+ "      /*All the styling goes here*/\n" + "      \n" + "      img {\n" + "        border: none;\n"
				+ "        -ms-interpolation-mode: bicubic;\n" + "        max-width: 100%; \n" + "      }\n" + "\n"
				+ "      body {\n" + "        background-color: #f6f6f6;\n" + "        font-family: sans-serif;\n"
				+ "        -webkit-font-smoothing: antialiased;\n" + "        font-size: 14px;\n"
				+ "        line-height: 1.4;\n" + "        margin: 0;\n" + "        padding: 0;\n"
				+ "        -ms-text-size-adjust: 100%;\n" + "        -webkit-text-size-adjust: 100%; \n" + "      }\n"
				+ "\n" + "      table {\n" + "        border-collapse: separate;\n" + "        mso-table-lspace: 0pt;\n"
				+ "        mso-table-rspace: 0pt;\n" + "        width: 100%; }\n" + "        table td {\n"
				+ "          font-family: sans-serif;\n" + "          font-size: 14px;\n"
				+ "          vertical-align: top; \n" + "      }\n" + "\n"
				+ "      /* -------------------------------------\n" + "          BODY & CONTAINER\n"
				+ "      ------------------------------------- */\n" + "\n" + "      .body {\n"
				+ "        background-color: #f6f6f6;\n" + "        width: 100%; \n" + "      }\n" + "\n"
				+ "      /* Set a max-width, and make it display as block so it will automatically stretch to that width, but will also shrink down on a phone or something */\n"
				+ "      .container {\n" + "        display: block;\n" + "        margin: 0 auto !important;\n"
				+ "        /* makes it centered */\n" + "        max-width: 580px;\n" + "        padding: 10px;\n"
				+ "        width: 580px; \n" + "      }\n" + "\n"
				+ "      /* This should also be a block element, so that it will fill 100% of the .container */\n"
				+ "      .content {\n" + "        box-sizing: border-box;\n" + "        display: block;\n"
				+ "        margin: 0 auto;\n" + "        max-width: 580px;\n" + "        padding: 10px; \n"
				+ "      }\n" + "\n" + "      /* -------------------------------------\n"
				+ "          HEADER, FOOTER, MAIN\n" + "      ------------------------------------- */\n"
				+ "      .main {\n" + "        background: #ffffff;\n" + "        border-radius: 3px;\n"
				+ "        width: 100%; \n" + "      }\n" + "\n" + "      .wrapper {\n"
				+ "        box-sizing: border-box;\n" + "        padding: 20px; \n" + "      }\n" + "\n"
				+ "      .content-block {\n" + "        padding-bottom: 10px;\n" + "        padding-top: 10px;\n"
				+ "      }\n" + "\n" + "      .footer {\n" + "        clear: both;\n" + "        margin-top: 10px;\n"
				+ "        text-align: center;\n" + "        width: 100%; \n" + "      }\n" + "        .footer td,\n"
				+ "        .footer p,\n" + "        .footer span,\n" + "        .footer a {\n"
				+ "          color: #999999;\n" + "          font-size: 12px;\n" + "          text-align: center; \n"
				+ "      }\n" + "\n" + "      /* -------------------------------------\n" + "          TYPOGRAPHY\n"
				+ "      ------------------------------------- */\n" + "      h1,\n" + "      h2,\n" + "      h3,\n"
				+ "      h4 {\n" + "        color: #000000;\n" + "        font-family: sans-serif;\n"
				+ "        font-weight: 400;\n" + "        line-height: 1.4;\n" + "        margin: 0;\n"
				+ "        margin-bottom: 30px; \n" + "      }\n" + "\n" + "      h1 {\n" + "        font-size: 35px;\n"
				+ "        font-weight: 300;\n" + "        text-align: center;\n"
				+ "        text-transform: capitalize; \n" + "      }\n" + "\n" + "      p,\n" + "      ul,\n"
				+ "      ol {\n" + "        font-family: sans-serif;\n" + "        font-size: 14px;\n"
				+ "        font-weight: normal;\n" + "        margin: 0;\n" + "        margin-bottom: 15px; \n"
				+ "      }\n" + "        p li,\n" + "        ul li,\n" + "        ol li {\n"
				+ "          list-style-position: inside;\n" + "          margin-left: 5px; \n" + "      }\n" + "\n"
				+ "      a {\n" + "        color: #3498db;\n" + "        text-decoration: underline; \n" + "      }\n"
				+ "\n" + "      /* -------------------------------------\n" + "          BUTTONS\n"
				+ "      ------------------------------------- */\n" + "      .btn {\n"
				+ "        box-sizing: border-box;\n" + "        width: 100%; }\n"
				+ "        .btn > tbody > tr > td {\n" + "          padding-bottom: 15px; }\n"
				+ "        .btn table {\n" + "          width: auto; \n" + "      }\n" + "        .btn table td {\n"
				+ "          background-color: #ffffff;\n" + "          border-radius: 5px;\n"
				+ "          text-align: center; \n" + "      }\n" + "        .btn a {\n"
				+ "          background-color: #ffffff;\n" + "          border: solid 1px #3498db;\n"
				+ "          border-radius: 5px;\n" + "          box-sizing: border-box;\n"
				+ "          color: #3498db;\n" + "          cursor: pointer;\n" + "          display: inline-block;\n"
				+ "          font-size: 14px;\n" + "          font-weight: bold;\n" + "          margin: 0;\n"
				+ "          padding: 12px 25px;\n" + "          text-decoration: none;\n"
				+ "          text-transform: capitalize; \n" + "      }\n" + "\n" + "      .btn-primary table td {\n"
				+ "        background-color: #3498db; \n" + "      }\n" + "\n" + "      .btn-primary a {\n"
				+ "        background-color: #3498db;\n" + "        border-color: #3498db;\n"
				+ "        color: #ffffff; \n" + "      }\n" + "\n" + "      /* -------------------------------------\n"
				+ "          OTHER STYLES THAT MIGHT BE USEFUL\n" + "      ------------------------------------- */\n"
				+ "      .last {\n" + "        margin-bottom: 0; \n" + "      }\n" + "\n" + "      .first {\n"
				+ "        margin-top: 0; \n" + "      }\n" + "\n" + "      .align-center {\n"
				+ "        text-align: center; \n" + "      }\n" + "\n" + "      .align-right {\n"
				+ "        text-align: right; \n" + "      }\n" + "\n" + "      .align-left {\n"
				+ "        text-align: left; \n" + "      }\n" + "\n" + "      .clear {\n" + "        clear: both; \n"
				+ "      }\n" + "\n" + "      .mt0 {\n" + "        margin-top: 0; \n" + "      }\n" + "\n"
				+ "      .mb0 {\n" + "        margin-bottom: 0; \n" + "      }\n" + "\n" + "      .preheader {\n"
				+ "        color: transparent;\n" + "        display: none;\n" + "        height: 0;\n"
				+ "        max-height: 0;\n" + "        max-width: 0;\n" + "        opacity: 0;\n"
				+ "        overflow: hidden;\n" + "        mso-hide: all;\n" + "        visibility: hidden;\n"
				+ "        width: 0; \n" + "      }\n" + "\n" + "      .powered-by a {\n"
				+ "        text-decoration: none; \n" + "      }\n" + "\n" + "      hr {\n" + "        border: 0;\n"
				+ "        border-bottom: 1px solid #f6f6f6;\n" + "        margin: 20px 0; \n" + "      }\n" + "\n"
				+ "      /* -------------------------------------\n"
				+ "          RESPONSIVE AND MOBILE FRIENDLY STYLES\n"
				+ "      ------------------------------------- */\n"
				+ "      @media only screen and (max-width: 620px) {\n" + "        table[class=body] h1 {\n"
				+ "          font-size: 28px !important;\n" + "          margin-bottom: 10px !important; \n"
				+ "        }\n" + "        table[class=body] p,\n" + "        table[class=body] ul,\n"
				+ "        table[class=body] ol,\n" + "        table[class=body] td,\n"
				+ "        table[class=body] span,\n" + "        table[class=body] a {\n"
				+ "          font-size: 16px !important; \n" + "        }\n" + "        table[class=body] .wrapper,\n"
				+ "        table[class=body] .article {\n" + "          padding: 10px !important; \n" + "        }\n"
				+ "        table[class=body] .content {\n" + "          padding: 0 !important; \n" + "        }\n"
				+ "        table[class=body] .container {\n" + "          padding: 0 !important;\n"
				+ "          width: 100% !important; \n" + "        }\n" + "        table[class=body] .main {\n"
				+ "          border-left-width: 0 !important;\n" + "          border-radius: 0 !important;\n"
				+ "          border-right-width: 0 !important; \n" + "        }\n"
				+ "        table[class=body] .btn table {\n" + "          width: 100% !important; \n" + "        }\n"
				+ "        table[class=body] .btn a {\n" + "          width: 100% !important; \n" + "        }\n"
				+ "        table[class=body] .img-responsive {\n" + "          height: auto !important;\n"
				+ "          max-width: 100% !important;\n" + "          width: auto !important; \n" + "        }\n"
				+ "      }\n" + "\n" + "      /* -------------------------------------\n"
				+ "          PRESERVE THESE STYLES IN THE HEAD\n" + "      ------------------------------------- */\n"
				+ "      @media all {\n" + "        .ExternalClass {\n" + "          width: 100%; \n" + "        }\n"
				+ "        .ExternalClass,\n" + "        .ExternalClass p,\n" + "        .ExternalClass span,\n"
				+ "        .ExternalClass font,\n" + "        .ExternalClass td,\n" + "        .ExternalClass div {\n"
				+ "          line-height: 100%; \n" + "        }\n" + "        .apple-link a {\n"
				+ "          color: inherit !important;\n" + "          font-family: inherit !important;\n"
				+ "          font-size: inherit !important;\n" + "          font-weight: inherit !important;\n"
				+ "          line-height: inherit !important;\n" + "          text-decoration: none !important; \n"
				+ "        }\n" + "        #MessageViewBody a {\n" + "          color: inherit;\n"
				+ "          text-decoration: none;\n" + "          font-size: inherit;\n"
				+ "          font-family: inherit;\n" + "          font-weight: inherit;\n"
				+ "          line-height: inherit;\n" + "        }\n" + "        .btn-primary table td:hover {\n"
				+ "          background-color: #34495e !important; \n" + "        }\n"
				+ "        .btn-primary a:hover {\n" + "          background-color: #34495e !important;\n"
				+ "          border-color: #34495e !important; \n" + "        } \n" + "      }\n" + "\n"
				+ "    </style>\n" + "  </head>\n" + "  <body class=\"\">\n"
				+ "    <span class=\"preheader\">This is preheader text. Some clients will show this text as a preview.</span>\n"
				+ "    <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"body\">\n"
				+ "      <tr>\n" + "        <td>&nbsp;</td>\n" + "        <td class=\"container\">\n"
				+ "          <div class=\"content\">\n" + "\n" + "            <!-- START CENTERED WHITE CONTAINER -->\n"
				+ "            <table role=\"presentation\" class=\"main\">\n"
				+ "                    <img src=\"https://imgur.com/D5TRtVo\"></a>\n" + "\n"
				
				+ "              <!-- START MAIN CONTENT AREA -->\n" + "              <tr>\n"
				+ "                <td class=\"wrapper\">\n"
				+ "                  <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
				+ "                    <tr>\n" + "                      <td>\n"
				+ "                        <p>Bonjour ,</p>\n"
				+ "                        <p>Merci pour l'utilsation de notre application CONSOMI TOUNSI.</p>\n"
				+ "                        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"btn btn-primary\">\n"
				+ "                          <tbody>\n" + "                            <tr>\n"
				+ "                              <td align=\"left\">\n"
				+ "                                <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
				+ "                                  <tbody>\n" + "                                  </tbody>\n"
				+ "                                </table>\n" + "                              </td>\n"
				+ "                            </tr>\n" + "                          </tbody>\n"
				+ "                        </table>\n" + "                        <p>Vous souvenez-vous ?</p>\n"
				+ "                        <p>Votre Mot de passe :  " + c.getEncrytedPassword() + "</p>\n"
				+ "                        <p>Cordialement.</p>\n"
				+ "                        <p>Bonne Chance! CONSOMI TOUNSI Group.</p>\n" + "                      </td>\n"
				+ "                    </tr>\n" + "                  </table>\n" + "                </td>\n"
				+ "              </tr>\n" + "\n" + "            <!-- END MAIN CONTENT AREA -->\n"
				+ "            </table>\n" + "            <!-- END CENTERED WHITE CONTAINER -->\n" + "\n"
				+ "            <!-- START FOOTER -->\n" + "            <div class=\"footer\">\n"
				+ "              <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
				+ "                <tr>\n" + "                  <td class=\"content-block\">\n"
				+ "                    <span class=\"apple-link\">CONSOMI TOUNSI,El-ghazela, Tunisie</span>\n"
				+ "                  </td>\n" + "                </tr>\n" + "                <tr>\n"
				+ "                  <td class=\"content-block powered-by\">\n"
				+ "                    Powered by <a href=\"http://htmlemail.io\">HTMLemail</a>.\n"
				+ "                  </td>\n" + "                </tr>\n" + "              </table>\n"
				+ "            </div>\n" + "            <!-- END FOOTER -->\n" + "\n" + "          </div>\n"
				+ "        </td>\n" + "        <td>&nbsp;</td>\n" + "      </tr>\n" + "    </table>\n" + "  </body>\n"
				+ "</html>\"");
		String messaage = buf.toString();

		//// ********************************////
		 MimeMessage message = javaMailSender.createMimeMessage();
	      
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	     
	    helper.setTo(c.getEmail());
	     helper.setFrom("consommi.toounsi.619@gmail.com");
	    helper.setSubject("Password");
	    helper.setText(messaage, messaage);
	    //helper.setText(String.format(messaage, true));
	         
	 // FileSystemResource file 
	   //   = new FileSystemResource(new File(pathToAttachment));
	    //helper.addAttachment("Invoice", file);
	 
	    javaMailSender.send(message);

		return c;
	}
	public List<String> findClient_pt_100(int nbpt) {
		return clientrepository.findClient_pt_100(nbpt);

	}

	public Client client_gangant(int nbpt) {
		List<String> kk = clientrepository.findClient_pt_100(nbpt);
		System.out.println("liste client "+kk);
		String delim = ",";
		String res = String.join(delim, kk);
		String motcommentaire1[] = res.split(",");
		int r1 = (int) (Math.random() * (motcommentaire1.length));
		String name1 = motcommentaire1[r1];
		long random = Long.parseLong(name1);
		Client a = clientrepository.findById(random).get();
		
		 a.setNum_carte_fidelity(a.getNum_carte_fidelity()-nbpt);
		 clientrepository.save(a);

		return a;

	}
@Transactional
	public Produit produit_gangant(int nbpt) throws MailException, MessagingException {
		Client a = client_gangant(nbpt);
	
		String w = a.getInteret();

		String motcommentaire[] = w.split(",");
		System.out.println("motcommentaire "+motcommentaire);
		int r = (int) (Math.random() * (motcommentaire.length));
		System.out.println("r "+r);
		String name = motcommentaire[r];
		System.out.println("name "+name);
		List<String> pp = clientrepository.Produit_par_cat(nbpt,name);
		System.out.println("list produit "+pp);
		String delim2 = ",";
		String res2 = String.join(delim2, pp);
		
		String motcommentaire2[] = res2.split(",");
		System.out.println("motcommentaire2 "+motcommentaire2);
		
		int r2 = (int) (Math.random() * (motcommentaire2.length));
		System.out.println("r2 "+r2);
		String name2 = motcommentaire2[r2];
		System.out.println("name2220 "+name2);
		 try {
			 System.out.println("name2221 "+name2);
			 int random2 = Integer.parseInt(name2);
			 Produit p1 = produitrepository.findById(random2).get();
	
			
		  
		
//		 int random2 = Integer.parseInt(name2);
//		Produit p1 = produitrepository.findById(random2).get();
		
		//////////// mail
		SimpleMailMessage mail = new SimpleMailMessage();
                                                         
		////*******************************/////
		StringBuilder buf = new StringBuilder();
		buf.append("\"<html>\n" + "  <head>\n" + "    <meta name=\"viewport\" content=\"width=device-width\" />\n"
				+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
				+ "    <title>Simple Transactional Email</title>\n" + "    <style>\n"
				+ "      /* -------------------------------------\n" + "          GLOBAL RESETS\n"
				+ "      ------------------------------------- */\n" + "      \n"
				+ "      /*All the styling goes here*/\n" + "      \n" + "      img {\n" + "        border: none;\n"
				+ "        -ms-interpolation-mode: bicubic;\n" + "        max-width: 100%; \n" + "      }\n" + "\n"
				+ "      body {\n" + "        background-color: #f6f6f6;\n" + "        font-family: sans-serif;\n"
				+ "        -webkit-font-smoothing: antialiased;\n" + "        font-size: 14px;\n"
				+ "        line-height: 1.4;\n" + "        margin: 0;\n" + "        padding: 0;\n"
				+ "        -ms-text-size-adjust: 100%;\n" + "        -webkit-text-size-adjust: 100%; \n" + "      }\n"
				+ "\n" + "      table {\n" + "        border-collapse: separate;\n" + "        mso-table-lspace: 0pt;\n"
				+ "        mso-table-rspace: 0pt;\n" + "        width: 100%; }\n" + "        table td {\n"
				+ "          font-family: sans-serif;\n" + "          font-size: 14px;\n"
				+ "          vertical-align: top; \n" + "      }\n" + "\n"
				+ "      /* -------------------------------------\n" + "          BODY & CONTAINER\n"
				+ "      ------------------------------------- */\n" + "\n" + "      .body {\n"
				+ "        background-color: #f6f6f6;\n" + "        width: 100%; \n" + "      }\n" + "\n"
				+ "      /* Set a max-width, and make it display as block so it will automatically stretch to that width, but will also shrink down on a phone or something */\n"
				+ "      .container {\n" + "        display: block;\n" + "        margin: 0 auto !important;\n"
				+ "        /* makes it centered */\n" + "        max-width: 580px;\n" + "        padding: 10px;\n"
				+ "        width: 580px; \n" + "      }\n" + "\n"
				+ "      /* This should also be a block element, so that it will fill 100% of the .container */\n"
				+ "      .content {\n" + "        box-sizing: border-box;\n" + "        display: block;\n"
				+ "        margin: 0 auto;\n" + "        max-width: 580px;\n" + "        padding: 10px; \n"
				+ "      }\n" + "\n" + "      /* -------------------------------------\n"
				+ "          HEADER, FOOTER, MAIN\n" + "      ------------------------------------- */\n"
				+ "      .main {\n" + "        background: #ffffff;\n" + "        border-radius: 3px;\n"
				+ "        width: 100%; \n" + "      }\n" + "\n" + "      .wrapper {\n"
				+ "        box-sizing: border-box;\n" + "        padding: 20px; \n" + "      }\n" + "\n"
				+ "      .content-block {\n" + "        padding-bottom: 10px;\n" + "        padding-top: 10px;\n"
				+ "      }\n" + "\n" + "      .footer {\n" + "        clear: both;\n" + "        margin-top: 10px;\n"
				+ "        text-align: center;\n" + "        width: 100%; \n" + "      }\n" + "        .footer td,\n"
				+ "        .footer p,\n" + "        .footer span,\n" + "        .footer a {\n"
				+ "          color: #999999;\n" + "          font-size: 12px;\n" + "          text-align: center; \n"
				+ "      }\n" + "\n" + "      /* -------------------------------------\n" + "          TYPOGRAPHY\n"
				+ "      ------------------------------------- */\n" + "      h1,\n" + "      h2,\n" + "      h3,\n"
				+ "      h4 {\n" + "        color: #000000;\n" + "        font-family: sans-serif;\n"
				+ "        font-weight: 400;\n" + "        line-height: 1.4;\n" + "        margin: 0;\n"
				+ "        margin-bottom: 30px; \n" + "      }\n" + "\n" + "      h1 {\n" + "        font-size: 35px;\n"
				+ "        font-weight: 300;\n" + "        text-align: center;\n"
				+ "        text-transform: capitalize; \n" + "      }\n" + "\n" + "      p,\n" + "      ul,\n"
				+ "      ol {\n" + "        font-family: sans-serif;\n" + "        font-size: 14px;\n"
				+ "        font-weight: normal;\n" + "        margin: 0;\n" + "        margin-bottom: 15px; \n"
				+ "      }\n" + "        p li,\n" + "        ul li,\n" + "        ol li {\n"
				+ "          list-style-position: inside;\n" + "          margin-left: 5px; \n" + "      }\n" + "\n"
				+ "      a {\n" + "        color: #3498db;\n" + "        text-decoration: underline; \n" + "      }\n"
				+ "\n" + "      /* -------------------------------------\n" + "          BUTTONS\n"
				+ "      ------------------------------------- */\n" + "      .btn {\n"
				+ "        box-sizing: border-box;\n" + "        width: 100%; }\n"
				+ "        .btn > tbody > tr > td {\n" + "          padding-bottom: 15px; }\n"
				+ "        .btn table {\n" + "          width: auto; \n" + "      }\n" + "        .btn table td {\n"
				+ "          background-color: #ffffff;\n" + "          border-radius: 5px;\n"
				+ "          text-align: center; \n" + "      }\n" + "        .btn a {\n"
				+ "          background-color: #ffffff;\n" + "          border: solid 1px #3498db;\n"
				+ "          border-radius: 5px;\n" + "          box-sizing: border-box;\n"
				+ "          color: #3498db;\n" + "          cursor: pointer;\n" + "          display: inline-block;\n"
				+ "          font-size: 14px;\n" + "          font-weight: bold;\n" + "          margin: 0;\n"
				+ "          padding: 12px 25px;\n" + "          text-decoration: none;\n"
				+ "          text-transform: capitalize; \n" + "      }\n" + "\n" + "      .btn-primary table td {\n"
				+ "        background-color: #3498db; \n" + "      }\n" + "\n" + "      .btn-primary a {\n"
				+ "        background-color: #3498db;\n" + "        border-color: #3498db;\n"
				+ "        color: #ffffff; \n" + "      }\n" + "\n" + "      /* -------------------------------------\n"
				+ "          OTHER STYLES THAT MIGHT BE USEFUL\n" + "      ------------------------------------- */\n"
				+ "      .last {\n" + "        margin-bottom: 0; \n" + "      }\n" + "\n" + "      .first {\n"
				+ "        margin-top: 0; \n" + "      }\n" + "\n" + "      .align-center {\n"
				+ "        text-align: center; \n" + "      }\n" + "\n" + "      .align-right {\n"
				+ "        text-align: right; \n" + "      }\n" + "\n" + "      .align-left {\n"
				+ "        text-align: left; \n" + "      }\n" + "\n" + "      .clear {\n" + "        clear: both; \n"
				+ "      }\n" + "\n" + "      .mt0 {\n" + "        margin-top: 0; \n" + "      }\n" + "\n"
				+ "      .mb0 {\n" + "        margin-bottom: 0; \n" + "      }\n" + "\n" + "      .preheader {\n"
				+ "        color: transparent;\n" + "        display: none;\n" + "        height: 0;\n"
				+ "        max-height: 0;\n" + "        max-width: 0;\n" + "        opacity: 0;\n"
				+ "        overflow: hidden;\n" + "        mso-hide: all;\n" + "        visibility: hidden;\n"
				+ "        width: 0; \n" + "      }\n" + "\n" + "      .powered-by a {\n"
				+ "        text-decoration: none; \n" + "      }\n" + "\n" + "      hr {\n" + "        border: 0;\n"
				+ "        border-bottom: 1px solid #f6f6f6;\n" + "        margin: 20px 0; \n" + "      }\n" + "\n"
				+ "      /* -------------------------------------\n"
				+ "          RESPONSIVE AND MOBILE FRIENDLY STYLES\n"
				+ "      ------------------------------------- */\n"
				+ "      @media only screen and (max-width: 620px) {\n" + "        table[class=body] h1 {\n"
				+ "          font-size: 28px !important;\n" + "          margin-bottom: 10px !important; \n"
				+ "        }\n" + "        table[class=body] p,\n" + "        table[class=body] ul,\n"
				+ "        table[class=body] ol,\n" + "        table[class=body] td,\n"
				+ "        table[class=body] span,\n" + "        table[class=body] a {\n"
				+ "          font-size: 16px !important; \n" + "        }\n" + "        table[class=body] .wrapper,\n"
				+ "        table[class=body] .article {\n" + "          padding: 10px !important; \n" + "        }\n"
				+ "        table[class=body] .content {\n" + "          padding: 0 !important; \n" + "        }\n"
				+ "        table[class=body] .container {\n" + "          padding: 0 !important;\n"
				+ "          width: 100% !important; \n" + "        }\n" + "        table[class=body] .main {\n"
				+ "          border-left-width: 0 !important;\n" + "          border-radius: 0 !important;\n"
				+ "          border-right-width: 0 !important; \n" + "        }\n"
				+ "        table[class=body] .btn table {\n" + "          width: 100% !important; \n" + "        }\n"
				+ "        table[class=body] .btn a {\n" + "          width: 100% !important; \n" + "        }\n"
				+ "        table[class=body] .img-responsive {\n" + "          height: auto !important;\n"
				+ "          max-width: 100% !important;\n" + "          width: auto !important; \n" + "        }\n"
				+ "      }\n" + "\n" + "      /* -------------------------------------\n"
				+ "          PRESERVE THESE STYLES IN THE HEAD\n" + "      ------------------------------------- */\n"
				+ "      @media all {\n" + "        .ExternalClass {\n" + "          width: 100%; \n" + "        }\n"
				+ "        .ExternalClass,\n" + "        .ExternalClass p,\n" + "        .ExternalClass span,\n"
				+ "        .ExternalClass font,\n" + "        .ExternalClass td,\n" + "        .ExternalClass div {\n"
				+ "          line-height: 100%; \n" + "        }\n" + "        .apple-link a {\n"
				+ "          color: inherit !important;\n" + "          font-family: inherit !important;\n"
				+ "          font-size: inherit !important;\n" + "          font-weight: inherit !important;\n"
				+ "          line-height: inherit !important;\n" + "          text-decoration: none !important; \n"
				+ "        }\n" + "        #MessageViewBody a {\n" + "          color: inherit;\n"
				+ "          text-decoration: none;\n" + "          font-size: inherit;\n"
				+ "          font-family: inherit;\n" + "          font-weight: inherit;\n"
				+ "          line-height: inherit;\n" + "        }\n" + "        .btn-primary table td:hover {\n"
				+ "          background-color: #34495e !important; \n" + "        }\n"
				+ "        .btn-primary a:hover {\n" + "          background-color: #34495e !important;\n"
				+ "          border-color: #34495e !important; \n" + "        } \n" + "      }\n" + "\n"
				+ "    </style>\n" + "  </head>\n" + "  <body class=\"\">\n"
				+ "    <span class=\"preheader\">This is preheader text. Some clients will show this text as a preview.</span>\n"
				+ "    <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"body\">\n"
				+ "      <tr>\n" + "        <td>&nbsp;</td>\n" + "        <td class=\"container\">\n"
				+ "          <div class=\"content\">\n" + "\n" + "            <!-- START CENTERED WHITE CONTAINER -->\n"
				+ "            <table role=\"presentation\" class=\"main\">\n"
				+ "                    <img src=\"https://imgur.com/D5TRtVo\"></a>\n" + "\n"
				
				+ "              <!-- START MAIN CONTENT AREA -->\n" + "              <tr>\n"
				+ "                <td class=\"wrapper\">\n"
				+ "                  <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
				+ "                    <tr>\n" + "                      <td>\n"
				+ "                        <p>Bonjour ,</p>\n"
				+ "                        <p>Merci pour l'utilsation de notre application CONSOMI TOUNSI.</p>\n"
				+ "                        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"btn btn-primary\">\n"
				+ "                          <tbody>\n" + "                            <tr>\n"
				+ "                              <td align=\"left\">\n"
				+ "                                <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
				+ "                                  <tbody>\n" + "                                  </tbody>\n"
				+ "                                </table>\n" + "                              </td>\n"
				+ "                            </tr>\n" + "                          </tbody>\n"
				+ "                        </table>\n" + "                        <p>Vous souvenez-vous ?</p>\n"
				+ "                        <p>Vous aussi, vous avez participé à notre grand jeu. Et vous avez bien fait !</p>\n"
				+ "                        <p>Nous avons maintenant le plaisir et l'honneur de vous annoncer que vous avez gagné le grand cadeau qui est, "
				+ p1.getNom() + " d'une valeur de " + p1.getPrixAchat() + " dinar tunisien</p>\n"
				+ "                        <p>Vous pourrez retirer votre cadeau au magasin à l'aide du bon ci-joint.</p>\n"
				+ "                      <h5>Nom Prénom " + a.getNom() +"  "+a.getPrenom()+"</h5>"
				+ "                        <p>Cordialement.</p>\n"
				+ "                        <p>Bonne Chance! CONSOMI TOUNSI Group.</p>\n" + "                      </td>\n"
				+ "                    </tr>\n" + "                  </table>\n" + "                </td>\n"
				+ "              </tr>\n" + "\n" + "            <!-- END MAIN CONTENT AREA -->\n"
				+ "            </table>\n" + "            <!-- END CENTERED WHITE CONTAINER -->\n" + "\n"
				+ "            <!-- START FOOTER -->\n" + "            <div class=\"footer\">\n"
				+ "              <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
				+ "                <tr>\n" + "                  <td class=\"content-block\">\n"
				+ "                    <span class=\"apple-link\">CONSOMI TOUNSI,El-ghazela, Tunisie</span>\n"
				+ "                  </td>\n" + "                </tr>\n" + "                <tr>\n"
				+ "                  <td class=\"content-block powered-by\">\n"
				+ "                    Powered by <a href=\"http://htmlemail.io\">HTMLemail</a>.\n"
				+ "                  </td>\n" + "                </tr>\n" + "              </table>\n"
				+ "            </div>\n" + "            <!-- END FOOTER -->\n" + "\n" + "          </div>\n"
				+ "        </td>\n" + "        <td>&nbsp;</td>\n" + "      </tr>\n" + "    </table>\n" + "  </body>\n"
				+ "</html>\"");
		
		String messaage = buf.toString();

		//// ********************************////
		 MimeMessage message = javaMailSender.createMimeMessage();
	      
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	     
	    helper.setTo(a.getEmail());
	     helper.setFrom("consommi.toounsi.619@gmail.com");
	    helper.setSubject("réussite à notre grand jeu");
	    helper.setText(messaage, messaage);
	    //helper.setText(String.format(messaage, true));
	         
	 // FileSystemResource file 
	   //   = new FileSystemResource(new File(pathToAttachment));
	    //helper.addAttachment("Invoice", file);
	 
	    javaMailSender.send(message);

	/*	mail.setTo(a.getEmail());
		mail.setFrom("noussairhamrit15@gmail.com");
		mail.setSubject("réussite à notre grand jeu");
		mail.setText(messaage);
		
		javaMailSender.send(mail);*/
	    
	    
	    
		//return p1;
		
		
		 System.out.println("le client   "+a.getEmail());
		 System.out.println("le client   "+p1.getNom());
		 System.out.println("name2222 "+name2);
		   }catch (NumberFormatException e){
		       System.out.println("not a number"); 
		       System.out.println("name2223 "+name2);
		   } 
		 return null;
	}

	static String getRandomString() {
		int r = (int) (Math.random() * 5);
		String name = new String[] { "India", "USA", "UK", "Russia" }[r];
		return name;
	}

	public List<String> Produit_par_cat(int prix,String nom) {
		return clientrepository.Produit_par_cat(prix,nom);
	}

	public void sendmail() throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setTo("noussair.hamrit@esprit.tn");
		mail.setFrom("consommi.toounsi.619@gmail.com");
		mail.setSubject("hello");
		mail.setText("hi noussair");
		javaMailSender.send(mail);
	}
	
}
