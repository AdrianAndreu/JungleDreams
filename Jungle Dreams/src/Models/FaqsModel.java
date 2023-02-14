package Models;

import java.util.ArrayList;

public class FaqsModel {
	private String pregunta;
	private String respuesta;
	private static ArrayList<FaqsModel> faqs;
	private static ArrayList<FaqsModel> faqsE;
	
	public FaqsModel(String pregunta, String respuesta) {
		this.pregunta=pregunta;
		this.respuesta=respuesta;
	}
	
	public void crearPreguntasYRespuestas() {
		faqs=new ArrayList<>();
		faqsE=new ArrayList<>();
		faqs.add(new FaqsModel("¿Cómo me puedo descargar la aplicación?", "La aplicación de escritorio es solo para el personal del hotel, hay una aplicación móvil que puedes descargar en vez de esa"));
		faqs.add(new FaqsModel("¿Que puedo hacer con la aplicación?", "Puedes crear, insertar y dar de baja usuarios, habitaciones y reservas"));
		faqs.add(new FaqsModel("¿Cómo realizo una reserva de hotel para otra persona?", "Cuando haces una reserva puedes poner el email de otra persona, puedes modificarlo por si te equivocas"));
		faqs.add(new FaqsModel("¿Cómo sé si mi reserva de hotel se ha confirmado con éxito?", "Puede llamar a un administrador del hotel o simplemente verlo en sus reservas en nuestra aplicación movil"));
		faqs.add(new FaqsModel("¿Puedo realizar reservas para el mismo día?", "Lo sentimos mucho, en nuestro hotel se tiene que reservar con un día de antelación"));
		faqs.add(new FaqsModel("¿Qué he de hacer si quiero contratar el servicio de parking del hotel?", "Cuando vengas podrás pagar el servicio de parking"));
		faqs.add(new FaqsModel("¿Puedo alojarme en un hotel con mi mascota?", "Nuestro hotel permite mascotas, así que no hay ningún problema"));
		
		faqsE.add(new FaqsModel("How can I download the hotel app?", "The desktop app is only for the hotel staff, there is a mobile app that you can download instead of it"));
		faqsE.add(new FaqsModel("What can I do with the app?", "You can insert, update and to cancel users, rooms and bookings"));
		faqsE.add(new FaqsModel("How can I book for other person?", "When you do a book you can put the email of another person, you can modify it if you get it wrong"));
		faqsE.add(new FaqsModel("How can I know if my book has been successfully confirmed?", "You can call to hotel staff or just see it at your books in our mobile app"));
		faqsE.add(new FaqsModel("I can book for the same day?", "We are sorry, but our hotel requires a one-day advance book"));
		faqsE.add(new FaqsModel("What do I have to do if I want to hire the hotel's parking service?", "When you come you can pay for the parking servivce"));
		faqsE.add(new FaqsModel("Can I stay at the hotel with my pet?", "Our hotel allows pets, so there is no problem"));
	}
}
