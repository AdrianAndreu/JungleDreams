package Models;

import java.util.ArrayList;

public class FaqsModel {
	private String pregunta;
	private String respuesta;
	private static ArrayList<FaqsModel> faqs;
	
	public FaqsModel(String pregunta, String respuesta) {
		this.pregunta=pregunta;
		this.respuesta=respuesta;
	}
	
	public void crearPreguntasYRespuestas() {
		faqs=new ArrayList<>();
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo s� si mi reserva de hotel se ha confirmado con �xito?", "Puede llamar a un administrador del hotel o simplemente verlo en sus reservas en nuestra aplicaci�n movil"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		faqs.add(new FaqsModel("�C�mo realizo una reserva de hotel para otra persona?", "Lo tiene que hacer un administrador que pueda crear, modificar y dar de baja una reserva"));
		
	}
}
