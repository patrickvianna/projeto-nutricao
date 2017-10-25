package Controller;
public class AlimentoCtrl {
    
    public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		ContatoDao dao = new ContatoDao();

		for (Contato c : dao.getContatos()) {
			modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getTelefone(), c.getEmail()});
		}
	}
}
