package friday0214;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void main(String[] args) {
		String smtpServer = "smtp.naver.com";
		int smtpPort = 465;
		//������ ��� ����
		final String sendId = "********"; //���̹� ���� ���̵� 
		final String sendPass = "**********"; // ���̹� ���� ���
		String sendEmailAddress ="*************";
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpServer);
		props.put("mail.smtp.port", smtpPort);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.ssl.enable", true);
		props.put("mail.smtp.ssl.trust", smtpServer);
		//�޴��� ����
		String receiveEmailAddress = "*************";
		String subject = "�ȳ��ϼ���. �̼����Դϴ�.";
		String content = "�н��� �̸��� ������ �����Դϴ�.";
		//���̵�� ������� �����˻��ϱ�
		Session session5 = Session.getDefaultInstance(props, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(sendId, sendPass);
			}
		});
		//session2.setDebug(true);
		try{
			Message mimeMessage = new MimeMessage(session5);
			mimeMessage.setFrom(new InternetAddress(sendEmailAddress));
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveEmailAddress));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(content);
			Transport.send(mimeMessage);
			System.out.print("message sent successfully..."); 
		} catch (AddressException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (MessagingException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 

	}

}
