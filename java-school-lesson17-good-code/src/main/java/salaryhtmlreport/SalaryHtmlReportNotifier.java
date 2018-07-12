package salaryhtmlreport;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;

public class SalaryHtmlReportNotifier {

    private final SalaryReportBuilder reportBuilder;

    public SalaryHtmlReportNotifier(Connection databaseConnection) {
        this.reportBuilder = new SalaryReportBuilder(databaseConnection);
    }

    public void generateAndSendHtmlSalaryReport(String resultingHtml, String recipients) {

        try {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("mail.google.com");

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(recipients);
            helper.setText(resultingHtml, true);
            helper.setSubject("Monthly department salary report");

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
