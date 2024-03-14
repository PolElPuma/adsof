import java.util.List;

public class IEEEArticleFormatter extends ArticleFormatter {
	/**
	 *
	 * @author Pol Pumar pol.pumar@estudiante.uam.es y Jorge Ibarreta jorge.ibarreta@estudiante.uam.es
	 *
	 * An example:
	 * 
	 * Inicial. Apellido, "Título del artículo", Nombre de la revista, vol. Volumen, no. Issue, año.
	 **/
	
	public IEEEArticleFormatter(){
		super("IEEE");
	}
	
	@Override
	
	public String formatAuthorsList(List<Author> authors) {
		StringBuffer sb = new StringBuffer();
		for (Author a : authors) {
			sb.append(a.getInitial()  + ". "  + a.getLastName()+ ", ");
		}
		return sb.toString();
	}
	
	@Override

	public String formatReference(Article a) {
		return formatAuthorsList(a.getAuthors()) + "\"" 
			   + a.getTitle() + "\", " + a.getJournal() + ", vol. " +
			   a.getVolume() + ", no. " + a.getIssue() + ", " + a.getYear() + ".";
	}
}
