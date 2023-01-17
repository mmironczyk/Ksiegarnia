package com.ksiegarnia.tools;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/** Klasa związana z wysyłaniem e-maili */
public class MailModel {
    private Properties mailServerProperties;
    private Session getMailSession;
    private MimeMessage generateMailMessage;
    final private String SENDER_MAIL = "bookzwami@onet.pl";
    final private String PASSWORD = "%Bookzwami123";
    final private String SMTP = "smtp.poczta.onet.pl";

    private String to;
    private String subject;
    private String emailBody;

    public MailModel(String to, String subject, String emailBody) {
        this.to = to;
        this.subject = subject;
        this.emailBody = emailBody;
    }

    /** Funkcja wysyła wiadomość z przyciskiem do aktywacji konta na podany adres email
     * @param act wygenerowany kod aktywacyjny przypisany do konta podczas rejestracji
     * @return Funkcja zwraca <b>true</b> jeśli udało się poprawnie wysłać wiadomość, w przeciwnym razie zwraca <b>false</b>.
     * @see com.ksiegarnia.controller.user.Signup
     * */
    public boolean sendActivationMail(String act) {
        try {

            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "465");
            mailServerProperties.put("mail.smtp.ssl.enable", "true");
            mailServerProperties.put("mail.smtp.host", SMTP);
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.user", SENDER_MAIL);
            mailServerProperties.put("mail.smtp.password", PASSWORD);
            getMailSession = Session.getDefaultInstance(mailServerProperties);
            generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.setFrom(new InternetAddress(SENDER_MAIL));
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            generateMailMessage.setSubject("Aktywacja konta","UTF-8");
            generateMailMessage.setHeader("Content-Type", "text/plain; charset=UTF-8");
            emailBody += "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "  <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\n" +
                    "  <title>Email Confirmation</title>\n" +
                    "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                    "  <style type=\"text/css\">\n" +
                    "  /**\n" +
                    "   * Google webfonts. Recommended to include the .woff version for cross-client compatibility.\n" +
                    "   */\n" +
                    "  @media screen {\n" +
                    "    @font-face {\n" +
                    "      font-family: 'Source Sans Pro';\n" +
                    "      font-style: normal;\n" +
                    "      font-weight: 400;\n" +
                    "      src: local('Source Sans Pro Regular'), local('SourceSansPro-Regular'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/ODelI1aHBYDBqgeIAH2zlBM0YzuT7MdOe03otPbuUS0.woff) format('woff');\n" +
                    "    }\n" +
                    "    @font-face {\n" +
                    "      font-family: 'Source Sans Pro';\n" +
                    "      font-style: normal;\n" +
                    "      font-weight: 700;\n" +
                    "      src: local('Source Sans Pro Bold'), local('SourceSansPro-Bold'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/toadOcfmlt9b38dHJxOBGFkQc6VGVFSmCnC_l7QZG60.woff) format('woff');\n" +
                    "    }\n" +
                    "  }\n" +
                    "  /**\n" +
                    "   * Avoid browser level font resizing.\n" +
                    "   * 1. Windows Mobile\n" +
                    "   * 2. iOS / OSX\n" +
                    "   */\n" +
                    "  body,\n" +
                    "  table,\n" +
                    "  td,\n" +
                    "  a {\n" +
                    "    -ms-text-size-adjust: 100%; /* 1 */\n" +
                    "    -webkit-text-size-adjust: 100%; /* 2 */\n" +
                    "  }\n" +
                    "  /**\n" +
                    "   * Remove extra space added to tables and cells in Outlook.\n" +
                    "   */\n" +
                    "  table,\n" +
                    "  td {\n" +
                    "    mso-table-rspace: 0pt;\n" +
                    "    mso-table-lspace: 0pt; \n" +
                    "  }\n" +
                    "  /**\n" +
                    "   * Better fluid images in Internet Explorer.\n" +
                    "   */\n" +
                    "  img {\n" +
                    "    -ms-interpolation-mode: bicubic;\n" +
                    "  }\n" +
                    "  /**\n" +
                    "   * Remove blue links for iOS devices.\n" +
                    "   */\n" +
                    "  a[x-apple-data-detectors] {\n" +
                    "    font-family: inherit !important;\n" +
                    "    font-size: inherit !important;\n" +
                    "    font-weight: inherit !important;\n" +
                    "    line-height: inherit !important;\n" +
                    "    color: inherit !important;\n" +
                    "    text-decoration: none !important;\n" +
                    "  }\n" +
                    "  /**\n" +
                    "   * Fix centering issues in Android 4.4.\n" +
                    "   */\n" +
                    "  div[style*=\"margin: 16px 0;\"] {\n" +
                    "    margin: 0 !important;\n" +
                    "  }\n" +
                    "  body {\n" +
                    "    width: 100% !important;\n" +
                    "    height: 100% !important;\n" +
                    "    padding: 0 !important;\n" +
                    "    margin: 0 !important;\n" +
                    "  }\n" +
                    "  /**\n" +
                    "   * Collapse table borders to avoid space between cells.\n" +
                    "   */\n" +
                    "  table {\n" +
                    "    border-collapse: collapse !important;\n" +
                    "  }\n" +
                    "  a {\n" +
                    "    color: #1a82e2;\n" +
                    "  }\n" +
                    "  img {\n" +
                    "    height: auto;\n" +
                    "    line-height: 100%;\n" +
                    "    text-decoration: none;\n" +
                    "    border: 0;\n" +
                    "    outline: none;\n" +
                    "  }\n" +
                    "  </style>\n" +
                    "\n" +
                    "</head>\n" +
                    "<body style=\"background-color: #e9ecef;\">\n" +
                    "\n" +
                    "  <!-- start preheader -->\n" +
                    "  <div class=\"preheader\" style=\"display: none; max-width: 0; max-height: 0; overflow: hidden; font-size: 1px; line-height: 1px; color: #fff; opacity: 0;\">\n" +
                    "    A preheader is the short summary text that follows the subject line when an email is viewed in the inbox.\n" +
                    "  </div>\n" +
                    "  <!-- end preheader -->\n" +
                    "\n" +
                    "  <!-- start body -->\n" +
                    "  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                    "\n" +
                    "    <!-- start logo -->\n" +
                    "    <tr>\n" +
                    "      <td align=\"center\" bgcolor=\"#e9ecef\">\n" +
                    "        <!--[if (gte mso 9)|(IE)]>\n" +
                    "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\n" +
                    "        <tr>\n" +
                    "        <td align=\"center\" valign=\"top\" width=\"600\">\n" +
                    "        <![endif]-->\n" +
                    "        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
                    "          <tr>\n" +
                    "            <td align=\"center\" valign=\"top\" style=\"padding: 36px 24px;\">\n" +
                    "              <a href=\"https://www.blogdesire.com\" target=\"_blank\" style=\"display: inline-block;\">\n" +
                    "                <img src=\"https://www.blogdesire.com/wp-content/uploads/2019/07/blogdesire-1.png\" alt=\"Logo\" border=\"0\" width=\"48\" style=\"display: block; width: 48px; max-width: 48px; min-width: 48px;\">\n" +
                    "              </a>\n" +
                    "            </td>\n" +
                    "          </tr>\n" +
                    "        </table>\n" +
                    "        <!--[if (gte mso 9)|(IE)]>\n" +
                    "        </td>\n" +
                    "        </tr>\n" +
                    "        </table>\n" +
                    "        <![endif]-->\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "    <!-- end logo -->\n" +
                    "\n" +
                    "    <!-- start hero -->\n" +
                    "    <tr>\n" +
                    "      <td align=\"center\" bgcolor=\"#e9ecef\">\n" +
                    "        <!--[if (gte mso 9)|(IE)]>\n" +
                    "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\n" +
                    "        <tr>\n" +
                    "        <td align=\"center\" valign=\"top\" width=\"600\">\n" +
                    "        <![endif]-->\n" +
                    "        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
                    "          <tr>\n" +
                    "            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 36px 24px 0; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; border-top: 3px solid #d4dadf;\">\n" +
                    "              <h1 style=\"margin: 0; font-size: 32px; font-weight: 700; letter-spacing: -1px; line-height: 48px;\">Aktywuj swoje konto</h1>\n" +
                    "            </td>\n" +
                    "          </tr>\n" +
                    "        </table>\n" +
                    "        <!--[if (gte mso 9)|(IE)]>\n" +
                    "        </td>\n" +
                    "        </tr>\n" +
                    "        </table>\n" +
                    "        <![endif]-->\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "    <!-- end hero -->\n" +
                    "\n" +
                    "    <!-- start copy block -->\n" +
                    "    <tr>\n" +
                    "      <td align=\"center\" bgcolor=\"#e9ecef\">\n" +
                    "        <!--[if (gte mso 9)|(IE)]>\n" +
                    "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\n" +
                    "        <tr>\n" +
                    "        <td align=\"center\" valign=\"top\" width=\"600\">\n" +
                    "        <![endif]-->\n" +
                    "        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
                    "\n" +
                    "          <!-- start copy -->\n" +
                    "          <tr>\n" +
                    "            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;\">\n" +
                    "              <p style=\"margin: 0;\">Naciśnij przycisk poniżej aby aktywować utworzone konto. Jeśli nie utworzyłeś konta w naszej księgarni, możesz po prostu zignorować tego maila.</p>\n" +
                    "            </td>\n" +
                    "          </tr>\n" +
                    "          <!-- end copy -->\n" +
                    "\n" +
                    "          <!-- start button -->\n" +
                    "          <tr>\n" +
                    "            <td align=\"left\" bgcolor=\"#ffffff\">\n" +
                    "              <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                    "                <tr>\n" +
                    "                  <td align=\"center\" bgcolor=\"#ffffff\" style=\"padding: 12px;\">\n" +
                    "                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                    "                      <tr>\n" +
                    "                        <td align=\"center\" bgcolor=\"#1a82e2\" style=\"border-radius: 6px;\">\n" +
                    "                          <a href=\"http://localhost:8080/Ksiegarnia_war_exploded/Activate?r="+act+"\" target=\"_blank\" style=\"display: inline-block; padding: 16px 36px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; color: #ffffff; text-decoration: none; border-radius: 6px;\">Aktywuj</a>\n" +
                    "                        </td>\n" +
                    "                      </tr>\n" +
                    "                    </table>\n" +
                    "                  </td>\n" +
                    "                </tr>\n" +
                    "              </table>\n" +
                    "            </td>\n" +
                    "          </tr>\n" +
                    "          <!-- end button -->\n" +
                    "\n" +
                    "          <!-- start copy -->\n" +
                    "          <tr>\n" +
                    "            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;\">\n" +
                    "            </td>\n" +
                    "          </tr>\n" +
                    "          <!-- end copy -->\n" +
                    "\n" +
                    "          <!-- start copy -->\n" +
                    "          <tr>\n" +
                    "            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px; border-bottom: 3px solid #d4dadf\">\n" +
                    "              <p style=\"margin: 0;\">Pozdrawiamy,<br> księgarnia bookzwami.pl</p>\n" +
                    "            </td>\n" +
                    "          </tr>\n" +
                    "          <!-- end copy -->\n" +
                    "\n" +
                    "        </table>\n" +
                    "        <!--[if (gte mso 9)|(IE)]>\n" +
                    "        </td>\n" +
                    "        </tr>\n" +
                    "        </table>\n" +
                    "        <![endif]-->\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "    <!-- end copy block -->\n" +
                    "\n" +
                    "    <!-- start footer -->\n" +
                    "    <tr>\n" +
                    "      <td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 24px;\">\n" +
                    "        <!--[if (gte mso 9)|(IE)]>\n" +
                    "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\n" +
                    "        <tr>\n" +
                    "        <td align=\"center\" valign=\"top\" width=\"600\">\n" +
                    "        <![endif]-->\n" +
                    "        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
                    "\n" +
                    "          <!-- start permission -->\n" +
                    "          <tr>\n" +
                    "            <td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;\">\n" +
                    "              <p style=\"margin: 0;\">Otrzymałeś tego maila, gdyż utworzono przy jego pomocy konto w naszej księgarni. Możesz po prostu usunąć tego maila.</p>\n" +
                    "            </td>\n" +
                    "          </tr>\n" +
                    "          <!-- end permission -->\n" +
                    "\n" +
                    "          <!-- start unsubscribe -->\n" +
                    "          <tr>\n" +
                    "            <td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;\">\n" +
                    "              <p style=\"margin: 0;\">Księgarnia BookzWami, ul. Powstańców 5 60-123 Sosnowiec</p>\n" +
                    "            </td>\n" +
                    "          </tr>\n" +
                    "          <!-- end unsubscribe -->\n" +
                    "\n" +
                    "        </table>\n" +
                    "        <!--[if (gte mso 9)|(IE)]>\n" +
                    "        </td>\n" +
                    "        </tr>\n" +
                    "        </table>\n" +
                    "        <![endif]-->\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "    <!-- end footer -->\n" +
                    "\n" +
                    "  </table>\n" +
                    "  <!-- end body -->\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>";
            generateMailMessage.setText(emailBody,"UTF-8");
            generateMailMessage.setContent(emailBody, "text/html; charset=utf-8");
            getMailSession.setDebug(true);
            Transport transport = getMailSession.getTransport("smtp");
            transport.connect(SMTP, SENDER_MAIL, PASSWORD);
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();
        } catch (AddressException ex) {
            ex.printStackTrace();
            return false;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
